<?php

header("Content-Type: application/json; charset=UTF-8");
require_once "config/conexion.php";

// 1. Recibimos los datos enviados por Android
$id_curso = isset($_POST['id_curso']) ? intval($_POST['id_curso']) : 0;
$matricula = isset($_POST['matricula']) ? trim($_POST['matricula']) : '';
$fecha_registro = isset($_POST['fecha_registro']) ? trim($_POST['fecha_registro']) : '';

// 2. Validamos los datos
if (empty($id_curso) || empty($matricula) || empty($fecha_registro)) {
    header("HTTP/1.1 400 Bad Request");
    echo json_encode(["error" => "Todos los campos son obligatorios"]);
    exit;
}

try {
    // 3. Insertamos la inscripción
    $stmt = $pdo->prepare(
        "INSERT INTO tbl_inscripciones
        (id_curso, matricula, fecha_registro)
        VALUES (?, ?, ?)"
    );

    $stmt->execute([
        $id_curso,
        $matricula,
        $fecha_registro
    ]);

    // 4. Respondemos a Android
    echo json_encode([
        "mensaje" => "Inscripción registrada correctamente",
        "id" => (int)$pdo->lastInsertId()
    ]);

} catch (PDOException $e) {
    header("HTTP/1.1 500 Internal Server Error");
    echo json_encode([
        "error" => "Error al registrar la inscripción"
    ]);
}
?>

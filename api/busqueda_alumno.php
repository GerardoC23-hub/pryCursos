<?php

header("Content-Type: application/json; charset=UTF-8");
require_once "config/conexion.php";

// 1. Recibimos los datos enviados por Android
$matricula = isset($_GET['matricula']) ? trim($_GET['matricula']) : '';

// 2. Validamos los datos
if ($matricula === '') {
    header("HTTP/1.1 400 Bad Request");
    echo json_encode([
        "error" => "La matrícula es obligatoria"
    ]);
    exit;
}

try {
    // 3. Buscamos al alumno
    $stmt = $pdo->prepare(
        "SELECT matricula, correo_institucional
        FROM tbl_alumnos
        WHERE matricula = ?"
    );

    $stmt->execute([$matricula]);
    $alumno = $stmt->fetch(PDO::FETCH_ASSOC);

    if (!$alumno) {
        header("HTTP/1.1 404 Not Found");
        echo json_encode([
            "error" => "No existe un alumno registrado con esa matrícula"
        ]);
        exit;
    }

    // 4. Respondemos a Android
    echo json_encode([
        "mensaje" => "Alumno encontrado correctamente",
        "matricula" => $alumno['matricula'],
        "correo_institucional" => $alumno['correo_institucional']
    ]);

} catch (Exception $e) {
    header("HTTP/1.1 500 Internal Server Error");
    echo json_encode([
        "error" => "Error al buscar al alumno"
    ]);
}
?>

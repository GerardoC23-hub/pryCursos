<?php

header("Content-Type: application/json; charset=UTF-8");
require_once "config/conexion.php";

$carrera_id = isset($_GET['id_carrera']) ? intval($_GET['id_carrera']) : 0;

try {
  if ($carrera_id > 0) {
    $stmt = $pdo->prepare(
      "SELECT c.id, c.id_carrera, c.nombre_curso, c.url_imagen_principal,
      c.cupo_maximo, COUNT(i.id) AS inscritos
      FROM tbl_cursos c
      LEFT JOIN tbl_inscripciones i ON i.id_curso = c.id
      WHERE c.id_carrera = ?
      GROUP BY c.id, c.id_carrera, c.nombre_curso, c.url_imagen_principal, c.cupo_maximo
      ORDER BY c.nombre_curso ASC"
    );

    $stmt->execute([$carrera_id]);

  } else {
    $stmt = $pdo->query(
      "SELECT c.id, c.id_carrera, c.nombre_curso, c.url_imagen_principal,
      c.cupo_maximo, COUNT(i.id) AS inscritos
      FROM tbl_cursos c
      LEFT JOIN tbl_inscripciones i ON i.id_curso = c.id
      GROUP BY c.id, c.id_carrera, c.nombre_curso, c.url_imagen_principal, c.cupo_maximo
      ORDER BY c.nombre_curso ASC"
    );
  }

  $cursos = $stmt->fetchAll();

  // Casteamos los tipos de datos para Kotlin
  foreach ($cursos as &$c) {
    $c['id'] = (int)$c['id'];
    $c['id_carrera'] = (int)$c['id_carrera'];
    $c['cupo_maximo'] = (int)$c['cupo_maximo'];
    $c['inscritos'] = (int)$c['inscritos'];
  }

  echo json_encode($cursos);

} catch (Exception $e) {
  header("HTTP/1.1 500 Internal Server Error");
  echo json_encode([
    "error" => "Error al obtener las inscripciones: " . $e->getMessage()
  ]);
}
?>

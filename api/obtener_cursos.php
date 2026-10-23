<?php
header("Content-Type: application/json; charset=UTF-8");
require_once "config/conexion.php";
$carrera_id = isset($_GET['id_carrera']) ? intval($_GET['id_carrera']) : 0;

try {
  if ($carrera_id > 0) {
    $stmt = $pdo->prepare("SELECT id, id_carrera, nombre_curso, descripcion, edificio, salon, total_horas,dias_atencion, horas_atencion, url_imagen_principal, cupo_maximo FROM tbl_cursos WHERE id_carrera = ?");
    $stmt->execute([$carrera_id]);
  } else {
    $stmt = $pdo->query("SELECT id, id_carrera, nombre_curso, descripcion, edificio, salon, total_horas,dias_atencion, horas_atencion, url_imagen_principal, cupo_maximo FROM tbl_cursos");
  }

  $cursos = $stmt->fetchAll();

  foreach ($cursos as &$c) {
    $c['id'] = (int)$c['id'];
    $c['id_carrera'] = (int)$c['id_carrera'];
  }

  echo json_encode($cursos);
} catch (Exception $e) {
  header("HTTP/1.1 500 Internal Server Error");
  echo json_encode(["error" => "Error al obtener catálogo de cursos: " . $e->getMessage()]);
}
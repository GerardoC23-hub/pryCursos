<?php

header("Content-Type: application/json");
require_once "config/conexion.php";

try{
    $stmt = $pdo->query("SELECT id, carrera FROM tbl_carreras ORDER BY carrera ASC");
    $carreras = $stmt->fetchAll();
    
    echo json_encode($carreras);

}
catch(Exception $e){
    header("HTTP/1.1 500 Internal Server Error");
    echo json_encode(["Error"=>"Error al obtener categorias: ".$e->getMessage()]);
}
?>


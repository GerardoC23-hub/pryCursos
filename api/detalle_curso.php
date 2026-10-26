<?php
//detalle del curso

header("Content-Type: application/json; charset=UTF-8");
require_once "config/conexion.php";

$id_curso=isset($_GET['id_curso'])?intval($_GET['id_curso']):0;

if($id_curso<=0){
    header("HTTP/1.1 400 Bad Request");
    echo json_encode(["error"=>  "El id del curso seleccionado no es valido"]);
    exit;
}

try{

    $stmt = $pdo->prepare("SELECT id, id_curso, url_imagen FROM tbl_imagenes_curso WHERE id_curso = ?");
    $stmt->execute([$id_curso]);
    $imagenes = $stmt->fetchAll();


    foreach ($imagenes as &$img) {
        $img['id'] = (int)$img['id'];
        $img['id_curso'] = (int)$img['id_curso'];
        }
  
    echo json_encode($imagenes);
    } catch (Exception $e) {
        header("HTTP/1.1 500 Internal Server Error");
        echo json_encode(["error" => "Error al obtener el detalle del curso: " . $e->getMessage()]);
        }
?>
<?php
$host = "srv638.hstgr.io";
$db = "u408544566_cursos_db";
$user = "u408544566_equipo_5c"; 
$pass = "Equipo_5c";

try{
    
    $pdo = new PDO("mysql:host=$host;dbname=$db;charset=utf8",$user, $pass);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES,false);
    //Se configura PDO para que mande excepciones si ocurre algun error en las consultas
    $pdo->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
    //se configura para que por defecto devuelva los datos como un arreglo asociativo
    $pdo->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_ASSOC);

}
catch(PDOException $e){
    //si la conexion llega a fallar se manda un error de codigo 500 y un mensaje con formato json explicando el error
    header("Content-Type: application/json", true, 500);
    echo json_encode([
        "error"=>"Error critico de conexion al servidor",
        "detalle"=>$e->getMessage()
    ]);
    exit;
}
?>
<?php
require 'vendor/autoload.php';

$app = new Slim\App();
define('BD_SERVIDOR', 'localhost');
define('BD_NOMBRE', 'gym');
define('BD_USUARIO', 'root');
define('BD_PASSWORD', '1234');

$db = new PDO('mysql:host=' . BD_SERVIDOR . ';dbname=' . BD_NOMBRE . ';charset=utf8', BD_USUARIO, BD_PASSWORD);

$app->get('/', function ($request, $response, $args) {
    $response->write("Welcome to Slim!");
    return $response;
});
/*Datos del gimnasio */
$app->get('/hora', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
        $consulta = $db->query("select * from hora");
        $resultados = $consulta->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($resultados);
});

$app->get('/ejercicio/{idgym}', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
        $consulta = $db->query("select * from ejercicio where idgimnasio =".$args['idgym']);
        $resultados = $consulta->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($resultados);
});

$app->get('/comida/{idgym}', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
        $consulta = $db->query("select * from comida where idgimnasio =".$args['idgym']);
        $resultados = $consulta->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($resultados);
});

$app->get('/gm', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
        $consulta = $db->query("select * from grupo_muscular");
        $resultados = $consulta->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($resultados);
});

$app->get('/categoria', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
        $consulta = $db->query("select * from categoria");
        $resultados = $consulta->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($resultados);
});
/*Datos del gimnasio */

/*Id del gimansio*/
$app->get('/usuario/{codigo}', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
        $consulta = $db->query("select * from usuario where clave = '".$args['codigo']."'");
        $resultados = $consulta->fetchAll(PDO::FETCH_ASSOC);
        if($resultados!=null){
        	return json_encode($resultados[0]['id']);
        }
    	else{
    		echo -1;
    	}
});
/*Id del gimansio*/

/*Informacion del cliente*/
$app->get('/clientecorreo/{correo}', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
        $consulta = $db->query("select * from cliente where correo = '".$args['correo']."'");
        $resultados = $consulta->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($resultados);
});

$app->get('/cliente/{id}', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
        $consulta = $db->query("select * from cliente where id = ".$args['id']);
        $resultados = $consulta->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($resultados);
});

$app->get('/cliente/{id}/rutina', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
        $consulta = $db->query("select * from cliente_ejercicio where idcliente = ".$args['id']);
        $resultados = $consulta->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($resultados);
});

$app->get('/cliente/{id}/rutina/{mes}/{dia}', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
        $consulta = $db->query("select * from cliente_ejercicio where idcliente = ".$args['id']." 
        	and mes=".$args['mes']." and dias=".$args['dia']);
        $resultados = $consulta->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($resultados);
});

$app->get('/cliente/{id}/comida', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
        $consulta = $db->query("select * from cliente_comida where idcliente = ".$args['id']);
        $resultados = $consulta->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($resultados);
});

$app->get('/cliente/{id}/comida/{idhora}/{mes}/{dia}', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
        $consulta = $db->query("select * from cliente_comida where idcliente = ".$args['id']."
        	and idhora= ".$args['idhora']." and mes=".$args['mes']." and dias=".$args['dia']);
        $resultados = $consulta->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($resultados);
});

$app->post('/cliente', function ($request, $response, $args) use($db) {
    	$db -> exec("set names utf8");
    	$cliente=$request->getParsedBody();
        $consulta = $db->query("insert into cliente VALUES (0,".$cliente['idgimnasio'].",'".$cliente['nombre']."','".$cliente['correo']."',NOW(),".$cliente['peso'].",".$cliente['altura'].",'".$cliente['foto']."')");
        $stmt = $db->query("SELECT LAST_INSERT_ID()");
		$lastId = $stmt->fetch(PDO::FETCH_NUM);
		$lastId = $lastId[0];
   	return $lastId;
});
/*Informacion del cliente*/

$app->run();

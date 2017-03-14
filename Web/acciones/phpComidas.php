<?php
 
$table = 'comida';
 
$primaryKey = 'id';
 
$columns = array(
    array('db'=> 'id','dt'=> 0),
    array('db'=> 'nombre','dt'=> 1),
    array('db' => 'idgimnasio', 'dt' => 2 ), 
    array('db' => 'idcategoria', 'dt' => 3 ) 
);
 
// SQL server connection information
$sql_details = array(
    'user' => 'root',
    'pass' => '1234',
    'db'   => 'gym',
    'host' => 'localhost'
);
 
 
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * If you just want to use the basic configuration for DataTables with PHP
 * server-side, there is no need to edit below this line.
 */
 
require( 'ssp.php' );
 
echo json_encode(
    SSP::simple( $_GET, $sql_details, $table, $primaryKey, $columns,null,"idcategoria = ".$_GET['cat'] )
);

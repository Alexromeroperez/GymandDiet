<?php
 
$table = 'ejercicio';
 
$primaryKey = 'id';
 
$columns = array(
    array('db'=> 'id','dt'=> 0),
    array('db'=> 'imagen','dt'=> 1),
    array('db' => 'nombre', 'dt' => 2 ), 
    array('db' => 'idgimnasio', 'dt' => 3 ),  
    array('db' => 'idgm', 'dt' => 4 )  
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
    SSP::simple( $_GET, $sql_details, $table, $primaryKey, $columns,null,"idgm = ".$_GET['gm'] )
);

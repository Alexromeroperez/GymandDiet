<?php
 
$table = 'cliente';
 
$primaryKey = 'id';
 
$columns = array(
    array('db'=> 'id','dt'=> 0),
    array('db'=> 'idgimnasio','dt'=> 1),
    array('db'=> 'foto','dt'=> 2),
    array('db' => 'nombre', 'dt' => 3 ),
    array('db' => 'correo',  'dt' => 4 ),
    array(
        'db'        => 'fecha_alta',
        'dt'        => 5,
        'formatter' => function( $d, $row ) {
            return date( 'd-m-Y', strtotime($d));
        }
    ),
    array( 'db' => 'peso',   'dt' => 6 ),
    array('db'=> 'altura','dt'=> 7)
       
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
    SSP::simple( $_GET, $sql_details, $table, $primaryKey, $columns )
);

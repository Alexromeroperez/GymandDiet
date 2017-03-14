<?php

function autocarga($clase) {
    include '../clases/' . $clase . '.php';
}
spl_autoload_register('autocarga');
$bd = new BaseDatos();
$gestorEjercicio=new GestorEjercicio($bd);

$gestorEjercicio->borrarEjer(Peticion::get('id'));

header("Location: ../sites/index.php?m=ejerciciosLista&gm=".Peticion::get('gm')."");

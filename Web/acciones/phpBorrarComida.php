<?php

function autocarga($clase) {
    include '../clases/' . $clase . '.php';
}
spl_autoload_register('autocarga');
$bd = new BaseDatos();
$gestorComida=new GestorComida($bd);

$gestorComida->borrarComida(Peticion::get('id'));

header("Location: ../sites/index.php?m=comidaLista&cat=".Peticion::get('cat')."");


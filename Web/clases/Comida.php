<?php


class Comida {
    
    private $id;
    private $idgimnasio;
    private $idcategoria;
    private $nombre;
    
    function __construct($id="", $idgimnasio="", $idcategoria="", $nombre="") {
        $this->id = $id;
        $this->idgimnasio = $idgimnasio;
        $this->idcategoria = $idcategoria;
        $this->nombre = $nombre;
    }

    function set($datos, $posini=0) { 
          
        $this->id = $datos[0+$posini];
        $this->id_cliente = $datos[1+$posini];        
        $this->id_estado = $datos[2+$posini];
        $this->nombre = $datos[3+$posini];
        $this->fecha_alta = $datos[4+$posini];
        $this->fecha_fin = $datos[5+$posini];
        $this->texto = $datos[6+$posini];
    }
    function getId() {
        return $this->id;
    }

    function getIdgimnasio() {
        return $this->idgimnasio;
    }

    function getIdcategoria() {
        return $this->idcategoria;
    }

    function getNombre() {
        return $this->nombre;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setIdgimnasio($idgimnasio) {
        $this->idgimnasio = $idgimnasio;
    }

    function setIdcategoria($idcategoria) {
        $this->idcategoria = $idcategoria;
    }

    function setNombre($nombre) {
        $this->nombre = $nombre;
    }


}

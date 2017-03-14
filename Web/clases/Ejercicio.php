<?php


class Ejercicio {
    
    private $id;
    private $idgimnasio;
    private $idgm;
    private $nombre;
    private $imagen;
    
    function __construct($id="", $idgimnasio="", $idgm="", $nombre="", $imagen="") {
        $this->id = $id;
        $this->idgimnasio = $idgimnasio;
        $this->idgm = $idgm;
        $this->nombre = $nombre;
        $this->imagen = $imagen;
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

    function getIdgm() {
        return $this->idgm;
    }

    function getNombre() {
        return $this->nombre;
    }

    function getImagen() {
        return $this->imagen;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setIdgimnasio($idgimnasio) {
        $this->idgimnasio = $idgimnasio;
    }

    function setIdgm($idgm) {
        $this->idgm = $idgm;
    }

    function setNombre($nombre) {
        $this->nombre = $nombre;
    }

    function setImagen($imagen) {
        $this->imagen = $imagen;
    }


}

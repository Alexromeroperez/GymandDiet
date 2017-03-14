<?php

class Cliente {
    
    private $id;
    private $idgimnasio;
    private $nombre;
    private $correo;
    private $fecha_alta;
    private $peso;
    private $altura;
    private $foto;
    
    function __construct($id="", $idgimnasio="", $nombre="", $correo="", $fecha_alta="", $peso="", $altura="", $foto="") {
        $this->id = $id;
        $this->idgimnasio = $idgimnasio;
        $this->nombre = $nombre;
        $this->correo = $correo;
        $this->fecha_alta = $fecha_alta;
        $this->peso = $peso;
        $this->altura = $altura;
        $this->foto = $foto;
    }
    
    function set($datos, $posini=0) { 
          
        $this->id = $datos[0+$posini];
        $this->idgimnasio = $datos[1+$posini];        
        $this->nombre = $datos[2+$posini];
        $this->correo = $datos[3+$posini];
        $this->fecha_alta = $datos[4+$posini];
        $this->peso = $datos[5+$posini];
        $this->altura = $datos[6+$posini];
        $this->foto = $datos[7+$posini];
    }
    
    function getId() {
        return $this->id;
    }

    function getIdgimnasio() {
        return $this->idgimnasio;
    }

    function getNombre() {
        return $this->nombre;
    }

    function getCorreo() {
        return $this->correo;
    }

    function getFecha_alta() {
        return $this->fecha_alta;
    }

    function getPeso() {
        return $this->peso;
    }

    function getAltura() {
        return $this->altura;
    }

    function getFoto() {
        return $this->foto;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setIdgimnasio($idgimnasio) {
        $this->idgimnasio = $idgimnasio;
    }

    function setNombre($nombre) {
        $this->nombre = $nombre;
    }

    function setCorreo($correo) {
        $this->correo = $correo;
    }

    function setFecha_alta($fecha_alta) {
        $this->fecha_alta = $fecha_alta;
    }

    function setPeso($peso) {
        $this->peso = $peso;
    }

    function setAltura($altura) {
        $this->altura = $altura;
    }

    function setFoto($foto) {
        $this->foto = $foto;
    }



}

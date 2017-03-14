<?php


class Cliente_ejercicio {
    
    private $id;
    private $idejercicio;
    private $idcliente;
    private $duracion;
    
    function __construct($id="", $idejercicio="", $idcliente="", $duracion="") {
        $this->id = $id;
        $this->idejercicio = $idejercicio;
        $this->idcliente = $idcliente;
        $this->duracion = $duracion;
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

    function getIdejercicio() {
        return $this->idejercicio;
    }

    function getIdcliente() {
        return $this->idcliente;
    }

    function getDuracion() {
        return $this->duracion;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setIdejercicio($idejercicio) {
        $this->idejercicio = $idejercicio;
    }

    function setIdcliente($idcliente) {
        $this->idcliente = $idcliente;
    }

    function setDuracion($duracion) {
        $this->duracion = $duracion;
    }


}

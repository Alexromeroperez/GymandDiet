<?php


class Cliente_comida {
    
    private $id;
    private $idcliente;
    private $idcomida;
    private $idhora;
    private $cantidad;
    
    function __construct($id="", $idcliente="", $idcomida="", $idhora="", $cantidad="") {
        $this->id = $id;
        $this->idcliente = $idcliente;
        $this->idcomida = $idcomida;
        $this->idhora = $idhora;
        $this->cantidad = $cantidad;
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

    function getIdcliente() {
        return $this->idcliente;
    }

    function getIdcomida() {
        return $this->idcomida;
    }

    function getIdhora() {
        return $this->idhora;
    }

    function getCantidad() {
        return $this->cantidad;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setIdcliente($idcliente) {
        $this->idcliente = $idcliente;
    }

    function setIdcomida($idcomida) {
        $this->idcomida = $idcomida;
    }

    function setIdhora($idhora) {
        $this->idhora = $idhora;
    }

    function setCantidad($cantidad) {
        $this->cantidad = $cantidad;
    }


}

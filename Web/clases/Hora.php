<?php


class Hora {
    private $id;
    private $hora;
    
    function __construct($id="", $hora="") {
        $this->id = $id;
        $this->hora = $hora;
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

    function getHora() {
        return $this->hora;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setHora($hora) {
        $this->hora = $hora;
    }


}

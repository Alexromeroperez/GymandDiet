<?php


class Categoria {
    
    private $id;
    private $categoria;
    
    function __construct($id="", $categoria="") {
        $this->id = $id;
        $this->categoria = $categoria;
    }

    function set($datos, $posini=0) { 
          
        $this->id = $datos[0+$posini];
        $this->categoria = $datos[1+$posini];        
    }
    function getId() {
        return $this->id;
    }

    function getCategoria() {
        return $this->categoria;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setCategoria($categoria) {
        $this->categoria = $categoria;
    }


}

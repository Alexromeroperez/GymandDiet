<?php

class Grupo_muscular {
   
    private $id;
    private $grupo_muscular;
    
    function __construct($id="", $grupo_muscular="") {
        $this->id = $id;
        $this->grupo_muscular = $grupo_muscular;
    }
    function set($datos, $posini=0) { 
        $this->id = $datos[0+$posini];
        $this->grupo_muscular = $datos[1+$posini];        
    }

    function getId() {
        return $this->id;
    }

    function getGrupo_muscular() {
        return $this->grupo_muscular;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setGrupo_muscular($grupo_muscular) {
        $this->grupo_muscular = $grupo_muscular;
    }


}

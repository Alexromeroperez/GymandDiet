<?php

class Usuario {
    
    private $id;
    private $usuario;
    private $contrasena;
    private $nombre;
    private $domicilio;
    private $poblacion;
    private $cpostal;
    private $telefono;
    private $email;
    private $logo;
    private $clave;
    
    function __construct($id="", $usuario="", $contrasena="", $nombre="", $domicilio="", $poblacion="", $cpostal="", $telefono="", $email="", $logo="", $clave="") {
        $this->id = $id;
        $this->usuario = $usuario;
        $this->contrasena = $contrasena;
        $this->nombre = $nombre;
        $this->domicilio = $domicilio;
        $this->poblacion = $poblacion;
        $this->cpostal = $cpostal;
        $this->telefono = $telefono;
        $this->email = $email;
        $this->logo = $logo;
        $this->clave = $clave;
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

    function getUsuario() {
        return $this->usuario;
    }

    function getContrasena() {
        return $this->contrasena;
    }

    function getNombre() {
        return $this->nombre;
    }

    function getDomicilio() {
        return $this->domicilio;
    }

    function getPoblacion() {
        return $this->poblacion;
    }

    function getCpostal() {
        return $this->cpostal;
    }

    function getTelefono() {
        return $this->telefono;
    }

    function getEmail() {
        return $this->email;
    }

    function getLogo() {
        return $this->logo;
    }

    function getClave() {
        return $this->clave;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setUsuario($usuario) {
        $this->usuario = $usuario;
    }

    function setContrasena($contrasena) {
        $this->contrasena = $contrasena;
    }

    function setNombre($nombre) {
        $this->nombre = $nombre;
    }

    function setDomicilio($domicilio) {
        $this->domicilio = $domicilio;
    }

    function setPoblacion($poblacion) {
        $this->poblacion = $poblacion;
    }

    function setCpostal($cpostal) {
        $this->cpostal = $cpostal;
    }

    function setTelefono($telefono) {
        $this->telefono = $telefono;
    }

    function setEmail($email) {
        $this->email = $email;
    }

    function setLogo($logo) {
        $this->logo = $logo;
    }

    function setClave($clave) {
        $this->clave = $clave;
    }


}

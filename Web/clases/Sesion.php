<?php

class Sesion {

    function __construct() {
        session_start();
        $this->timeout();
            //$this->redirigir();
        $this->control();
            //$this->redirigir();
    }

    private function timeout() {
        if ($this->isAutentificado()) {
            $tiempo = $this->get("_timeout");
            if ($tiempo != null) {
                if ($tiempo + 60 * Constantes::$tiempoSesion < time()) {
                    $this->cerrarSession();
                    return true;
                } else {
                    $this->set("_timeout", time());
                }
            } else {
                $this->set("_timeout", time());
            }
        }
        return false;
    }

    private function control() {
        if ($this->isAutentificado()) {
            $ip = $this->get("_ip");
            $cliente = $this->get("_cliente");
            if ($ip != null && $cliente != null) {
                if ($ip == $_SERVER["REMOTE_ADDR"] && $cliente == $_SERVER["HTTP_USER_AGENT"]) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    function cerrarSession() {
        session_unset();
        session_destroy();
    }

    function set($atributo, $valor) {
        $_SESSION[$atributo] = $valor;
    }

    function get($atributo) {
        if (isset($_SESSION[$atributo]))
            return $_SESSION[$atributo];
        return null;
    }

    function setCM(CM $cm) {
        $this->set("_cm", $cm);
        $this->set("_timeout", time());
        $this->set("_ip", $_SERVER["REMOTE_ADDR"]);
        $this->set("_cliente", $_SERVER["HTTP_USER_AGENT"]);
    }
    
   
     function setRecordar($recordar){
        if($recordar){
           if($this->isAutentificado()){
               
                setcookie("_u",$this->getCM()->getUsuario(),time()+60*60*24*31, '/');
                setcookie("_c",$this->getCM()->getContrasena(),time()+60*60*24*31, '/');
            }
        }else{
            setcookie("_u","",time()-60*60*24*31);
            setcookie("_c","",time()-60*60*24*31);
        }
    }

    function getRecordarUsuario(){
        if(isset($_COOKIE["_u"])){
            return $_COOKIE["_usuario"];
        }
        return null;
    }
    
    function getRecordarContrasena(){
        if(isset($_COOKIE["_u"])){
            return $_COOKIE["_c"];
        }
        return null;
    }

    function getCM() {
        return $this->get("_cm");
    }

    function isAutentificado() {
        return $this->getCM() != null;
    }

    function isAdministrador() {
        $u = $this->getCM();
        if ($u == null)
            return false;
        $tipo = $u->getTipo();
        if ($tipo == "administrador")
            return true;
        return false;
        //return $this->getUsuario() != null && $this->getUsuario()->getTipo()=="administrador";
    }

    function redirigir($destino = "select.php") {
        header("Location:" . $destino);
        exit;
    }

    function autentificado($destino = "select.php") {
        if (!$this->isAutentificado()) {
            $this->redirigir($destino);
        }
    }

    function administrador($destino = "select.php") {
        if (!$this->isAdministrador()) {
            $this->redirigir($destino);
        }
    }

}

?>
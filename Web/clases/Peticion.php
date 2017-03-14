<?php

class Peticion {

   
    public static function get($nombre) {
        if (isset($_GET[$nombre])) {
            if (empty($_GET[$nombre])) {
                return "";
            } else {
                if (is_array($_GET[$nombre])) {
                    $valores = [];
                    foreach ($_GET[$nombre] as $valor) {
                        $valores[] = $valor;
                    }
                    return $valores;
                } else {
                    return $_GET[$nombre];
                }
            }
        } else {
            return NULL;
        }
    }

    public static function post($nombre) {
        if (isset($_POST[$nombre])) {
            if (empty($_POST[$nombre])) {
                return "";
            } else {
                if (is_array($_POST[$nombre])) {
                    $valores = [];
                    foreach ($_POST[$nombre] as $valor) {
                        $valores[] = $valor;
                    }
                    return $valores;
                } else {
                    return $_POST[$nombre];
                }
            }
        } else {
            return NULL;
        }
    }
   

}

?>
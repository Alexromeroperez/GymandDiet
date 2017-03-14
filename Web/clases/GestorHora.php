<?php


class GestorHora {
   private $bd = null;
    private $nombreTabla = "cm";
    
    function __construct(BaseDatos $bd) {
        $this->bd = $bd;
        
    }

    /*
    Muy importante son los tipos de las variables que vamos a vincular. Por cada variable a vincular ($nombre y $correo en nuestro ejemplo) especificaremos su tipo mediante un carácter dentro de la cadena que corresponde al segundo parámetro de la función.
    Los tipos pueden ser cuatro:
    - "i" si la variable a la que vincula es de tipo entero. 
    - "d" si la variable a la que vincula es de tipo double.
    - "s" si la variable a la que vincula es tipo cadena. 
    - "b" si la variable a la que vincula es tipo blob.
    */
}

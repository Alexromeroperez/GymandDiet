<?php

class Subir {

    private $input, $destino='', $nombre='', $tamaño,
            $errorpropio = 0, $gestionarchivo = "conservar",
            $extensiones = ["jpg" => 1, "png" => 1, "gif" => 1, "JPG" => 1, "PNG" => 1, "GIF" => 1];

    public function __construct($input) {
        $this->input = $input;
        $this->tamaño = 1024 * 1024 * 10;
        $this->check();
        if($this->errorpropio==0)
            $this->nombre=$_FILES[$this->input]["name"];
    }

    private function check() {
        $this->errorpropio = 0;
        $this->checkInput();
        if ($this->errorpropio == 0) {
            $this->checkTamaño();
            $this->checkExtension();
            $this->checkUpload();
        }
    }

    private function checkInput() {
        if (!isset($_FILES[$this->input])) {
            $this->errorpropio = -1;
        }
    }

    private function checkTamaño() {
        if ($_FILES[$this->input]["size"] > $this->tamaño)
            $this->errorpropio = -2;
    }

    private function checkExtension() {
        $nombreoriginal = $_FILES[$this->input]["name"];
        $partes = pathinfo($nombreoriginal);
        $ext = $partes['extension'];
        $ext=  strtolower($ext);
        if (!$this->isValidExtension($ext)) {
            $this->errorpropio = -3;
        }
    }

    private function checkUpload() {
        if (!is_uploaded_file($_FILES[$this->input]['tmp_name']))
            $this->errorpropio = -4;
    }

    private function getValidName() {
        if ($this->gestionarchivo == "conservar") {
            if (file_exists($this->destino . $this->nombre))
                return "";
            else
                return $this->nombre;
        }
        elseif ($this->gestionarchivo == "sobrescribir") {
            return $this->nombre;
        } elseif ($this->gestionarchivo == "renombrar") {
            $carpeta = $this->destino;
            $nombre = $this->nombre;
            $partes = pathinfo($nombre);
            $ext = $partes['extension'];
            $nom = $partes['filename'];
            $nomext = $nom . "." . $ext;
            $cont = 0;
            while (file_exists($carpeta . $nomext)) {
                $cont++;
                $nomext = $nom . "_" . $cont . "." . $ext;
            }
            if($cont!=0){
                $this->setNombre($nom . "_" . $cont);
            }
            return $nomext;
        }
    }

    public function getError() {
        if ($this->errorpropio == 0)
            return $_FILES[$this->input]["error"];
        return $this->errorpropio;
    }

    public function getInput() {
        return $this->input;
    }

    public function setInput($input) {
        $this->input = $input;
        $this->nombre='';
        $this->check();
        if($this->errorpropio==0)
            $this->nombre=$_FILES[$this->input]["name"];
    }

    public function getDestino() {
        return $this->destino;
    }

    public function setDestino($destino) {
        if ($destino == "" || $destino == "/")
            $this->destino = "";
        else {
            $caracter = substr($destino, -1);
            if ($caracter != "/")
                $destino.="/";
            $this->destino = $destino;
        }
    }

    public function getGestion() {
        return $this->gestionarchivo;
    }

    public function setSobrescribir() {
        $this->gestionarchivo = "sobrescribir";
    }

    public function setRenombrar() {
        $this->gestionarchivo = "renombrar";
    }

    public function setConservar() {
        $this->gestionarchivo = "conservar";
    }

    public function getNombre() {
        return $this->nombre;
    }

    public function setNombre($nombre) {
        $nombreoriginal = $_FILES[$this->input]["name"];
        $partes = pathinfo($nombreoriginal);
        $ext = $partes['extension'];
        $this->nombre = $nombre . "." . $ext;
    }

    public function getTamaño() {
        return $this->tamaño;
    }

    public function setTamaño($tamaño) {
        $this->tamaño = $tamaño;
        $this->check();
    }

    public function getExtensiones() {
        return $this->extensiones;
    }

    public function addExtension($extension) {
        if (!$this->isValidExtension($extension)) {
            $this->extensiones[$extension] = 1;
            $this->check();
        }
    }

    public function isValidExtension($extension) {
        return isset($this->extensiones[$extension]);
    }

    public function removeExtension($extension) {
        if ($this->isValidExtension($extension)) {
            unset($this->extensiones[$extension]);
            $this->check();
        }
    }

    public function subirAvatar($avatar,$id) {
      
        $this->check();
        if ($this->getError() == 0) {
            $nombre = $this->getValidName();
            if ($nombre != "") {
                if($avatar!="sinAvatar.jpg"){
                    unlink(Constantes::$rutaAvatar.$avatar);
                }
                move_uploaded_file($_FILES[$this->input]["tmp_name"], $this->destino . $nombre);
                    return $this->resizeImagen(Constantes::$rutaAvatar,$nombre , 1920, 1080, $id, 70);
            }
        }
        return false;
    }
    public function subirLogo($logo,$id) {
        $this->check();
        if ($this->getError() == 0) {
            $nombre = $this->getValidName();
            if ($nombre != "") {
                if($logo!="sinLogo.jpg"){
                    unlink(Constantes::$rutaLogo.$logo);
                }
                move_uploaded_file($_FILES[$this->input]["tmp_name"], $this->destino . $nombre);
                
                return $this->resizeImagen(Constantes::$rutaLogo, $nombre, 1920, 1080, $id, 70);
            }
        }
        return false;
    }

    public function resizeImagen($ruta, $nombre, $alto, $ancho,$nombreN,$calidad){
        $rutaImagenOriginal = $ruta.$nombre;
        $img_original = imagecreatefromjpeg($rutaImagenOriginal);
        $max_ancho = $ancho;
        $max_alto = $alto;
        list($ancho,$alto)=getimagesize($rutaImagenOriginal);
        $x_ratio = $max_ancho / $ancho;
        $y_ratio = $max_alto / $alto;
        if( ($ancho <= $max_ancho) && ($alto <= $max_alto) ){//Si ancho 
            $ancho_final = $ancho;
                    $alto_final = $alto;
            } else if (($x_ratio * $alto) < $max_alto){
                    $alto_final = ceil($x_ratio * $alto);
                    $ancho_final = $max_ancho;
            } else{
                    $ancho_final = ceil($y_ratio * $ancho);
                    $alto_final = $max_alto;
            }
        $tmp=imagecreatetruecolor($ancho_final,$alto_final);
        imagecopyresampled($tmp,$img_original,0,0,0,0,$ancho_final, $alto_final,$ancho,$alto);
        imagedestroy($img_original);
        imagejpeg($tmp,$ruta.$nombreN.".jpg",$calidad);
        unlink($rutaImagenOriginal);
        return $nombreN.".jpg";
    } 
}

?>
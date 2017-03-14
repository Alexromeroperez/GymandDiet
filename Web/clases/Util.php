<?php

class Util {

    private function __construct() {
    }
    public static function enviarCorreoGmail($origen, $clave, $destino, $asunto, $mensaje) {
        require 'PHPMailerAutoload.php';
        date_default_timezone_set("Europe/Madrid");
        $mail = new PHPMailer();
        $mail->IsSMTP();
        $mail->SMTPAuth = true;
        $mail->SMTPSecure = "ssl"; // extension=php_openssl.dll
        $mail->Host = "smtp.gmail.com";
        $mail->Port = 465;
        $mail->Username = $origen;
        $mail->Password = $clave;
        $mail->Subject = $asunto;
        $mail->MsgHTML($mensaje);
        $mail->AddAddress($destino);
        if (!$mail->Send()) {
            return false;
        } else {
            return true;
        }
    }

    public static function getPaginas($numregs, $pagina = 0, $rpp = 10) {
        $paginas = ceil($numregs / $rpp) - 1;
        $ant = $pagina - 1;
        if ($ant < 0) {
            $ant = 0;
        }
        $sig = $pagina + 1;
        if ($sig >= $paginas) {
            $sig = $paginas;
        }
        if ($pagina > $paginas) {
            $pagina = $paginas;
        }
        if ($pagina < 0) {
            $pagina = 0;
        }
        $resultado[0] = 0; //primera
        $resultado[1] = $ant; //anterior
        $resultado[2] = $sig; //siguiente
        $resultado[3] = $paginas; //última
        $resultado[4] = $pagina; //actual
        return $resultado;
    }

    public static function getSelect($valores, $seleccionado = "", $id = "", $name = "", $blanco=true) {
        $r = "<select name=\"$name\" id=\"$id\" >\n";
        if($blanco)
            $r .= "<option value=\"\">&nbsp;</option>\n";
        foreach ($valores as $indice => $valor) {
            $selected = "";
            if (is_array($valor)) {
                if ($valor[0] == $seleccionado)
                    $selected = "selected=\"selected\"";
                $r .= "<option $selected value=\"$valor[0]\">$valor[1]</option>\n";
            }
            else {
                if ($valor == $seleccionado) {
                    $selected = "selected=\"selected\"";
                }
                $r .= "<option $selected value=\"$valor\">$valor</option>\n";
            }
        }
        $r .= "</select>";
        return $r;
    }

    public static function limpiar($cadena) {
        $search = array("<", ">", "&", "'", "\"");
        $replace = array("&lt;", "&gt", "&amp;", "&apos;", "&quot;");
        $final = str_replace($search, $replace, $cadena);
        return $final;
    }
    public static function codificaContrasena($contrasena){
        
        return password_hash($contrasena, PASSWORD_BCRYPT);

    }
    public static function comprobarContrasena($contrasenaSinCodificar,$contrasenaCodificada){        
        if (password_verify($contrasenaSinCodificar, $contrasenaCodificada)) {
            // es correcta puede entrar
            return TRUE;
        } else {
            // la contraseña es incorrecta
            return FALSE;
        }

    }
    
    public static function contenido($parametro){
        $configuracion['principal'] = 'principal_gd.php';
        $configuracion['perfilUsuario'] = 'perfilUsuario_gd.php';
        $configuracion['clientes'] = 'clientes_gd.php';
        $configuracion['contacta'] = 'contacta_gd.php';
        $configuracion['cliente'] = 'perfilCliente_gd.php';
        $configuracion['ejerciciosLista'] = 'ejerciciosLista_gd.php';
        $configuracion['comidaLista'] = 'comidaLista_gd.php';
        $configuracion['rutina'] = 'anadirRutina_gd.php';
        $configuracion['dieta'] = 'anadirDieta_gd.php';

        
        if ($parametro==NULL || $parametro=="" || empty($parametro)){         
            $modulo = "principal";       
        }else{                    
            $modulo = $_GET['m'];
        }
        if (!empty($configuracion[$modulo])){
            return $contenido = $configuracion[$modulo];
        }else{
            return $contenido = $configuracion["principal"];
        }
        
    }
    

}
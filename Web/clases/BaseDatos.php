<?php
class BaseDatos {
    private $conexion;
    private $resultado;
    private $sentencia;
    function __construct() {
        $this->conexion = new mysqli(Constantes::$servidor, Constantes::$usuario, Constantes::$clave, Constantes::$baseDatos);
        $this->conexion->set_charset("utf8");
        $this->conexion->query("SET lc_time_names = 'es_ES'");
    }
    function closeConexion() {
        $this->conexion->close();
    }
    function limpiar($str){
        return $this->conexion->real_escape_string($str);
    }
    function getAutonumerico() {
        return $this->conexion->insert_id;
    }
    function getFila() {
        return $this->resultado->fetch_array();
    }
    function getTodo() {
        while($row = $this->resultado->fetch_assoc()){
                $rows[] = $row;
        }
        return $rows;
    }
    
    function getFilaObject() {
        return $this->resultado->fetch_object();
    }
    function getNumeroFilasAfectadas() {
        return $this->conexion->affected_rows;
    }
    function getNumeroFilasConsulta() {
        return $this->resultado->num_rows;
    }
    function moverFila($n) {
        $this->resultado->data_seek($n);
    }
    function setConsulta($consulta) {
        return $this->resultado = $this->conexion->query($consulta);
    }
    function setConsultaPreparada($consulta, $arrayparametros){
        $this->prepareConsulta($consulta);
        $this->asociaParametros($arrayparametros);
        $this->ejecutaconsulta();
    }
     private function prepareConsulta($consulta){
        $this->sentencia=$this->conexion->prepare($consulta);
    }

    private function asociaParametros($arrayparametros){
        call_user_func_array(array($this->sentencia,"bind_param"), $this->referencia($arrayparametros));
    }
    private function ejecutaconsulta(){
        $this->sentencia->execute();
        $this->resultado=  $this->sentencia->get_result();
    }
    private function referencia($arrayParametros){
        $referencia=[];
        foreach ($arrayParametros as $indice => $valor) {
            $referencia[$indice]=&$arrayParametros[$indice];            
        }
        return $referencia;
    }
}
?>
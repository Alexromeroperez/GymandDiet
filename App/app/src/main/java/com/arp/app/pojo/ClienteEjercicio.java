package com.arp.app.pojo;

import android.content.ContentValues;
import android.database.Cursor;

import com.arp.app.bd.Contrato;

/**
 * Created by pc-aromero on 03/05/2016.
 */
public class ClienteEjercicio {
    private long id,idejercicio,idcliente;
    private int mes,dias;
    private String duracion;

    public ClienteEjercicio() {
    }

    public ClienteEjercicio(long id, long idejercicio, long idcliente, int mes, int dias, String duracion) {
        this.id = id;
        this.idejercicio = idejercicio;
        this.idcliente = idcliente;
        this.mes = mes;
        this.dias = dias;
        this.duracion = duracion;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdejercicio() {
        return idejercicio;
    }

    public void setIdejercicio(long idejercicio) {
        this.idejercicio = idejercicio;
    }

    public long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setCursor(Cursor c){
        id=c.getLong(c.getColumnIndex(Contrato.TablaClienteEjercicio._ID));
        idejercicio=c.getLong(c.getColumnIndex(Contrato.TablaClienteEjercicio.EJERCICIO));
        idcliente=c.getLong(c.getColumnIndex(Contrato.TablaClienteEjercicio.CLIENTE));
        mes=c.getInt(c.getColumnIndex(Contrato.TablaClienteEjercicio.MES));
        dias=c.getInt(c.getColumnIndex(Contrato.TablaClienteEjercicio.DIA));
        duracion=c.getString(c.getColumnIndex(Contrato.TablaClienteEjercicio.DURACION));
    }

    public ContentValues setValues(){
        ContentValues cv=new ContentValues();
        cv.put(Contrato.TablaClienteEjercicio._ID,id);
        cv.put(Contrato.TablaClienteEjercicio.EJERCICIO,idejercicio);
        cv.put(Contrato.TablaClienteEjercicio.CLIENTE,idcliente);
        cv.put(Contrato.TablaClienteEjercicio.MES,mes);
        cv.put(Contrato.TablaClienteEjercicio.DIA,dias);
        cv.put(Contrato.TablaClienteEjercicio.DURACION,duracion);

        return cv;
    }

    @Override
    public String toString() {
        return "ClienteEjercicio{" +
                "id=" + id +
                ", idejercicio=" + idejercicio +
                ", idcliente=" + idcliente +
                ", mes=" + mes +
                ", dias=" + dias +
                ", duracion='" + duracion + '\'' +
                '}';
    }
}

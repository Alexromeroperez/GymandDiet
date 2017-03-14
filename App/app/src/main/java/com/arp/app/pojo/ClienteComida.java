package com.arp.app.pojo;

import android.content.ContentValues;
import android.database.Cursor;

import com.arp.app.bd.Contrato;

/**
 * Created by pc-aromero on 03/05/2016.
 */
public class ClienteComida {
    private long id,idcliente,idcomida,idhora;
    private int mes,dias;
    private String cantidad;

    public ClienteComida() {
    }

    public ClienteComida(long id, long idcliente, long idcomida, long idhora, int mes, int dias, String cantidad) {
        this.id = id;
        this.idcliente = idcliente;
        this.idcomida = idcomida;
        this.idhora = idhora;
        this.mes = mes;
        this.dias = dias;
        this.cantidad = cantidad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public long getIdcomida() {
        return idcomida;
    }

    public void setIdcomida(long idcomida) {
        this.idcomida = idcomida;
    }

    public long getIdhora() {
        return idhora;
    }

    public void setIdhora(long idhora) {
        this.idhora = idhora;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setCursor(Cursor c){
        id=c.getLong(c.getColumnIndex(Contrato.TablaClienteComida._ID));
        idcomida=c.getLong(c.getColumnIndex(Contrato.TablaClienteComida.COMIDA));
        idcliente=c.getLong(c.getColumnIndex(Contrato.TablaClienteComida.CLIENTE));
        mes=c.getInt(c.getColumnIndex(Contrato.TablaClienteComida.MES));
        dias=c.getInt(c.getColumnIndex(Contrato.TablaClienteComida.DIA));
        cantidad=c.getString(c.getColumnIndex(Contrato.TablaClienteComida.CANTIDAD));
    }

    public ContentValues setValues(){
        ContentValues cv=new ContentValues();
        cv.put(Contrato.TablaClienteComida._ID,id);
        cv.put(Contrato.TablaClienteComida.CLIENTE,idcliente);
        cv.put(Contrato.TablaClienteComida.COMIDA,idcomida);
        cv.put(Contrato.TablaClienteComida.HORA,idhora);
        cv.put(Contrato.TablaClienteComida.MES,mes);
        cv.put(Contrato.TablaClienteComida.DIA,dias);
        cv.put(Contrato.TablaClienteComida.CANTIDAD,cantidad);
        return cv;
    }

    @Override
    public String toString() {
        return "ClienteComida{" +
                "id=" + id +
                ", idcliente=" + idcliente +
                ", idcomida=" + idcomida +
                ", idhora=" + idhora +
                ", mes=" + mes +
                ", dias=" + dias +
                ", cantidad='" + cantidad + '\'' +
                '}';
    }
}

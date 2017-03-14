package com.arp.app.pojo;

import android.content.ContentValues;

import com.arp.app.bd.Contrato;

/**
 * Created by pc-aromero on 03/05/2016.
 */
public class Comida {

    private long id,idgimnasio,idcategoria;
    private String nombre;

    public Comida() {
    }

    public Comida(long id, long idgimnasio, long idcategoria, String nombre) {
        this.id = id;
        this.idgimnasio = idgimnasio;
        this.idcategoria = idcategoria;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdgimnasio() {
        return idgimnasio;
    }

    public void setIdgimnasio(long idgimnasio) {
        this.idgimnasio = idgimnasio;
    }

    public long getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(long idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ContentValues setValues(){
        ContentValues cv=new ContentValues();
        cv.put(Contrato.TablaComida._ID,id);
        cv.put(Contrato.TablaComida.GIMNASIO,idgimnasio);
        cv.put(Contrato.TablaComida.CATEGORIA,idcategoria);
        cv.put(Contrato.TablaComida.NOMBRE,nombre);
        return cv;
    }
    @Override
    public String toString() {
        return "Comida{" +
                "id=" + id +
                ", idgimnasio=" + idgimnasio +
                ", idcategoria=" + idcategoria +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

package com.arp.app.pojo;

import android.content.ContentValues;
import android.content.Context;

import com.arp.app.bd.Contrato;

/**
 * Created by pc-aromero on 03/05/2016.
 */
public class Ejercicio {

    private long id,idgimnasio,idgm;
    private String nombre,imagen;

    public Ejercicio() {
    }

    public Ejercicio(long id, long idgimnasio, long idgm, String nombre, String imagen) {
        this.id = id;
        this.idgimnasio = idgimnasio;
        this.idgm = idgm;
        this.nombre = nombre;
        this.imagen = imagen;
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

    public long getIdgm() {
        return idgm;
    }

    public void setIdgm(long idgm) {
        this.idgm = idgm;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public ContentValues setValues(){
        ContentValues cv=new ContentValues();
        cv.put(Contrato.TablaEjercicio._ID,this.id);
        cv.put(Contrato.TablaEjercicio.GIMNASIO,this.idgimnasio);
        cv.put(Contrato.TablaEjercicio.GM,this.idgm);
        cv.put(Contrato.TablaEjercicio.NOMBRE,this.nombre);
        cv.put(Contrato.TablaEjercicio.IMAGEN,this.imagen);
        return cv;
    }

    @Override
    public String toString() {
        return "Ejercicio{" +
                "id=" + id +
                ", idgimnasio=" + idgimnasio +
                ", idgm=" + idgm +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}

package com.arp.app.pojo;

import android.content.ContentValues;

import com.arp.app.bd.Contrato;

import java.util.Calendar;

/**
 * Created by pc-aromero on 03/05/2016.
 */
public class Categoria {
    private long id;
    private String categoria;

    public Categoria() {
    }

    public Categoria(long id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ContentValues setValues(){
        ContentValues cv=new ContentValues();
        cv.put(Contrato.TablaCategoria._ID,id);
        cv.put(Contrato.TablaCategoria.CATEGORIA,categoria);
        return cv;
    }
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}

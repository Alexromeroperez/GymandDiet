package com.arp.app.pojo;

import android.content.ContentValues;
import android.database.Cursor;

import com.arp.app.bd.Contrato;

/**
 * Created by pc-aromero on 03/05/2016.
 */
public class Hora {
    private long id;
    private String hora;

    public Hora() {
    }

    public Hora(long id, String hora) {
        this.id = id;
        this.hora = hora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public ContentValues setValues(){
        ContentValues cv=new ContentValues();
        cv.put(Contrato.TablaHora._ID,id);
        cv.put(Contrato.TablaHora.HORA,hora);
        return cv;
    }

    public void setCursor(Cursor c){
        id=c.getLong(c.getColumnIndex(Contrato.TablaHora._ID));
        hora=c.getString(c.getColumnIndex(Contrato.TablaHora.HORA));
    }

    @Override
    public String toString() {
        return "Hora{" +
                "id=" + id +
                ", hora='" + hora + '\'' +
                '}';
    }
}

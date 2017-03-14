package com.arp.app.pojo;

import android.content.ContentValues;

import com.arp.app.bd.Contrato;

/**
 * Created by pc-aromero on 03/05/2016.
 */
public class GrupoMuscular {
    private long id;
    private String grupo_muscular;

    public GrupoMuscular() {
    }

    public GrupoMuscular(long id, String grupo_muscular) {
        this.id = id;
        this.grupo_muscular = grupo_muscular;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGrupomuscular() {
        return grupo_muscular;
    }

    public void setGrupomuscular(String grupo_muscular) {
        this.grupo_muscular = grupo_muscular;
    }

    public ContentValues setValues(){
        ContentValues cv=new ContentValues();
        cv.put(Contrato.TablaGrupoMuscular._ID,id);
        cv.put(Contrato.TablaGrupoMuscular.GRUPO,grupo_muscular);
        return cv;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", grupo_muscular='" + grupo_muscular + '\'' +
                '}';
    }
}

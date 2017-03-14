package com.arp.app.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by pc-aromero on 05/05/2016.
 */
public class Ayudante extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="gd.db";
    public static final int DATABASE_VERSION = 1;

    public Ayudante(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
        Log.v("INFO","ENTRO EN EL CREATE DE AYUDANTE");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql;
        sql="create table "+Contrato.TablaCategoria.TABLA+ " ("+
                Contrato.TablaCategoria._ID+ " integer primary key, "+
                Contrato.TablaCategoria.CATEGORIA+" text)";
        db.execSQL(sql);

        String sq2;
        sq2="create table "+Contrato.TablaCliente.TABLA+ " ("+
                Contrato.TablaCliente._ID+ " integer primary key, "+
                Contrato.TablaCliente.GIMNASIO+" integer, "+
                Contrato.TablaCliente.NOMBRE+" text, "+
                Contrato.TablaCliente.CORREO+" text, "+
                Contrato.TablaCliente.FECHA+" text, "+
                Contrato.TablaCliente.PESO+" integer, "+
                Contrato.TablaCliente.ALTURA+" integer, "+
                Contrato.TablaCliente.FOTO+" text)";
        db.execSQL(sq2);

        String sq3;
        sq3="create table "+Contrato.TablaClienteComida.TABLA+ " ("+
                Contrato.TablaClienteComida._ID+ " integer primary key, "+
                Contrato.TablaClienteComida.CLIENTE+" integer, "+
                Contrato.TablaClienteComida.COMIDA+" integer, "+
                Contrato.TablaClienteComida.HORA+" integer, "+
                Contrato.TablaClienteComida.MES+" integer, "+
                Contrato.TablaClienteComida.DIA+" integer, "+
                Contrato.TablaClienteComida.CANTIDAD+" text) ";
        db.execSQL(sq3);

        sq3="create table "+Contrato.TablaClienteEjercicio.TABLA+ " ("+
                Contrato.TablaClienteEjercicio._ID+ " integer primary key, "+
                Contrato.TablaClienteEjercicio.EJERCICIO+" integer, "+
                Contrato.TablaClienteEjercicio.CLIENTE+" integer, "+
                Contrato.TablaClienteEjercicio.MES+" integer, "+
                Contrato.TablaClienteEjercicio.DIA+" integer, "+
                Contrato.TablaClienteEjercicio.DURACION+" text) ";
        db.execSQL(sq3);

        sq3="create table "+Contrato.TablaComida.TABLA+ " ("+
                Contrato.TablaComida._ID+ " integer primary key, "+
                Contrato.TablaComida.GIMNASIO+" integer, "+
                Contrato.TablaComida.CATEGORIA+" integer, "+
                Contrato.TablaComida.NOMBRE+" text) ";
        db.execSQL(sq3);

        sq3="create table "+Contrato.TablaEjercicio.TABLA+ " ("+
                Contrato.TablaEjercicio._ID+ " integer primary key, "+
                Contrato.TablaEjercicio.GIMNASIO+" integer, "+
                Contrato.TablaEjercicio.GM+" integer, "+
                Contrato.TablaEjercicio.NOMBRE+" text, "+
                Contrato.TablaEjercicio.IMAGEN+" text) ";
        db.execSQL(sq3);

        sq3="create table "+Contrato.TablaGrupoMuscular.TABLA+ " ("+
                Contrato.TablaGrupoMuscular._ID+ " integer primary key, "+
                Contrato.TablaGrupoMuscular.GRUPO+" text) ";
        db.execSQL(sq3);

        sq3="create table "+Contrato.TablaHora.TABLA+ " ("+
                Contrato.TablaHora._ID+ " integer primary key, "+
                Contrato.TablaHora.HORA+" text) ";
        db.execSQL(sq3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="drop table if exists "
                + Contrato.TablaCategoria.TABLA;
        db.execSQL(sql);
        sql="drop table if exists "
                + Contrato.TablaCliente.TABLA;
        db.execSQL(sql);
        sql="drop table if exists "
                + Contrato.TablaClienteComida.TABLA;
        db.execSQL(sql);
        sql="drop table if exists "
                + Contrato.TablaClienteEjercicio.TABLA;
        db.execSQL(sql);
        sql="drop table if exists "
                + Contrato.TablaEjercicio.TABLA;
        db.execSQL(sql);
        sql="drop table if exists "
                + Contrato.TablaComida.TABLA;
        db.execSQL(sql);
        sql="drop table if exists "
                + Contrato.TablaGrupoMuscular.TABLA;
        db.execSQL(sql);
        sql="drop table if exists "
                + Contrato.TablaHora.TABLA;
        db.execSQL(sql);
        onCreate(db);

    }
}

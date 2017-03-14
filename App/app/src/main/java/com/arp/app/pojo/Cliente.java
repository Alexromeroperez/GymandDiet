package com.arp.app.pojo;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Patterns;

import com.arp.app.bd.Contrato;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by pc-aromero on 03/05/2016.
 */
public class Cliente implements Parcelable {

    private long id,idgimnasio;
    private String nombre,correo,foto;
    private int peso,altura;
    private String fecha_alta;

    public Cliente() {

    }

    public Cliente(long id, long idgimnasio, String nombre, String correo,String fecha_alta, int peso, int altura,String foto ) {
        this.id = id;
        this.idgimnasio = idgimnasio;
        this.nombre = nombre;
        this.correo = correo;
        this.foto = foto;
        this.peso = peso;
        this.altura = altura;
        this.fecha_alta = fecha_alta;
    }


    protected Cliente(Parcel in) {
        id = in.readLong();
        idgimnasio = in.readLong();
        nombre = in.readString();
        correo = in.readString();
        foto = in.readString();
        peso = in.readInt();
        altura = in.readInt();
        fecha_alta = in.readString();
    }

    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public void setCursor(Cursor c){
        id=c.getLong(c.getColumnIndex(Contrato.TablaCliente._ID));
        idgimnasio=c.getLong(c.getColumnIndex(Contrato.TablaCliente.GIMNASIO));
        nombre=c.getString(c.getColumnIndex(Contrato.TablaCliente.NOMBRE));
        correo=c.getString(c.getColumnIndex(Contrato.TablaCliente.CORREO));
        fecha_alta=c.getString(c.getColumnIndex(Contrato.TablaCliente.FECHA));
        peso=c.getInt(c.getColumnIndex(Contrato.TablaCliente.PESO));
        altura=c.getInt(c.getColumnIndex(Contrato.TablaCliente.ALTURA));
        foto=c.getString(c.getColumnIndex(Contrato.TablaCliente.FOTO));
    }

    public ContentValues setValues(){
        ContentValues cv=new ContentValues();
        cv.put(Contrato.TablaCliente._ID,id);
        cv.put(Contrato.TablaCliente.GIMNASIO,idgimnasio);
        cv.put(Contrato.TablaCliente.NOMBRE,nombre);
        cv.put(Contrato.TablaCliente.CORREO,correo);
        cv.put(Contrato.TablaCliente.FECHA,fecha_alta);
        cv.put(Contrato.TablaCliente.PESO,peso);
        cv.put(Contrato.TablaCliente.ALTURA,altura);
        cv.put(Contrato.TablaCliente.FOTO,foto);
        return cv;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", idgimnasio=" + idgimnasio +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", foto='" + foto + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", fecha_alta=" + fecha_alta +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(idgimnasio);
        dest.writeString(nombre);
        dest.writeString(correo);
        dest.writeString(foto);
        dest.writeInt(peso);
        dest.writeInt(altura);
        dest.writeString(fecha_alta);
    }
}

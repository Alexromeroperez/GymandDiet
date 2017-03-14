package com.arp.app;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.arp.app.bd.Ayudante;
import com.arp.app.bd.Contrato;

/**
 * Created by pc-aromero on 05/05/2016.
 */
public class Proveedor extends ContentProvider {

    public static final UriMatcher uriSwitch;

    public static final int CATEGORIAS = 1;
    public static final int IDCATEGORIA = 2;

    public static final int CLIENTES = 3;
    public static final int IDCLIENTE = 4;

    public static final int CCOMIDAS = 5;
    public static final int IDCCOMIDA = 6;

    public static final int CEJERCICIOS = 7;
    public static final int IDCEJERCICIO= 8;

    public static final int COMIDAS = 9;
    public static final int IDCOMIDA = 10;

    public static final int EJERCICIOS = 11;
    public static final int IDEJERCICIO = 12;

    public static final int GMUSCULARES = 13;
    public static final int IDGMUSCULAR = 14;

    public static final int HORAS = 15;
    public static final int IDHORA = 16;

    static{
        uriSwitch = new UriMatcher(UriMatcher.NO_MATCH);
        uriSwitch.addURI(Contrato.TablaCategoria.AUTHORITY, Contrato.TablaCategoria.TABLA, CATEGORIAS);//Le damos la instrucción de qué hacer a la URI
        uriSwitch.addURI(Contrato.TablaCliente.AUTHORITY, Contrato.TablaCliente.TABLA, CLIENTES);
        uriSwitch.addURI(Contrato.TablaClienteComida.AUTHORITY, Contrato.TablaClienteComida.TABLA, CCOMIDAS);
        uriSwitch.addURI(Contrato.TablaClienteEjercicio.AUTHORITY, Contrato.TablaClienteEjercicio.TABLA, CEJERCICIOS);
        uriSwitch.addURI(Contrato.TablaComida.AUTHORITY, Contrato.TablaComida.TABLA, COMIDAS);
        uriSwitch.addURI(Contrato.TablaEjercicio.AUTHORITY, Contrato.TablaEjercicio.TABLA, EJERCICIOS);
        uriSwitch.addURI(Contrato.TablaGrupoMuscular.AUTHORITY, Contrato.TablaGrupoMuscular.TABLA, GMUSCULARES);
        uriSwitch.addURI(Contrato.TablaHora.AUTHORITY, Contrato.TablaHora.TABLA, HORAS);

        uriSwitch.addURI(Contrato.TablaCategoria.AUTHORITY, Contrato.TablaCategoria.TABLA + "/#", IDCATEGORIA);
        uriSwitch.addURI(Contrato.TablaCliente.AUTHORITY, Contrato.TablaCliente.TABLA + "/#", IDCLIENTE);
        uriSwitch.addURI(Contrato.TablaClienteComida.AUTHORITY, Contrato.TablaClienteComida.TABLA + "/#", IDCCOMIDA);
        uriSwitch.addURI(Contrato.TablaClienteEjercicio.AUTHORITY, Contrato.TablaClienteEjercicio.TABLA + "/#", IDCEJERCICIO);
        uriSwitch.addURI(Contrato.TablaComida.AUTHORITY, Contrato.TablaComida.TABLA + "/#", IDCOMIDA);
        uriSwitch.addURI(Contrato.TablaEjercicio.AUTHORITY, Contrato.TablaEjercicio.TABLA + "/#", IDEJERCICIO);
        uriSwitch.addURI(Contrato.TablaGrupoMuscular.AUTHORITY, Contrato.TablaGrupoMuscular.TABLA + "/#", IDGMUSCULAR);
        uriSwitch.addURI(Contrato.TablaHora.AUTHORITY, Contrato.TablaHora.TABLA + "/#", IDHORA);

    }

    private Ayudante ad;



    @Override
    public boolean onCreate() {
        ad=new Ayudante(getContext());
        Log.v("INFO","ENTRO EN EL CREATE DE PROVEEDOR");
        ad.getReadableDatabase();
        return true;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriSwitch.match(uri)){
            case CATEGORIAS:
                return Contrato.TablaCategoria.MULTIPLE_MIME;
            case IDCATEGORIA:
                return Contrato.TablaCategoria.SINGLE_MIME;
            case CLIENTES:
                return Contrato.TablaCliente.MULTIPLE_MIME;
            case IDCLIENTE:
                return Contrato.TablaCliente.SINGLE_MIME;
            case CCOMIDAS:
                return Contrato.TablaClienteComida.MULTIPLE_MIME;
            case IDCCOMIDA:
                return Contrato.TablaClienteComida.SINGLE_MIME;
            case CEJERCICIOS:
                return Contrato.TablaClienteEjercicio.MULTIPLE_MIME;
            case IDCEJERCICIO:
                return Contrato.TablaClienteEjercicio.SINGLE_MIME;
            case COMIDAS:
                return Contrato.TablaComida.MULTIPLE_MIME;
            case IDCOMIDA:
                return Contrato.TablaComida.SINGLE_MIME;
            case EJERCICIOS:
                return Contrato.TablaEjercicio.MULTIPLE_MIME;
            case IDEJERCICIO:
                return Contrato.TablaEjercicio.SINGLE_MIME;
            case GMUSCULARES:
                return Contrato.TablaGrupoMuscular.MULTIPLE_MIME;
            case IDGMUSCULAR:
                return Contrato.TablaGrupoMuscular.SINGLE_MIME;
            case HORAS:
                return Contrato.TablaHora.MULTIPLE_MIME;
            case IDHORA:
                return Contrato.TablaHora.SINGLE_MIME;
            default:
                throw new IllegalArgumentException("Tipo de actividad desconocida " + uri);
        }
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = ad.getReadableDatabase();
        int match=uriSwitch.match(uri);
        long idActividad=0;
        Cursor c;
        switch (match){
            case CATEGORIAS:
                c = db.query(Contrato.TablaCategoria.TABLA, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case CLIENTES:
                c = db.query(Contrato.TablaCliente.TABLA, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case CCOMIDAS:
                c = db.query(Contrato.TablaClienteComida.TABLA, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case CEJERCICIOS:
                c = db.query(Contrato.TablaClienteEjercicio.TABLA, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case COMIDAS:
                c = db.query(Contrato.TablaComida.TABLA, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case EJERCICIOS:
                c = db.query(Contrato.TablaEjercicio.TABLA, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case GMUSCULARES:
                c = db.query(Contrato.TablaGrupoMuscular.TABLA, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case HORAS:
                c = db.query(Contrato.TablaHora.TABLA, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case IDCATEGORIA:
                idActividad = ContentUris.parseId(uri);
                c = db.query(Contrato.TablaCategoria.TABLA, projection, Contrato.TablaCategoria._ID + "= ? " , new String [] {idActividad + ""},
                        null, null, sortOrder);
                break;
            case IDCLIENTE:
                idActividad = ContentUris.parseId(uri);
                c = db.query(Contrato.TablaCliente.TABLA, projection, Contrato.TablaCliente._ID + "= ? " , new String [] {idActividad + ""},
                        null, null, sortOrder);
                break;
            case IDCCOMIDA:
                idActividad = ContentUris.parseId(uri);
                c = db.query(Contrato.TablaClienteComida.TABLA, projection, Contrato.TablaClienteComida._ID + "= ? " , new String [] {idActividad + ""},
                        null, null, sortOrder);
                break;
            case IDCEJERCICIO:
                idActividad = ContentUris.parseId(uri);
                c = db.query(Contrato.TablaClienteEjercicio.TABLA, projection, Contrato.TablaClienteEjercicio._ID + "= ? " , new String [] {idActividad + ""},
                        null, null, sortOrder);
                break;
            case IDCOMIDA:
                idActividad = ContentUris.parseId(uri);
                c = db.query(Contrato.TablaComida.TABLA, projection, Contrato.TablaComida._ID + "= ? " , new String [] {idActividad + ""},
                        null, null, sortOrder);
                break;
            case IDEJERCICIO:
                idActividad = ContentUris.parseId(uri);
                c = db.query(Contrato.TablaEjercicio.TABLA, projection, Contrato.TablaEjercicio._ID + "= ? " , new String [] {idActividad + ""},
                        null, null, sortOrder);
                break;
            case IDGMUSCULAR:
                idActividad = ContentUris.parseId(uri);
                c = db.query(Contrato.TablaGrupoMuscular.TABLA, projection, Contrato.TablaGrupoMuscular._ID + "= ? " , new String [] {idActividad + ""},
                        null, null, sortOrder);
                break;
            case IDHORA:
                idActividad = ContentUris.parseId(uri);
                c = db.query(Contrato.TablaHora.TABLA, projection, Contrato.TablaHora._ID + "= ? " , new String [] {idActividad + ""},
                        null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("URI no soportada: " + uri);
        }
        switch (match) {
            case CATEGORIAS: case IDCATEGORIA:
                c.setNotificationUri(getContext().getContentResolver(),Contrato.TablaCategoria.CONTENT_URI);
                break;
            case CLIENTES: case IDCLIENTE:
                c.setNotificationUri(getContext().getContentResolver(),Contrato.TablaCliente.CONTENT_URI);
                break;
            case CCOMIDAS: case IDCCOMIDA:
                c.setNotificationUri(getContext().getContentResolver(),Contrato.TablaClienteComida.CONTENT_URI);
                break;
            case CEJERCICIOS: case IDCEJERCICIO:
                c.setNotificationUri(getContext().getContentResolver(),Contrato.TablaClienteEjercicio.CONTENT_URI);
                break;
            case COMIDAS: case IDCOMIDA:
                c.setNotificationUri(getContext().getContentResolver(),Contrato.TablaComida.CONTENT_URI);
                break;
            case EJERCICIOS: case IDEJERCICIO:
                c.setNotificationUri(getContext().getContentResolver(),Contrato.TablaEjercicio.CONTENT_URI);
                break;
            case GMUSCULARES: case IDGMUSCULAR:
                c.setNotificationUri(getContext().getContentResolver(),Contrato.TablaGrupoMuscular.CONTENT_URI);
                break;
            case HORAS: case IDHORA:
                c.setNotificationUri(getContext().getContentResolver(),Contrato.TablaHora.CONTENT_URI);
                break;
        }
        return c;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if(uriSwitch.match(uri) != CATEGORIAS && uriSwitch.match(uri) != IDCATEGORIA &&
                uriSwitch.match(uri) != CLIENTES && uriSwitch.match(uri) != IDCLIENTE &&uriSwitch.match(uri) != CCOMIDAS && uriSwitch.match(uri) != IDCCOMIDA &&
                uriSwitch.match(uri) != CEJERCICIOS && uriSwitch.match(uri) != IDCEJERCICIO &&uriSwitch.match(uri) != COMIDAS && uriSwitch.match(uri) != IDCOMIDA &&
                uriSwitch.match(uri) != EJERCICIOS && uriSwitch.match(uri) != IDEJERCICIO &&uriSwitch.match(uri) != GMUSCULARES && uriSwitch.match(uri) != IDGMUSCULAR &&
                uriSwitch.match(uri) != HORAS && uriSwitch.match(uri) != IDHORA){
            throw new IllegalArgumentException("URI desconocida : " + uri + uriSwitch.match(uri) );
        }
        ContentValues contentValues;
        if (values != null) {
            contentValues =values;
        } else {
            contentValues = new ContentValues();
        }
        long rowId=0;
        SQLiteDatabase db = ad.getWritableDatabase();
        switch (uriSwitch.match(uri)) {
            case CATEGORIAS:
                rowId = db.insert(Contrato.TablaCategoria.TABLA, null, contentValues);
                if (rowId > 0) {
                    //Si se ha insertado el elemento correctamente, entonces devolvemos la uri del elemento que se acaba de insertar
                    Uri uri_actividad = ContentUris.withAppendedId(Contrato.TablaCategoria.CONTENT_URI, rowId);
                    getContext().getContentResolver().notifyChange(uri_actividad, null);
                    return uri_actividad;
                }
                throw new SQLException("Error al insertar fila en : " + uri);
            case CLIENTES:
                rowId = db.insert(Contrato.TablaCliente.TABLA, null, contentValues);
                if (rowId > 0) {
                    //Si se ha insertado el elemento correctamente, entonces devolvemos la uri del elemento que se acaba de insertar
                    Uri uri_actividad = ContentUris.withAppendedId(Contrato.TablaCliente.CONTENT_URI, rowId);
                    getContext().getContentResolver().notifyChange(uri_actividad, null);
                    return uri_actividad;
                }
                throw new SQLException("Error al insertar fila en : " + uri);
            case CCOMIDAS:
                rowId = db.insert(Contrato.TablaClienteComida.TABLA, null, contentValues);
                if (rowId > 0) {
                    //Si se ha insertado el elemento correctamente, entonces devolvemos la uri del elemento que se acaba de insertar
                    Uri uri_actividad = ContentUris.withAppendedId(Contrato.TablaClienteComida.CONTENT_URI, rowId);
                    getContext().getContentResolver().notifyChange(uri_actividad, null);
                    return uri_actividad;
                }
                throw new SQLException("Error al insertar fila en : " + uri);
            case CEJERCICIOS:
                rowId = db.insert(Contrato.TablaClienteEjercicio.TABLA, null, contentValues);
                if (rowId > 0) {
                    //Si se ha insertado el elemento correctamente, entonces devolvemos la uri del elemento que se acaba de insertar
                    Uri uri_actividad = ContentUris.withAppendedId(Contrato.TablaClienteEjercicio.CONTENT_URI, rowId);
                    getContext().getContentResolver().notifyChange(uri_actividad, null);
                    return uri_actividad;
                }
                throw new SQLException("Error al insertar fila en : " + uri);
            case COMIDAS:
                rowId = db.insert(Contrato.TablaComida.TABLA, null, contentValues);
                if (rowId > 0) {
                    //Si se ha insertado el elemento correctamente, entonces devolvemos la uri del elemento que se acaba de insertar
                    Uri uri_actividad = ContentUris.withAppendedId(Contrato.TablaComida.CONTENT_URI, rowId);
                    getContext().getContentResolver().notifyChange(uri_actividad, null);
                    return uri_actividad;
                }
                throw new SQLException("Error al insertar fila en : " + uri);
            case EJERCICIOS:
                rowId = db.insert(Contrato.TablaEjercicio.TABLA, null, contentValues);
                if (rowId > 0) {
                    //Si se ha insertado el elemento correctamente, entonces devolvemos la uri del elemento que se acaba de insertar
                    Uri uri_actividad = ContentUris.withAppendedId(Contrato.TablaEjercicio.CONTENT_URI, rowId);
                    getContext().getContentResolver().notifyChange(uri_actividad, null);
                    return uri_actividad;
                }
                throw new SQLException("Error al insertar fila en : " + uri);
            case GMUSCULARES:
                rowId = db.insert(Contrato.TablaGrupoMuscular.TABLA, null, contentValues);
                if (rowId > 0) {
                    //Si se ha insertado el elemento correctamente, entonces devolvemos la uri del elemento que se acaba de insertar
                    Uri uri_actividad = ContentUris.withAppendedId(Contrato.TablaGrupoMuscular.CONTENT_URI, rowId);
                    getContext().getContentResolver().notifyChange(uri_actividad, null);
                    return uri_actividad;
                }
                throw new SQLException("Error al insertar fila en : " + uri);
            case HORAS:
                rowId = db.insert(Contrato.TablaHora.TABLA, null, contentValues);
                if (rowId > 0) {
                    //Si se ha insertado el elemento correctamente, entonces devolvemos la uri del elemento que se acaba de insertar
                    Uri uri_actividad = ContentUris.withAppendedId(Contrato.TablaHora.CONTENT_URI, rowId);
                    getContext().getContentResolver().notifyChange(uri_actividad, null);
                    return uri_actividad;
                }
                throw new SQLException("Error al insertar fila en : " + uri);
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = ad.getWritableDatabase();// Vuelve a abrir la base de datos para conectar con ella en modo escritura
        int match = uriSwitch.match(uri);//Obtengo la uri
        int affected;
        switch (match) {
            case CATEGORIAS: //Muchas canciones
                affected = db.delete(Contrato.TablaCategoria.TABLA, selection, selectionArgs);
                break;

            case CCOMIDAS:
                affected = db.delete(Contrato.TablaClienteComida.TABLA, selection, selectionArgs);
                break;

            case CLIENTES:
                affected = db.delete(Contrato.TablaCliente.TABLA, selection, selectionArgs);
                break;

            case CEJERCICIOS:
                affected = db.delete(Contrato.TablaClienteEjercicio.TABLA, selection, selectionArgs);
                break;

            case COMIDAS:
                affected = db.delete(Contrato.TablaComida.TABLA, selection, selectionArgs);
                break;

            case EJERCICIOS:
                affected = db.delete(Contrato.TablaEjercicio.TABLA, selection, selectionArgs);
                break;

            case GMUSCULARES:
                affected = db.delete(Contrato.TablaGrupoMuscular.TABLA, selection, selectionArgs);
                break;
            case HORAS:
                affected = db.delete(Contrato.TablaHora.TABLA, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Elemento actividad desconocido: " +
                        uri);
        }
        // Notificar cambio asociado a la urigetContext().getContentResolver().notifyChange(uri, null);
        getContext().getContentResolver().notifyChange(uri, null);
        return affected;//Devuelve el numero de filas borradas
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = ad.getWritableDatabase();
        int affected;
        String idActividad="";
        switch (uriSwitch.match(uri)) {
            case CATEGORIAS:
                affected = db.update(Contrato.TablaCategoria.TABLA, values, selection, selectionArgs);
                break;
            case IDCATEGORIA:
                idActividad = uri.getPathSegments().get(1);
                affected = db.update(Contrato.TablaCategoria.TABLA, values,
                        Contrato.TablaCategoria._ID + "= ?", new String[]{idActividad});
                break;
            case CLIENTES:
                affected = db.update(Contrato.TablaCliente.TABLA, values, selection, selectionArgs);
                break;
            case IDCLIENTE:
                idActividad = uri.getPathSegments().get(1);
                affected = db.update(Contrato.TablaCliente.TABLA, values,
                        Contrato.TablaCategoria._ID + "= ?", new String[]{idActividad});
                break;
            case CCOMIDAS:
                affected = db.update(Contrato.TablaClienteComida.TABLA, values, selection, selectionArgs);
                break;
            case IDCCOMIDA:
                idActividad = uri.getPathSegments().get(1);
                affected = db.update(Contrato.TablaClienteComida.TABLA, values,
                        Contrato.TablaCategoria._ID + "= ?", new String[]{idActividad});
                break;
            case CEJERCICIOS:
                affected = db.update(Contrato.TablaClienteEjercicio.TABLA, values, selection, selectionArgs);
                break;
            case IDCEJERCICIO:
                idActividad = uri.getPathSegments().get(1);
                affected = db.update(Contrato.TablaClienteEjercicio.TABLA, values,
                        Contrato.TablaCategoria._ID + "= ?", new String[]{idActividad});
                break;
            case COMIDAS:
                affected = db.update(Contrato.TablaComida.TABLA, values, selection, selectionArgs);
                break;
            case IDCOMIDA:
                idActividad = uri.getPathSegments().get(1);
                affected = db.update(Contrato.TablaComida.TABLA, values,
                        Contrato.TablaCategoria._ID + "= ?", new String[]{idActividad});
                break;
            case EJERCICIOS:
                affected = db.update(Contrato.TablaEjercicio.TABLA, values, selection, selectionArgs);
                break;
            case IDEJERCICIO:
                idActividad = uri.getPathSegments().get(1);
                affected = db.update(Contrato.TablaEjercicio.TABLA, values,
                        Contrato.TablaCategoria._ID + "= ?", new String[]{idActividad});
                break;
            case GMUSCULARES:
                affected = db.update(Contrato.TablaGrupoMuscular.TABLA, values, selection, selectionArgs);
                break;
            case IDGMUSCULAR:
                idActividad = uri.getPathSegments().get(1);
                affected = db.update(Contrato.TablaGrupoMuscular.TABLA, values,
                        Contrato.TablaCategoria._ID + "= ?", new String[]{idActividad});
                break;
            case HORAS:
                affected = db.update(Contrato.TablaHora.TABLA, values, selection, selectionArgs);
                break;
            case IDHORA:
                idActividad = uri.getPathSegments().get(1);
                affected = db.update(Contrato.TablaHora.TABLA, values,
                        Contrato.TablaCategoria._ID + "= ?", new String[]{idActividad});
                break;
            default:
                throw new IllegalArgumentException("URI desconocida: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return affected;
    }

}

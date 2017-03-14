package com.arp.app.bd;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by pc-aromero on 05/05/2016.
 */
public class Contrato {

    public Contrato() {
    }

    public static abstract class TablaCategoria implements BaseColumns {

        public static final String TABLA = "categoria";
        public static final String CATEGORIA = "categoria";

        //La autoridad es la cadena q identifica a qué contentprovider se llama
        public final static String AUTHORITY = "com.arp.app.Proveedor";
        //Definir como llego a la tabla cliente (a q tabla estoy llegando)
        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MULTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;
    }

    public static abstract class TablaCliente implements BaseColumns {

        public static final String TABLA = "cliente";
        public static final String GIMNASIO = "idgimnasio";
        public static final String NOMBRE = "nombre";
        public static final String CORREO = "correo";
        public static final String FECHA = "fecha_alta";
        public static final String PESO = "peso";
        public static final String ALTURA = "altura";
        public static final String FOTO = "foto";


        //La autoridad es la cadena q identifica a qué contentprovider se llama
        public final static String AUTHORITY = "com.arp.app.Proveedor";
        //Definir como llego a la tabla cliente (a q tabla estoy llegando)
        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MULTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;
    }

    public static abstract class TablaClienteComida implements BaseColumns {

        public static final String TABLA = "clientecomida";
        public static final String CLIENTE = "idcliente";
        public static final String COMIDA = "idcomida";
        public static final String HORA = "idhora";
        public static final String MES = "mes";
        public static final String DIA = "dias";
        public static final String CANTIDAD = "cantidad";

        //La autoridad es la cadena q identifica a qué contentprovider se llama
        public final static String AUTHORITY = "com.arp.app.Proveedor";
        //Definir como llego a la tabla cliente (a q tabla estoy llegando)
        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MULTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;
    }

    public static abstract class TablaClienteEjercicio implements BaseColumns {

        public static final String TABLA = "clienteejercicio";
        public static final String EJERCICIO = "idejercicio";
        public static final String CLIENTE = "idcliente";
        public static final String MES = "mes";
        public static final String DIA = "dias";
        public static final String DURACION = "duracion";

        //La autoridad es la cadena q identifica a qué contentprovider se llama
        public final static String AUTHORITY = "com.arp.app.Proveedor";
        //Definir como llego a la tabla cliente (a q tabla estoy llegando)
        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MULTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;
    }

    public static abstract class TablaComida implements BaseColumns {

        public static final String TABLA = "comida";
        public static final String GIMNASIO = "idgimnasio";
        public static final String CATEGORIA = "idcategoria";
        public static final String NOMBRE = "nombre";


        //La autoridad es la cadena q identifica a qué contentprovider se llama
        public final static String AUTHORITY = "com.arp.app.Proveedor";
        //Definir como llego a la tabla cliente (a q tabla estoy llegando)
        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MULTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;
    }

    public static abstract class TablaEjercicio implements BaseColumns {

        public static final String TABLA = "ejercicio";
        public static final String GIMNASIO = "idgimnasio";
        public static final String GM = "idgm";
        public static final String NOMBRE = "nombre";
        public static final String IMAGEN = "imagen";


        //La autoridad es la cadena q identifica a qué contentprovider se llama
        public final static String AUTHORITY = "com.arp.app.Proveedor";
        //Definir como llego a la tabla cliente (a q tabla estoy llegando)
        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MULTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;
    }

    public static abstract class TablaGrupoMuscular implements BaseColumns {

        public static final String TABLA = "grupomuscular";
        public static final String GRUPO = "grupo_muscular";

        //La autoridad es la cadena q identifica a qué contentprovider se llama
        public final static String AUTHORITY = "com.arp.app.Proveedor";
        //Definir como llego a la tabla cliente (a q tabla estoy llegando)
        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MULTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;
    }

    public static abstract class TablaHora implements BaseColumns {

        public static final String TABLA = "hora";
        public static final String HORA = "hora";

        //La autoridad es la cadena q identifica a qué contentprovider se llama
        public final static String AUTHORITY = "com.arp.app.Proveedor";
        //Definir como llego a la tabla cliente (a q tabla estoy llegando)
        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MULTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;
    }
}

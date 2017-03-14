package com.arp.app.auxiliares;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by pc-aromero on 09/05/2016.
 */
public class Interfaz {
    public static void tostada(Context c, int texto){
        Toast.makeText(c,texto,Toast.LENGTH_SHORT).show();
    }

    public static boolean conexion(Context c){
        ConnectivityManager conMgr = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();
        if (i == null)
            return false;
        if (!i.isConnected())
            return false;
        if (!i.isAvailable())
            return false;
        return true;
    }
}

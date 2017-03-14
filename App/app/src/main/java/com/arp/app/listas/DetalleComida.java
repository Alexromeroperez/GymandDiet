package com.arp.app.listas;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import com.arp.app.Api;
import com.arp.app.R;
import com.arp.app.adaptadores.AdaptadorComida;
import com.arp.app.adaptadores.AdaptadorEjercicio;
import com.arp.app.auxiliares.Interfaz;
import com.arp.app.bd.Contrato;
import com.arp.app.pojo.ClienteComida;
import com.arp.app.pojo.ClienteEjercicio;
import com.arp.app.pojo.Hora;
import com.arp.app.auxiliares.RetrofitCliente;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleComida extends AppCompatActivity {

    private ExpandableListView lv;
    private AdaptadorComida adC;
    private List<Hora> horas;
    private HashMap<Hora,List<ClienteComida>> contenido;
    private Cursor c;
    private int dia;
    private List<ClienteComida> tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_comida);
        dia = getIntent().getIntExtra("dia", 0);
        lv=(ExpandableListView)findViewById(R.id.lvDetalleComida);
        lv.setDivider(null);
        horas = new ArrayList<>();
        contenido = new HashMap<>();
        init();
    }

    private void init() {
        getHoraBd();
        for (Hora hora:horas) {
            contenido.put(hora,consultaBd(hora));
        }
        adC = new AdaptadorComida(this, horas,contenido);
        lv.setAdapter(adC);
    }

    private List<ClienteComida> consultaBd(Hora hora) {
        tiempo=new ArrayList<>();
        String var = Contrato.TablaClienteComida.MES + " = ? and " + Contrato.TablaClienteComida.DIA + " = ? and "+Contrato.TablaClienteComida.HORA+" = ?";
        c = getContentResolver().query(Contrato.TablaClienteComida.CONTENT_URI, null, var, new String[]{(Calendar.getInstance().get(Calendar.MONTH)+1) + "", dia + "",hora.getId()+""}, null);
        while (c.moveToNext()) {
            ClienteComida cc = new ClienteComida();
            cc.setCursor(c);
            tiempo.add(cc);
        }
        return tiempo;
    }

    private void getHoraBd(){
        c=getContentResolver().query(Contrato.TablaHora.CONTENT_URI,null,null,null,Contrato.TablaHora._ID);
        while (c.moveToNext()){
            Hora h=new Hora();
            h.setCursor(c);
            horas.add(h);
        }
    }

}

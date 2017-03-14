package com.arp.app.listas;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.arp.app.Api;
import com.arp.app.R;
import com.arp.app.adaptadores.AdaptadorEjercicio;
import com.arp.app.auxiliares.Interfaz;
import com.arp.app.bd.Contrato;
import com.arp.app.pojo.ClienteEjercicio;
import com.arp.app.auxiliares.RetrofitCliente;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleEjercicio extends AppCompatActivity {

    private ListView lv;
    private List<ClienteEjercicio> ejercicios;
    private AdaptadorEjercicio adE;
    private RetrofitCliente retrofit;
    private SharedPreferences sh;
    private Api api;
    private int dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        dia = getIntent().getIntExtra("dia", 0);
        sh = this.getSharedPreferences("informacion", Context.MODE_PRIVATE);
        lv = (ListView) findViewById(R.id.lvDetalleEjer);

        lv.setDivider(null);

        retrofit = new RetrofitCliente();
        api = retrofit.getApi();
        ejercicios = new ArrayList<>();

        if (Interfaz.conexion(this)) {
            Call<List<ClienteEjercicio>> call = api.getEjercicios(sh.getInt("idCl", 0), (Calendar.getInstance().get(Calendar.MONTH)+1), dia);
            call.enqueue(new Callback<List<ClienteEjercicio>>() {
                @Override
                public void onResponse(Call<List<ClienteEjercicio>> call, Response<List<ClienteEjercicio>> response) {

                    for (ClienteEjercicio ejer : response.body()) {
                        ejercicios.add(ejer);
                    }
                    adE = new AdaptadorEjercicio(getApplicationContext(), ejercicios);
                    lv.setAdapter(adE);

                }

                @Override
                public void onFailure(Call<List<ClienteEjercicio>> call, Throwable t) {
                    consultaBd();
                }
            });
        }else{
            consultaBd();
        }
    }

    private void consultaBd(){
        String var=Contrato.TablaClienteEjercicio.MES+" = ? and "+Contrato.TablaClienteEjercicio.DIA+" = ?";
        Cursor c=getContentResolver().query(Contrato.TablaClienteEjercicio.CONTENT_URI,null,var,new String[]{(Calendar.getInstance().get(Calendar.MONTH)+1)+"",dia+""},null);
        while (c.moveToNext()){
            ClienteEjercicio ce=new ClienteEjercicio();
            ce.setCursor(c);
            ejercicios.add(ce);
        }
        adE = new AdaptadorEjercicio(this, ejercicios);
        lv.setAdapter(adE);
    }
}

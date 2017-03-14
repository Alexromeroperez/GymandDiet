package com.arp.app.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.arp.app.Api;
import com.arp.app.R;
import com.arp.app.auxiliares.Interfaz;
import com.arp.app.auxiliares.Splash;
import com.arp.app.auxiliares.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private SharedPreferences sh;
    private SharedPreferences.Editor editor;
    private EditText et;
    private RetrofitCliente rc;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et=(EditText)findViewById(R.id.etCodigo);
        sh=this.getSharedPreferences("informacion",Context.MODE_PRIVATE);
        rc=new RetrofitCliente();
        api=rc.getApi();
        if(sh.getString("codigo","")!=""){
            Intent i=new Intent(this,Splash.class);
            startActivity(i);
            finish();
        }
    }

    public void acceder(View v){
        if(Interfaz.conexion(this)) {
            final String codigo = et.getText().toString();
            if (!codigo.equals("")) {
                final int[] id = {-1};
                Call<Integer> call = api.getIdGim(codigo);
                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        int idr = response.body();
                        id[0] = idr;
                        if (id[0] != -1) {
                            editor = sh.edit();
                            editor.putLong("idgym", id[0]);
                            editor.commit();
                            Intent i = new Intent(getApplicationContext(), Info.class);
                            i.putExtra("codigo", codigo);
                            startActivity(i);
                            finish();
                        } else {
                            Interfaz.tostada(getApplicationContext(), R.string.ttCodigo);
                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Interfaz.tostada(getApplicationContext(), R.string.ttError);
                    }
                });

            } else {
                Interfaz.tostada(this, R.string.ttCodigo2);
            }
        } else {
            Interfaz.tostada(this,R.string.ttError);
        }
    }
}

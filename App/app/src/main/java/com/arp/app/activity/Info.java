package com.arp.app.activity;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.arp.app.Api;
import com.arp.app.R;
import com.arp.app.auxiliares.Interfaz;
import com.arp.app.auxiliares.Splash;
import com.arp.app.pojo.Cliente;
import com.arp.app.auxiliares.RetrofitCliente;

import java.util.List;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Info extends AppCompatActivity {
    private EditText etNombre, etAltura, etPeso;
    private RetrofitCliente rc;
    private Api api;
    private long idGym;
    private SharedPreferences sh;
    private SharedPreferences.Editor editor;
    private String codigo;
    private Cliente cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        codigo = getIntent().getStringExtra("codigo");
        etAltura = (EditText) findViewById(R.id.etAltura);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etPeso = (EditText) findViewById(R.id.etPeso);

        sh = this.getSharedPreferences("informacion", Context.MODE_PRIVATE);
        idGym = sh.getLong("idgym", 0);
        rc = new RetrofitCliente();
        api = rc.getApi();
    }

    public void aceptar(View v) {
        if (compruebaCampos()) {
            cl = new Cliente(0, idGym, etNombre.getText().toString(), getEmailCliente(), null, Integer.parseInt(etPeso.getText().toString()), Integer.parseInt(etAltura.getText().toString()), "sinfoto.jpg");
            checkCliente(cl);
        } else {
            Interfaz.tostada(this, R.string.ttInfo);
        }
    }

    public void recuperar(View v) {
        Call<List<Cliente>> call = api.getCorreo(getEmailCliente());
        call.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                if (response.body().size() != 0) {
                    Cliente cl = response.body().get(0);
                    editor = sh.edit();
                    editor.putInt("idCl", (int) cl.getId());
                    editor.putString("codigo", codigo);
                    editor.commit();
                    Intent i = new Intent(getApplicationContext(), Splash.class);
                    startActivity(i);
                    finish();
                } else {
                    Interfaz.tostada(getApplicationContext(), R.string.ttCuenta);
                }
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                Interfaz.tostada(getApplicationContext(), R.string.ttError);
            }
        });
    }

    private boolean compruebaCampos() {
        if (etAltura.getText().toString().compareTo("") != 0 && etPeso.getText().toString().compareTo("") != 0 && etNombre.getText().toString().compareTo("") != 0) {
            return true;
        }
        return false;
    }

    private void insertCliente(Cliente cl) {
        final int[] id = {-1};
        Call<Integer> call = api.setCliente(cl);
        call.enqueue(new Callback<Integer>() {
                         @Override
                         public void onResponse(Call<Integer> call, Response<Integer> response) {
                             id[0] = response.body();
                             editor = sh.edit();
                             editor.putInt("idCl", id[0]);
                             editor.putString("codigo", codigo);
                             editor.commit();
                             Intent i = new Intent(getApplicationContext(), Splash.class);
                             startActivity(i);
                             finish();
                         }

                         @Override
                         public void onFailure(Call<Integer> call, Throwable t) {
                             Interfaz.tostada(getApplicationContext(), R.string.ttError);
                         }
                     }
        );
    }

    private void checkCliente(final Cliente cl) {
        Call<List<Cliente>> call = api.getCorreo(getEmailCliente());
        call.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                if (response.body().size() == 0) {
                    insertCliente(cl);
                } else {
                    Interfaz.tostada(getApplicationContext(), R.string.ttCuenta2);
                }
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                Interfaz.tostada(getApplicationContext(), R.string.ttError);
            }
        });
    }

    private String getEmailCliente() {
        Pattern email = Patterns.EMAIL_ADDRESS;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return "sinpermiso";
        }
        Account[] accounts = AccountManager.get(this).getAccounts();
        for (Account account : accounts) {
            if (email.matcher(account.name).matches()) {
                String possibleEmail = account.name;
                return possibleEmail;
            }
        }
        return "";
    }
}

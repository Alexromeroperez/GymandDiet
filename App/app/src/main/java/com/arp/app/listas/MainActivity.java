package com.arp.app.listas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import com.arp.app.Api;
import com.arp.app.Proveedor;
import com.arp.app.R;
import com.arp.app.adaptadores.Adaptador;
import com.arp.app.auxiliares.Consultas;
import com.arp.app.auxiliares.Interfaz;
import com.arp.app.bd.Contrato;
import com.arp.app.pojo.Cliente;
import com.arp.app.auxiliares.RetrofitCliente;

import java.io.File;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TabHost tabhost;
    private ListView lvRutina,lvDieta;
    private Adaptador ad;
    private String[] dias;
    private Cliente cl;
    private Proveedor pr;
    private RetrofitCliente retr;
    private Api api;
    private Consultas con;
    private SharedPreferences sh;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sh = this.getSharedPreferences("informacion", Context.MODE_PRIVATE);
        pr=new Proveedor();
        sincronizar();
        initTab();
        init();
    }

    /*******************************************************/
    /*******************************************************/
    /**********************Menus****************************/
    /*******************************************************/
    /*******************************************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id) {
            case R.id.sincro:
                editor = sh.edit();
                editor.putBoolean("sinc", false);
                editor.commit();
                deleteInfoMovil();
                sincronizar();
                return true;

            case R.id.gim:
                alert();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**********************************************************/
    /**********************************************************/
                    /*METODOS DE INICIO*/
    /**********************************************************/
    /**********************************************************/

    private void sincronizar(){
        if(sh.getBoolean("sinc",false)==false){
            if(Interfaz.conexion(this)) {
                con = new Consultas(this);
                con.generarDatos();
                editor = sh.edit();
                editor.putBoolean("sinc", true);
                editor.commit();
            }else {
                Interfaz.tostada(this,R.string.ttError);
            }
        }else{
            Cursor c=getContentResolver().query(Contrato.TablaCliente.CONTENT_URI,null,null,null,null);
            c.moveToFirst();
            cl=new Cliente();
            cl.setCursor(c);
        }
    }

    private void initTab(){
        tabhost= (TabHost) findViewById(R.id.tabHost);
        tabhost.setup();
        TabHost.TabSpec tab1 = tabhost.newTabSpec("tab1");  //aspectos de cada Tab (pestaña)
        TabHost.TabSpec tab2 = tabhost.newTabSpec("tab2");
        tab1.setIndicator("Rutina");    //qué queremos que aparezca en las pestañas
        tab1.setContent(R.id.rutina);
        tab2.setIndicator("Dieta");    //qué queremos que aparezca en las pestañas
        tab2.setContent(R.id.dieta);
        tabhost.addTab(tab1);
        tabhost.addTab(tab2);
    }

    private void init(){
        lvRutina=(ListView)findViewById(R.id.lvRutina);
        lvDieta=(ListView)findViewById(R.id.lvDieta);
        dias=getResources().getStringArray(R.array.semana);
        retr=new RetrofitCliente();
        api=retr.getApi();
        ad=new Adaptador(this,dias);
        lvRutina.setAdapter(ad);
        lvDieta.setAdapter(ad);
        clickList(lvRutina,this,DetalleEjercicio.class);
        clickList(lvDieta,this,DetalleComida.class);
    }

    private void clickList(final ListView lv, final Context origen, final Class destino){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(origen,destino);
                i.putExtra("dia",position+1);
                startActivity(i);
            }
        });
    }

    /**********************************************************/
    /**********************************************************/
                    /*METODOS DE CAMBIO DE GIMNASIO*/
    /**********************************************************/
    /**********************************************************/

    private void alert(){
        final EditText et;
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View v=inflater.inflate(R.layout.activity_cambio_gim, null);
        et=(EditText) v.findViewById(R.id.etCod);
        builder.setView(v);
        builder.setMessage(R.string.etCodigo).setPositiveButton(R.string.btAceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String texto=et.getText().toString();
                if(texto.compareTo("")!=0
                        && Interfaz.conexion(getApplicationContext())==true
                            && texto.compareTo(sh.getString("codigo","nulo"))!=0 && cl!=null)
                {
                    gym(texto);
                }else {
                    Interfaz.tostada(MainActivity.this,R.string.ttError);
                }
            }
        });
        builder.show();
    }

    private void gym(final String codigo){
        final int[] id = {-1};
        Call<Integer> call=api.getIdGim(codigo);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                int idr =response.body();
                id[0] =idr;
                if (id[0] !=-1) {
                    editor=sh.edit();
                    editor.putBoolean("sinc", false);
                    cl.setIdgimnasio(idr);
                    editor.putString("codigo",codigo);
                    editor.commit();
                    borrarCliente();
                }else {
                    Interfaz.tostada(getApplicationContext(),R.string.ttCodigo);
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Interfaz.tostada(getApplicationContext(),R.string.ttError);
                Log.v("BORRAR","COMPRUEBAAAAAAAAAAAAAAAAAAAAA");
            }
        });
    }

    private void insertCliente(){
        cl.setId(0);
        final int[] id = new int[1];
        Call<Integer> call = api.setCliente(cl);
        call.enqueue(new Callback<Integer>() {
                         @Override
                         public void onResponse(Call<Integer> call, Response<Integer> response) {
                             id[0] = response.body();
                             editor=sh.edit();
                             editor.putInt("idCl",id[0]);
                             editor.commit();
                             sincronizar();
                             Interfaz.tostada(getApplicationContext(),R.string.ttCambio);
                         }

                         @Override
                         public void onFailure(Call<Integer> call, Throwable t) {
                             Interfaz.tostada(getApplicationContext(),R.string.ttError);
                             Log.v("BORRAR","AÑADEEEEEEEEEEEEEEEEEEEEEE");
                         }
                     }
        );
    }

    private void borrarCliente(){
        Call<Integer> call=api.deleteCliente((int) cl.getId());
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                deleteInfoMovil();
                insertCliente();
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Interfaz.tostada(getApplicationContext(),R.string.ttError);
                Log.v("BORRAR","BORRRRRAAAAAAAAAAAAAAA");
            }
        });
    }

    private void deleteInfoMovil(){
        getContentResolver().delete(Contrato.TablaClienteEjercicio.CONTENT_URI,null,null);
        getContentResolver().delete(Contrato.TablaCliente.CONTENT_URI,null,null);
        getContentResolver().delete(Contrato.TablaClienteComida.CONTENT_URI,null,null);
        getContentResolver().delete(Contrato.TablaCategoria.CONTENT_URI,null,null);
        getContentResolver().delete(Contrato.TablaComida.CONTENT_URI,null,null);
        getContentResolver().delete(Contrato.TablaGrupoMuscular.CONTENT_URI,null,null);
        getContentResolver().delete(Contrato.TablaHora.CONTENT_URI,null,null);
        getContentResolver().delete(Contrato.TablaEjercicio.CONTENT_URI,null,null);
        File f=new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+"");
        if (f.isDirectory()){
            String[] children = f.list();
            for (int i = 0; i < children.length; i++)
            {
                new File(f, children[i]).delete();
            }
        }
    }
}

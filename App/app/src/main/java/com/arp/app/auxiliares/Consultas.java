package com.arp.app.auxiliares;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import com.arp.app.Api;
import com.arp.app.R;
import com.arp.app.bd.Contrato;
import com.arp.app.pojo.Categoria;
import com.arp.app.pojo.Cliente;
import com.arp.app.pojo.ClienteComida;
import com.arp.app.pojo.ClienteEjercicio;
import com.arp.app.pojo.Comida;
import com.arp.app.pojo.Ejercicio;
import com.arp.app.pojo.GrupoMuscular;
import com.arp.app.pojo.Hora;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pc-aromero on 19/05/2016.
 */
public class Consultas {

    private RetrofitCliente retrofitCliente;
    private Api api;
    private int idgym;
    private Context c;
    private SharedPreferences sh;
    private int idcl;
    private String ruta="http://192.168.1.90/gym/sites/images/ejercicios/";

    public Consultas(Context c) {
        this.c=c;
        retrofitCliente=new RetrofitCliente();
        api=retrofitCliente.getApi();
        sh = c.getSharedPreferences("informacion", Context.MODE_PRIVATE);
        idgym= (int) sh.getLong("idgym",0);
        idcl=sh.getInt("idCl",0);
    }

    /**Hago la consulta a la base de datos del servidor y inserto todos los datos en la BD del movil***/

    public void generarDatos() {
        getListaEjer();
        getListaEjercicioCliente();
        getListaCategoria();
        getListaCliente();
        getListaComida();
        getListaComidaCliente();
        getListaHora();
        getListaGm();
    }

    private void getListaEjer(){
        Call<List<Ejercicio>> call=api.getEjercicio(idgym);
        call.enqueue(new Callback<List<Ejercicio>>() {
            @Override
            public void onResponse(Call<List<Ejercicio>> call, Response<List<Ejercicio>> response) {
                if(response.body()!=null){
                    List<String> ce=new ArrayList<>();
                    for (Ejercicio ejer:response.body()) {
                        c.getContentResolver().insert(Contrato.TablaEjercicio.CONTENT_URI,ejer.setValues());
                        ce.add(ejer.getImagen());
                    }
                    String [] list=new String[ce.size()];
                    list=ce.toArray(list);
                    Hilo h=new Hilo();
                    h.execute(list);
                }
            }

            @Override
            public void onFailure(Call<List<Ejercicio>> call, Throwable t) {
                Interfaz.tostada(c, R.string.ttError);
            }
        });
    }

    private void getListaHora(){
        Call<List<Hora>> call=api.getHora();
        call.enqueue(new Callback<List<Hora>>() {
            @Override
            public void onResponse(Call<List<Hora>> call, Response<List<Hora>> response) {
                for (Hora hora:response.body()) {
                    c.getContentResolver().insert(Contrato.TablaHora.CONTENT_URI,hora.setValues());
                }
            }

            @Override
            public void onFailure(Call<List<Hora>> call, Throwable t) {
                Interfaz.tostada(c,R.string.ttError);
            }
        });
    }

    private void getListaCategoria(){
        Call<List<Categoria>> call=api.getCategoria();
        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                for (Categoria cat:response.body()) {
                    c.getContentResolver().insert(Contrato.TablaCategoria.CONTENT_URI,cat.setValues());
                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Interfaz.tostada(c,R.string.ttError);
            }
        });
    }

    private void getListaComida(){
        Call<List<Comida>> call=api.getComida(idgym);
        call.enqueue(new Callback<List<Comida>>() {
            @Override
            public void onResponse(Call<List<Comida>> call, Response<List<Comida>> response) {
                if(response.body()!=null) {
                    for (Comida co : response.body()) {
                        c.getContentResolver().insert(Contrato.TablaComida.CONTENT_URI, co.setValues());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Comida>> call, Throwable t) {
                Interfaz.tostada(c,R.string.ttError);
            }
        });
    }

    private void getListaGm(){
        Call<List<GrupoMuscular>> call=api.getGm();
        call.enqueue(new Callback<List<GrupoMuscular>>() {
            @Override
            public void onResponse(Call<List<GrupoMuscular>> call, Response<List<GrupoMuscular>> response) {
                for (GrupoMuscular gm:response.body()) {
                    c.getContentResolver().insert(Contrato.TablaGrupoMuscular.CONTENT_URI,gm.setValues());
                }
            }

            @Override
            public void onFailure(Call<List<GrupoMuscular>> call, Throwable t) {
                Interfaz.tostada(c,R.string.ttError);
            }
        });
    }

    private void getListaCliente(){
        final Cliente[] cl = {new Cliente()};
        Call<List<Cliente>> call=api.getCliente(sh.getInt("idCl",0));
        call.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                cl[0] =response.body().get(0);
                c.getContentResolver().insert(Contrato.TablaCliente.CONTENT_URI, cl[0].setValues());
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                Interfaz.tostada(c,R.string.ttError);
            }
        });
    }

    private void getListaEjercicioCliente(){
        Call<List<ClienteEjercicio>> call=api.getEjercicioCliente(idcl);
        call.enqueue(new Callback<List<ClienteEjercicio>>() {
            @Override
            public void onResponse(Call<List<ClienteEjercicio>> call, Response<List<ClienteEjercicio>> response) {
                if(response.body()!=null) {
                    for (ClienteEjercicio ce : response.body()) {
                        c.getContentResolver().insert(Contrato.TablaClienteEjercicio.CONTENT_URI, ce.setValues());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ClienteEjercicio>> call, Throwable t) {
                Interfaz.tostada(c,R.string.ttError);
            }
        });
    }

    private void getListaComidaCliente(){
        Call<List<ClienteComida>> call=api.getComidaCliente(idcl);
        call.enqueue(new Callback<List<ClienteComida>>() {
            @Override
            public void onResponse(Call<List<ClienteComida>> call, Response<List<ClienteComida>> response) {
                if(response.body()!=null) {
                    for (ClienteComida cc : response.body()) {
                        if (cc != null) {
                            c.getContentResolver().insert(Contrato.TablaClienteComida.CONTENT_URI, cc.setValues());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ClienteComida>> call, Throwable t) {
                Interfaz.tostada(c,R.string.ttError);
            }
        });
    }

    class Hilo extends AsyncTask<String,Void,Bitmap>{
        private ProgressDialog dialog=new ProgressDialog(c);

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Interfaz.tostada(c,R.string.ttError);
        }

        @Override
        protected void onPreExecute() {
            dialog.setMessage("Descargando imagenes");
            dialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                for (String img:params){
                    URL url = new URL(ruta+img);
                    URLConnection urlCon = url.openConnection();
                    InputStream is = urlCon.getInputStream();
                    Bitmap bt = BitmapFactory.decodeStream(is);
                    File f=new File(c.getExternalFilesDir(Environment.DIRECTORY_PICTURES),img);
                    if(f.getAbsolutePath().compareTo(c.getExternalFilesDir(Environment.DIRECTORY_PICTURES)+img)!=0) {
                        FileOutputStream out = new FileOutputStream(f);
                        bt.compress(Bitmap.CompressFormat.JPEG, 90, out);
                        out.flush();
                        out.close();
                    }
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            dialog.dismiss();
        }
    }

}

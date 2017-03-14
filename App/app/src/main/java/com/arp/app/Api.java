package com.arp.app;

import com.arp.app.pojo.Categoria;
import com.arp.app.pojo.Cliente;
import com.arp.app.pojo.ClienteComida;
import com.arp.app.pojo.ClienteEjercicio;
import com.arp.app.pojo.Comida;
import com.arp.app.pojo.Ejercicio;
import com.arp.app.pojo.GrupoMuscular;
import com.arp.app.pojo.Hora;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by pc-aromero on 03/05/2016.
 */
public interface Api {
    @GET("gym/api/usuario/{codigo}")
    Call<Integer> getIdGim(@Path("codigo") String clave);

    /*Info del gimnasio*/
    @GET("gym/api/ejercicio/{idgym}")
    Call<List<Ejercicio>> getEjercicio(@Path("idgym") int id);

    @GET("gym/api/hora")
    Call<List<Hora>> getHora();

    @GET("gym/api/comida/{idgym}")
    Call<List<Comida>> getComida(@Path("idgym") int id);

    @GET("gym/api/gm")
    Call<List<GrupoMuscular>> getGm();

    @GET("gym/api/categoria")
    Call<List<Categoria>> getCategoria();

    @GET("gym/api/cliente/{id}/rutina")
    Call<List<ClienteEjercicio>> getEjercicioCliente(@Path("id")int id);

    @GET("gym/api/cliente/{id}/comida")
    Call<List<ClienteComida>> getComidaCliente(@Path("id")int id);

    /*Info del gimnasio*/
    @GET("gym/api/cliente/{idcliente}/rutina/{mes}/{dia}")
    Call<List<ClienteEjercicio>> getEjercicios(@Path("idcliente") int id, @Path("mes") int mes, @Path("dia") int dia);

    @GET("gym/api/cliente/{idcliente}/comida/{mes}/{dia}")
    Call<List<ClienteEjercicio>> getComidas(@Path("idcliente") int id, @Path("mes") int mes, @Path("dia") int dia);

    @GET("gym/api/clientecorreo/{correo}")
    Call<List<Cliente>> getCorreo(@Path("correo") String correo);

    @GET("gym/api/cliente/{id}")
    Call<List<Cliente>> getCliente(@Path("id") int id);

    @POST("gym/api/cliente")
    Call<Integer> setCliente(@Body Cliente cl);

    @DELETE("gym/api/gimnasio/cliente/{id}")
    Call<Integer> deleteCliente(@Path("id") int id);
}

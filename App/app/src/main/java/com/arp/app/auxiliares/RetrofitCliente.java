package com.arp.app.auxiliares;

import android.util.Log;

import com.arp.app.Api;
import com.arp.app.auxiliares.Interfaz;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pc-aromero on 11/05/2016.
 */
public class RetrofitCliente {
    private Api api;
    private Retrofit retrofit;

    public RetrofitCliente() {
        retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.90/").addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(Api.class);
    }

    public Api getApi() {
        return api;
    }


}

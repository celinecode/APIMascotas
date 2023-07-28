package com.example.mismascotas.restApi.adapter;

import com.example.mismascotas.restApi.ConstantesRestApi;
import com.example.mismascotas.restApi.EndpointsApi;
import com.example.mismascotas.restApi.deserializador.PetDeserializador;
import com.example.mismascotas.restApi.model.PetResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetDeserializador());
        return gsonBuilder.create();
    }
}

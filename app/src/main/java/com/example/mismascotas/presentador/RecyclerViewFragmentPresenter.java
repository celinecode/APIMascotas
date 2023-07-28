package com.example.mismascotas.presentador;

import com.example.mismascotas.pojo.Pet;
//import com.example.mismascotas.db.ConstructorPets;
import com.example.mismascotas.fragment.IRecyclerViewFragmentView;
import com.example.mismascotas.R;
//import java.util.ArrayList;
import android.content.Context;
import com.example.mismascotas.restApi.EndpointsApi;
import com.example.mismascotas.restApi.adapter.RestApiAdapter;
import com.example.mismascotas.restApi.model.PetResponse;
import com.google.gson.Gson;

import android.util.Log;
import java.util.*;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class RecyclerViewFragmentPresenter implements IRecyclerViewPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    //private ConstructorPets constructorPets;
    private ArrayList<Pet> pets;


    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
      
        petResponseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
                PetResponse petResponse = response.body();
                pets = new ArrayList<>();
                pets = petResponse.getPets();
                mostrarPets();
            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });

    }


    @Override
    public void mostrarPets() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(
                iRecyclerViewFragmentView.crearAdapter(pets));
        iRecyclerViewFragmentView.generarGridLayout();

    }


}

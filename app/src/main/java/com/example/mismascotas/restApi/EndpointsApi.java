package com.example.mismascotas.restApi;

import com.example.mismascotas.restApi.model.PetResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<PetResponse> getRecentMedia();
}

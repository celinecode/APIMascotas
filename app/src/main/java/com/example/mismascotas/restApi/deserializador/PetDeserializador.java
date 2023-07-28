package com.example.mismascotas.restApi.deserializador;

import com.example.mismascotas.pojo.Pet;
import com.example.mismascotas.restApi.JsonKeys;
import com.example.mismascotas.restApi.model.PetResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PetDeserializador implements JsonDeserializer<PetResponse> {
    @Override
    public PetResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PetResponse petResponse = gson.fromJson(json, PetResponse.class);
        JsonArray petResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        petResponse.setPets(deserializarPetDeJson(petResponseData));
        return petResponse;
    }

    private ArrayList<Pet> deserializarPetDeJson(JsonArray petResponseData){
        ArrayList<Pet> pets = new ArrayList<>();
        for (int i = 0; i < petResponseData.size() ; i++) {
            JsonObject petResponseDataObject = petResponseData.get(i).getAsJsonObject();

            JsonObject userJson     = petResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String nombreCompleto   = userJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imageJson            = petResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            String urlFoto                  = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            Pet petActual = new Pet();
            petActual.setId(id);
            petActual.setNombreCompleto(nombreCompleto);
            petActual.setUrlFoto(urlFoto);
            petActual.setLikes(likes);

            pets.add(petActual);

        }

        return pets;
    }
}

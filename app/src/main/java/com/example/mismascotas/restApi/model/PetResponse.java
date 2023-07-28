package com.example.mismascotas.restApi.model;

import com.example.mismascotas.pojo.Pet;

import java.util.ArrayList;

public class PetResponse {

    ArrayList<Pet> pets;

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
}

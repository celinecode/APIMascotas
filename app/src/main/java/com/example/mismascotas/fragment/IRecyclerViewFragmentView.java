package com.example.mismascotas.fragment;

import com.example.mismascotas.pojo.Pet;
import com.example.mismascotas.adapter.PetAdapter;
import java.util.ArrayList;
public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public void generarGridLayout();
    public PetAdapter crearAdapter(ArrayList<Pet> pets);
    public void inicializarAdaptadorRV(PetAdapter adaptador);
}

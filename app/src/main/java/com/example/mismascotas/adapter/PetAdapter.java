package com.example.mismascotas.adapter;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.app.Activity;
import android.content.Context;

import com.example.mismascotas.pojo.Pet;
import com.example.mismascotas.R;
import com.example.mismascotas.DetalleMascota;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>{
    ArrayList<Pet> pets;
    Activity activity;
    Context context;

    public PetAdapter(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    //inflar el layout y pasar al viewholder para que obtenga los views
    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_pet,parent,false);
        return new PetViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final PetViewHolder petViewHolder, int position){
       final Pet pet = pets.get(position);

        Picasso.with(activity)
                .load(pet.getUrlFoto())
                .placeholder(R.drawable.shock_rave_bonus_icon)
                .into(petViewHolder.ivFoto);

        petViewHolder.showlikes.setText(String.valueOf(pet.getLikes()));

        petViewHolder.ivFoto.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), DetalleMascota.class);
                intent.putExtra("url", pet.getUrlFoto());
                intent.putExtra("likes",pet.getLikes());
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount(){
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{

       
        private TextView showlikes;


        public PetViewHolder(View itemView) {
            super(itemView);
           
            showlikes = (TextView) itemView.findViewById(R.id.showlikes);

        }
    }
}

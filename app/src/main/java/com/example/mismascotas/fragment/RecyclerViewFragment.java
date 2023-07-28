package com.example.mismascotas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mismascotas.presentador.RecyclerViewFragmentPresenter;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.mismascotas.R;
import com.example.mismascotas.adapter.PetAdapter;
import com.example.mismascotas.pojo.Pet;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment
        implements IRecyclerViewFragmentView {

    private ArrayList<Pet> pets;
    private RecyclerView rvPets;

    private RecyclerViewFragmentPresenter presenter;
        private String param1;
        private String param2;
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                param1 = getArguments().getString("param1");
                param2 = getArguments().getString("param2");
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState)
        {
            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

            return v;
        }




       /* public static FirstFragment newInstance(String param1,
                                                String param2)
        {
            FirstFragment fragment = new FirstFragment();
            Bundle args = new Bundle();
            args.putString("param1", param1);
            args.putString("param2", param2);
            fragment.setArguments(args);
            return fragment;
        }*/

        @Override
        public void onViewCreated(View view,
                                  Bundle savedInstanceState)
        {
            super.onViewCreated(view, savedInstanceState);

            rvPets = (RecyclerView) view.findViewById(R.id.rvPets);
            presenter = new RecyclerViewFragmentPresenter(this,getContext());

        }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new  LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPets.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvPets.setLayoutManager(gridLayoutManager);
    }


    @Override
    public void inicializarAdaptadorRV(PetAdapter adaptador) {
        rvPets.setAdapter(adaptador);
    }

}

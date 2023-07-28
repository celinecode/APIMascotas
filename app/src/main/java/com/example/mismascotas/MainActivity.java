package com.example.mismascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mismascotas.adapter.PetAdapter;
import com.example.mismascotas.pojo.Pet;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import com.example.mismascotas.fragment.RecyclerViewFragment;
import com.example.mismascotas.fragment.PerfilViewFragment;
import com.example.mismascotas.adapter.PageAdapter;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pet> pets;
    private RecyclerView rvPets;
    private Toolbar myToolbar;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById(R.id.materialToolbar);
        setSupportActionBar(myToolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager2) findViewById(R.id.viewPager);
        setUpViewPager();

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new  ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilViewFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(
            getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.pets);
        tabLayout.getTabAt(1).setIcon(R.drawable.pata);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.contact:
                Intent intent = new Intent(this, ContactActivity.class);
                startActivity(intent);
                break;
            case R.id.config:
                Intent intent = new Intent(this, ConfigActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }



}
package com.example.mismascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.TextView;

public class ConfigActivity extends AppCompatActivity {

    private EditText user;
    private Button botonGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.materialToolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       user = findViewById(R.id.user);
        botonGuardar = findViewById(R.id.botonGuardar);

        // Declaring fragment manager from making data
        // transactions using the custom fragment
        final androidx.fragment.app
                .FragmentManager pFragmentManager
                = getSupportFragmentManager();
        final androidx.fragment.app
                .FragmentTransaction pFragmentTransaction
                = pFragmentManager.beginTransaction();
        final PerfilViewFragment pFragment
                = new PerfilViewFragment();
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle mBundle = new Bundle();
                mBundle.putString(
                        "user",
                        user.getText().toString());
                pFragment.setArguments(mBundle);
  
            }
        });
    }
}
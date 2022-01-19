package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.example.myfirstapp.classes.User;

public class MainMenuActivity extends AppCompatActivity {

    User currentUser;

    Button buttonShow,buttonCreate,buttonSettings,buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonShow=findViewById(R.id.buttonShow);
        buttonCreate=findViewById(R.id.buttonCreate);
        buttonSettings=findViewById(R.id.buttonSettings);
        buttonLogout=findViewById(R.id.buttonLogout);




        buttonShow.setOnClickListener(v -> startActivity(new Intent(MainMenuActivity.this,
                ShowCarpoolActivity.class)));
        buttonSettings.setOnClickListener(v -> startActivity(new Intent(MainMenuActivity.this,
                SettingsActivity.class)));
        buttonCreate.setOnClickListener(v -> startActivity(new Intent(MainMenuActivity.this,
                CreateCarpoolActivity.class)));
        buttonSettings.setOnClickListener(v -> startActivity(new Intent(MainMenuActivity.this,
                SettingsActivity.class)));
        buttonLogout.setOnClickListener(v -> Toast.makeText(MainMenuActivity.this,
                "Logout Knopf funktioniert",
                Toast.LENGTH_SHORT).show());
    }
}
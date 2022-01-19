package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

public class ShowCarpoolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_carpool);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);



    }
}
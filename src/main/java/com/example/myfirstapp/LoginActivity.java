package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import com.mysql.jdbc.Driver;

public class LoginActivity extends AppCompatActivity {
    Button buttonLogIn,buttonCreateCarpool,buttonShow,buttonCreate,buttonSettings,buttonLogout;
    EditText editPassword,editCity,editCitycode,editNumberSeats,editUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_screen);

        String username ="admin";
        String password ="admin";

        buttonLogIn=findViewById(R.id.buttonLogIn);
        buttonCreateCarpool=findViewById(R.id.buttonCreateCarpool);
        buttonShow=findViewById(R.id.buttonShow);
        buttonCreate=findViewById(R.id.buttonCreate);
        buttonSettings=findViewById(R.id.buttonSettings);
        buttonLogout=findViewById(R.id.buttonLogout);

        editUsername=findViewById(R.id.editUsername);
        editPassword=findViewById(R.id.editPassword);
        editCity=findViewById(R.id.editCity);
        editCitycode=findViewById(R.id.editCityCode);
        editNumberSeats=findViewById(R.id.editNumberSeats);

        buttonLogIn.setOnClickListener(v -> {
            Login test =new Login();
            Toast.makeText(LoginActivity.this,test.login("",""),Toast.LENGTH_SHORT).show();
            /*if(username.equals(editUsername.getText().toString()) || password.equals(editPassword.getText().toString())) {
                startActivity(new Intent(LoginActivity.this, MainMenuActivity.class));
            }else{
                Toast.makeText(LoginActivity.this,"Falscher Username/Password admin:"+ editUsername.getText().toString()+"password: "+editPassword.getText().toString(),Toast.LENGTH_SHORT).show();
            }**/
        });

    }


}

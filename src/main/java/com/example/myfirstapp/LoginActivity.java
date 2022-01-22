package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.classes.User;
import com.example.myfirstapp.httpinterfaces.UserApiInterface;

import java.security.MessageDigest;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import com.mysql.jdbc.Driver;

public class LoginActivity extends AppCompatActivity {
    Button buttonLogIn;
    EditText editPassword,editUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_screen);

        String username ="admin";
        String password ="admin";


        buttonLogIn=findViewById(R.id.buttonLogIn);
        editUsername=findViewById(R.id.editUsername);
        editPassword=findViewById(R.id.editPassword);
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(" http://10.50.128.76:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserApiInterface userApiInterface = retrofit.create(UserApiInterface.class);



        buttonLogIn.setOnClickListener(v -> {
            try{

                User user =new User("username",hashPassword(password));
                Call call = userApiInterface.login(user);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        if(response.isSuccessful()) {
                            startActivity(new Intent(LoginActivity.this, MainMenuActivity.class));
                        }else if (response.code()==418) {
                            Toast.makeText(LoginActivity.this, "Passwort falsch", Toast.LENGTH_LONG);
                        }else{
                         Toast.makeText(LoginActivity.this,"Error 404 : Username not found",Toast.LENGTH_LONG);
                        }
                        }
                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(LoginActivity.this,t.getMessage(),Toast.LENGTH_LONG);
                    }
                });
            } catch (Exception e){
                e.printStackTrace();
            }

        });

    }



    public static String hashPassword(String originalPassword){
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(originalPassword.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

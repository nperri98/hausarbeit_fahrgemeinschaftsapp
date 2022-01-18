package com.example.myfirstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.classes.User;
import com.example.myfirstapp.httpinterfaces.UserApiInterface;

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


        buttonLogIn.setOnClickListener(v -> {
            try{
                Retrofit retrofit= new Retrofit.Builder()
                        .baseUrl("10.50.128.78:8080")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                UserApiInterface userApiInterface = retrofit.create(UserApiInterface.class);

                Call<List<User>> call = userApiInterface.getUser();


                call.enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                        if(!response.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Code: "+response.code(),Toast.LENGTH_LONG).show();
                            return;
                        }
                       List<User> userList = response.body();

                        for(User user : userList){
                            Toast.makeText(LoginActivity.this,user.getUsername(),Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable throwable) {
                        Toast.makeText(LoginActivity.this,throwable.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });



            }catch (Exception e){
                e.printStackTrace();
            }

        });

    }


}

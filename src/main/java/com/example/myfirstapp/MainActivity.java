package com.example.myfirstapp;

import android.os.Bundle;
import android.widget.TextView;
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

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(" http://192.168.178.33:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApiInterface userApiInterface = retrofit.create(UserApiInterface.class);

        Call<List<User>> call = userApiInterface.getUser();


        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<User> posts = response.body();

                assert posts != null;
                for (User post : posts) {
                    String content = "";
                    content += "ID: " + post.getAdress() + "\n";
                    content += "User ID: " + post.getUsername() + "\n";
                    content += "Title: " + post.getPassword() + "\n";
                    content += "Text: " + post.getPostalcode() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable throwable) {
                textViewResult.setText(throwable.getMessage());
            }
        });
    }
}
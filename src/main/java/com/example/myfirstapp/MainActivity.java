package com.example.myfirstapp;

import static com.example.myfirstapp.LoginActivity.hashPassword;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.classes.User;
import com.example.myfirstapp.httpinterfaces.UserApiInterface;

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
                .baseUrl(" http://10.50.128.76:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApiInterface userApiInterface = retrofit.create(UserApiInterface.class);
        User test = new User("test1",hashPassword("password124"));

        Call<User> call = userApiInterface.login(test);


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (!response.isSuccessful()) {

                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                User post = response.body();


                    String content = "";
                assert post != null;
                content += "ID: " + post.getAdress() + "\n";
                    content += "User ID: " + post.getUsername() + "\n";
                    content += "Title: " + post.getPassword() + "\n";
                    content += "Text: " + post.getPostalcode() + "\n\n";

                    textViewResult.append(content);
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                textViewResult.setText(throwable.getMessage());
            }
        });
    }
}
package com.example.myfirstapp.httpinterfaces;

import com.example.myfirstapp.classes.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApiInterface {
    @GET("/user")
    Call <List<User>> getUser();

    @POST("/user")
    Call<User> saveUser(@Body User saveUser);

    @POST("/user/login")
    Call<User> login ( @Body User loginUser);
}

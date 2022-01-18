package com.example.myfirstapp.httpinterfaces;

import com.example.myfirstapp.classes.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApiInterface {
    @GET("/user")
    Call <List<User>> getUser();
}

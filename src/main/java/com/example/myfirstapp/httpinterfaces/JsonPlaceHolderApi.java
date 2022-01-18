package com.example.myfirstapp.httpinterfaces;

import com.example.myfirstapp.classes.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
@GET("/posts")
    Call<List<Post>> getPosts();
}

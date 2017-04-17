package com.example.giovanni.desafioandroidnovo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Giovanni on 11/04/2017.
 */

public interface GitHubClient {

    @GET("/users/{fs-opensource}/repositories/")
    Call<List<GitHubModel>> reposForUser(@Path("fs-opensource") String user);

    @GET("users/{fs-opensource}/repositories")
    Call<List<GitHubModel>> reposForUser(@Path("page") Integer page);

}





package com.example.giovanni.desafioandroidnovo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Giovanni on 13/04/2017.
 */

public interface ModelService {

    @GET("/repositories")
    Call<List<GitHubModel>> getModel(
            @Query("page") int page,
            @Query("name") String name,
            @Query("fullname") String fullname,
            @Query("avatar_url") String avatar,
            @Query("language") String language
    );

    @GET("/repositories")
    Call<List<GitHubModel>> getModel(
            @QueryMap Map<String, String> options
    );

}

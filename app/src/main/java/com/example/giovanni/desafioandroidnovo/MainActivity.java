package com.example.giovanni.desafioandroidnovo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static android.R.id.list;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<GitHubModel> ModelList = new ArrayList<>();

    private void ModelNews() {
        Map<String, String> data = new HashMap<>();
        data.put("language", "Java");
        data.put("name", "RxJava");
        data.put("fullname", "ReactiveX/RxJava");
        data.put("page", String.valueOf(1));

        // simplified call to request the news with already initialized service
        Call<List<GitHubModel>> call = ModelService.(data);
        call.enqueue(new GitHubModel(data));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_recyclerteste);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new GitHubAdapter(ModelList, this));
       // recyclerView.setAdapter(adapter);

        String API_BASE_URL = "https://api.github.com/search/repositories";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();

        GitHubClient client =  retrofit.create(GitHubClient.class);

        // Fetch a list of the Github repositories.
        Call<List<GitHubModel>> call =
                client.reposForUser("fs-opensource");


        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<List<GitHubModel>>() {
            @Override
            public void onResponse(Call<List<GitHubModel>> call, Response<List<GitHubModel>> response) {
                List<GitHubModel> repositories = response.body();

            }

            @Override
            public void onFailure(Call<List<GitHubModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR ! :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

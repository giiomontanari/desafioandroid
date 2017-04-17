package com.example.giovanni.desafioandroidnovo;

import java.util.List;

/**
 * Created by Giovanni on 11/04/2017.
 */

public class GitHubModel {

    private int id;
    private String name;
    private String fullname;

    public int getId() {
        return id;
    }

    public GitHubModel(MainActivity mainActivity, List<GitHubModel> repositories) {
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getFullname() {

        return fullname;
    }

    public void setFullname(String fullname) {

        this.fullname = fullname;
    }


}

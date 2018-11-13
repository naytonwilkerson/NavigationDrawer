package com.example.naytonwilkerson.navigationdrawer.services;

import com.example.naytonwilkerson.navigationdrawer.model.Aluno;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface InterfaceDeServico {

    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("/lista_de_alunos")
    Call<List<Aluno>> webserviceNotasDeAlunos();

}



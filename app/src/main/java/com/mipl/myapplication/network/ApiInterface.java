package com.mipl.myapplication.network;


import com.mipl.myapplication.model.Data;
import com.mipl.myapplication.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("?")
    Call<Response> allMovies(@Query("apikey")String API_KEY, @Query("s")String s);
}

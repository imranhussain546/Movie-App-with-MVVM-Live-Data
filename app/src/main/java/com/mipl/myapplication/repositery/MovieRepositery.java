package com.mipl.myapplication.repositery;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mipl.myapplication.helper.DataResource;

import com.mipl.myapplication.model.Data;
import com.mipl.myapplication.model.Response;
import com.mipl.myapplication.network.ApiInterface;
import com.mipl.myapplication.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MovieRepositery {
    public static MovieRepositery MovieRepository;
    public ApiInterface apiInterface;

    private MutableLiveData mutableLiveData = new MutableLiveData<DataResource<Response>>();
    public LiveData<DataResource<Response>> movieLiveData = mutableLiveData;

    public static MovieRepositery getInstance() {
        MovieRepository = new MovieRepositery();

        return MovieRepository;
    }

    public  void getMovie(String name)
    {
        apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        Call<Response> call = apiInterface.allMovies("a0783fa9",name);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.body().getResponse().equalsIgnoreCase("True")) {
                    mutableLiveData.postValue(DataResource.success(response.body()));
                } else {
                    mutableLiveData.postValue(DataResource.error(response.message()));
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.e("Responseeee", "failure: "+t.getMessage());
            }
        });
    }
}

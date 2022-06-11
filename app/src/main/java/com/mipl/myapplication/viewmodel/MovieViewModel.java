package com.mipl.myapplication.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mipl.myapplication.helper.DataResource;

import com.mipl.myapplication.model.Data;
import com.mipl.myapplication.model.Response;
import com.mipl.myapplication.repositery.MovieRepositery;

import java.util.List;

public class MovieViewModel extends ViewModel {
    MovieRepositery repository = new MovieRepositery();
    public LiveData<DataResource<Response>> movieLiveData = repository.movieLiveData;


    public void loadMovieList(String name) {
        repository.getMovie(name);

    }
}

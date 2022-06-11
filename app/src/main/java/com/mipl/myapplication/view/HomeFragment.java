package com.mipl.myapplication.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mipl.myapplication.adapter.MyListAdapter;
import com.mipl.myapplication.databinding.FragmentHomeBinding;
import com.mipl.myapplication.helper.DataResource;
import com.mipl.myapplication.model.Data;

import com.mipl.myapplication.model.Response;
import com.mipl.myapplication.viewmodel.MovieViewModel;

import java.util.List;


public class HomeFragment extends Fragment {
    MovieViewModel viewModel;
     FragmentHomeBinding binding;
     MyListAdapter myListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentHomeBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false); // MAX NUMBER OF SPACES
        binding.recyclerHomeMyList.setLayoutManager(lLayout);
         search();
        return (binding.getRoot());
    }

    private void search() {
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (charSequence.length()>0)
            {
                        viewModel.loadMovieList(String.valueOf(charSequence));

            }
            }

            @Override
            public void afterTextChanged(Editable editable) {
              //  getList();
            }
        });

        viewModel.movieLiveData.observe(getActivity(), new Observer<DataResource<Response>>() {
            @Override
            public void onChanged(DataResource<Response> listDataResource) {
                switch (listDataResource.getStatus())
                {
                    case SUCCESS:
                        myListAdapter = new MyListAdapter(getContext(),listDataResource.getActualData().getSearch());
                        binding.recyclerHomeMyList.setAdapter(myListAdapter);


                        break;
                    case LOADING:
                        break;
                    case ERROR:

                        break;
                    default:
                        break;
                }
            }
        });
    }


    private void getList() {

    }
}
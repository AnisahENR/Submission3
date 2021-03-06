package com.example.submission3.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submission3.BuildConfig;
import com.example.submission3.adapter.AdapterListFollow;
import com.example.submission3.model.UserModel;
import com.example.submission3.R;
import com.example.submission3.response.FollowerResponse;
import com.example.submission3.retrofit.ApiService;
import com.example.submission3.retrofit.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFollowingFragment extends Fragment {

    ApiService service;
    private RecyclerView recyclerView;
    private AdapterListFollow mAdapter;
    ArrayList<UserModel> listuser;
    private ProgressBar progressBar;
    String username;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_follower, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progressBar);


        listuser = new ArrayList<UserModel>();
        username = getArguments().getString("username");
        getfollowing(username);

        recyclerView = view.findViewById(R.id.daftar_follow);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setHasFixedSize(true);
        setAdapter();
    }

    private void setAdapter() {
        //set data and list adapter
        mAdapter = new AdapterListFollow(getContext(), listuser);
        recyclerView.setAdapter(mAdapter);
    }

    private void getfollowing(String username) {
        progressBar.setVisibility(View.VISIBLE);
        String token = BuildConfig.GITHUB_TOKEN;
        service = ServiceGenerator.createService(ApiService.class);
        Call<List<FollowerResponse>> CallBody3;
        CallBody3 = service.following(username, token);

        CallBody3.enqueue(new Callback<List<FollowerResponse>>() {
            @Override
            public void onResponse(Call<List<FollowerResponse>> call, Response<List<FollowerResponse>> response) {

                List<FollowerResponse> data = response.body();
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.INVISIBLE);
                    for (int i = 0; i < data.size(); i++) {
                        listuser.add(new UserModel(data.get(i).login, data.get(i).avatar_url));
                    }
                    mAdapter.notifyDataSetChanged();
//                    Log.d("data following", new Gson().toJson(response.body()));
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getContext(), response.message() + "  datasalah", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<FollowerResponse>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("coba gagal", t.getMessage());
            }

        });
    }
}

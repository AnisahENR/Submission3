package com.example.submission3.retrofit;

import com.example.submission3.response.CariResponse;
import com.example.submission3.response.FollowerResponse;
import com.example.submission3.response.UsersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiService {

    //api detail pengguna
    @GET("users/{username}")
    Call<UsersResponse> user(@Path("username") String username,
                             @Header("Authorization") String token);

    // api pencarian pengguna
    @GET("search/users")
    Call<CariResponse> cari(
            @Query("q") String q,
            @Header("Authorization") String token
    );

    // api follower pengguna
    @GET("users/{username}/followers")
    Call<List<FollowerResponse>> follower(
            @Path("username") String username,
            @Header("Authorization") String token
    );

    // api following pengguna
    @GET("users/{username}/following")
    Call<List<FollowerResponse>> following(
            @Path("username") String username,
            @Header("Authorization") String token
    );
}

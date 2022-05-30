package com.example.binlocation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface newApi {
    String BASE_URL = "http://192.168.25.16/bl_api/get_zones_data";
    @GET("marvel")
    Call<List<Results>> getsuperHeroes();
}

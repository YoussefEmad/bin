package com.example.Interface;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIPassId {
     String BASE_URL="http://192.168.25.16/bl_api/get_zones/";     //"http://192.168.25.16/bl_api/get_zones"

     @GET("get_zones")  //get_zones
    Call<String> getState();


     @GET("getDistrict/{aisleID}")  //get Aiesle
    Call<String> getDistrict(@Path("aisleID")int id );


     @GET("getSubDistrict/{rackID}")  //get Rack
    Call<String> getSubDistrict(@Path("rackID")int id);

}

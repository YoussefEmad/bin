package com.example.binlocation;




import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static RetrofitClient instance = null;
    public newApi apii;
    public  RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(apii.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apii = retrofit.create(newApi.class);
    }




    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public newApi getMyApi() {
        return apii;
    }

}

package com.example.binlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.Interface.APIPassId;
import com.example.entities.District;
import com.example.entities.States;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class getter extends AppCompatActivity {
    private Spinner spinnerState,spinnerDistrict,spinnerSubDist,spinnerBin;
    private ArrayList<String> getstateName = new ArrayList<String>();
    private ArrayList<String> getdistrictName = new ArrayList<String>();
    private ArrayList<String> getsubdistrictName = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getter);
        spinnerState = (Spinner) findViewById(R.id.spinnerState);
        spinnerDistrict = (Spinner) findViewById(R.id.spinnerDistrict);
        spinnerSubDist = (Spinner) findViewById(R.id.spinnerSubDist);
        spinnerBin = (Spinner) findViewById(R.id.spinnerBin);
        getStates();




    }

    private void getStates() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIPassId.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create()).build();
        APIPassId apiPassId = retrofit.create(APIPassId.class);
        Call<String> call = apiPassId.getState();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("response",response.body().toString());
                if(response.body()!=null){
                    Log.i("Success",response.body().toString());
                    try {
                        String getResponse = response.body().toString();
                        List<States> getstateData = new ArrayList<States>();
                        JSONArray jsonArray = new JSONArray(getResponse);
                        getstateData.add(new States(1,"zoneName"));
                        for (int i=0; i<jsonArray.length();i++){
                            States states = new States();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            states.setZoneID(jsonObject.getInt("zoneID"));
                            states.setZoneName(jsonObject.getString("zoneName"));
                            getstateData.add(states);

                        }
                        for (int i=0;i< getstateData.size();i++){
                            getstateName.add(getstateData.get(i).getZoneName().toString());
                        }
                        ArrayAdapter<String> spinStateAdapter = new ArrayAdapter<String>(getter.this, android.R.layout.simple_spinner_item,getstateName);
                        spinStateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerState.setAdapter(spinStateAdapter);
                        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                                int getstatesID = getstateData.get(position).getZoneID();
                                get_District(getstatesID);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    catch (JSONException ex){
                        ex.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });



        }

    private void get_District(int getstatesID) {
        getdistrictName.clear();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIPassId.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create()).build();
        APIPassId apiPassId = retrofit.create(APIPassId.class);
        Call<String> call = apiPassId.getDistrict(getstatesID);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("response",response.body().toString());
                if(response.body()!=null){
                    Log.i("Success",response.body().toString());
                    try {
                        String getResponse = response.body().toString();
                        List<District> getdistrictData= new ArrayList<>();
                        JSONArray jsonArray = new JSONArray(getResponse);
                        getdistrictData.add(new District(1,"-- SELECT --"));
                        for (int i=0; i<jsonArray.length();i++){
                            District district  = new District();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            district.setAisleID(jsonObject.getInt("aisleID"));
                            district.setAisleName(jsonObject.getString("aisleName"));
                            getdistrictData.add(district);

                        }
                        for (int i=0;i< getdistrictData.size();i++){
                            getdistrictName.add(getdistrictData.get(i).getAisleName().toString());
                        }
                        ArrayAdapter<String> spinDistrictAdapter = new ArrayAdapter<String>(getter.this, android.R.layout.simple_spinner_item,getdistrictName);
                        spinDistrictAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerDistrict.setAdapter(spinDistrictAdapter);
                        spinnerDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });


                    } catch (JSONException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

}




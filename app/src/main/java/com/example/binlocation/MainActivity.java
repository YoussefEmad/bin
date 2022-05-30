package com.example.binlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.api.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;


public class MainActivity extends AppCompatActivity {
    Button save;
    ListView superListView;
    Button btn_search;
    Spinner spMin, spMax;  //spMin1, //spMax1
    ArrayList<String> pricelist = new ArrayList<>();
    ArrayList<String> minList = new ArrayList<>();
    ArrayList<String> maxList = new ArrayList<>();
    // ArrayList<String> minList1=new ArrayList<>();
    // ArrayList<String> maxList1=new ArrayList<>();
    ArrayAdapter<String> minAdapter, maxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////////////////////////// good code////////////////////
        save = findViewById(R.id.save);
        btn_search = findViewById(R.id.btn_search);
        // assign variables
        spMin = findViewById(R.id.sp_min);
        spMax = findViewById(R.id.sp_max);
        //spMin=findViewById(R.id.sp_min1);
        //spMax=findViewById(R.id.sp_max1);

        // use for loop
        for (int i = 1; i <= 15; i++) {
            // add values in price list
            pricelist.add("Asile" + i);
            // check condition
            if (i > 1) {
                // Not include first value  in max list
                maxList.add("Zone" + i);
            }

            if (i != 15) {
                // Not include  last value in min list
                minList.add("Zone" + i);
            }
        }

        // Initialize adapter
        minAdapter = new ArrayAdapter<>(this, R.layout.item_dropdwon, minList);
        maxAdapter = new ArrayAdapter<>(this, R.layout.item_dropdwon, maxList); //item_dropdown
        // set adapter
        spMin.setAdapter(minAdapter);
        spMax.setAdapter(maxAdapter);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchActivities();
            }
        });

        // set item selected listener on min spinner
        spMin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // clear max list
                maxList.clear();
                // use for loop
                for (int i = position + 1; i < pricelist.size(); i++) {
                    // add values in max list
                    maxList.add(pricelist.get(i));
                }
                // notify adapter
                maxAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Error ya nas", Toast.LENGTH_SHORT).show();
            }
        });
        ///////////////////////////////////old code//////////////////////////

    }

    private void searchActivities() {
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);

    }

    private void switchActivities() {
        Intent intent = new Intent(MainActivity.this, getter.class);
        startActivity(intent);
    }
}
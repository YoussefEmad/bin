package com.example.binlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class getter extends AppCompatActivity {
    Spinner spMin, spMax;

    ArrayList<String> pricelist = new ArrayList<>();
    ArrayList<String> minList = new ArrayList<>();
    ArrayList<String> maxList = new ArrayList<>();
     //ArrayList<String> minList=new ArrayList<>();
     //ArrayList<String> maxList=new ArrayList<>();
    ArrayAdapter<String> minAdapter, maxAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getter);
        spMin = findViewById(R.id.sp_min2);
        spMax = findViewById(R.id.sp_max2);
        spMin=findViewById(R.id.sp_min3);
        spMax=findViewById(R.id.sp_max3);

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
                Toast.makeText(getter.this, "Error ya nas", Toast.LENGTH_SHORT).show();
            }
        });
    }


}

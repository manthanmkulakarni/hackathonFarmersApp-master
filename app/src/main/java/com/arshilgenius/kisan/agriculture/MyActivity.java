package com.arshilgenius.kisan.agriculture;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.arshilgenius.kisan.agriculture.Activity.Paddy;
import com.arshilgenius.kisan.agriculture.Activity.Wheat;

public class MyActivity extends AppCompatActivity {
    Spinner spinner;
    int currentItem =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        spinner=(Spinner)findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(currentItem==position){
                   return;

                }
                else if(currentItem+1==position){
                    startActivity(new Intent(MyActivity.this, Paddy.class));
                }
                else if(currentItem+2==position){
                    startActivity(new Intent(MyActivity.this, Wheat.class));
                }
                else {
                    Toast.makeText(MyActivity.this, R.string.crop_not_found,Toast.LENGTH_SHORT);
                    return;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}

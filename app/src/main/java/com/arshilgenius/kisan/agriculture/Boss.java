package com.arshilgenius.kisan.agriculture;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.arshilgenius.kisan.agriculture.Activity.Paddy;
import com.arshilgenius.kisan.agriculture.Activity.Wheat;
import com.firebase.client.Firebase;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Boss extends AppCompatActivity {
    Spinner spinner;
    String Gender;

    EditText ed;
    EditText ed2;
    EditText ed3;

    int currentItem =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oss);
        spinner=(Spinner)findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(currentItem==position){
                    return;

                }
                else if(currentItem+1==position){
                    Gender="Male";

                }
                else if(currentItem+2==position){
                    Gender="Female";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });
        ed = (EditText) findViewById(R.id.ftype);
        ed2 = (EditText) findViewById(R.id.age);
        ed3 = (EditText) findViewById(R.id.loc);

        Firebase.setAndroidContext(this);



    }
    public void c(View view) {
        String amount = ed.getText().toString();
        String kg = ed2.getText().toString();
        String loc = ed3.getText().toString();
            String  url="https://farmerapp-efbfa.firebaseio.com/LABOURS";
            Firebase ref = new Firebase(url);
            ordering order = new ordering();

            order.setAmount(amount);
            order.setKgs(kg);
            order.setGender(Gender);
            order.setLat("9.9312");
            order.setLongg("76.2673");
            order.setLoc(loc);
            ref.push().setValue(order);

    }



}


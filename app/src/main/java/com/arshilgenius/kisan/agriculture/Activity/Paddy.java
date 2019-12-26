package com.arshilgenius.kisan.agriculture.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import com.arshilgenius.kisan.agriculture.Date1;
import com.arshilgenius.kisan.agriculture.R;
import com.arshilgenius.kisan.agriculture.dayListAdapter;

import java.util.ArrayList;
import java.util.Calendar;

public class Paddy extends AppCompatActivity {
    private static final String TAG = "Paddy";
    Button date;
    private static final String finalDate = null;
    int month,day,year;
    String Date;
    static final int DILOG_ID=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paddy);
        Log.d(TAG,"OnCreate Paddy : Started");

        showDialogOnButtonClick();
        final Calendar cal = Calendar.getInstance();
        year=cal.get(Calendar.YEAR);
        month=cal.get(Calendar.MONTH);
        day=cal.get(Calendar.DAY_OF_MONTH);






    }
    public void dateInput(){
        ListView mListview =  (ListView)findViewById(R.id.theList);

        com.arshilgenius.kisan.agriculture.Date1 day1 =new Date1(DateConverter(year,month,day),"Plaw a small area of the whole farming land and sow the seed with water fully filled land.");
        com.arshilgenius.kisan.agriculture.Date1 day7 =new Date1(addDay(year,month,day,7),"Add fertilizers to the small land");
        com.arshilgenius.kisan.agriculture.Date1 day22 =new Date1(addDay(year,month,day,22),"Spread all the germinated seed over the whole farming land ,construct a small mud wall across each block to hold water and construct canals to each block and fill water fully");
        com.arshilgenius.kisan.agriculture.Date1 month15 =new Date1(addDay(year,month,day,67),"decrease water level ");
        com.arshilgenius.kisan.agriculture.Date1 month153 =new Date1(addDay(year,month,day,70),"Apply fertilizers and pluck weeds grown across the fields");
        com.arshilgenius.kisan.agriculture.Date1 month156 =new Date1(addDay(year,month,day,73),"Increase water level to fullest  ");
        com.arshilgenius.kisan.agriculture.Date1 month25 =new Date1(addDay(year,month,day,97),"decrease water level ");
        com.arshilgenius.kisan.agriculture.Date1 month253 =new Date1(addDay(year,month,day,100),"Apply fertilizers and pluck weeds grown across the fields");
        com.arshilgenius.kisan.agriculture.Date1 month256 =new Date1(addDay(year,month,day,103),"Increase water level to fullest  ");
        com.arshilgenius.kisan.agriculture.Date1 month4 =new Date1(addDay(year,month,day,120),"Stop water completely and check if the paddy seeds are red");
        com.arshilgenius.kisan.agriculture.Date1 month47 =new Date1(addDay(year,month,day,127),"Cut Paddy");

        ArrayList<com.arshilgenius.kisan.agriculture.Date1> dayList = new ArrayList<>();

        dayList.add(day1);
        dayList.add(day7);
        dayList.add(day22);
        dayList.add(month15);
        dayList.add(month153);
        dayList.add(month156);
        dayList.add(month25);
        dayList.add(month253);
        dayList.add(month256);
        dayList.add(month4);
        dayList.add(month47);


        dayListAdapter adapter = new dayListAdapter(this,R.layout.list_item1_layout,dayList);
        mListview.setAdapter(adapter);

    }
    public void showDialogOnButtonClick(){
        date = (Button)findViewById(R.id.clickdate);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DILOG_ID);


            }
        });

    }
    @Override
    protected Dialog onCreateDialog(int id){
        if (id==DILOG_ID)
        {
            return new DatePickerDialog(this,dpickerListner,year,month,day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener dpickerListner =  new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        year=i;
        month=i1+1;
        day=i2;
            dateInput();

            Toast.makeText(Paddy.this,String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year),Toast.LENGTH_SHORT).show();
        }
    };

    public String DateConverter(int year,int month,int day){
        String Date12=String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
        return Date12;

    }
    public String addDay(int year,int month,int day,int days){
        String date12;
        int d=0,m=0,y=0;
        d=day+days;
        m=month;
        y=year;
        if(d>=32&&d<64)
        {
            d=d%31;
            m=month+1;
        }else if(d>=62&&d<93){
            d=d%62;
            m=month+2;
        }else if(d>=93&&d<124){
            d=d%93;
            m=month+3;
        }
        else if(d>124){
            d=d%124;
            m=month+4;
        }
        if(m>12){
            m=m%12;
            y=year+1;
        }
        date12 =String.valueOf(d)+"/"+String.valueOf(m)+"/"+String.valueOf(y);;
        return date12;
    }


}

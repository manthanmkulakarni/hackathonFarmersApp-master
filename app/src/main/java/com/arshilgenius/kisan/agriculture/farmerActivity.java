package com.arshilgenius.kisan.agriculture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class farmerActivity extends AppCompatActivity {


    GridView activityGrid1,activityGrid2;
    ArrayAdapter adapter1,adapter2;

    String data1[]={"Empty","Empty","Empty","Empty"};
    String data2[]={"Empty","Empty","Empty","Empty"};
    String username,emial,place,datestr,day;
    Firebase ref;
    int flg=0;
    Button addcrop;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);
        Firebase.setAndroidContext(farmerActivity.this);
        ref=new Firebase("https://farmerapp-efbfa.firebaseio.com/USERDATA/");

        date = new Date();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
        Date date = new Date();
        datestr=dateFormat.format(date);
        dateFormat = new SimpleDateFormat("dd");
        day=dateFormat.format(date);

        addcrop=(Button)findViewById(R.id.addcrop);

        //Toast.makeText(farmerActivity.this,"User name "+FirebaseAuth.getInstance().getCurrentUser().getEmail(),Toast.LENGTH_LONG).show();

        activityGrid1=(GridView)findViewById(R.id.activityGrid1);
        adapter1=new ArrayAdapter<String>(this,R.layout.grid_activity_layout,R.id.text,data1);
        activityGrid1.setAdapter(adapter1);

        activityGrid2=(GridView)findViewById(R.id.activityGrid2);
        adapter2=new ArrayAdapter<String>(this,R.layout.grid_activity_layout,R.id.text,data2);
        activityGrid2.setAdapter(adapter2);



        addcrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flg==0){
                    data1[0]="Paddy Seed sowing : "+datestr+"/"+day;
                    data1[1]="Paddy Watering : every 3-2 day";
                    data1[2]="Fertilizers : "+datestr+"/"+Integer.toString((Integer.parseInt(day)+5));
                    data1[3]="Paddy Harvest : "+datestr+"/"+Integer.toString((Integer.parseInt(day)+25));

                    Toast.makeText(farmerActivity.this, "Paddy added", Toast.LENGTH_LONG).show();
                    adapter1=new ArrayAdapter<String>(farmerActivity.this,R.layout.grid_activity_layout,R.id.text,data1);
                    activityGrid1.setAdapter(adapter1);
                    flg=flg+1;
                }
                else if(flg==1){
                    data2[0]="ragi Seed sowing : "+datestr+"/"+day;
                    data2[1]="Ragi Watering : every 3-2 day";
                    data2[2]="Fertilizers : "+datestr+"/"+Integer.toString((Integer.parseInt(day)+7));
                    data2[3]="Ragi Harvest : "+datestr+"/"+Integer.toString((Integer.parseInt(day)+20));

                    Toast.makeText(farmerActivity.this, "Ragi added", Toast.LENGTH_LONG).show();
                    adapter2=new ArrayAdapter<String>(farmerActivity.this,R.layout.grid_activity_layout,R.id.text,data2);
                    activityGrid2.setAdapter(adapter1);
                    flg=flg+1;
                }
            }
        });

        //adapter2=new ArrayAdapter<String>(this,R.layout.grid_activity_layout,R.id.text2,data2);

        username="Locations ";
        read();



        activityGrid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String temp= adapterView.getItemAtPosition(i).toString();
                Toast.makeText(farmerActivity.this,temp+" position "+Integer.toString(i),Toast.LENGTH_LONG).show();
            }
        });

        activityGrid2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String temp= adapterView.getItemAtPosition(i).toString();
                Toast.makeText(farmerActivity.this,temp+" position "+Integer.toString(i),Toast.LENGTH_LONG).show();
            }
        });
    }


    public void read()
    {



        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot usersSnapshot) {

                //Toast.makeText(farmerActivity.this,Long.toString(usersSnapshot.getChildrenCount()),Toast.LENGTH_LONG).show();
                for (DataSnapshot userSnapshot : usersSnapshot.getChildren()) {
                   //FarmerData forums = userSnapshot.getValue(FarmerData.class);
                   // Toast.makeText(farmerActivity.this,userSnapshot.getKey(),Toast.LENGTH_SHORT).show();
                    //place=forums.getPlace();
                   //Toast.makeText(farmerActivity.this,place ,Toast.LENGTH_LONG);
                    username=username+userSnapshot.child("place").getValue()+" ";

                }
                Toast.makeText(farmerActivity.this, username, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

    }
}

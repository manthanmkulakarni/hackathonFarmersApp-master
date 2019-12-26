package com.arshilgenius.kisan.agriculture;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.text.DateFormat;
import java.util.Date;

import me.itangqi.waveloadingview.WaveLoadingView;



public class menuscreen extends ActionBarActivity {
    static int[] imageResources = new int[]{


            R.drawable.cloudy,
            R.drawable.smartphone,
            R.drawable.cart,
            R.drawable.order,
            R.drawable.hourglass,
            R.drawable.labour,
            R.drawable.money,
            R.drawable.news,
            R.drawable.clipboard,




    };
    static int[] Strings = new int[]{


            R.string.weather,
            R.string.forum,
            R.string.buy,
            R.string.sell,
            R.string.my_activity,

            R.string.Labour,
            R.string.budget,
            R.string.news,
            R.string.extrafeature,





    };

    ImageButton ibuttton;
    static int imageResourceIndex = 0;
    static int str = 0;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuscreen);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
       // Toast.makeText(this, currentDateTimeString, Toast.LENGTH_LONG).show();;



        ibuttton=(ImageButton)findViewById(R.id.imageButton);

        WaveLoadingView mWaveLoadingView = (WaveLoadingView) findViewById(R.id.waveLoadingView);
        mWaveLoadingView.setShapeType(WaveLoadingView.ShapeType.CIRCLE);

        mWaveLoadingView.setCenterTitleColor(Color.GRAY);
        mWaveLoadingView.setBottomTitleSize(18);
        mWaveLoadingView.setProgressValue(20);
        mWaveLoadingView.setBorderWidth(0);
        mWaveLoadingView.setAmplitudeRatio(60);
        mWaveLoadingView.setWaveColor(Color.parseColor("#ff64c2f4"));
        mWaveLoadingView.setTopTitleStrokeColor(Color.parseColor("#ff1ca8f4"));
        mWaveLoadingView.setTopTitleStrokeWidth(3);
        mWaveLoadingView.setAnimDuration(6000);
        mWaveLoadingView.pauseAnimation();
        mWaveLoadingView.resumeAnimation();
        mWaveLoadingView.cancelAnimation();
        mWaveLoadingView.startAnimation();

        ibuttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent in=new Intent(menuscreen.this,loginOrSignup.class);
                startActivity(in);
            }
        });
        
       bmb();

    }

  /*  public  void in()
    {

        WaveLoadingView mWaveLoadingView = (WaveLoadingView) findViewById(R.id.waveLoadingView);
        mWaveLoadingView.setShapeType(WaveLoadingView.ShapeType.CIRCLE);
        mWaveLoadingView.setTopTitle("Top Title");
        mWaveLoadingView.setCenterTitleColor(Color.GRAY);
        mWaveLoadingView.setBottomTitleSize(18);
        mWaveLoadingView.setProgressValue(80);
        mWaveLoadingView.setBorderWidth(10);
        mWaveLoadingView.setAmplitudeRatio(60);
        mWaveLoadingView.setWaveColor(Color.GRAY);
        mWaveLoadingView.setBorderColor(Color.GRAY);
        mWaveLoadingView.setTopTitleStrokeColor(Color.BLUE);
        mWaveLoadingView.setTopTitleStrokeWidth(3);
        mWaveLoadingView.setAnimDuration(6000);
        mWaveLoadingView.pauseAnimation();
        mWaveLoadingView.resumeAnimation();
        mWaveLoadingView.cancelAnimation();
        mWaveLoadingView.startAnimation();

    }*/
    public void bmb()
    {
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb);
        bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_9_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_9_1);
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            TextOutsideCircleButton.Builder builder =new TextOutsideCircleButton.Builder()
                    .normalTextRes(getString())
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {


                            if (index == 0) {
                                stock(index);

                            }
                            if (index == 1) {
                                sales(index);
                            }
                            if (index == 2) {
                                buy(index);


                            }
                            if (index == 3) {
                                addcrop(index);
                            }
                            if (index == 4) {
                                myactivity(index);
                            }
                            if (index==5) {
                                Labouractivity(index);
                            }
                            if(index==6){
                                budgetactivity(index);
                            }
                            if(index==7){
                                orderingg(index);
                            }
                            if(index==8){
                                extrafeatues(index);
                            }

                        }
                    })

                    .normalImageRes(getImageResource());
            bmb.addBuilder(builder);
        }
    }
    public static int getString() {
        if (str >= Strings.length) str = 0;
        return Strings[str++];
    }
    public static int getImageResource() {
        if (imageResourceIndex >= imageResources.length) imageResourceIndex = 0;
        return imageResources[imageResourceIndex++];
    }
    public void start(int pos)
    {
        //   Toast.makeText(this, Integer.toString(pos), Toast.LENGTH_LONG).show();
        Intent in = new Intent( this, MainActivity.class);
        startActivity(in);
    }
    public void stock(int pos)
    {
        //   Toast.makeText(this, Integer.toString(pos), Toast.LENGTH_LONG).show();
        Intent in = new Intent( this, sunmain.class);
        startActivity(in);
    }
    public void sales(int pos)
    {
        //   Toast.makeText(this, Integer.toString(pos), Toast.LENGTH_LONG).show();
        Intent in = new Intent( this, forum.class);
        startActivity(in);
    }
    public void buy(int pos)
    {
        //   Toast.makeText(this, Integer.toString(pos), Toast.LENGTH_LONG).show();
        Intent in = new Intent( this, orders.class);
        startActivity(in);
    }

    public void orderingg(int pos)
    {
        // Toast.makeText(this, Integer.toString(pos), Toast.LENGTH_LONG).show();
        Intent in = new Intent( this, newsmain.class);
        startActivity(in);
    }
    public void addcrop(int pos)
    {
        // Toast.makeText(this, Integer.toString(pos), Toast.LENGTH_LONG).show();
        Intent in = new Intent( this, createlisting.class);
        startActivity(in);
    }
    public void myactivity(int pos){
        Intent in=new Intent(menuscreen.this,MyActivity.class);
        startActivity(in);
    }
    public void budgetactivity(int pos){
        Intent in=new Intent(this,budgetActivity.class);
        startActivity(in);
    }
    public void extrafeatues(int pos){
        Intent in=new Intent(this,More.class);
        startActivity(in);
    }
    public void Labouractivity(int pos){
        startActivity(new Intent(this,Labouractivity.class));
    }

}

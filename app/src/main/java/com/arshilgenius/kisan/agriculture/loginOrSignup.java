package com.arshilgenius.kisan.agriculture;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import me.itangqi.waveloadingview.WaveLoadingView;

public class loginOrSignup extends AppCompatActivity {

    static int[] imageResources = new int[]{
            R.drawable.login,
            R.drawable.signup,


    };
    static int[] Strings = new int[]{
            R.string.login,
            R.string.signup,

    };

    static int imageResourceIndex = 0;
    static int str = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_signup);


        WaveLoadingView mWaveLoadingView = (WaveLoadingView) findViewById(R.id.waveLoadingView1);
        mWaveLoadingView.setShapeType(WaveLoadingView.ShapeType.CIRCLE);

        mWaveLoadingView.setTopTitle("Login Or Signup");
        mWaveLoadingView.setCenterTitleColor(Color.GRAY);
        mWaveLoadingView.setTopTitleSize(35);
        mWaveLoadingView.setProgressValue(65);
        mWaveLoadingView.setBorderWidth(10);
        mWaveLoadingView.setAmplitudeRatio(80);
        mWaveLoadingView.setWaveColor(Color.BLUE);
        mWaveLoadingView.setBorderColor(Color.GRAY);

        bmb();
    }

    public void bmb()
    {
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmblogin);
        bmb.setButtonEnum(ButtonEnum.Ham);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.HAM_2);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_2);
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder()
                    .normalTextRes(getString())
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {


                            if (index == 0) {
                                loginIntent(index);

                            }
                            if (index == 1) {
                                signupIntent(index);
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
    public void loginIntent(int pos){
        Intent in=new Intent(this,login.class);
        startActivity(in);
    }
    public void signupIntent(int pos){
        Intent in=new Intent(this,signup.class);
        startActivity(in);
    }

}

package com.teicm.fiveandone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.media.MediaPlayer;




public class StartMenuActivity extends AppCompatActivity {

    MediaPlayer  bkgrdmsc;

    Button btnPlay, btnScore ;
    ImageButton btnSettings, btnAbout, btnUser, btnGift ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
        bkgrdmsc = MediaPlayer.create(StartMenuActivity.this, R.raw.music);
        bkgrdmsc.setLooping(true);
        bkgrdmsc.start();



        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnScore = (Button) findViewById(R.id.btnScore);
        btnAbout = (ImageButton) findViewById(R.id.btnAbout);
        btnUser = (ImageButton) findViewById(R.id.btnUser);
        btnGift = (ImageButton) findViewById(R.id.btnGift);
        btnSettings = (ImageButton) findViewById(R.id.btnSettings);


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),QuizActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ScoreActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Settings.class);
                startActivity(intent);
                finish();
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),About.class);
                startActivity(intent);
                finish();
            }
        });
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),User.class);
                startActivity(intent);
                finish();
            }
        });
        btnGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Gift.class);
                startActivity(intent);
                finish();
            }
        });


    }


    @Override
    protected void onPause(){
        super.onPause();
        bkgrdmsc.release();
        finish();
    }
}








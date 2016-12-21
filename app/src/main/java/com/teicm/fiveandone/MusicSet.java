package com.teicm.fiveandone;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MusicSet extends AppCompatActivity {

    MediaPlayer sound1;
    MediaPlayer sound2;
    ImageButton btnBack;
    @Override
    protected void onPause(){
        super.onPause();
        sound1.release();
        sound2.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_set);
        sound1 = MediaPlayer.create(this, R.raw.sound1);
        sound2 = MediaPlayer.create(this, R.raw.sound2);

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadSettings = new Intent(MusicSet.this, Settings.class);
                startActivity(intentLoadSettings);
            }
        });
    }

    public void playsong2 (View v) {
        sound2.start();
    }
    public void playsong1 (View v ){
        sound1.start();
    }
}
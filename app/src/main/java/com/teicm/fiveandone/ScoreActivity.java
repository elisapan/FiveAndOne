package com.teicm.fiveandone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import static com.teicm.fiveandone.R.id.btnBack;

public class ScoreActivity extends AppCompatActivity {

    ImageButton  btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        btnBack = (ImageButton)findViewById(R.id.btnBack);
        btnBack.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Intent intentLoadStartMenuActivity = new Intent (ScoreActivity.this,StartMenuActivity.class);
                startActivity(intentLoadStartMenuActivity);
            }
        });
    }
}
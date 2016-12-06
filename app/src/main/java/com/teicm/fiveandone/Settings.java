package com.teicm.fiveandone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Settings extends AppCompatActivity {

    ImageButton  btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Intent intentLoadStartMenuActivity = new Intent (Settings.this,StartMenuActivity.class);
                startActivity(intentLoadStartMenuActivity);
            }
        });
    }
}
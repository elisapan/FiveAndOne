package com.teicm.fiveandone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class About extends AppCompatActivity {
    RatingBar rating_b;
    Button button_sbm;
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        btnBack = (ImageButton)findViewById(R.id.btnBack);
        btnBack.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadStartMenuActivity = new Intent(About.this, StartMenuActivity.class);
                startActivity(intentLoadStartMenuActivity);

            }
        });
    }


    public void btnRating(View v) {
        rating_b = (RatingBar) findViewById(R.id.rating_b);
        button_sbm = (Button) findViewById(R.id.button_sbm);

        button_sbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = String.valueOf(rating_b.getRating());

                Toast.makeText(About.this, "Rating : "+rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
}


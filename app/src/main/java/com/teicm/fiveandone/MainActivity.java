package com.teicm.fiveandone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.button1;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView infoText;
    Button map;


    public Button button1;
    public void init(){

        button1 = (Button) findViewById(R.id.next);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act3 = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(act3);

            }
        });


    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText) findViewById(R.id.usernameInput) ;
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        infoText = (TextView) findViewById(R.id.infoText);
        map =(Button) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

                final String name = sharedPref.getString("username", "");
                Intent myIntent = new Intent(MainActivity.this, MapsActivity.class);
                myIntent.putExtra("parameter",name);
                startActivity(myIntent);

                MainActivity.this.startActivity(myIntent);

            }
        });



        //init();



    }



    //Save Info
    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", usernameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved !", Toast.LENGTH_LONG).show();
    }

//Print the data


    public void displayData(View view) {
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        final String name = sharedPref.getString("username", "");
        String pw = sharedPref.getString("password", "");
        infoText.setText("Username:" + name + " "+" Password:" + pw);






        //
        button1 = (Button) findViewById(R.id.next);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(MainActivity.this, QuizActivity.class);
                act.putExtra("parameter",name);
                startActivity(act);

            }
        });

    }





}

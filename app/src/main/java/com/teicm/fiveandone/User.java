package com.teicm.fiveandone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class User extends AppCompatActivity {
    TextView final_result, txtoutput;
    Button btnSubmit;
    ArrayList<String> Selection = new ArrayList<String>();
    ImageButton btnBack;
    Spinner spinneru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);




        spinneru = (Spinner)findViewById(R.id.spinner);


        spinneru.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                switch (i){

                    case 0:
                        Toast.makeText(getApplicationContext(),"the hair is Blond",Toast.LENGTH_LONG).show();
                        break;
                    case  1:
                        Toast.makeText(getApplicationContext(),"the hair is Black",Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"the hair is Brown",Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });







        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadStartMenuActivity = new Intent(User.this, StartMenuActivity.class);
                startActivity(intentLoadStartMenuActivity);
                final_result = (TextView) findViewById(R.id.finalresult);
                final_result.setEnabled(false);

            }
        });
    }


    public void selectSex(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.male:
                if (checked) {
                    final_result.setText("You select male");
                    final_result.setEnabled(true);
                } else {
                    final_result.setEnabled(false);
                }
                break;

            case R.id.female:
                if (checked) {
                    final_result.setText("You select female");
                    final_result.setEnabled(true);
                } else {
                    final_result.setEnabled(false);
                }
                break;


        }
    }

    public void selectItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.eye_blue:

                if (checked) {
                    Selection.add("Blue");
                } else {
                    Selection.remove("Blue");
                }
                break;
            case R.id.eye_black:

                if (checked) {
                    Selection.add("Black");
                } else {
                    Selection.remove("Black");
                }
                break;
            case R.id.eye_green:

                if (checked) {
                    Selection.add("Green");
                } else {
                    Selection.remove("Green");
                }
                break;
            case R.id.eye_brown:

                if (checked) {
                    Selection.add("Brown");
                } else {
                    Selection.remove("Brown");
                }
                break;

        }

    }


    public void btnSubmit(View v) {
        EditText txtinput = (EditText) findViewById(R.id.txtinput);
        TextView txtoutput = (TextView) findViewById(R.id.txtoutput);
        txtoutput.setText("Hi " + txtinput.getText().toString());

    }
}
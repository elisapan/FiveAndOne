package com.teicm.fiveandone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class characterActivity extends AppCompatActivity {

    TextView final_result;
    EditText namChar;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    ArrayList<String> Selection = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        final_result = (TextView) findViewById(R.id.result);
        final_result.setEnabled(false);
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.hair_color, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void selectItem(View view )
    {
        boolean checked = ((CheckBox) view ).isChecked();
        switch (view.getId())
        {
            case R.id.eye_blue :

                if (checked)
                {Selection.add("Blue");}
                else
                {
                    Selection.remove("Blue");
                }
                break;
            case R.id.eye_black :

                if (checked)
                {Selection.add("Black");}
                else
                {
                    Selection.remove("Black");
                }
                break;
            case R.id.eye_green :

                if (checked)
                {Selection.add("Green");}
                else
                {
                    Selection.remove("Green");
                }
                break;
            case R.id.eye_brown :

                if (checked)
                {Selection.add("Brown");}
                else
                {
                    Selection.remove("Brown");
                }
                break;





        }


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
                    final_result.setText("You select famele");
                    final_result.setEnabled(true);
                } else {
                    final_result.setEnabled(false);
                }
                break;


        }

    }
}
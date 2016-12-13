package com.teicm.fiveandone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Levelb extends Activity
{

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelb);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        radioGroup = (RadioGroup) findViewById(R.id.lev_id);
        show = (Button) findViewById(R.id.show);

        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                if(selectedId==a){
                    Toast.makeText(Levelb.this,
                            radioButton.getText(),"Σωστο!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Levelb.this, Levelc.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Levelb.this,
                            radioButton.getText(),"Λαθος!!", Toast.LENGTH_SHORT).show();}
            }
        }
    });
}


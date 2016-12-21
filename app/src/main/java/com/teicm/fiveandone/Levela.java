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

import static com.teicm.fiveandone.R.id.a;

public class Levela extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levela);

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

                if (selectedId == a) {
                    radioButton.setText("Σωστό!!");
                    radioButton.setEnabled(true);
                    Intent intent = new Intent(Levela.this, Levelb.class);
                    startActivity(intent);
                } else {
                    radioButton.setText("Λάθος!!");
                    radioButton.setEnabled(true);
                }
            }
        });
    }
}

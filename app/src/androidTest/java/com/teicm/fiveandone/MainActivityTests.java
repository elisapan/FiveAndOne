package com.teicm.fiveandone;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivityTests extends ActivityInstrumentationTestCase2 <MainActivity>{
    MainActivity cMain;
    EditText tusernameInput ,tpasswordInput;
    TextView tinfoText;
    Button tmap;

    public MainActivityTests(Class <MainActivity> activityClass){
        super(activityClass);
    }


    public MainActivityTests(String name) {
        super(MainActivity.class);
        setName(name);
    }
    protected void setUp() throws Exception {
        super.setUp();
        cMain=getActivity();
        tusernameInput = (EditText) cMain.findViewById(R.id.usernameInput);
        tpasswordInput = (EditText) cMain.findViewById(R.id.passwordInput);
        tinfoText = (TextView) cMain.findViewById(R.id.infoText);
        tmap = (Button) cMain.findViewById(R.id.map);


        setActivityInitialTouchMode(true);
    }

    //Check if activity was created
    public final void testPreconditions(){
        assertNotNull(cMain);
    }
    //Check if edit text was created
    public final void testEditText(){
        assertNotNull(tusernameInput);
        assertNotNull(tpasswordInput);
    }


    //Check if button was created
    public final void testButton(){
        assertNotNull(tmap);
    }

    //Check if textview was created
    public final void testTextView(){
        assertNotNull(tinfoText);
    }


}


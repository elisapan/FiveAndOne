package com.teicm.fiveandone;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;


public class MapsActivityTest extends ActivityInstrumentationTestCase2 <MapsActivity> {

    MapsActivity cMain;

     GoogleMap tmMap;
     TextView tWelcome;
     TextView tInfo;
     Button tNext;
     Button tBonus;

     Marker tmSerres;
     Marker tmThessaloniki;
     Marker tmEdessa;
     Marker tmLarissa;
     Marker tmVolos;
     Marker tmAthens;




    public MapsActivityTest (Class <MapsActivity> activityClass){
        super(activityClass);
    }


    public MapsActivityTest(String name) {
        super(MapsActivity.class);
        setName(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
        cMain=getActivity();



        tInfo = (TextView) cMain.findViewById(R.id.info);
        tWelcome = (TextView) cMain.findViewById(R.id.welcome);

        
        tNext = (Button) cMain.findViewById(R.id.next);
        //tBonus = (Button) cMain.findViewById(R.id.Bonus);

        setActivityInitialTouchMode(true);
    }

    //Check if activity was created
    public final void testPreconditions(){
        assertNotNull("Test If the Activity was Created",cMain);
    }
    //Check if edit text was created
    public final void testTextView(){
        assertNotNull(tInfo);
        assertNotNull(tWelcome);
    }

    //Check if button was created
    public final void testButton(){

        assertNotNull(tNext);
    }








}

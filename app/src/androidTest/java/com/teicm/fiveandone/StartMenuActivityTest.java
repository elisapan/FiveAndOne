package com.teicm.fiveandone;

import android.support.test.filters.SmallTest;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.ImageButton;
/**
 * Created by lizpa on 5/1/2017.
 */

public class StartMenuActivityTest extends ActivityInstrumentationTestCase2 <StartMenuActivity> {
    public StartMenuActivityTest() {
        super(StartMenuActivity.class);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testbutton() {
        Button btnPlay = (Button) getActivity().findViewById(R.id.btnPlay);
        Button btnScore = (Button) getActivity().findViewById(R.id.btnScore);
        assertNotNull(btnPlay);
        assertNotNull(btnScore);
    }

    @SmallTest
    public void testimagebutton() {
        ImageButton btnSettings = (ImageButton) getActivity().findViewById(R.id.btnSettings);
        ImageButton btnAbout = (ImageButton) getActivity().findViewById(R.id.btnAbout);
        ImageButton btnUser = (ImageButton) getActivity().findViewById(R.id.btnUser);
        ImageButton btnGift = (ImageButton) getActivity().findViewById(R.id.btnGift);
        assertNotNull(btnAbout);
        assertNotNull(btnSettings);
        assertNotNull(btnUser);
        assertNotNull(btnGift);
    }



    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


}
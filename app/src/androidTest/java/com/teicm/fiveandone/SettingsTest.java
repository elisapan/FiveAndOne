package com.teicm.fiveandone;

import android.support.test.filters.SmallTest;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by lizpa on 5/1/2017.
 */

public class SettingsTest extends ActivityInstrumentationTestCase2<Settings> {
    public SettingsTest() {
        super(Settings.class);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testbutton() {
        Button btnMusic = (Button) getActivity().findViewById(R.id.btnMusic);
        assertNotNull(btnMusic);
    }

    @SmallTest
    public void testimagebutton() {
        ImageButton btnBack = (ImageButton) getActivity().findViewById(R.id.btnBack);
        assertNotNull(btnBack);
    }



    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


}

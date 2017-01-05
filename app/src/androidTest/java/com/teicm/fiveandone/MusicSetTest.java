package com.teicm.fiveandone;

import android.support.test.filters.SmallTest;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by lizpa on 5/1/2017.
 */



    public class MusicSetTest extends ActivityInstrumentationTestCase2<MusicSet> {
        public MusicSetTest() {
            super(MusicSet.class);

        }

        @Override
        protected void setUp() throws Exception {
            super.setUp();
        }


    @SmallTest
    public void testbutton() {
        Button song1 = (Button) getActivity().findViewById(R.id.song1);
        Button song2 = (Button) getActivity().findViewById(R.id.song2);
        assertNotNull(song1);
        assertNotNull(song2);
    }
        @SmallTest
        public void testimagebutton() {
            ImageButton btnBack= (ImageButton) getActivity().findViewById(R.id.btnBack);
            assertNotNull(btnBack);
        }


        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
        }


    }

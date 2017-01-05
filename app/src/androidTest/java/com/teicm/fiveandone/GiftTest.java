package com.teicm.fiveandone;

import android.support.test.filters.SmallTest;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lizpa on 5/1/2017.
 */


public class GiftTest extends ActivityInstrumentationTestCase2<Gift> {
    public GiftTest() {
        super(Gift.class);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testtextview() {
        TextView scoreLabel1 = (TextView) getActivity().findViewById(R.id.scoreLabel);
        TextView startLabel1 = (TextView) getActivity().findViewById(R.id.startLabel);
        assertNotNull(scoreLabel1);
        assertNotNull(startLabel1);
    }

    @SmallTest
    public void testimageview() {
        ImageView zombie = (ImageView) getActivity().findViewById(R.id.zombie);
        ImageView orange = (ImageView) getActivity().findViewById(R.id.orange);
        ImageView pink = (ImageView) getActivity().findViewById(R.id.pink);
        ImageView blue = (ImageView) getActivity().findViewById(R.id.blue);
        assertNotNull(zombie);
        assertNotNull(orange);
        assertNotNull(pink);
        assertNotNull(blue);
    }



    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


}
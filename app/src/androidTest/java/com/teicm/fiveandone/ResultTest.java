package com.teicm.fiveandone;

import android.support.test.filters.SmallTest;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

/**
 * Created by lizpa on 5/1/2017.
 */

public class ResultTest extends ActivityInstrumentationTestCase2<Result> {
    public ResultTest() {
        super(Result.class);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testtextview() {
        TextView scoreLabel1 = (TextView) getActivity().findViewById(R.id.scoreLabel);
        TextView highScoreLabel1 = (TextView) getActivity().findViewById(R.id.highScoreLabel);
        assertNotNull(scoreLabel1);
        assertNotNull(highScoreLabel1);
    }




    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


}
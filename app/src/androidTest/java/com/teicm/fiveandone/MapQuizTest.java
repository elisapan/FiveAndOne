package com.teicm.fiveandone;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MapQuizTest extends ActivityInstrumentationTestCase2 <MapQuiz> {
    MapQuiz cMain;


     Button tQuestionButton;
     Button tAnswerButton;
     TextView tQuestionTextView;
     TextView tAnswerTextView;
     EditText tAnswerText;
     TextView tWelcome;
     Button tback;

    public MapQuizTest (Class <MapQuiz> activityClass){
        super(activityClass);
    }

    public MapQuizTest(String name) {
        super(MapQuiz.class);
        setName(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
        cMain=getActivity();

        tAnswerText = (EditText) cMain.findViewById(R.id.AnswerText);
        tQuestionTextView = (TextView) cMain.findViewById(R.id.QuestionTextView);
        tAnswerTextView = (TextView) cMain.findViewById(R.id.AnswerTextView);
        tWelcome = (TextView) cMain.findViewById(R.id.welcome);
        tAnswerButton = (Button) cMain.findViewById(R.id.AnswerButton);
        tQuestionButton = (Button) cMain.findViewById(R.id.QuestionButton);
        tback = (Button) cMain.findViewById(R.id.Back);


        setActivityInitialTouchMode(true);
    }
    //Check if activity was created
    public final void testPreconditions(){
        assertNotNull(cMain);
    }
    //Check if edit text was created
    public final void testEditText(){
        assertNotNull(tAnswerText);
    }

    //Check if button was created
    public final void testButton(){
        assertNotNull(tAnswerButton);
        assertNotNull(tback);
    }


    //Check if textview was created
    public final void testTextView(){
        assertNotNull(tQuestionTextView);
        assertNotNull(tAnswerTextView);
        assertNotNull(tWelcome);
    }






}

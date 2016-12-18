package com.teicm.fiveandone;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;




public class QuizActivityTest extends ActivityInstrumentationTestCase2 <QuizActivity> {
    QuizActivity cMain;
    Button tAnswerButton;
    TextView tQuestionTextView, tAnswerTextView;
    EditText tAnswerText;
    TextView tWelcome;
    Button tClose;
    RadioButton tradioButton7,tradioButton6,tradioButton8,tradioButton9;
    RadioGroup tradioG;
    Button tnext;

    public QuizActivityTest (Class <QuizActivity> activityClass){
        super(activityClass);
    }


    public QuizActivityTest(String name) {
        super(QuizActivity.class);
        setName(name);
    }



    protected void setUp() throws Exception {
        super.setUp();
        cMain=getActivity();

        tAnswerText = (EditText) cMain.findViewById(R.id.AnswerText);
        tQuestionTextView = (TextView) cMain.findViewById(R.id.QuestionTextView);
        tAnswerTextView = (TextView) cMain.findViewById(R.id.AnswerTextView);
        tWelcome = (TextView) cMain.findViewById(R.id.welcome);
        tradioButton7 = (RadioButton) cMain.findViewById(R.id.radioButton7) ;
        tradioButton6 = (RadioButton) cMain.findViewById(R.id.radioButton6);
        tradioButton8 = (RadioButton) cMain.findViewById(R.id.radioButton8);
        tradioButton9 = (RadioButton) cMain.findViewById(R.id.radioButton9);
        tradioG = (RadioGroup) cMain.findViewById(R.id.radioG) ;
        tAnswerButton = (Button) cMain.findViewById(R.id.AnswerButton);
        tClose = (Button) cMain.findViewById(R.id.close);
        tnext = (Button) cMain.findViewById(R.id.next);

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
        assertNotNull(tnext);
    }

    public final void testButtonClose() {
        assertNotNull(tClose);
    }

    //Check if textview was created
    public final void testTextView(){
        assertNotNull(tQuestionTextView);
        assertNotNull(tAnswerTextView);
        assertNotNull(tWelcome);
    }

    //Check if radiobuttons was created
    public final void testRadioButton(){
        assertNotNull(tradioButton6);
        assertNotNull(tradioButton7);
        assertNotNull(tradioButton8);
        assertNotNull(tradioButton9);

    }

    //Check if radioGroup was created
    public final void testRadioGroup(){
        assertNotNull(tradioG);
    }





}

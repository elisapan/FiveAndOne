package com.teicm.fiveandone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private int CurrentQuestion;
    private String [] Questions;
    private String [] Answers;
    private Button QuestionButton;
    private Button AnswerButton;
    private TextView QuestionTextView;
    private TextView AnswerTextView;
    private EditText AnswerText;
    private TextView Welcome;
    private Button Close;
    //String user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent act = getIntent();
        String name = act.getExtras().getString("parameter");

        Welcome = (TextView) findViewById(R.id.welcome);
        AnswerButton = (Button) findViewById(R.id.AnswerButton);
        QuestionButton = (Button) findViewById(R.id.QuestionButton);
        QuestionTextView = (TextView) findViewById(R.id.QuestionTextView);
        AnswerTextView = (TextView) findViewById(R.id.AnswerTextView);
        AnswerText = (EditText) findViewById(R.id.AnswerText);
        Close = (Button) findViewById(R.id.close) ;
        Welcome.setText("Καλωσήρθες χρήστη: "+name);
        init();
        Close.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }

        });




    }
    public void init() {
        Questions = new String[] {"What's the name of this programming language ? ", "What's the opposite of black ?", "What's the capital of Greece ?"};
        Answers = new String [] {"java", "white", "athens"};
        CurrentQuestion = 0;
        AnswerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CheckAnswer();
            }});
        QuestionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShowQuestion();
            }});


    }

    public void ShowQuestion()
    {
        CurrentQuestion ++;
        if (CurrentQuestion == Questions.length)
            CurrentQuestion = 0;

        QuestionTextView.setText(Questions[CurrentQuestion]);
        AnswerText.setText(" ");
        AnswerTextView.setText(" ");

    }


    public boolean isCorrect (String answer){
        return (answer.equalsIgnoreCase(Answers [CurrentQuestion]));
    }

    public void CheckAnswer() {
        String ans = AnswerText.getText().toString();
        if(isCorrect(ans)== true )
            AnswerTextView.setText("Σωστό");
        else
            AnswerTextView.setText("Λάθος!! Η σωστη ειναι : " + Answers[CurrentQuestion]);
    }




}

package com.teicm.fiveandone;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MapQuiz extends AppCompatActivity {

    private int CurrentQuestion;
    private String [] Questions;
    private String [] Answers;
    private Button QuestionButton;
    private Button AnswerButton;
    private TextView QuestionTextView;
    private TextView AnswerTextView;
    private EditText AnswerText;
    private TextView Welcome;
    private Button back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_quiz);

        Welcome = (TextView) findViewById(R.id.welcome);
        AnswerButton = (Button) findViewById(R.id.AnswerButton);
        QuestionButton = (Button) findViewById(R.id.QuestionButton);
        QuestionTextView = (TextView) findViewById(R.id.QuestionTextView);
        AnswerTextView = (TextView) findViewById(R.id.AnswerTextView);
        AnswerText = (EditText) findViewById(R.id.AnswerText);
        Welcome.setText("Καλωσήρθες στο παιχνίδι: ");
        init();
        back = (Button) findViewById(R.id.Back);
        back.setVisibility(View.INVISIBLE);








    }
    public void init() {
        Questions = new String[] {"What's the capital of Greece ? "};
        Answers = new String [] {"Athens"};
        //CurrentQuestion = 0;
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
    //showquestions in quiz
    public void ShowQuestion()
    {
        CurrentQuestion ++;
        if (CurrentQuestion == Questions.length)
            CurrentQuestion = 0;

        QuestionTextView.setText(Questions[CurrentQuestion]);
        AnswerText.setText(" ");
        AnswerTextView.setText(" ");

    }



    //say if is true or false the amnswer
    public void CheckAnswer() {
        String ans = AnswerText.getText().toString();
        if(ans == "athens" ) {
            AnswerTextView.setText("Σωστό");
            back.setVisibility(View.VISIBLE);
        }
        else {
            AnswerTextView.setText("Λάθος!! Προσπάθησε πάλι.");
            back.setVisibility(View.VISIBLE);
        }
    }




}

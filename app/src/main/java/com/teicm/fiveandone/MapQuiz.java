package com.teicm.fiveandone;



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
        Welcome.setText("Καλωσήρθες χρήστη στο παιχνίδι: ");
        init();






    }
    public void init() {
        Questions = new String[] {"What's the name of the town ? "};
        Answers = new String [] {"thessaloniki"};
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

    //check correctivity of the answer
    public boolean isCorrect (String answer){
        return (answer.equalsIgnoreCase(Answers [CurrentQuestion]));
    }

    //say if is true or false the amnswer
    public void CheckAnswer() {
        String ans = AnswerText.getText().toString();
        if(isCorrect(ans)== true )
            AnswerTextView.setText("Σωστό");
        else
            AnswerTextView.setText("Λάθος!! Η σωστη ειναι : " + Answers[CurrentQuestion]);
    }




}

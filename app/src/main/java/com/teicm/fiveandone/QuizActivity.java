package com.teicm.fiveandone;

import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import static android.R.id.list;

public class QuizActivity extends AppCompatActivity {

    private int CurrentQuestion;
    private String[] Questions;
    private String[] Answers;
    private Button QuestionButton;
    private Button AnswerButton;
    private TextView QuestionTextView;
    private TextView AnswerTextView;
    private EditText AnswerText;
    private TextView Welcome;
    private Button Close;
    public List<clsQuestion> questions;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
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
        Close = (Button) findViewById(R.id.close);
        Welcome.setText("Καλωσήρθες χρήστη: " + name);
        questions = new ArrayList<clsQuestion>();
        init();
        Close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Process.killProcess(Process.myPid());
                System.exit(1);
            }

        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void init() {

        initializeQuestions();

        Log.d("Johnnnnnnnnnnnnnnnnn",Integer.toString(questions.size()));

        Questions = new String[]{"What's the name of this programming language ? ", "What's the opposite of black ?", "What's the capital of Greece ?"};
        Answers = new String[]{"java", "white", "athens"};
        CurrentQuestion = 0;
        AnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer();
            }
        });
        QuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowQuestion();
            }
        });


    }

    //showquestions in quiz
    public void ShowQuestion() {
        CurrentQuestion++;
        if (CurrentQuestion == Questions.length)
            CurrentQuestion = 0;

        QuestionTextView.setText(Questions[CurrentQuestion]);
        AnswerText.setText(" ");
        AnswerTextView.setText(" ");


        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");

        //myRef.setValue("Hello, World!ggggggg");

    }

    //check correctivity of the answer
    public boolean isCorrect(String answer) {
        return (answer.equalsIgnoreCase(Answers[CurrentQuestion]));
    }

    //say if is true or false the amnswer
    public void CheckAnswer() {
        String ans = AnswerText.getText().toString();
        if (isCorrect(ans) == true)
            AnswerTextView.setText("Σωστό");
        else
            AnswerTextView.setText("Λάθος!! Η σωστη ειναι : " + Answers[CurrentQuestion]);
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Quiz Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    private void initializeQuestions()
    {

        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();

        ValueEventListener john = mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot category : dataSnapshot.getChildren())
                {
                    for (DataSnapshot question : category.getChildren())
                    {
                        clsQuestion q = new clsQuestion(category.getKey(), question.getKey(), question.getValue().toString());

                        questions.add(q);
                        int i=questions.size()-1;
                        Log.d("jolllllhn", questions.get(i).getqType()+ " "+ questions.get(i).getqQuestion() + " "+questions.get(i).getqAnswer());

                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });




    }

    class clsQuestion
    {
        private String qType;
        private String qQuestion;
        private String qAnswer;

        public clsQuestion( String t, String q, String a)
        {
            this.qType = t;
            this.qQuestion = q;
            this.qAnswer = a;
        }

        public String getqType() {
            return qType;
        }

        public void setqType(String qType) {
            this.qType = qType;
        }

        public String getqQuestion() {
            return qQuestion;
        }

        public void setqQuestion(String qQuestion) {
            this.qQuestion = qQuestion;
        }

        public String getqAnswer() {
            return qAnswer;
        }

        public void setqAnswer(String qAnswer) {
            this.qAnswer = qAnswer;
        }
    }

}



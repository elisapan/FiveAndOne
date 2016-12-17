package com.teicm.fiveandone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.Random;
import java.util.concurrent.Semaphore;

import static android.R.id.list;

public class QuizActivity extends AppCompatActivity
{
    private Button AnswerButton;
    private TextView QuestionTextView;
    private TextView AnswerTextView;
    private EditText AnswerText;
    private TextView Welcome;
    private Button Close;
    private Spinner spinner2;
    private RadioButton radioButton7;
    private RadioButton radioButton6;
    private RadioButton radioButton8;
    private RadioButton radioButton9;
    private RadioGroup radioG;
    private Button next;
    private int i;
    public final List<clsQuestion> questions=new ArrayList<clsQuestion>(); //List of clsQuestion's members
    private List<String> cat = new ArrayList<String>();//This list is used to populate spinner2
    protected Random ran=new Random();
    private clsQuestion selectedQuestion;
    private GoogleApiClient client;
    protected int score;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //Intent act = getIntent();
        //String name = act.getExtras().getString("parameter");

        score=0;
        Welcome = (TextView) findViewById(R.id.welcome);
        AnswerButton = (Button) findViewById(R.id.AnswerButton);
        QuestionTextView = (TextView) findViewById(R.id.QuestionTextView);
        Close = (Button) findViewById(R.id.close);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        //Welcome.setText("Καλωσήρθες χρήστη: " + name);
        radioButton6 = (RadioButton) findViewById(R.id.radioButton6);
        radioButton7 = (RadioButton) findViewById(R.id.radioButton7);
        radioButton8 = (RadioButton) findViewById(R.id.radioButton8);
        radioButton9 = (RadioButton) findViewById(R.id.radioButton9);
        radioG = (RadioGroup)  findViewById(R.id.radioG);
        next = (Button) findViewById(R.id.buttonnext) ;
        next.setVisibility(View.INVISIBLE);

        DatabaseReference mDatabase;                                    //Connect with Firebase
        mDatabase = FirebaseDatabase.getInstance().getReference();      //Take a Database's Shanpshot

        ValueEventListener john = mDatabase.addValueEventListener( new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for ( DataSnapshot category : dataSnapshot.getChildren() )     //Iterate between DB's categories
                {
                    cat.add(category.getKey().toString());                      //Adding category to the list
                    for ( DataSnapshot question : category.getChildren() ) //Iterate between category's questions
                    {
                        clsQuestion q = new clsQuestion( category.getKey(), question.getKey() ); //Create new clsQuestion member

                        for( DataSnapshot answer: question.getChildren() ) //Iterate between question's possible answers
                        {
                            q.getqAnswers().add( answer.getKey().toString() ); //Add answer to clsQuestion q questions list


                            if( answer.getValue().toString().equals("1") ) //Checking if answer has correct attribute
                            {

                                q.setCorrectAnswer( answer.getKey().toString() ); //Setting q's correctAnswer Attribute
                            }

                        }


                        questions.add(q); //Adding Q in the list of Questions

                    }
                }
                init();

            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });




        Close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Process.killProcess(Process.myPid());
                System.exit(1);
            }

        });

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void init()
    {

        AnswerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                CheckAnswer();
            }
        });

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cat);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter); //Setting spinner2's categories data
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener()); //Adding spinner2's reaction when selecting item

    }

    //showquestions in quiz
    public void ShowQuestion() {

        AnswerText.setText(" ");
        AnswerTextView.setText(" ");
    }

    //check correctivity of the answer
    public boolean isCorrect(String answer) {
        return true;
    }

    //say if is true or false the amnswer
    public void CheckAnswer()
    {
        int id=radioG.getCheckedRadioButtonId();
        RadioButton rb=(RadioButton) findViewById(id);
        String a=rb.getText().toString();
        if(selectedQuestion.getCorrectAnswer().equals(   a ))
        {
            score = score + 1;
            Welcome.setText("SCORE: "+Integer.toString(score));
            Toast.makeText(QuizActivity.this, "Σωστή απάντηση. Πάτησε το κουμπί δεξιά", Toast.LENGTH_LONG).show();
            Log.d("jolllllhn", "CORRECT");
            next.setVisibility(View.VISIBLE);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent act = new Intent(QuizActivity.this, MapsActivity.class);
                    //act2.putExtra("parameter",name);

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result",1);
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();


                }
            } );


        }
        else
        {
            Log.d("jolllllhn", "WRONG");
            Toast.makeText(QuizActivity.this, "Λάθος απάντηση", Toast.LENGTH_LONG).show();
            next.setVisibility(View.INVISIBLE);
        }

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


    class clsQuestion
    {
        private String qType;
        private String qQuestion;
        private List<String> qAnswers;
        private String correctAnswer;

        public clsQuestion( String t, String q )
        {
            this.qType = t;
            this.qQuestion = q;
            this.qAnswers = new ArrayList<String>();
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

        public List<String> getqAnswers() {
            return qAnswers;
        }

        public void setqAnswers(List<String> qAnswers) {
            this.qAnswers = qAnswers;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public void setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
        }
    }

    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener
    {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id)
        {
            String c = parent.getItemAtPosition(pos).toString();
            List ql=new ArrayList<clsQuestion>();
            for(clsQuestion x: questions)
            {
                if(x.getqType().equals(c))
                {
                    ql.add(x);
                }
            }


            int x = ran.nextInt(ql.size());
            selectedQuestion = (clsQuestion) ql.get(x);
            QuestionTextView.setText(selectedQuestion.getqQuestion());
            radioButton6.setText(selectedQuestion.getqAnswers().get(0));
            radioButton7.setText(selectedQuestion.getqAnswers().get(1));
            radioButton8.setText(selectedQuestion.getqAnswers().get(2));
            radioButton9.setText(selectedQuestion.getqAnswers().get(3));

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }

}



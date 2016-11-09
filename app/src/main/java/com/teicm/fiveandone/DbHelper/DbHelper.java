package com.teicm.fiveandone.DbHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.teicm.fiveandone.Model.Questions;
import com.teicm.fiveandone.Model.Ranking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizpa on 9/11/2016.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "databaseFiveAndOne";
    private static String DB_PATH = "";
    private SQLiteDatabase mDataBase;
    private Context mContext = null;
    public DbHelper(Context context) {
        super(context, DB_NAME, null, 1);

        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        openDataBase();
        this.mContext = context;
    }

    public void openDataBase() {
        String myPath = DB_PATH + DB_NAME;
        mDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }
    public void copyDataBase() throws IOException {
        try {
            InputStream myInput = mContext.getAssets().open(DB_NAME);
            String outputFileName = DB_PATH + DB_NAME;
            OutputStream myOutput = new FileOutputStream(outputFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0)
                myOutput.write(buffer, 0, length);

            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private boolean checkDataBase() {
        SQLiteDatabase tempDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            tempDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (tempDB != null)
            tempDB.close();
        return tempDB != null ? true : false;
    }
    public void createDataBase() throws IOException {
        boolean isDBExists = checkDataBase();
        if (isDBExists) {

        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Questions> getAllQuestions() {
        List<Questions> listQuestions = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("SELECT * FROM Questions ORDER BY Random()", null);
            if (c == null) return null;
            c.moveToFirst();
            do {
                int Id = c.getInt(c.getColumnIndex("ID"));
                String Question = c.getString(c.getColumnIndex("Question"));
                String AnswerA = c.getString(c.getColumnIndex("AnswerA"));
                String AnswerB = c.getString(c.getColumnIndex("AnswerB"));
                String CorrectAnswer = c.getString(c.getColumnIndex("CorrectAnswer"));

                Questions questions = new Questions (Id, Question, AnswerA, AnswerB, CorrectAnswer);
                listQuestions.add(questions);
            }
            while (c.moveToNext());
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        db.close();
        return listQuestions;
    }

    // Insert Score to Ranking Table
    public void insertScore(int score) {
        String query = "INSERT INTO Ranking(Score) VALUES("+score+")";
        mDataBase.execSQL(query);
    }

    //Get Score and sort ranking
    public List<Ranking> getRanking() {
        List<Ranking> listRanking = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("SELECT * FROM Ranking Order By Score DESC;", null);
            if (c == null) return null;
            c.moveToNext();
            do {
                int Id = c.getInt(c.getColumnIndex("Id"));
                int Score = c.getInt(c.getColumnIndex("Score"));

                Ranking ranking = new Ranking(Id, Score);
                listRanking.add(ranking);
            } while (c.moveToNext());
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return listRanking;

    }


}

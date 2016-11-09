package com.teicm.fiveandone.Model;

/**
 * Created by lizpa on 9/11/2016.
 */



public class Questions {
    private int ID;
    private String Question;
    private String AnswerA;
    private String AnswerB;
    private String CorrectAnswer;

    public Questions (int ID, String question, String answerA, String answerB, String correctAnswer) {
        this.ID = ID;
        Question = question;
        AnswerA = answerA;
        AnswerB = answerB;
        CorrectAnswer = correctAnswer;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {Question= question;}

    public String getAnswerA() {
        return AnswerA;
    }

    public void setAnswerA(String answerA) {
        AnswerA = answerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public void setAnswerB(String answerB) {
        AnswerB = answerB;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }
}


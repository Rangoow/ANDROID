package com.example.topquizzocapp.Model;

import java.util.List;

public class Question {
    private String mQuestion;
    private List<String> mChoiceList;
    private int mAnswerIndex;

    public Question(String question, List<String> choiceList, int answerIndex) {
        this.setQuestion(question);
    }

    public void setQuestion( String Question){
        mQuestion = Question;
    }

    public String getQuestion(){
        return mQuestion;
    }

    public void setChoiceList(List<String> choicelist){
        if (choicelist == null){
            throw new IllegalArgumentException("Array cannot be null !");
        }
        mChoiceList = choicelist;
    }

    public List<String> getChoiceList(){
        return mChoiceList;
    }

    public void setAnswerIndex(int answerIndex){
        mAnswerIndex = answerIndex;
    }

    public int getAnswerIndex(){
        return mAnswerIndex;
    }
}

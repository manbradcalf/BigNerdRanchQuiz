package com.example.benbignerdranch.bignerdranchquiz;

/**
 * Created by ben.medcalf on 12/30/15.
 */
public class QuestionModel {

    private int mTextResId;


    private boolean mAnswerTrue;
    private boolean mCheat;

    public QuestionModel(int TextResId, boolean AnswerTrue, boolean Cheat) {

        mAnswerTrue = AnswerTrue;
        mTextResId = TextResId;
        mCheat = Cheat;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }

    public boolean isCheat() {return mCheat;}

    public void setCheat(Boolean Cheat) {this.mCheat = Cheat;}
}

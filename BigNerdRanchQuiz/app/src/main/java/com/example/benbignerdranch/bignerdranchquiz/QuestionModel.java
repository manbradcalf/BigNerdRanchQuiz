package com.example.benbignerdranch.bignerdranchquiz;

/**
 * Created by ben.medcalf on 12/30/15.
 */
public class QuestionModel {

    private int mTextResId;
    private boolean mAnswerTrue;

    public QuestionModel(int TextResId, boolean AnswerTrue) {

        mAnswerTrue = AnswerTrue;
        mTextResId = TextResId;
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
}

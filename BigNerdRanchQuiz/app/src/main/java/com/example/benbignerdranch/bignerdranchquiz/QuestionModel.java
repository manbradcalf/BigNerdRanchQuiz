package com.example.benbignerdranch.bignerdranchquiz;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ben.medcalf on 12/30/15.
 */
public class QuestionModel implements Parcelable {

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

    public void setTextResId(int mTextResId) {this.mTextResId = mTextResId;}

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }

    public boolean isCheat() {return mCheat;}

    public void setCheat(Boolean Cheat) {this.mCheat = Cheat;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mTextResId);
        dest.writeByte(mAnswerTrue ? (byte) 1 : (byte) 0);
        dest.writeByte(mCheat ? (byte) 1 : (byte) 0);
    }

    protected QuestionModel(Parcel in) {
        this.mTextResId = in.readInt();
        this.mAnswerTrue = in.readByte() != 0;
        this.mCheat = in.readByte() != 0;
    }

    public static final Parcelable.Creator<QuestionModel> CREATOR = new Parcelable.Creator<QuestionModel>() {
        public QuestionModel createFromParcel(Parcel source) {
            return new QuestionModel(source);
        }

        public QuestionModel[] newArray(int size) {
            return new QuestionModel[size];
        }
    };
}

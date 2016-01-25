package com.example.benbignerdranch.bignerdranchquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {



    // Declaring Member Variables
    private static final String TAG = "CheatActivity";
    private static final String EXTRA_ANSWER_IS_TRUE =
            "com.benbignerdranch.bignerdranchquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN =
            "com.benbignerdranch.bignerdranchquiz.answer_shown";
    private boolean mAnswerIsTrue;
    private boolean mAnswerIsShown;
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    // Intent Constructor for this activity
    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Wire up the views
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        mShowAnswer = (Button) findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswer(mAnswerIsTrue);
            }
        });

        // Show the answer if savedInstanceState is not null
        if (savedInstanceState != null
                && savedInstanceState.getBoolean(EXTRA_ANSWER_SHOWN, false)) {
            showAnswer(mAnswerIsTrue);
            mAnswerIsShown = true;
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putBoolean(EXTRA_ANSWER_SHOWN, mAnswerIsShown);
    }

    private void showAnswer(Boolean answerIsTrue) {
        if (answerIsTrue) {
            mAnswerTextView.setText(R.string.true_button);
        } else {
            mAnswerTextView.setText(R.string.false_button);
        }
        mAnswerIsShown = true;
        setAnswerShownResult(true);
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    public static Boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }
}



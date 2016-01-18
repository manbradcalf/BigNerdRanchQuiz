package com.example.benbignerdranch.bignerdranchquiz;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.benbignerdranch.bignerdranchquiz.QuestionModel;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;
    private TextView mQuestionTextView;

    private QuestionModel[] mQuestionBank = new QuestionModel[] {
            new QuestionModel(R.string.question_africa, false),
            new QuestionModel(R.string.question_oceans, false),
            new QuestionModel(R.string.question_mideast, false),
            new QuestionModel(R.string.question_americas, true),
            new QuestionModel(R.string.question_asia, true),
    };

    private int mCurrentIndex = 0;

    private static final String TAG = "MainActivity";
    private static final String KEY_INDEX = "Index";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Wiring up buttons
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mPreviousButton = (ImageButton) findViewById(R.id.previous_button);

        //Wiring up the QuestionTextView
        mQuestionTextView = (TextView) findViewById(R.id.question_text);
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

        //Setting listeners on the buttons
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();

            }
        });

        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex >= .1) {
                    mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                    updateQuestion();
                }
                else {
                    Toast.makeText(MainActivity.this, "This is the first question!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        updateQuestion();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }


    private void incorrectToast() {
        Toast.makeText(MainActivity.this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT).show();
    }

    private void correctToast() {
        Toast.makeText(MainActivity.this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT).show();
    }

    private void checkAnswer(boolean userPressedTrue) {
            boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
            if (answerIsTrue == userPressedTrue) {correctToast();}
            else {incorrectToast();}
        }



    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
}

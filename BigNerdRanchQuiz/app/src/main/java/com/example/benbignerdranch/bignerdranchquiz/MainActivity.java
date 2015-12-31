package com.example.benbignerdranch.bignerdranchquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.benbignerdranch.bignerdranchquiz.QuestionModel;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private QuestionModel[] mQuestionBank = new QuestionModel[] {
            new QuestionModel(R.string.question_africa, false),
            new QuestionModel(R.string.question_oceans, false),
            new QuestionModel(R.string.question_mideast, false),
            new QuestionModel(R.string.question_americas, true),
            new QuestionModel(R.string.question_asia, true),
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Wiring up the True & False buttons
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);

        //Wiring up next button
        mNextButton = (Button) findViewById(R.id.next_button);

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

        updateQuestion();
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

package com.example.lazar.testlicnosti.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.example.lazar.testlicnosti.DataProvider;
import com.example.lazar.testlicnosti.PreferenceUtility;
import com.example.lazar.testlicnosti.R;
import com.example.lazar.testlicnosti.model.QuestionModel;
import com.facebook.stetho.Stetho;

import static com.example.lazar.testlicnosti.Constants.Points;
import static com.example.lazar.testlicnosti.Utils.returnPointForQuestion;
import static com.example.lazar.testlicnosti.Utils.setCounter;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView counter;
    private TextView questionTextView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Context mContext;

    QuestionModel mQuestionModel;

    private int questionNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Stetho.initializeWithDefaults(this);
        initViews();
        setClickListeners();
        updateUI(questionNum);
    }

    private void initViews() {
        questionTextView = findViewById(R.id.question);
        counter = findViewById(R.id.counter);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
    }

    private void updateUI(int question) {
        mContext = QuestionActivity.this;
        mQuestionModel = DataProvider.get(mContext).getQuestion(question);
        questionTextView.setText(mQuestionModel.getText());
        questionTextView.startAnimation(AnimationUtils
                .loadAnimation(this, android.R.anim.slide_in_left));
        setCounter(counter, questionNum);
    }

    private void setClickListeners() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    private void getNewQuestion() {
        if (questionNum < 60) {
            questionNum++;
            setCounter(counter, questionNum);
            updateUI(questionNum);
        } else {
            Intent intent = new Intent(this, TestActivity.class);
            startActivity(intent);
        }
    }

    private void answerTheQuestion(int asc, int desc) {
        int point = returnPointForQuestion(mQuestionModel.isAscending(), asc, desc);
        mQuestionModel.setPoints(point);
        DataProvider.get(mContext).setQuestion(mQuestionModel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                answerTheQuestion(Points.ONE_ASC, Points.ONE_DESC);
                getNewQuestion();
                break;

            case R.id.button2:
                answerTheQuestion(Points.TWO_ASC, Points.TWO_DESC);
                getNewQuestion();
                break;
            case R.id.button3:
                answerTheQuestion(Points.THREE, Points.THREE);
                getNewQuestion();
                break;
            case R.id.button4:
                answerTheQuestion(Points.FOUR_ASC, Points.FOUR_DESC);
                getNewQuestion();
                break;
            case R.id.button5:
                answerTheQuestion(Points.FIVE_ASC, Points.FIVE_DESC);
                getNewQuestion();
                break;
        }
    }
}

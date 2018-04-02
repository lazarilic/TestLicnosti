package com.example.lazar.testlicnosti.activities;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.lazar.testlicnosti.R;
import com.example.lazar.testlicnosti.ScoringKey;
import com.example.lazar.testlicnosti.adapters.AnswersAdapter;
import com.example.lazar.testlicnosti.database.FirebaseAccess;
import com.example.lazar.testlicnosti.model.Answer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.lazar.testlicnosti.Constants.*;

/**
 * Activity for displaying answers
 */
public class AnswerActivity extends AppCompatActivity {

    RecyclerView answersRecycler;
    AnswersAdapter answersAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        initViews();
        new LongRunningOperation().execute();
        sendResultsToFirebase();
    }

    private void updateUI(List<Answer> answers) {
        if (answersAdapter == null) {
            answersAdapter = new AnswersAdapter(this, answers);
            answersRecycler.setAdapter(answersAdapter);
        } else {
            answersAdapter.notifyDataSetChanged();
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class LongRunningOperation extends AsyncTask<Void, Void, List<Answer>> {

        @Override
        protected List<Answer> doInBackground(Void... voids) {
            ScoringKey scoringKey = new ScoringKey();
            return scoringKey.getAllAnswers(getApplicationContext());
        }

        @Override
        protected void onPostExecute(List<Answer> answers) {
            updateUI(answers);
        }
    }

    private void initViews() {
        answersRecycler = findViewById(R.id.answers_recycler_view);
        answersRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void sendResultsToFirebase() {
        new FirebaseAccess(AnswerActivity.this).sendResults();
    }
}

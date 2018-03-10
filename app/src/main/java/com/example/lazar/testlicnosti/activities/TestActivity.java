package com.example.lazar.testlicnosti.activities;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lazar.testlicnosti.Constants;
import com.example.lazar.testlicnosti.R;
import com.example.lazar.testlicnosti.ScoringKey;
import com.example.lazar.testlicnosti.database.FirebaseAccess;

import java.util.HashMap;
import java.util.Map;

import static com.example.lazar.testlicnosti.Constants.*;

/**
 * Created by Lazar on 12/17/17.
 */

public class TestActivity extends AppCompatActivity {

    TextView emotionality;
    TextView extraversion;
    TextView openness;
    TextView agreeableness;
    TextView conscientiousness;
    TextView honestyHumility;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);
        initViews();
        new LongRunningOperation().execute();
        sendResultsToFirebase();
    }

    private void updateUI(Map<String, String> answers) {
        emotionality.setText(answers.get(Types.EMOTIONALITY));
        extraversion.setText(answers.get(Types.EXTRAVERSION));
        openness.setText(answers.get(Types.OPENNESS_TO_EXPERIENCE));
        agreeableness.setText(answers.get(Types.AGREEABLENESS));
        conscientiousness.setText(answers.get(Types.CONSCIENTIOUSNESS));
        honestyHumility.setText(answers.get(Types.HONESTY_HUMILITY));
    }

    @SuppressLint("StaticFieldLeak")
    private class LongRunningOperation extends AsyncTask<Void, Void, HashMap<String, String>> {

        @Override
        protected HashMap<String, String> doInBackground(Void... voids) {
            ScoringKey scoringKey = new ScoringKey();
            return (HashMap<String, String>) scoringKey.getAllAnswers(getApplicationContext());

        }

        @Override
        protected void onPostExecute(HashMap<String, String> answers) {
            updateUI(answers);
        }
    }

    private void initViews() {
        emotionality = findViewById(R.id.emotionality_tv);
        extraversion = findViewById(R.id.extraversio_tv);
        openness = findViewById(R.id.openness_tv);
        agreeableness = findViewById(R.id.agreeableness_tv);
        conscientiousness = findViewById(R.id.conscientiousness_tv);
        honestyHumility = findViewById(R.id.honesty_humility_tv);
    }

    private void sendResultsToFirebase() {
        new FirebaseAccess(TestActivity.this).sendResults();
    }
}

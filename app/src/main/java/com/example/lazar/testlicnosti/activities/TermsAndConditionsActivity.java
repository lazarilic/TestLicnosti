package com.example.lazar.testlicnosti.activities;

import android.app.Activity;
import android.os.Bundle;

import com.example.lazar.testlicnosti.R;

/**
 * Activity responsible for showing Terms and Conditions
 */
public class TermsAndConditionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

//        findViewById(R.id.iconBack).setOnClickListener(view -> {
//            finish();
//        });
    }
}

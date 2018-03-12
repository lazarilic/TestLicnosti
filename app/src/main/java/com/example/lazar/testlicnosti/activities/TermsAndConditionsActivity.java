package com.example.lazar.testlicnosti.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lazar.testlicnosti.R;

/**
 * Activity responsible for showing Terms and Conditions
 */
public class TermsAndConditionsActivity extends Activity{

    Button acceptButton, returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        initViews();
        setOnClickListeners();
    }

    private void initViews() {
        acceptButton = findViewById(R.id.acceptButton);
        returnButton = findViewById(R.id.returnButton);
    }
    private void setOnClickListeners() {
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

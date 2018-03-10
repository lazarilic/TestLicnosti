package com.example.lazar.testlicnosti.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lazar.testlicnosti.Constants;
import com.example.lazar.testlicnosti.PreferenceUtility;
import com.example.lazar.testlicnosti.R;
import com.example.lazar.testlicnosti.SpinnerAdapter;

public class UserInfoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView age, termsAndConditions;
    Spinner spinner;
    Button nextButton;
    RadioGroup radioGroup;
    CheckBox termsCheckBox;
    SpinnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initViews();
        initListeners();
        createEducationAdapter();
    }
    private void initViews() {
        age = findViewById(R.id.ageEditText);
        radioGroup = findViewById(R.id.rGroup);
        nextButton = findViewById(R.id.buttonNext);
        nextButton.setEnabled(false);
        spinner = findViewById(R.id.spinner);
        termsAndConditions = findViewById(R.id.termsAndConditionsTextView);
        termsCheckBox = findViewById(R.id.termsAndConditionsCheckbox);
    }

    private void initListeners() {
        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateForm();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.femaleRadioButton:
                        PreferenceUtility.setUserGender(getApplicationContext(),
                                Constants.GENDER_FEMALE);
                        break;

                    case R.id.maleRadioButton:
                        PreferenceUtility.setUserGender(getApplicationContext(),
                                Constants.GENDER_MALE);
                        break;
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                validateForm();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceUtility.setUserAge(UserInfoActivity.this, age.getText().toString());
                PreferenceUtility.setEducationLevel(UserInfoActivity.this,
                        spinner.getSelectedItem().toString());
                Intent intent = new Intent(UserInfoActivity.this, QuestionActivity.class);
                startActivity(intent);
            }
        });

        termsAndConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this,
                        TermsAndConditionsActivity.class);
                startActivity(intent);
            }
        });
        termsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                validateForm();
            }
        });
    }

    private void createEducationAdapter() {
//        ArrayAdapter<CharSequence> educationArray = ArrayAdapter.createFromResource(this,
//                R.array.education_array, android.R.layout.simple_spinner_item);
//        educationArray.setDropDownViewResource(
//                android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(educationArray);
        String[] array = getResources().getStringArray(R.array.education_array);
        adapter = new SpinnerAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,
                array);
        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void validateForm() {
        String defaultSpinnerText = "Izaberi";
        if (!age.getText().toString().equalsIgnoreCase("") && termsCheckBox.isChecked()
                && !spinner.getSelectedItem().equals(defaultSpinnerText)) {
            nextButton.setEnabled(true);
        } else nextButton.setEnabled(false);

    }
}



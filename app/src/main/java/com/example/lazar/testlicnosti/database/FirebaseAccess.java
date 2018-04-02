package com.example.lazar.testlicnosti.database;

import android.content.Context;

import com.example.lazar.testlicnosti.Constants;
import com.example.lazar.testlicnosti.DataProvider;
import com.example.lazar.testlicnosti.PreferenceUtility;
import com.example.lazar.testlicnosti.Utils;
import com.example.lazar.testlicnosti.model.QuestionModel;
import com.example.lazar.testlicnosti.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Lazar on 2/26/18.
 */

public class FirebaseAccess {

    private static final String ANSWERS_NODE = "answers";
    private static final String USER_INFO_NODE = "userInfo";
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private DatabaseReference answers;
    private DatabaseReference userInfo;
    private Context context;

    public FirebaseAccess(Context context) {
        this.context = context;
        database = FirebaseDatabase.getInstance();
    }

    public void sendResults() {
        reference = database.getReference().child(Constants.USERS).push();
        answers = reference.child(ANSWERS_NODE);
        userInfo = reference.child(USER_INFO_NODE);

        List<QuestionModel> questions = DataProvider.get(context).getAllQuestions();
        answers.setValue(questions);

        User user = new User();
        user.setGender(PreferenceUtility.getUserGender(context));
        user.setAge(PreferenceUtility.getUsegeAge(context));
        user.setEducation(PreferenceUtility.getEducationLevel(context));
        user.setCurrentTime(Utils.getCurrentTime());
        userInfo.setValue(user);
    }
}

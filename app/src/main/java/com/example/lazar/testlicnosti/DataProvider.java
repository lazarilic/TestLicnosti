package com.example.lazar.testlicnosti;

import android.content.Context;

import com.example.lazar.testlicnosti.database.DatabaseAccess;
import com.example.lazar.testlicnosti.model.QuestionModel;

import java.util.List;

/**
 * Created by Lazar on 1/23/18.
 */
public class DataProvider {

    private Context context;
    private static DataProvider instance;

    private DatabaseAccess mDatabaseAccess;

    public static DataProvider get(Context context) {
        if(instance == null) {
            instance = new DataProvider(context);
        }
        return instance;
    }

    private DataProvider(Context context) {
        this.context = context;
        mDatabaseAccess = DatabaseAccess.getInstance(this.context);
        mDatabaseAccess.open();
    }

    public QuestionModel getQuestion(int id) {
        return mDatabaseAccess.getQuestion(id);
    }

    public void setQuestion(QuestionModel question) {
        mDatabaseAccess.updateQuestion(question);
    }

    public List<QuestionModel> getSubTypePoints(String type) {
        return  mDatabaseAccess.getSubTypesPoints(type);
    }

    public List<String> getTypes() {
        return mDatabaseAccess.getAllSubTypeNames();
    }

    public List<QuestionModel> getAllQuestions() {
        return  mDatabaseAccess.getAllQuestions();
    }
}

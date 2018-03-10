package com.example.lazar.testlicnosti;

import android.content.Context;

import com.example.lazar.testlicnosti.database.DatabaseAccess;
import com.example.lazar.testlicnosti.model.QuestionModel;

import java.util.List;

/**
 * Created by Lazar on 1/23/18.
 */
public class DataProvider {

    private Context mContext;
    private static DataProvider instance;

    private DatabaseAccess mDatabaseAccess;

    public static DataProvider get(Context context) {
        if(instance == null) {
            instance = new DataProvider(context);
        }
        return instance;
    }

    private DataProvider(Context context) {
        mContext = context;
        mDatabaseAccess = DatabaseAccess.getInstance(mContext);
        mDatabaseAccess.open();
    }

    public QuestionModel getQuestion(int id) {
        QuestionModel questionModel;
        questionModel = mDatabaseAccess.getQuestion(id);
        return questionModel;
    }

    public void setQuestion(QuestionModel question) {
        mDatabaseAccess.updateQuestion(question);
    }

    List<QuestionModel> getSubTypePoints(String type) {
        List<QuestionModel> questions;
        questions = mDatabaseAccess.getSubTypesPoints(type);
        return questions;
    }

    List<String> getTypes() {
        List<String> types;
        types = mDatabaseAccess.getAllSubTypeNames();
        return types;
    }

    public List<QuestionModel> getAllQuestions() {
        List<QuestionModel> questions;
        questions = mDatabaseAccess.getAllQuestions();
        return questions;
    }
}

package com.example.lazar.testlicnosti.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lazar.testlicnosti.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lazar on 10/1/17.
 */

public class DatabaseAccess {

    private static final String TABLE_NAME = "question";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TEXT = "text";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_IS_ASCENDING = "isAscending";
    private static final String COLUMN_POINTS = "points";

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to avoid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DatabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all questions from the database.
     *
     * @return a List of questions
     */
    public List<QuestionModel> getAllQuestions() {
        List<QuestionModel> list = new ArrayList<>();
        Cursor c = database.rawQuery("SELECT * FROM question", null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            QuestionModel questionModel = new QuestionModel(
                    Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_ID))),
                    c.getString(c.getColumnIndex(COLUMN_TYPE)),
                    Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_IS_ASCENDING))),
                    Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_POINTS))));
            list.add(questionModel);
            c.moveToNext();
        }
        c.close();
        return list;
    }

    public QuestionModel getQuestion(int position) {
        String pos = String.valueOf(position);
        String[] args = new String[] {pos};
        String[] columnsToReturn = new String[] {COLUMN_ID, COLUMN_TEXT, COLUMN_TYPE, COLUMN_IS_ASCENDING};
        String selection = "id = ?";
        Cursor c = database.query(
                TABLE_NAME,
                columnsToReturn,
                selection,
                args,
                null,
                null,
                null);
        c.moveToFirst();
        QuestionModel questionModel = new QuestionModel(
                Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_ID))),
                c.getString(c.getColumnIndex(COLUMN_TEXT)),
                c.getString(c.getColumnIndex(COLUMN_TYPE)),
                Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_IS_ASCENDING))
                ));
        c.close();
           return questionModel;
    }

    public void updateQuestion(QuestionModel questionModel) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_POINTS, questionModel.getPoints());

        database.update(TABLE_NAME,
                values,
                COLUMN_ID + " = ?",
                new String[]{String.valueOf(questionModel.getId())});
    }

    public List<QuestionModel> getSubTypesPoints(String type) {
        List<QuestionModel> subTypePoints = new ArrayList<>();
        String[] args = new String[] {type};
        String[] columnsToReturn = new String[] {COLUMN_TYPE, COLUMN_POINTS};
        String selection = COLUMN_TYPE + " LIKE ?";
        Cursor c = database.query(
                TABLE_NAME,
                columnsToReturn,
                selection,
                args,
                null,
                null,
                null);

        c.moveToFirst();
        while (!c.isAfterLast()){
            QuestionModel questionModel = new QuestionModel(
                    Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_POINTS))),
                    c.getString(c.getColumnIndex(COLUMN_TYPE)));
                subTypePoints.add(questionModel);
                c.moveToNext();
        }
        c.close();
        return subTypePoints;
    }

    public List<String> getAllSubTypeNames() {
        List<String> types = new ArrayList<>();
        String type;
        Cursor c = database.rawQuery("SELECT DISTINCT(type) FROM question", null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            type = c.getString(c.getColumnIndex(COLUMN_TYPE));
            types.add(type);
            c.moveToNext();
        }

        return types;
    }

}

package com.example.lazar.testlicnosti.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Lazar on 10/1/17.
 */

public class DatabaseOpenHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "questions.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}

package com.example.lazar.testlicnosti;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by Lazar on 2/6/18.
 */
public class PreferenceUtility {

    private static final String GENDER = "gender";
    private static final String DEFAULT_GENDER = "female";
    private static final String AGE = "age";
    private static final String EDUCATION_LEVEL = "education_level";
    private static final String TAG = PreferenceUtility.class.getName();


    public static void setUserGender(Context context, String gender) {
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
                editor.putString(GENDER, gender);
                editor.apply();

        Log.i(TAG, "Gender set: " + gender);
    }

    public static void setUserAge(Context context, String age) {
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(AGE, age);
        editor.apply();
    }

    public static void setEducationLevel(Context context, String education) {
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(EDUCATION_LEVEL, education);
        editor.apply();
    }

    public static String getUserGender(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(GENDER, DEFAULT_GENDER);
    }

    public static String getUserAge(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(AGE, "");
    }

    public static String getEducationLevel(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(EDUCATION_LEVEL, "");
    }
}

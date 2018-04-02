package com.example.lazar.testlicnosti;

import android.content.Context;
import android.util.Log;

import com.example.lazar.testlicnosti.model.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.lazar.testlicnosti.Constants.Types;

/**
 * Created by Lazar on 1/25/18.
 */
public class ScoringKey {

    private static final String TAG = ScoringKey.class.getName();

    Map<String, Double> subTypeGrades;

    private static Map<String, Double> getAverageGradesForAllSubTypes(Context context) {
        List<String> types = DataProvider.get(context).getTypes();
        Map<String, Double> typeAveragePoints = new HashMap<>();

        for (int i = 0; i <= types.size() - 1; i++) {
            Double typeAverage = Utils.calculateAveragePoint(
                    DataProvider.get(context).getSubTypePoints(types.get(i)));
            typeAveragePoints.put(types.get(i), typeAverage);
        }
        return typeAveragePoints;
    }

    private Map<String, Double> getAverageGradesForAllTypes(Context context) {
        Map<String, Double> typeGrades = new HashMap<>();
        subTypeGrades = getAverageGradesForAllSubTypes(context);
        for (int i = 0; i < Constants.getTypeNames().size(); i++) {
            typeGrades.put(Constants.getTypeNames().get(i), returnAverageForType(Constants.getTypeNames().get(i)));
            Log.d(TAG, Constants.getTypeNames().get(i) + " " + returnAverageForType(Constants.getTypeNames().get(i)));
        }
        Log.d(TAG, "-------------------------");
        return typeGrades;
    }

    private double returnAverageForType(String type) {
        double averagePoint = 0;
        switch (type) {
            case Types.AGREEABLENESS:
                averagePoint = getTypePoint(Constants.getSubTypesForAgreeableness());
                break;

            case Types.CONSCIENTIOUSNESS:
                averagePoint = getTypePoint(Constants.getSubTypesForConscientiousness());
                break;

            case Types.EMOTIONALITY:
                averagePoint = getTypePoint(Constants.getSubTypesForEmotionality());
                break;

            case Types.EXTRAVERSION:
                averagePoint = getTypePoint(Constants.getSubTypesForExtraversion());
                break;

            case Types.HONESTY_HUMILITY:
                averagePoint = getTypePoint(Constants.getSubTypesForHonestyHumility());
                break;

            case Types.OPENNESS_TO_EXPERIENCE:
                averagePoint = getTypePoint(Constants.getSubTypesForOpennessToExperience());
                break;
        }
        return averagePoint;
    }

    private double getTypePoint(List<String> typeSubTypes) {
        List<Double> grades = new ArrayList<>();
        for (String subType: typeSubTypes) {
            grades.add(subTypeGrades.get(subType));
        }
        return Utils.calculateAveragePointForType(grades);
    }

    public List<Answer> getAllAnswers(Context context) {
        DisplayQuestion displayQuestion = new DisplayQuestion(context);
        Map<String, Double> grades = getAverageGradesForAllTypes(context);
        List<Answer> answers = new ArrayList<>();

        for (Map.Entry<String, Double> grade: grades.entrySet()) {
            String text = displayQuestion.getFinalAnswer(grade.getKey(), grade.getValue());
            Answer answer = new Answer(grade.getKey(), text);
            answers.add(answer);
        }
        return answers;
    }
}

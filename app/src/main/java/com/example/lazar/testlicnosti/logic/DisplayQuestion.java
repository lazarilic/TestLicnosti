package com.example.lazar.testlicnosti.logic;

import android.content.Context;

import com.example.lazar.testlicnosti.Constants;
import com.example.lazar.testlicnosti.PreferenceUtility;
import com.example.lazar.testlicnosti.R;

import static com.example.lazar.testlicnosti.Constants.*;

/**
 * Class for displaying question based on gender and points for certain type
 */
public class DisplayQuestion {

    private Context context;

    public DisplayQuestion(Context context) {
        this.context = context;
    }

    public String getFinalAnswer(String type, double points) {
        String gender = PreferenceUtility.getUserGender(context);
        if (gender.equals(Constants.GENDER_FEMALE)) {
            return getAnswerForFemale(context, type, points);
        }
        return getAnswerForMale(context, type, points);
    }

    private String getAnswerForFemale(Context context, String type, double points) {
        String answerText = null;

        switch (type) {

            case Types.HONESTY_HUMILITY:
                if (points < StandardScoreFemale.HONESTY_HUMILITY_LEFT) {
                    answerText = context.getString(R.string.honesty_humility_low);
                }
                if (points >= StandardScoreFemale.HONESTY_HUMILITY_LEFT &&
                        points < StandardScoreFemale.HONESTY_HUMILITY_RIGHT) {
                    answerText = context.getString(R.string.honesty_humility_medium);
                }
                if (points > StandardScoreFemale.HONESTY_HUMILITY_RIGHT) {
                    answerText = context.getString(R.string.honesty_humility_high);
                }
                break;

            case Types.AGREEABLENESS:
                if (points < StandardScoreFemale.AGREEABLENESS_LEFT) {
                    answerText = context.getString(R.string.agreeableness_low);
                }
                if (points >= StandardScoreFemale.AGREEABLENESS_LEFT &&
                        points < StandardScoreFemale.AGREEABLENESS_RIGHT) {
                    answerText = context.getString(R.string.agreeableness_medium);
                }
                if (points > StandardScoreFemale.AGREEABLENESS_RIGHT) {
                    answerText = context.getString(R.string.agreeableness_high);
                }
                break;

            case Types.EMOTIONALITY:
                if (points < StandardScoreFemale.EMOTIONALITY_LEFT) {
                    answerText = context.getString(R.string.emotionality_low);
                }
                if (points >= StandardScoreFemale.EMOTIONALITY_LEFT &&
                        points < StandardScoreFemale.EMOTIONALITY_RIGHT) {
                    answerText = context.getString(R.string.emotionality_medium);
                }
                if (points > StandardScoreFemale.EMOTIONALITY_RIGHT) {
                    answerText = context.getString(R.string.emotionality_high);
                }
                break;

            case Types.EXTRAVERSION:
                if (points < StandardScoreFemale.EXTRAVERSION_LEFT) {
                    answerText = context.getString(R.string.extraversion_low);
                }
                if (points >= StandardScoreFemale.EXTRAVERSION_LEFT &&
                        points < StandardScoreFemale.EXTRAVERSION_RIGHT) {
                    answerText = context.getString(R.string.extraversion_medium);
                }
                if (points > StandardScoreFemale.EXTRAVERSION_RIGHT) {
                    answerText = context.getString(R.string.extraversion_high);
                }
                break;

            case Types.CONSCIENTIOUSNESS:
                if (points < StandardScoreFemale.CONSCIENTIOUSNESS_LEFT) {
                    answerText = context.getString(R.string.conscientiuousness_low);
                }
                if (points >= StandardScoreFemale.CONSCIENTIOUSNESS_LEFT &&
                        points < StandardScoreFemale.CONSCIENTIOUSNESS_RIGHT) {
                    answerText = context.getString(R.string.conscientiuousness_medium);
                }
                if (points > StandardScoreFemale.CONSCIENTIOUSNESS_RIGHT) {
                    answerText = context.getString(R.string.conscientiuousness_high);
                }
                break;

            case Types.OPENNESS_TO_EXPERIENCE:
                if (points < StandardScoreFemale.OPENNESS_TO_EXPERIENCE_LEFT) {
                    answerText = context.getString(R.string.openness_low);
                }
                if (points >= StandardScoreFemale.OPENNESS_TO_EXPERIENCE_LEFT &&
                        points < StandardScoreFemale.OPENNESS_TO_EXPERIENCE_RIGHT) {
                    answerText = context.getString(R.string.openness_medium);
                }
                if (points > StandardScoreFemale.OPENNESS_TO_EXPERIENCE_RIGHT) {
                    answerText = context.getString(R.string.openness_high);
                }
                break;

            //TODO default value?
            default:
                return "";
        }
        return answerText;
    }

    private String getAnswerForMale(Context context, String type, double points) {
        String answerText = null;

        switch (type) {

            case Types.HONESTY_HUMILITY:
                if (points < StandardScoreMale.HONESTY_HUMILITY_LEFT) {
                    answerText = context.getString(R.string.honesty_humility_low);
                }
                if (points >= StandardScoreMale.HONESTY_HUMILITY_LEFT &&
                        points < StandardScoreMale.HONESTY_HUMILITY_RIGHT) {
                    answerText = context.getString(R.string.honesty_humility_medium);
                }
                if (points > StandardScoreMale.HONESTY_HUMILITY_RIGHT) {
                    answerText = context.getString(R.string.honesty_humility_high);
                }
                break;

            case Types.AGREEABLENESS:
                if (points < StandardScoreMale.AGREEABLENESS_LEFT) {
                    answerText = context.getString(R.string.agreeableness_low);
                }
                if (points >= StandardScoreMale.AGREEABLENESS_LEFT &&
                        points < StandardScoreFemale.AGREEABLENESS_RIGHT) {
                    answerText = context.getString(R.string.agreeableness_medium);
                }
                if (points > StandardScoreMale.AGREEABLENESS_RIGHT) {
                    answerText = context.getString(R.string.agreeableness_high);
                }
                break;

            case Types.EMOTIONALITY:
                if (points < StandardScoreMale.EMOTIONALITY_LEFT) {
                    answerText = context.getString(R.string.emotionality_low);
                }
                if (points >= StandardScoreMale.EMOTIONALITY_LEFT &&
                        points < StandardScoreMale.EMOTIONALITY_RIGHT) {
                    answerText =context.getString(R.string.emotionality_medium);
                }
                if (points > StandardScoreMale.EMOTIONALITY_RIGHT) {
                    answerText = context.getString(R.string.emotionality_high);
                }
                break;

            case Types.EXTRAVERSION:
                if (points < StandardScoreMale.EXTRAVERSION_LEFT) {
                    answerText = context.getString(R.string.extraversion_low);
                }
                if (points >= StandardScoreMale.EXTRAVERSION_LEFT &&
                        points < StandardScoreFemale.EXTRAVERSION_RIGHT) {
                    answerText = context.getString(R.string.extraversion_medium);
                }
                if (points > StandardScoreMale.EXTRAVERSION_RIGHT) {
                    answerText = context.getString(R.string.extraversion_high);
                }
                break;

            case Types.CONSCIENTIOUSNESS:
                if (points < StandardScoreMale.CONSCIENTIOUSNESS_LEFT) {
                    answerText = context.getString(R.string.conscientiuousness_low);
                }
                if (points >= StandardScoreMale.CONSCIENTIOUSNESS_LEFT &&
                        points < StandardScoreMale.CONSCIENTIOUSNESS_RIGHT) {
                    answerText = context.getString(R.string.conscientiuousness_medium);
                }
                if (points > StandardScoreMale.CONSCIENTIOUSNESS_RIGHT) {
                    answerText = context.getString(R.string.conscientiuousness_high);
                }
                break;

            case Types.OPENNESS_TO_EXPERIENCE:
                if (points < StandardScoreMale.OPENNESS_TO_EXPERIENCE_LEFT) {
                    answerText = context.getString(R.string.openness_low);
                }
                if (points >= StandardScoreMale.OPENNESS_TO_EXPERIENCE_LEFT &&
                        points < StandardScoreMale.OPENNESS_TO_EXPERIENCE_RIGHT) {
                    answerText = context.getString(R.string.openness_medium);
                }
                if (points > StandardScoreMale.OPENNESS_TO_EXPERIENCE_RIGHT) {
                    answerText = context.getString(R.string.openness_high);
                }
                break;

            //TODO default value?
            default:
                return "";
        }
        return answerText;
    }

}

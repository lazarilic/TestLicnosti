package com.example.lazar.testlicnosti;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lazar on 1/26/18.
 */

public class Constants {

    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String USERS = "users";


    public static final class Points {

        public static final int ONE_ASC = 1;
        public static final int ONE_DESC = 5;
        public static final int TWO_ASC = 2;
        public static final int TWO_DESC = 4;
        public static final int THREE = 3;
        public static final int FOUR_ASC = 4;
        public static final int FOUR_DESC = 2;
        public static final int FIVE_ASC = 5;
        public static final int FIVE_DESC = 1;
    }

    static final class SubTypes {

        static final String AESTHETIC_APPRECIATION = "aesthetic_appreciation";
        static final String ORGANIZATION = "organization";
        static final String FORGIVENESS = "forgiveness";
        static final String SOCIAL_SELF_ESTEEM = "social_self_esteem";
        static final String FEARFULNESS = "fearfulness";
        static final String SINCERITY = "sincerity";
        static final String INQUISITIVENESS = "inquisitiveness";
        static final String DILIGENCE = "diligence";
        static final String GENTLENESS = "gentleness";
        static final String SOCIAL_BOLDNESS = "social_boldness";
        static final String ANXIETY = "anxiety";
        static final String FAIRNESS = "fairness";
        static final String CREATIVITY = "creativity";
        static final String PERFECTIONISM = "perfectionism";
        static final String FLEXIBILITY = "flexibility";
        static final String SOCIABILITY = "sociability";
        static final String DEPENDENCE = "dependence";
        static final String GREED_AVOIDANCE = "greed_avoidance";
        static final String UNCONVENTIONALITY = "unconventionality";
        static final String PRUDENCE = "prudence";
        static final String PATIENCE = "patience";
        static final String LIVELINESS = "liveliness";
        static final String SENTIMENTALITY = "sentimentality";
        static final String MODESTY = "modesty";
    }

    public static final class Types {

        public static final String HONESTY_HUMILITY = "honesty_humility";
        public static final String EMOTIONALITY = "emotionality";
        public static final String EXTRAVERSION = "extraversion";
        public static final String AGREEABLENESS = "agreeableness";
        public static final String CONSCIENTIOUSNESS = "conscientiousness";
        public static final String OPENNESS_TO_EXPERIENCE = "openness_to_experience";
    }

    static final class StandardScoreMale {

        static final double HONESTY_HUMILITY_LEFT = 3.23;
        static final double HONESTY_HUMILITY_RIGHT = 4.33;

        static final double EMOTIONALITY_LEFT = 2.38;
        static final double EMOTIONALITY_RIGHT = 3.36;

        static final double EXTRAVERSION_LEFT = 2.67;
        static final double EXTRAVERSION_RIGHT = 3.85;

        static final double AGREEABLENESS_LEFT = 2.67;
        static final double AGREEABLENESS_RIGHT = 3.79;

        static final double CONSCIENTIOUSNESS_LEFT = 3.21;
        static final double CONSCIENTIOUSNESS_RIGHT = 4.25;

        static final double OPENNESS_TO_EXPERIENCE_LEFT = 2.98;
        static final double OPENNESS_TO_EXPERIENCE_RIGHT = 4.26;
    }

    static final class StandardScoreFemale {

        static final double HONESTY_HUMILITY_LEFT = 3.48;
        static final double HONESTY_HUMILITY_RIGHT = 4.48;

        static final double EMOTIONALITY_LEFT = 2.83;
        static final double EMOTIONALITY_RIGHT = 3.91;

        static final double EXTRAVERSION_LEFT = 2.67;
        static final double EXTRAVERSION_RIGHT = 3.97;

        static final double AGREEABLENESS_LEFT = 2.84;
        static final double AGREEABLENESS_RIGHT = 3.92;

        static final double CONSCIENTIOUSNESS_LEFT = 3.22;
        static final double CONSCIENTIOUSNESS_RIGHT = 4.24;

        static final double OPENNESS_TO_EXPERIENCE_LEFT = 2.94;
        static final double OPENNESS_TO_EXPERIENCE_RIGHT = 4.24;
    }

    public static ArrayList<String> getTypeNames() {
        ArrayList<String> types = new ArrayList<>();
        types.add(Types.AGREEABLENESS);
        types.add(Types.CONSCIENTIOUSNESS);
        types.add(Types.EMOTIONALITY);
        types.add(Types.EXTRAVERSION);
        types.add(Types.HONESTY_HUMILITY);
        types.add(Types.OPENNESS_TO_EXPERIENCE);
        return types;
    }

    public static List<String> getSubTypesForHonestyHumility() {
        List<String> subTypes = new ArrayList<>();
        subTypes.add(SubTypes.SINCERITY);
        subTypes.add(SubTypes.FAIRNESS);
        subTypes.add(SubTypes.GREED_AVOIDANCE);
        subTypes.add(SubTypes.MODESTY);
        return subTypes;
    }

    public static List<String> getSubTypesForEmotionality() {
        List<String> subTypes = new ArrayList<>();
        subTypes.add(SubTypes.FEARFULNESS);
        subTypes.add(SubTypes.ANXIETY);
        subTypes.add(SubTypes.DEPENDENCE);
        subTypes.add(SubTypes.SENTIMENTALITY);
        return subTypes;
    }

    public static List<String> getSubTypesForExtraversion() {
        List<String> subTypes = new ArrayList<>();
        subTypes.add(SubTypes.SOCIAL_SELF_ESTEEM);
        subTypes.add(SubTypes.SOCIAL_BOLDNESS);
        subTypes.add(SubTypes.SOCIABILITY);
        subTypes.add(SubTypes.LIVELINESS);
        return subTypes;
    }

    public static List<String> getSubTypesForAgreeableness() {
        List<String> subTypes = new ArrayList<>();
        subTypes.add(SubTypes.FORGIVENESS);
        subTypes.add(SubTypes.GENTLENESS);
        subTypes.add(SubTypes.FLEXIBILITY);
        subTypes.add(SubTypes.PATIENCE);
        return subTypes;
    }

    public static List<String> getSubTypesForConscientiousness() {
        List<String> subTypes = new ArrayList<>();
        subTypes.add(SubTypes.ORGANIZATION);
        subTypes.add(SubTypes.DILIGENCE);
        subTypes.add(SubTypes.PERFECTIONISM);
        subTypes.add(SubTypes.PRUDENCE);
        return subTypes;
    }

    public static List<String> getSubTypesForOpennessToExperience() {
        List<String> subTypes = new ArrayList<>();
        subTypes.add(SubTypes.AESTHETIC_APPRECIATION);
        subTypes.add(SubTypes.INQUISITIVENESS);
        subTypes.add(SubTypes.CREATIVITY);
        subTypes.add(SubTypes.UNCONVENTIONALITY);
        return subTypes;
    }

}

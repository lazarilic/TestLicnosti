package com.example.lazar.testlicnosti;

import android.widget.TextView;
import com.example.lazar.testlicnosti.model.QuestionModel;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Lazar on 1/24/18.
 */
public class Utils {

    public static int returnPointForQuestion(int isAscending, int ascPoint, int descPoint){
        if(isAscending == 1) return ascPoint;
        else return descPoint;
    }

    public static void setCounter(TextView counter, int counterNum) {
        counter.setText(String.valueOf(counterNum + "/60"));
    }

    public static double calculateAveragePoint(List<QuestionModel> list) {
        Integer sum = 0;
        if(!list.isEmpty()) {
            for (QuestionModel model : list) {
                sum += model.getPoints();
            }
            return sum.doubleValue() / list.size();
        }
        return sum;
    }

    public static double calculateAveragePointForType(List<Double> list) {
        Integer sum = 0;
        if(!list.isEmpty()) {
            for (Double grade : list) {
                sum += grade.intValue();
            }
            return sum.doubleValue() / list.size();
        }
        return sum;
    }

    public static String getCurrentTime() {
        Locale locale = new Locale("sr");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", locale);
        return simpleDateFormat.format(Calendar.getInstance().getTime());
    }
}

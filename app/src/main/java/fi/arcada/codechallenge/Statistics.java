package fi.arcada.codechallenge;


import java.util.ArrayList;

public class Statistics {
    public static double calcMean(ArrayList<Double> num) {

        int sum = 0;
        for (Double x : num) {
            sum += x;
        }
        double average = (double)sum / num.size();

        return average;
    }
}

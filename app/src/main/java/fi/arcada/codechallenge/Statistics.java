package fi.arcada.codechallenge;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Statistics {
    public static double calcMean(ArrayList<Double> num) {

        double sum = 0;
        for (Double x : num) {
            sum += x;
        }
        double average = sum / num.size();

        return average;
    }

    public static double calcMin(ArrayList<Double> num) {
        double min = Collections.min(num);

        return min;
    }

    public static double calcMax(ArrayList<Double> num) {
        double max = Collections.max(num);

        return max;
    }

    public static double calcMedian(ArrayList<Double> num) {
        Collections.sort(num);

        double median;
        int size = num.size();

        if (size % 2 == 1) {
            median = num.get(size / 2);
        } else {
            double mid1 = num.get(size / 2 - 1);
            double mid2 = num.get(size / 2);

            median = (mid1 + mid2) / 2;
        }

        return median;
    }

    public static double calcMode(ArrayList<Double> num) {
        Map<Double, Integer> countMap = new HashMap<>();

        for (double numbers : num) {
            countMap.put(numbers, countMap.getOrDefault(numbers, 0) + 1);
        }

        Double mode = num.get(0);
        int maxCount = 0;

        for (Map.Entry<Double, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }

        return mode;
    }

    public static double calcStdev(ArrayList<Double> num) {
        double sum = 0;
        for (Double x : num) {
            sum += x;
        }

        double average = (double)sum / num.size();
        double diff = 0;

        for (double numbers : num) {
            diff += Math.pow(numbers - average, 2);
        }

        double stDev = Math.sqrt(diff / (num.size() - 1));

        return stDev;
    }

    public static double calcLQ(ArrayList<Double> num) {
        Collections.sort(num);

        int size = num.size();
        double q1;

        if (size % 2 == 0) {
            q1 = calcMedian(new ArrayList<>(num.subList(0, size / 2)));

        } else {
            q1 = calcMedian(new ArrayList<>(num.subList(0, size / 2)));
        }

        return q1;
    }

    public static double calcUQ(ArrayList<Double> num) {
        Collections.sort(num);

        int size = num.size();
        double q3;

        if (size % 2 == 0) {
            q3 = calcMedian(new ArrayList<>(num.subList(size / 2, size)));
        } else {
            q3 = calcMedian(new ArrayList<>(num.subList(size / 2 + 1, size)));
        }

        return q3;
    }

    public static double calcQR(ArrayList<Double> num) {

        double q1 = calcLQ(num);
        double q3 = calcUQ(num);

        double qr = q3-q1;

        return qr;
    }
}


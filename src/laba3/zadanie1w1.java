package laba3;

import java.util.ArrayList;
import java.util.Arrays;

public class zadanie1w1 {
    public static ArrayList<Double> arrX = new ArrayList<>(Arrays.asList(-0.93247, -0.66121, -0.23862, 0.23862, 0.66121, 0.93247));
    public static ArrayList<Double> arrC = new ArrayList<>(Arrays.asList(0.171324, 0.360762, 0.46793, 0.46793, 0.360762, 0.171324));

    public static double func(Double x) {
        return x / Math.pow(Math.sin(3 * x),2);
    }

    public static double pfunc(Double x) {
        return -(x/3)*(1/Math.tan(3*x))+(0.1111)*Math.log((Math.sin(3*x)));
    }

    public static void main(String[] args) {
        System.out.printf("Left: %.6f\n", leftRect(interval(0.2, 1.0, 0.1), 0.1));
        System.out.printf("Right: %.6f\n", rightRect(interval(0.2, 1.0, 0.1), 0.1));
        System.out.printf("Center: %.6f\n", centerRect(interval(0.2, 1.0, 0.05), 0.1));
        System.out.printf("Trapez: %.6f\n", trapez(interval(0.2, 1.0, 0.05), 0.05));
        System.out.printf("Parabl: %.6f\n", parabl(interval(0.2, 1.0, 0.05), 0.05));
        System.out.printf("Gauss: %.6f\n", gauss(arrX, arrC, 0.2, 1.0));
        System.out.printf("Nuoton-Lebnic: %.6f\n", nutonLebnic(0.2, 1.0));

    }

    public static ArrayList<Double> interval(double a, double b, double h) {
        ArrayList<Double> list = new ArrayList<>();
        double inter = a;
        if (a < b) {
            while (inter < b) {
                list.add(inter);
                inter += h;
            }
            list.add(b);
        }
        return list;
    }

    public static Double leftRect(ArrayList<Double> list, Double h) {
        Double sum = 0.0;
        for (int i = 0; i < list.size() - 1; i++) {
            sum += func(list.get(i));
        }
        return h * sum;
    }

    public static Double rightRect(ArrayList<Double> list, Double h) {
        Double sum = 0.0;
        for (int i = 1; i < list.size(); i++) {
            sum += func(list.get(i));
        }
        return h * sum;
    }

    public static Double centerRect(ArrayList<Double> list, Double h) {
        Double sum = 0.0;
        for (int i = 1; i < list.size() - 1; i += 2) {
            sum += func(list.get(i));
        }
        return h * sum;
    }

    public static Double trapez(ArrayList<Double> list, Double h) {
        Double sum = 0.0;
        for (int i = 2; i < list.size() - 1; i += 2) {
            sum += func(list.get(i));
        }
        sum = func(list.get(0)) + ((2 * sum) + func(list.get(list.size() - 1)));
        return h * sum;
    }

    public static Double parabl(ArrayList<Double> list, Double h) {
        Double sum = 0.0, sum2 = 0.0, result;
        for (int i = 2; i < list.size() - 1; i += 2) {
            sum += func(list.get(i));
        }
        for (int i = 1; i < list.size() - 1; i += 2) {
            sum2 += func(list.get(i));
        }
        result = func(list.get(0)) + func(list.get(list.size() - 1)) + (4 * sum2) + (2 * sum);
        return (h / 3) * result;
    }

    public static Double gauss(ArrayList<Double> arrX, ArrayList<Double> arrC, Double a, Double b) {
        Double t, sum = 0.0;
        for (int i = 0; i < 6; i++) {
            t = ((b - a) / 2) * arrX.get(i) + ((b + a) / 2);
            sum += arrC.get(i) * func(t);
        }
        return ((b - a) / 2) * sum;
    }

    public static Double nutonLebnic(Double a, Double b) {
        return pfunc(b) - pfunc(a);
    }
}
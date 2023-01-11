package laba1;

public class zadanie1w5 {
    static int count = 0;

    public static void main(String[] args) {
        System.out.println("Value: " + solve(0, 1) + "\nCount: " + count);
    }

    public static double func(double x) {
        return x + 4 * Math.sin(x);
    }

    public static double prfunc(double x) {
        return 4 * Math.cos(x) + 1;
    }

    // Решение методом Ньютона
    public static double solve(double a, double e) {
        double x = a;
        double temp;
        do {
            double xn = x - func(x) / prfunc(x);
            temp = Math.abs(xn - x);
            x = xn;
            count++;
        } while (temp > e);
        return x - func(x) / prfunc(x);
    }
}
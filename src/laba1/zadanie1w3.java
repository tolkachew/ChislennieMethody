package laba1;

public class zadanie1w3 {
    static int count = 0;
    public static void main(String[] args) {
        System.out.println("Value: " + solve(0,1) + "\nCount: " + count);
    }
    public static double func(double x){
        return x+4*Math.sin(x);
    }

    // Решение методом деления отрезка пополам
    public static double  solve(double start, double end){
        if(end - start <= 0.001){
            return start;
        }

        double x = start + (end - start) / 2;
        if(func(start) * func(x) > 0){
            count++;
            return solve(x, end);
        } else {
            return solve(start, x);
        }
    }
}

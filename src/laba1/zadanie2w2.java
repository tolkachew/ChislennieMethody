package laba1;

public class zadanie2w2 {
    static int count = 0;
    public static void main(String[] args) {
        System.out.println("Value: " + solve(0,1) + "\nCount: " + count);
    }
    public static double func(double x){
        return Math.pow(x,3) - 0.2 * Math.pow(x,2) + 3.5*x - 1.4;
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

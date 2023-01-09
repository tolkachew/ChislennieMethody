package laba1;

public class zadanie1w6 {
    static int count = 0;
    public static void main(String[] args) {
        System.out.println("Value: " + solve(0,1) + "\nCount: " + count);
    }
    public static double func(double x){
        return x + 4 * Math.sin(x);
    }

    // Решение методом хорд
    public static double  solve(double x0, double x1){
        double x = x1;
        do{
            x = x - func(x) / (func(x) - func(x0)) * (x - x0);
            count++;
        } while (Math.abs(func(x)) > 0.001);
        return x;
    }
}

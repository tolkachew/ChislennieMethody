package laba1;

public class zadanie1w4 {
    static int count = 0;
    public static void main(String[] args) {
        System.out.println("Value: " + solve(0,1) + "\nCount: " + count);
    }
    public static double func(double x){
        return x+4*Math.sin(x);
    }

    // Решение методом секущих
    public static double  solve(double x_prev, double x_curr){
        double x_next = 0;
        double tmp;
        do{
            tmp = x_next;
            x_next = x_curr - func(x_curr) / (func(x_prev) - func(x_curr)) * (x_prev - x_curr);
            x_prev = x_curr;
            x_curr = tmp;
            count++;
        } while (Math.abs(x_next - x_curr) > 0.001);
        return x_next;
    }
}

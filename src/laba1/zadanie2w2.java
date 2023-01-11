package laba1;

public class zadanie2w2 {
    static int count = 0;
    static double r, x, x0 = 0;

    public static void main(String[] args) {
        solve(0, 2);
    }

    public static double func(double x) {
        return (Math.pow(-x, 3) + 0.2 * Math.pow(x, 2) + 1.4) / 3.5;
    }
    /*
       Привести уравнение к виду, позволяющему применить метод простой итерации
       x^3+0.2x^2+3.5x+1.4=0
       -3.5x=x^3+0.2x^2+1.4
       3.5x=-x^3-0.2x^2-1.4
       x=(-x^3-0.2x^2-1.4)/3.5  -- уравнение вида, позволяющего применить метод итерации

       Проверка условия сходимости МПИ:
       Ф(x)=(-x^3-0.2x^2-1.4)/3.5 = (2*(-3x^2-2x/5)/7
       Ф(0)=0
       Ф(1)=0.9
       Т.к. Ф(0) и Ф(1) < 1, то МПИ сходимо
     */

    public static double func1(double x) {
        //  (-x^3+0.2x^2+1.4)/3.5
        return (2 * (-3*Math.pow(x,2)-2*x/5))/7;
    }

    // Решение методом простых итераций
    public static void solve(double start, double end) {
        if (Math.abs(func1(start)) < 1)
            x0 = start;
        else if (Math.abs(func1(end)) < 1) {
            x0 = end;
        } else System.out.println("Error");
        System.out.println("X0: " + x0);
        do {
            x = func(x0);
            r = Math.abs(x - x0);
            count++;
            System.out.printf("I: %d | X: %.5f | R: %.5f]\n", count, x, r);
            x0 = x;
        } while (r > 0.001);
    }
}

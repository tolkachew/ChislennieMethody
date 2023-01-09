package laba1;

import java.util.ArrayList;
import java.util.Scanner;

public class zadanie1w2 {
    public static double h;
    //Объявление функции
    public static double func(double x){
        return x+4*Math.sin(x);
    }

    public static void main(String[] args) {
        //Ввод шага с клавиатуры
        Scanner scanner = new Scanner(System.in, "utf-8");
        System.setProperty("console.encoding","utf-8");
        System.out.print("Enter step: ");
        h = scanner.nextDouble();

        //Создание массива
        ArrayList<Double[]> list = new ArrayList<>();
        double i = -10.0;
        int n  = 1;

        //Функция отделения корней
        while (i < 10.0){
            if (func(i) * func(i + h) < 0 ){
                list.add(new Double[] {i,i+h});
                System.out.printf("x-%d [%.3f;%.3f]",n,i,i+h);
            }
            i+=h;
        }
    }
}
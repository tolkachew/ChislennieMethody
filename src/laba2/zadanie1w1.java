package laba2;

import java.util.ArrayList;
import java.util.Scanner;

public class zadanie1w1 {
    public static double h, a ,b;
    public static ArrayList<Double> listInt = new ArrayList<>();
    public static ArrayList<Double> leftF = new ArrayList<>();
    public static ArrayList<Double> centerF = new ArrayList<>();
    public static ArrayList<Double> rightF = new ArrayList<>();
    public static ArrayList<Double> secondF = new ArrayList<>();

    public static double func(Double x){
        return Math.log(x)-1/x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter left border");
        a = scanner.nextDouble();
        System.out.println("Enter right border");
        b = scanner.nextDouble();
        System.out.println("Enter step");
        h = scanner.nextDouble();

        double inter = a;

        if (a < b) {
            while (inter < b){
                listInt.add(inter);
                inter += h;
            }
            listInt.add(b);

            // вычисление производных
            for (int i = 0; i < listInt.size(); i++) {
                //правая
                if (i < listInt.size()-1){
                    rightF.add((func(listInt.get(i + 1)) - func(listInt.get(i))) / h);
                } else rightF.add(0.0);
                //левая
                if (i > 0){
                    leftF.add((func(listInt.get(i)) - func(listInt.get(i-1))) / h);
                }else leftF.add(0.0);
                //центральная
                if (i > 0 && i < listInt.size()-1){
                    centerF.add((func(listInt.get(i+1)) - func(listInt.get(i-1))) / (2*h));
                    secondF.add((func(listInt.get(i+1)) - 2 * func(listInt.get(i)) + func(listInt.get(i-1))) / (h*h));
                }else {
                    centerF.add(0.0);
                    secondF.add(0.0);
                }
            }
        } else System.out.println("Неправильные границы");

        for (int i = 0; i <listInt.size()-1; i++) {
            System.out.printf("%d: X: %.2f ,f(x)\'-right : %.2f ,f(x)\'-left : %.2f ,f(x)\'-center : %.2f ,f(x)\'' : %.2f \n", i+1,listInt.get(i),rightF.get(i),leftF.get(i),centerF.get(i),secondF.get(i));
        }

    }
}
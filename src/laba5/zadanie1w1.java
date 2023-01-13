package laba5;

public class zadanie1w1 {
    static int n = 4 , m = 4;

    static double[][] A =
                    {{1.7,-1.8,1.9,-57.4},
                    {1.1,-4.3,1.5,-1.7},
                    {1.2,1.4,1.6,1.8},
                    {7.1,-1.3,-4.1,5.2}};
    static double[] b =
                    {10,19,20,10};

    static double[][] L = new double[n][m];
    static double[][] U = new double[n][m];
    static double[] G = new double[m];
    static double[] X = new double[m];

    public static void main(String[] args) {
        printM(A,b);
        findLU();
        findG();
        findX();
    }

    public static void printM(double[][] m, double[] b){
        System.out.println("Матрица A:");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%6.2f\t", m[i][j]);
            }
            System.out.printf("=%6.2f", b[i]);
            System.out.println();
        }
        System.out.println();
    }
    public static void printLU(double[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%6.2f\t", m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static public void findLU() {

        for (int i = 0; i < A.length; i++) {

            // Верхняя треугольная матрица
            for (int k = i; k < A.length; k++) {
                // Суммирование элементов L(i, j) * U(j, k)
                double sum = 0;
                for (int j = 0; j < i; j++)
                    sum += (L[i][j] * U[j][k]);

                // Вычисление коэффицентов U(i, k)
                U[i][k] = A[i][k] - sum;
            }

            // Нижняя треугольная матрица
            for (int k = i; k < A.length; k++) {
                if (i == k)
                    L[i][i] = 1; // Единичная диагональ
                else {
                    // Суммирование элементов L(k, j) * U(j, i)
                    double sum = 0;
                    for (int j = 0; j < i; j++)
                        sum += (L[k][j] * U[j][i]);

                    // Вычисление коэффицентов L(k, i)
                    L[k][i] = (A[k][i] - sum) / U[i][i];
                }
            }
        }
        System.out.println("Матрица L:");
        printLU(L);
        System.out.println("Матрица U:");
        printLU(U);
    }

    static public void findG() {
        G[0] = b[0];
        for (int i = 1; i < A.length; i++) {
            double sum = 0;
            for (int j = 0; j <= i - 1; j++) {
                sum += (L[i][j] * G[j]);
            }
            G[i] = b[i] - sum;
        }
        System.out.println("Вектор G:");
        for (int i = 0; i < A.length; i++) {
            System.out.printf("G%d:%6.2f\t",i,G[i]);
        }
    }
    static public void findX() {
        X[A.length - 1] = G[A.length - 1] / U[A.length - 1][A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < A.length; j++) {
                sum += U[i][j] * X[j];
            }
            X[i] = (G[i] - sum) / U[i][i];
        }
        System.out.println("\nВектор X:");
        for (int i = 0; i < A.length; i++) {
            System.out.printf("X%d:%6.2f\t",i,X[i]);
        }
    }
}
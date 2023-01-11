package laba4;

public class zadanie1w1 {
    public static void main(String[] args) {

        // Ввод данных
        //матрица4х4
        int n = 4, m = 4;

        double[][] A =
                        {{5.7, -7.8, -5.6, -8.3},
                        {6.6, 13.1, -6.3, 4.3},
                        {14.7, -2.8, 5.6, -12.1},
                        {18.5, 12.7, -23.7, 5.7}};
        double[] b =
                        {2.4, -5.5, 8.6, 14.7};

        // Метод Гаусса

        int N = n;
        for (int p = 0; p < N; p++) {

            int max = p;
            for (int i = p + 1; i < N; i++) {

                // Уравнениение с максимальным коэффицентом 1
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p];
            A[p] = A[max];
            A[max] = temp;
            double t = b[p];
            b[p] = b[max];
            b[max] = t;

            if (Math.abs(A[p][p]) <= 1e-10) {
                System.out.println("Система не имеет решений");
                return;
            }

            // Обнуление коэффицентов Х
            for (int i = p + 1; i < N; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < N; j++) {
                    A[i][j] -= alpha * A[p][j];

                }

            }

            //Вывод матрицы
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    System.out.printf("%6.2f\t", A[i][j]);
                }
                System.out.printf("=%6.2f", b[i]);
                System.out.println();
            }
            System.out.println();
        }

        // Обратный проход от х4 -> x1
        double[] x = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }

        //Вывод результатов
        if (n < m) {
            System.out.print("Система имеет бесконечное множество решений");
        } else {
            System.out.println("Система имеет единственное решение.\n Значения неизвестных: ");
            for (int i = 0; i < N; i++) {
                System.out.printf("%6.2f\t", x[i]);
            }
        }
    }
}
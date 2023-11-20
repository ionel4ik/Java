package org.example;

public class Variant4 {

    public enum DAY_OF_WEEK{
        MONDAY, TUESDAY, WEDNESDAY
    }


    public int inputOutputTask(int k) {
        return 0;
    }


    public int integerNumbersTask(int a, int b) {
        return (a / b);
    }


    public boolean booleanTask(int a, int b) {
        return a > 2 && b%3 == 0 ;
    }



    public int ifTask(int a, int b, int c) {
        int result = 0;
        if (a > 0){
            result += 1;
        }

        if (b > 0){
            result += 1;
        }

        if (c > 0){
            result += 1;
        }
        return result;
    }



    public int switchTask(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default -> throw new IllegalArgumentException("Wrong month!");
        };
    }



    public double[] forTask(double priceForKg) {
        double[] arr =  new double[10] ;
        for(int i = 1; i <= 10 ; i++){
            arr[i-1] = priceForKg * i;
        }
        return arr;
    }


    public boolean whileTask(int n) {
        while (n > 1) {
            n /= 3;
            if (n % 3 == 1) {
                return false;
            }
        }
        return true;
    }

    public int[] arrayTask(int n, int a, int d) {
        int[] arr = new int[n];
        int temp = 1;
        for (int i = 0; i < n; i++) {  // Start the loop from 0
            arr[i] = a * temp;
            temp *= d;
        }
        return arr;
    }


    public int[][] twoDimensionArrayTask(int m, int n) {
        int[][] matrix = new int[m][n];
        int counter = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = counter++;
            }
        }
        return matrix;
    }

    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}

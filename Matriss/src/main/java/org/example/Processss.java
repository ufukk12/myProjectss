package org.example;

import java.util.Scanner;

public class Processss {
    private int rows;
    private int cols;
    private double[][] matrix;
    private double[] answer;
    private double[][] ekMatris;
    Scanner sc = new Scanner(System.in);

    public Processss(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new double[rows][cols];
        this.answer = new double[rows];
        this.ekMatris = new double[rows][cols + 1];
    }

    public Processss() {
    }

    public void yazdir(String input) {
        System.out.println(input);
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
        // setRows çağrıldığında dizilerin yeniden boyutlandırılması gerekir
        this.matrix = new double[rows][this.cols];
        this.answer = new double[rows];
        this.ekMatris = new double[rows][this.cols + 1];
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
        // setCols çağrıldığında dizilerin yeniden boyutlandırılması gerekir
        this.matrix = new double[this.rows][cols];
        this.ekMatris = new double[this.rows][cols + 1];
    }

    public int giveRol() {
        int row = sc.nextInt();
        if (row <= 0) {
            yazdir("Hatalı Satır Değeri!");
            yazdir("Tekrar Satır Değeri Girin: ");
            return giveRol();
        }
        return row;
    }

    public int giveCol() {
        int col = sc.nextInt();
        if (col <= 0) {
            yazdir("Hatalı Sütun Değeri!");
            yazdir("Tekrar Sütun Değeri Girin: ");
            return giveCol();
        }
        return col;
    }

    private double[] answers() {
        for (int i = 0; i < rows; i++) {
            yazdir("Lütfen " + (i + 1) + ". denklemin cevabını giriniz:");
            answer[i] = sc.nextDouble(); // int yerine double okumalı
        }
        return answer;
    }

    private double[][] matrisLog() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                yazdir("Matrisin " + (i + 1) + ". satır, " + (j + 1) + ". sütun elemanını giriniz:");
                matrix[i][j] = sc.nextDouble(); // int yerine double okumalı
            }
        }
        return matrix;
    }

    private void createAugmentedMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ekMatris[i][j] = matrix[i][j];
            }
            ekMatris[i][cols] = answer[i];
        }
    }

    public void makeEshelon() {
        createAugmentedMatrix(); // İlk olarak ek matrisi oluşturur

        for (int p = 0; p < rows && p < cols; p++) {
            // Pivot bulma (maksimum mutlak değere sahip eleman)
            int maxRow = p;
            for (int i = p + 1; i < rows; i++) {
                if (Math.abs(ekMatris[i][p]) > Math.abs(ekMatris[maxRow][p])) {
                    maxRow = i;
                }
            }

            // Satırları değiştirme (pivot satırını en üste taşıma)
            double[] temp = ekMatris[p];
            ekMatris[p] = ekMatris[maxRow];
            ekMatris[maxRow] = temp;

            // Pivot eleman 0 ise, bu sütunu atla (çözüm yok veya sonsuz çözüm var)
            if (ekMatris[p][p] == 0) {
                continue;
            }

            // Pivotun altındaki tüm elemanları sıfırlama
            for (int i = p + 1; i < rows; i++) {
                double alpha = ekMatris[i][p] / ekMatris[p][p];
                for (int j = p; j < cols + 1; j++) {
                    ekMatris[i][j] -= alpha * ekMatris[p][j];
                }
            }
        }
    }

    public void printMatrix(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("%8.2f ", mat[i][j]);
            }
            System.out.println();
        }
    }

    public void Process() throws InterruptedException {
        yazdir("Matrisin elemanlarını giriniz.");
        matrix = matrisLog();

        yazdir("Lütfen denklem sisteminin cevaplarını giriniz:");
        answer = answers();

        yazdir("Matris Eşelon Hale Getiriliyor...");
        Thread.sleep(5000);

        makeEshelon();

        System.out.println("\nMatris Eşelon Formunda:");
        printMatrix(ekMatris);
    }
}
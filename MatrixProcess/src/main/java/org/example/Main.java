package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Process process = new Process();
        int rows = 0;
        int coulum = 0;
        process.yazdır("Lütfen Matrisin Satır Sayısını Giriniz");
        rows = process.getRow();

        process.yazdır("Lütfen Matrisin Sütun Sayısını Giriniz");
        coulum = process.getColumn();

        double[][] matrix = new double[rows][coulum];

        process.yazdır("Lütfen matrisin sırasıyla satırlarını girin");
        for (int i = 0; i < rows; i++) {
            process.yazdır((i+1) + ". satırdasınız ");
            for (int j = 0; j < coulum; j++) {
                process.yazdır((j+1) +". sütundasınız");
                matrix[i][j] = input.nextInt();
            }

        }
        process.yazdır("Lütfen sırasıyla yukarıdan aşagı olacak sekilde sonucları girin");
        double[] results = process.results(rows);

        double[] çözümler = process.solveLineerSystem(matrix , results);

        System.out.println("----------ÇÖZÜMLR-------------");
        for (int i = 0; i < rows; i++) {
            System.out.println("x"+(i+1)+  "=" + çözümler[i]);
        }

    }
}
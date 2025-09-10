package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Processss p = new Processss();
        int rows;
        int cols;

        p.yazdir("Lütfen Satır Değeri Giriniz: ");
        rows = p.giveRol();
        p.yazdir("Lütfen Sütun Değeri Giriniz: ");
        cols = p.giveCol();

        Processss pp = new Processss(rows, cols);

        pp.Process();

    }
}
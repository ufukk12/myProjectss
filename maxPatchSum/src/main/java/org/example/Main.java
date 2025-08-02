package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //FOR PROJECT EULER QUESTION 18

         /*
            - Kullanıcı Tarafından n satırlı
                        *
                       * *
                      * * *
                      ...
               Formatında üçgen olusturacak sekilde sayılar girilecektir

            en üstten başlanacak şekilde bir alt satırdaki max eleman alınıp

         */

        maxPatchSumFunc func = new maxPatchSumFunc();
        Scanner scn = new Scanner(System.in);

        System.out.println("Lütfen Üçgenin Satır Sayısını giriniz: ");
        int col = scn.nextInt();
        int sum = 0;

        System.out.println("Max Toplam = " + func.maxPath(1 , sum , col));


    }
}
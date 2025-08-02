package org.example;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class maxPatchSumFunc {
    Scanner sc = new Scanner(System.in);

    public int maxPath(int sayac , int sum, int col){

        // Sayac 1 den baslayacak !!

        if(sayac == (col +1)){
            return sum;
        }

        int[] sumArray = new int[sayac];
        int[] yeni = diziDoldur(sumArray , sayac);

        Arrays.sort(yeni);

        sum += yeni[yeni.length - 1];
        sayac++;

        return maxPath(sayac, sum, col);
    }

    private int[] diziDoldur(int[] dizi, int sayac){

        for(int i = 0; i < dizi.length; i++){
            System.out.println("Lütfen" + (sayac) + ". satırının" + (i+1) + ". elemanını girin.");
            dizi[i] = sc.nextInt();
        }
        return dizi;
    }
}

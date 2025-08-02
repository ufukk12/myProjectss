package org.example;

import java.util.Scanner;

public class Functions {

    Scanner input = new Scanner(System.in);

    public void mesajYazdir(String yazdir){
        System.out.println(yazdir);
        char secim;

    }

    public char secimAl(Scanner input , char secim){
        secim = input.next().charAt(0);
        return secim;
    }

    public double[] vizeAl(Scanner input , double[] vize){
        mesajYazdir("Lütfen Her Kullanıcının Sıra Numarasına göre vize Notunu girin");
        for (int i = 0; i < vize.length; i++){
            if (vize[i] != 0){
                mesajYazdir("Şu numaraya sahip örencinin notunu girmişsiniz--->" + (i+1));
                mesajYazdir("Lütfen sıradaki öğrencinin notunu girin");
                mesajYazdir("Bu öğrencinin notu" + vize[i]);
                i = i + 1;

            }else {

            }

            vize[i] = input.nextInt();


        }
        return vize;
    }

    public double[] fınalAl (Scanner input , double[] fınal){
        mesajYazdir("Lütfen Her Kullanıcının Sıra Numarasına göre final Notunu girin");
        for (int i = 0; i <fınal.length; i++){
            if (fınal[i] != 0){
                mesajYazdir("Şu numaraya sahip örencinin notunu girmişsiniz" + (i+1) + "Lütfen sıradaki öğrencinin notunu girin");
                i = i + 1;

            }else {

            }
            fınal[i]= input.nextInt();

        }
        return fınal;
    }

    public int basarıNotHesapla(double vize , double fınal , int basarı){
        basarı = (int) (vize * 0.4 + fınal * 0.6);

        return basarı;
    }

    public void görüntülemeGeçiş (Scanner scn, char secim2){
        mesajYazdir("Görüntüleme menüsüne girmek ister misiniz(e/h)?");
        secim2 = secimAl(input , secim2);

        if (secim2 == 'e'){

        }else if (secim2 == 'h'){

        }else {
            mesajYazdir("Yanlış seçim! Lütfen tekrar seçim yapın");
            görüntülemeGeçiş(input ,secim2);
        }

        switch (secim2){
            case 'e':

            case 'h':
                break;
        }

    }

    public int göruntülemeMenu(int secim3){
        mesajYazdir("Lütfen görüntülemek istediğiniz işlemin no sunu girin:");
        mesajYazdir("küçükten büyüğe fiyat sıralaması -->1");
        mesajYazdir("sepet-->2");
        secim3 = input.nextInt();

        if (secim3 == 1){

        }else if (secim3 == 2){

        }else {
            mesajYazdir("Yanlış seçim! Lüütfen tekrar seçim yapın");
            göruntülemeMenu(secim3);
        }

        return secim3;

    }
    public int ogrenciNo (int no ){
        no = input.nextInt();
        if (no > 5 ) {
            mesajYazdir("Böyle bir ogrenci yoktur Lütfen listeye gore numara girin:");
            ogrenciNo(no);
        }else if (no == 0){
            mesajYazdir("Böyle bir ogrenci yoktur Lütfen listeye gore numara girin:");
            ogrenciNo(no);
        }else {

        }
        return no;
    }
}







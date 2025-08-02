package org.example;

import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Functions fnks = new Functions();

        char secim1 = 0;
        char secim2 = 0;
        int basarı = 0;
        int secim3 = 0;
        int no = 0;




        String[] ogrenciler = {
                "Ufuk Özdemir",
                "Mehmet Eren Adalı",
                "Hasan Tarık Seçgin",
                "Fatih Avşar",
                "Medine Kızmaz"
        };

        double[] vizeNotlari = new double[ogrenciler.length];
        double[] finalNotlari = new double[ogrenciler.length];

        fnks.mesajYazdir("--------------------------------------------");

        fnks.mesajYazdir("Öğrenci Numaraları aşagıdadır;");
        fnks.mesajYazdir("Ufuk Özdemirr->1" +
                "Mehmet Eren Adalı->2" +
                "Hasan Tarık Seçgin->3" +
                "Fatih Avşar->4" +
                "Medine Kızmaz->5");

        vizeNotlari[0]=10;

        fnks.mesajYazdir("Lütfen yapmak istediğiniz işlemin harfini girin:");
        fnks.mesajYazdir("Not girişi--> n");
        fnks.mesajYazdir("Not Görüntüleme--> g");

        secim1 = fnks.secimAl(scn , secim1);

        switch (secim1){
            case 'n':
                vizeNotlari = fnks.vizeAl(scn , vizeNotlari);
                finalNotlari = fnks.fınalAl(scn , finalNotlari);
                fnks.mesajYazdir("Görüntüleme menüsüne girmek ister misiniz(e/h)?");
                fnks.görüntülemeGeçiş(scn , secim2);

            case 'g':
                secim3 = fnks.göruntülemeMenu(secim3);

                switch (secim3){
                    case 1:
                        fnks.mesajYazdir("Görüntülemek istediğiniz öğrenci no girin");
                        no = fnks.ogrenciNo(no);
                        fnks.mesajYazdir(ogrenciler[no-1] + "in vize ve final notu");
                        System.out.println("vize :" + vizeNotlari[no-1]);
                        System.out.println("final : " + finalNotlari[no-1]);

                    case 2:
                        for (int i =0; i < ogrenciler.length; i++){
                            if(fnks.basarıNotHesapla(vizeNotlari[i] , finalNotlari[i] , basarı ) >= 50){
                                fnks.mesajYazdir(ogrenciler[i] + "başarılı! Başarı Notu:" + fnks.basarıNotHesapla(vizeNotlari[i] , finalNotlari[i] , basarı ) );
                            }else {
                                fnks.mesajYazdir(ogrenciler[i] + "başarısız! Başarı Notu:" + fnks.basarıNotHesapla(vizeNotlari[i] , finalNotlari[i] , basarı ) );
                            }
                        }
                }


        }






    }
}
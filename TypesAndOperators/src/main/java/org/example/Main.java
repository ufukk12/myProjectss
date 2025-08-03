package org.example;

public class Main {
    public static void main(String[] args) {

        int maxInteger11 = Integer.MIN_VALUE;
        int minInteger12 = Integer.MAX_VALUE;

        double maxDouble21 = Double.MIN_VALUE;
        double minDouble22 = Double.MAX_VALUE;

        float maxFloat31 = Float.MIN_VALUE;
        float minFloat32 = Float.MAX_VALUE;

        long maxLong41 = Long.MIN_VALUE;
        long minLong42 = Long.MAX_VALUE;

        short maxShort51 = Short.MAX_VALUE;
        short minShort52 = Short.MAX_VALUE;

        byte maxByte61 = Byte.MIN_VALUE;
        byte minByte62 = Byte.MAX_VALUE;


        char A; // one anything
        A = 'A'; // Tek tırnak

        /*
           Char için unicod sitesindeki kodu /uaaaa a bir rakam;
           A = /u
         */

        boolean TF; // True - False


    System.out.println("integer min :" + maxInteger11);
    System.out.println("integer max :" + minInteger12);
    System.out.println("Double min :" + maxDouble21);
    System.out.println("Double max :" + minDouble22);
    System.out.println("Float min :" + maxFloat31);
    System.out.println("Float max :" + minFloat32);
    System.out.println("Long min :" + maxLong41);
    System.out.println("Long Max :" + minLong42);
    System.out.println("Short min :" + maxShort51);
    System.out.println("Short Max :" + minShort52);
    System.out.println("Byte min :" + maxByte61);
    System.out.println("Byte Max :" + minByte62);

    /*
     Programda Görüldüğü üzere bütün sayı tiplerinin sayı dogrusunda belli bir aralığı vardır.
        Eger maxInteger11 değerine herhangi bir sayı pozitif sayı eklresem minInteger değerine kayacaktır
                Örnek Çıktı;
                    - System.out.println("integer max :" + (maxInteger11 + 1) );
                    > -2147483648
     */

     /*
       !!!!!    Çok Çok Büyük sayıları okumayı kolaylaştırmak için sayıların arasına "_" koyulabilitr.
      */
     int myInteger = 2_147_483_647 ;

     /*
            Eger maxInteger değerinden daha büyük sayıları kullanmamız gerekiyorsa long kullanmamız gerekir
                Fakat;
                    - long a = 2_147_483_648 (maxInteger dan büyük) verdiğimizde hata veriyor.
                    bununiçin sayının sonunua "L" koymamız gerekir

                    -long a = 2_147_483_648L yaptıgımızda Hata gider

                    Aynı şekilde Double için D , float içi F ... gelebilir (double için sayı.0) da kabuldür

      */

        // long myLongFalse = 2_147_483_648; //Integer Number is too Large
        long myLongTrue = 9_223L;

        // float myFloatFalse = 246_465_456_464_684;
        float myFloatTrue = 246F;

        // double myDoubleFalse = 246_465_456_464_684;
        double myDoubleTrue = 246.0; //  246465456464684D

        /*
             Bölme işlemleri Int Bölmesi ve diğer bölmeler olarak 2 ye ayrılır(diğer tiplerin)

             İnt Bölmesinde int ve long için
                    sayı ondalıklı çıkarsa sayıyı kendisinden küçük en büyük tam sayıya yuvarlar
                    (Tam değer fonksiyonu)

             Diğer Bölmelerde normal olarak sayıyı ondalıklı olarak yazdırır
         */

        System.out.println("-----------------------------------------------");

        System.out.println("Integer Bölmesi" + myInteger/2);
        System.out.println("Float Bölmesi" + myFloatTrue/2);
        System.out.println("Double Bölmesi " + myDoubleTrue/2);
        System.out.println("Long Bölmesi" + myLongTrue/2);


        //------------------------------!!!!

        String myName = "Ufuk";
        System.out.println("My Name İs " + myName);
        myName = myName + " Ozdemir";
        System.out.println("My Name Is " + myName);

        int year = 2025;

        myName = myName + year;
        System.out.println("My Name Is " + myName);
        myName = myName + " " + 2025;
        System.out.println("My Name Is " + myName);

        /*
                Int değer tanımlanıp String ile toplanmaya çalışılırsa Hata alınmaz

                int year = 2025
                myName = myName + year;  // hata vermez ınt degeri stringe cevirir
                myName = myName + 2025;  // hata vermez ınt degeri stringe cevirir
         */



    }
}
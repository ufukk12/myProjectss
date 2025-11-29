package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
                 +                    +
               + |------|------|------| +
                 |      |      |      |
                 |------|------|------|
                 |      |      |      |
                 |------|------|------|
                 |      |      |      |
               + |------|------|------| +
                 +                    +
         */

        String[][] sosTable = new String[3][3];
        sosGame s = new sosGame(sosTable);

        String[] sORo = s.SorO();
        s.dgrAl(1 , sORo[0] , sORo[1]);

    }
}
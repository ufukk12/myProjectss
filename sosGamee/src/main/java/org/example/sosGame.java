package org.example;
import java.util.*;

public class sosGame {
    private String[][] sosTable;
    Scanner sc = new Scanner(System.in);

    public sosGame(String[][] sosTable) {
        this.sosTable = sosTable;
    }

    private void yazdir(String input) {
        System.out.println(input);
    }

    private int satırAl() {
        int scm = sc.nextInt();
        if (scm != 1 && scm != 2 && scm != 3) {
            yazdir("Hatalı Satır dgri Lütfen 1 - 2 - 3  dgrlrindn birini girin");
            return satırAl();
        }
        return scm;
    }

    private int sütunAl() {
        int scm = sc.nextInt();
        if (scm != 1 && scm != 2 && scm != 3) {
            yazdir("Hatalı Sütun dgri Lütfen 1 - 2 - 3  dgrlrindn birini girin");
            return sütunAl();
        }
        return scm;
    }

    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + sosTable[i][0] + " | " + sosTable[i][1] + " | " + sosTable[i][2] + " |");
            System.out.println("-------------");
        }


        for(int i = 0; i<sosTable.length; i++) {
            for(int j = 0; j<sosTable[i].length; j++) {
                if(sosTable[i][j] == null) {
                    sosTable[i][j] = " ";
                }
            }
        }

    }

    public String SorOscm(){
        String scm = sc.nextLine();
        if(scm.length() != 1) {
            yazdir("Sadece S ya da O girilebilir !!");
            yazdir("Tekrar dnyin");
            return SorOscm();
        }

        String scm1 = scm.toUpperCase();

        if(!scm1.equals("S") && !scm1.equals("O")) {
            yazdir("Sadece S ya da O girilebilir !!");
            yazdir("Tekrar dnyin");
            return SorOscm();
        }

        return scm1;

    }

    public String[] SorO() {
        yazdir("1. Oyuncu Seçimini Yapsın: (S - O)");
        String player1 = SorOscm();
        String player2;

        if(player1.equals("S")) {
            player2 = "O";
        }else {
            player2 = "S";
        }
        String[] sORo = {player1 , player2};
        return sORo;
    }

    public boolean check(){

        for(int i = 0; i<sosTable.length; i++) {

                if(sosTable[i][0] == sosTable[i][1] && sosTable[i][1] == sosTable[i][2] && !sosTable[i][0].equals(" ")) {
                    return true;
                }

        }

            for(int i = 0; i<sosTable.length; i++) {
                if (sosTable[0][i] == sosTable[1][i] && sosTable[1][i] == sosTable[2][i] && !sosTable[0][i].equals(" ")) {
                        return true;
                    }

            }
            return false;
    }

    public void isBoxFull(int playerRow, int playerCol) {

        if (sosTable[playerRow - 1][playerCol - 1] != null && sosTable[playerRow - 1][playerCol - 1] != " "  ) {
                yazdir("Bu Kutu dolu!! Başka Kutu Girin");
                System.out.print("Satır : ");
                playerRow = satırAl();
                System.out.print("Satır : ");
                playerCol = sütunAl();
                isBoxFull(playerRow, playerCol);
            }
        }





    public void dgrAl(int Player , String player1 , String player2 ) {

        printBoard();
        yazdir("Oyun Sırası " + Player + ". Oyuncuda");
        yazdir("Lütfen Kullanmak İstdiğiniz Satırı Seçin;");
        int playerRow = satırAl();

        yazdir("Lütfen Kullanmak İstdiğiniz Sütunu Seçin;");
        int playerCol = sütunAl();
        isBoxFull(playerRow, playerCol);

        if(Player == 1){
            sosTable[playerRow - 1][playerCol-1] = player1;
        }else {
            sosTable[playerRow - 1][playerCol - 1] = player2;
        }

        boolean isFinish = check();

        if  (!isFinish) {
            if(Player < 2) {
                Player++;
                dgrAl(Player , player1 , player2);
            }else {
                Player = 1;
                dgrAl(Player , player1 , player2);
            }

        }else {
            yazdir("OYUN BİTTİ OYUNU " + Player + ". OYUNCU KAZANI");
        }



    }
}

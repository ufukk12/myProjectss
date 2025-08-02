package org.example;

import java.util.Scanner;

public class Process {



    Scanner input = new Scanner(System.in);
    public void yazdır(String input){
        System.out.println(input);
    }

    public int getRow() {
        int row = input.nextInt();

        if (row < 1) {
            yazdır("Matrisin Satır Sayısı 1 den küçük olamaz. Tekrar Satır Değeri Girin.");
            return getRow();
        } else {
            return row;
        }
    }

    public int getColumn(){
        int column = input.nextInt();

        if (column<1){
            yazdır("Matrisin Satır Sayısı 1 den küçük olamaz. Tekrar Satır Değeri Girin.");
            return getColumn();
        }else{
            return column;
        }

    }

    public double[] results(int rows){
        double[] results = new double[rows];
        for (int i=0;i<rows;i++){
            results[i]=input.nextInt();
        }
        return results;
    }

    private double[][] extraMatrix(double[][] matrix , double[] result ){
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;

        double[][] extraMatrix = new double[matrixRows][matrixColumns+1];

        for(int i=0;i<matrixRows;i++){
            for(int j=0;j<matrixColumns; j++){
                extraMatrix[i][j]=matrix[i][j];
            }

        }

        for (int i=0;i< matrix.length;i++){
            extraMatrix[i][matrix[0].length]= result[i];
        }

        return extraMatrix;
    }

    private int findPivot(double[][] matrix , int row){
        for (int i=0;i<matrix[0].length;i++){
            if(matrix[row][i] != 0) {
                return i;
            }
         }
        return -1;
     }


    private double[][] eshelonForm(double[][] matrix, int sayac) {
        int matrixRow = matrix.length;
        int matrixColumn = matrix[0].length;

        if (sayac >= matrixRow) {
            return matrix;
        }

        int pivotİndex = findPivot(matrix, sayac);


        if (pivotİndex == -1 || matrix[sayac][pivotİndex] == 0) {
            return eshelonForm(matrix, sayac + 1);
        }

        double pivot = matrix[sayac][pivotİndex];


        for (int row = sayac + 1; row < matrixRow; row++) {
            double factor = matrix[row][pivotİndex] / pivot;


            for (int col = 0; col < matrixColumn; col++) {
                matrix[row][col] -= factor * matrix[sayac][col];
            }
        }


        return eshelonForm(matrix, sayac + 1);
    }

    public double[] solveLineerSystem(double[][] matrix , double[] result ){
        double[][] extraMatrix = extraMatrix(matrix,result);
        double[][] eshelonMatrix = eshelonForm(extraMatrix ,0);
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;


        double[] solution = new double[matrixRows];

        for (int j=0;j<matrixRows-1;j++){
            for(int i=0; i<matrixColumns-1; i++){
                if (eshelonMatrix[j][i] == 0 & eshelonMatrix[j][matrixColumns-1] == 0){
                    yazdır("bu sistemin çözüm kümesi sonsuz elemanlıdır");
                    return null;

                }else if(matrix[j][i] == 0 & matrix[j][matrixColumns-1] != 0){
                    yazdır("Uğraşma kiral çözemezsin bunu bu sistem onun seni niye sebebsizce bırakması ile aynı");
                    return null;

                }else {
                    for (int k = 0; k < solution.length - 1; k++){

                        if(matrix[matrixRows-1][matrixColumns-2] != 0){
                            solution[matrixRows-1] = matrix[matrixRows-1][matrixColumns-1] / matrix[matrixRows-1][matrixColumns-2];
                        }else{
                            solution[matrixRows-1] = 0;
                        }
                    }
                }
            }
        }
        return solution;
        }
    }


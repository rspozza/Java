/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.thread.utils;

/**
 *
 * @author User
 */
public class Matrizes {
    
    private int linhas;
    private int colunas;
    private int[][] matriz;
    private int[] diagonalPrincipal;
    private int[] diagonalSecundaria;
    private Boolean isMatrizQuadrada = false;

    /**
     * Constructor for objects of class Matrizes
     */
    public Matrizes( int linhas, int colunas ) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.matriz = new int[this.linhas][this.colunas];

        this.gerarMatriz();

        if ( this.linhas == this.colunas ) {
            this.isMatrizQuadrada = true;
            // instancia a diagonal principal/secundaria
            this.diagonalPrincipal  = new int[this.linhas];
            this.diagonalSecundaria = new int[this.linhas];
            // gera um array com os elementos da diagonal principal/secundaria
            this.gerarDiagonalPrincipal();
            this.gerarDiagonalSecundaria();
        }
    }

    // generating data
    private void gerarMatriz(){
        for ( int i = 0 ; i < this.linhas ; i++ ) {
            for ( int j = 0 ; j < this.colunas ; j++ ) {
                int randomNumber = (int)Math.round(Math.random()*100);
                this.matriz[i][j] = randomNumber;
            }
        }
    }

    private void gerarDiagonalPrincipal(){
        int indexArray = 0;

        for ( int i = 0 ; i < this.linhas ; i++ ) {
            for ( int j = 0 ; j < this.colunas ; j++ ) {
                if ( i == j ){
                    this.diagonalPrincipal[ indexArray ] = this.matriz[i][j];
                    indexArray++;
                }
            }
        }
    }

    private void gerarDiagonalSecundaria(){
        int indexArray = 0;
        int length     = this.linhas;

        for ( int coluna = length-1 ; coluna > -1 ; coluna-- ) {
            this.diagonalSecundaria[ indexArray ] = this.matriz[ indexArray ][ coluna ];
            System.out.println( "secundaria -> " + this.matriz[ indexArray ][ coluna ] + "\n");
            indexArray++;
        }
    }

    // output
    public void printMatriz(){
        for ( int i = 0 ; i < this.linhas ; i++ ) {
            for ( int j = 0 ; j < this.colunas ; j++ ) {
                System.out.print( matriz[i][j] + "\t" );
            }
            System.out.println();
        }
    }

    public void printDiagonalPrincipal(){
        int length      = this.diagonalPrincipal.length;
        String output   = ", ";

        for ( int i = 0 ; i < length ; i++ ) {

            int item = this.diagonalPrincipal[i];
            
            // esconde a virgula na ultima posicao e pula uma linha
            if ( (i+1) == length ) {
                output = " \n";
            }

            System.out.print( item + output );
        }
    }

    public void printDiagonalSecundaria(){
        int length = this.diagonalSecundaria.length;
        String output   = ", ";

        for ( int i = 0 ; i < length ; i++ ) {

            int item = this.diagonalSecundaria[i];

            // esconde a virgula na ultima posicao e pula uma linha
            if ( (i+1) == length ) {
                output = " \n";
            }
            
            System.out.print( item + output );
        }
    }
}
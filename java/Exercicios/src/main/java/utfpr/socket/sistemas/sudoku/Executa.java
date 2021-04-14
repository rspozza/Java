/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.socket.sistemas.sudoku;

/**
 *
 * @author User
 */
public class Executa {

    public static int matriz[][] = matrizCorreta();
    public static GerarMatriz gm = new GerarMatriz();
    //public static int matriz[][] = gm.constroiMatriz(9);

    public static void main(String[] args) throws InterruptedException {
        
        gm.exibeMatriz(matriz);
        System.out.println("====================");
        System.out.println("Resultado");
        executaThreads();
        //executaThreadsComTempo();

    }

    public static void executaThreads() {
        for (int i = 0; i < matriz.length; i++) {
            new Thread(new ThreadVerifica("Coluna", i + 1, gm.retornaColuna(matriz, i))).start();
            new Thread(new ThreadVerifica("Linha", i + 1, gm.retornaLinha(matriz, i))).start();
            new Thread(new ThreadVerifica("Quadrante", i + 1, gm.retornaQuadrante(matriz, i))).start();
        }
    }

    public static void executaThreadsComTempo() throws InterruptedException {
        long tInicial = System.currentTimeMillis();

        for (int i = 0; i < matriz.length; i++) {
            for (Thread t : new Thread[]{
                new Thread(new ThreadVerifica("Coluna", i + 1, gm.retornaColuna(matriz, i))),
                new Thread(new ThreadVerifica("Linha", i + 1, gm.retornaLinha(matriz, i))),
                new Thread(new ThreadVerifica("Quadrante", i + 1, gm.retornaQuadrante(matriz, i)))}) {
                t.start();
                t.join();
            }

        }
        long tFinal = System.currentTimeMillis();
        System.out.println("Tempo total: " + (tFinal - tInicial)+" milisegundos.");
    }

    
    public static void verificaSequencia(){
        
    }
    
    public static int[][] matrizCorreta() {
        int[][] teste = {{5, 3, 4, 6, 7, 8, 9, 1, 2}, {6, 7, 2, 1, 9, 5, 3, 4, 8}, {1, 9, 8, 3, 4, 2, 5, 6, 7}, 
            {8, 5, 9, 7, 6, 1, 4, 2, 3}, {4, 2, 6, 8, 5, 3, 7, 9, 1},{7, 1, 3, 9, 2, 4, 8, 5, 6}, {9, 6, 1, 5, 3, 7, 2, 8, 4}, 
            {2, 8, 7, 4, 1, 9, 6, 3, 5}, {3, 4, 5, 2, 8, 6, 1, 7, 9}};
        return teste;
    }
    
}

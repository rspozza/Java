package utfpr.socket.sistemas.sudoku;

import java.util.Random;

public class GerarMatriz {

    public int[][] constroiMatriz(int n) {
        int[][] matrix = new int[n][n];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Integer r = rand.nextInt(9)+1;
                matrix[i][j] = Math.abs(r);
            }
        }
        return matrix;
    }

    public int[] retornaLinha(int[][] matriz, int n){
        int linha[] = new int[matriz.length];
        for(int i=0;i<matriz.length;i++){
            linha[i]=matriz[n][i];
        }
        return linha;
    }
    
    public int[] retornaColuna(int[][] matriz, int n){
        int linha[] = new int[matriz.length];
        for(int i=0;i<matriz.length;i++){
            linha[i]=matriz[i][n];
        }
        return linha;
    }
    
    public int[] retornaQuadrante(int[][] matriz, int n){
        int quadrante[] = new int[matriz.length];
        int indice = 0;
        switch(n){
            case 0:
                for(int i=0;i<3;i++)
                    for(int j=0;j<3;j++){
                        quadrante[indice] = matriz[i][j];
                        indice++;
                    }
                break;
            case 1:
                for(int i=3;i<6;i++)
                    for(int j=0;j<3;j++){
                        quadrante[indice] = matriz[i][j];
                        indice++;
                    }
                break;
            case 2:
                for(int i=6;i<9;i++)
                    for(int j=0;j<3;j++){
                        quadrante[indice] = matriz[i][j];
                        indice++;
                    }
                break;
            case 3:
                for(int i=0;i<3;i++)
                    for(int j=3;j<6;j++){
                        quadrante[indice] = matriz[i][j];
                        indice++;
                    }
                break;
            case 4:
                for(int i=3;i<6;i++)
                    for(int j=3;j<6;j++){
                        quadrante[indice] = matriz[i][j];
                        indice++;
                    }
                break;
            case 5:
                for(int i=6;i<9;i++)
                    for(int j=3;j<6;j++){
                        quadrante[indice] = matriz[i][j];
                        indice++;
                    }
                break;
            case 6:
                for(int i=0;i<3;i++)
                    for(int j=6;j<9;j++){
                        quadrante[indice] = matriz[i][j];
                        indice++;
                    }
                break;
            case 7:
                for(int i=3;i<6;i++)
                    for(int j=6;j<9;j++){
                        quadrante[indice] = matriz[i][j];
                        indice++;
                    }
                break;
            default:
                for(int i=6;i<9;i++)
                    for(int j=6;j<9;j++){
                        quadrante[indice] = matriz[i][j];
                        indice++;
                    }                
        }                
        return quadrante;
    }    
    
    public void exibeMatriz(int[][] matrix) {
        System.out.println("Matriz gerada:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("]");
        }
        System.out.println();
    }
}

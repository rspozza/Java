package atividade5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Piada {

    private FileReader arquivo;
    private BufferedReader br;

    public Piada() {
        try {
            this.arquivo = new FileReader("src/atividade5/piadas.txt");
            this.br = new BufferedReader(this.arquivo);
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }

    public String lerPiada() {

        try {
            String linha = br.readLine();
            while (linha != null) {
                return linha;
            }

            this.arquivo.close();

        } catch (IOException e) {            
        }

        return null;
    }
}

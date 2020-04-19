package utfpr.arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeituraArquivoTexto {

    public static void main(String[] args) {
        File arquivo = new File("/tmp/testeAula.txt");
        try {
            if (!arquivo.exists()) {
//cria um arquivo (vazio)
                arquivo.createNewFile();
            }
//caso seja um diretório, é possível listar seus arquivos e diretórios
            File[] arquivos = arquivo.listFiles();
//escreve no arquivo
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Texto a ser escrito no txt");
            bw.newLine();
            bw.close();
            fw.close();
//faz a leitura do arquivo    
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
//enquanto houver mais linhas
            while (br.ready()) {
//lê a proxima linha
                String linha = br.readLine();
//faz algo com a linha
                System.out.println(linha);
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

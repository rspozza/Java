/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.thread.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */

public class ManipulaTexto {
    private File arquivo;
    private BufferedReader entrada;
    private BufferedWriter saida;

    public void ManipulaTexto() {
        arquivo = null;
        entrada = null;
        saida = null;
    }

    public void criarArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showSaveDialog(null);//posiciona a janela no centro da tela
        //usando o this a janela é centrada na janela da aplicação. O FileChooser é modal
        if (result == JFileChooser.CANCEL_OPTION) {
            return;//finaliza a execuçao do metodo
        }
        arquivo = fileChooser.getSelectedFile();
        System.out.println(fileChooser.getName());

        if (arquivo == null || arquivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (arquivo.exists()) {
                    saida = new BufferedWriter(new FileWriter(arquivo, true));//true(append).
                    System.out.println("existe");
                } else {
                    saida = new BufferedWriter(new FileWriter(arquivo, false));//false(rewrite).
                    System.out.println("NAO existe");
                }
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Erro ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void fecharArquivo() {
        try {
            if (saida != null) {
                saida.close();
            }
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null, "Error ao Fechar Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void GravaCliente(Cliente cliente) {
        if (saida == null){
            criarArquivo();
        }
        try {
            saida.write(cliente.getNome() + "\n");
            saida.write(cliente.getIdade() + "\n");
            saida.write(cliente.getFone() + "\n");
            saida.write("xxx\n");
            saida.flush();
        } catch (NumberFormatException formatException) {
            JOptionPane.showMessageDialog(null, "Erro", "Formato de Número Inválido.", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioException) {
            fecharArquivo();
        }
    }

    public void abrirArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        }
        arquivo = fileChooser.getSelectedFile();
        System.out.println(arquivo);

        if (arquivo == null || arquivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                entrada = new BufferedReader(new FileReader(arquivo));
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Error ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Cliente lerRegistro() {
        Cliente cliente = null;
        if (entrada == null){
            abrirArquivo();
        }
        try {
            cliente = new Cliente();
            cliente.setNome(entrada.readLine());
            cliente.setFone(entrada.readLine());
            cliente.setIdade(Integer.parseInt(entrada.readLine()));
            String fim = entrada.readLine();
            if (!fim.equals("xxx")) {
                JOptionPane.showMessageDialog(null, "Erro na leitura do Registro.", "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
            }
        } catch (EOFException endOfFileException) {
            JOptionPane.showMessageDialog(null, "Nao existem mais registros no arquivo.", "Fim do Arquivo", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null, "Erro durante a leitura do arquivo", "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Erro na conversao do tipo ou final do arquivo.", "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
        }finally{
            return cliente;     
        }
    }
}

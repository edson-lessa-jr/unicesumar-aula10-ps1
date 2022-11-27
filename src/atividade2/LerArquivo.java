package atividade2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LerArquivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome o arquivo a ser lido");
        String nomeArquivo = scanner.nextLine();
        try{
            FileReader arquivo = new FileReader(nomeArquivo);
            BufferedReader arquivoEmMemoria = new BufferedReader(arquivo);
            String linha = arquivoEmMemoria.readLine();
            while (linha !=null){
                System.out.println(linha);
                linha = arquivoEmMemoria.readLine();
            }
            arquivo.close();

        } catch (FileNotFoundException e) {
            System.out.println("O arquivo "+nomeArquivo+"não foi encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package atividade1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GerarTabuada {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o número da tabuada a ser gerada");
            int numeroTabuada = scanner.nextInt();

            String resultado = escritaTabuada(numeroTabuada);
            gerarArquivo(resultado);
            System.out.println(resultado);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void gerarArquivo(String resultado) throws IOException {
        String NOME_ARQUIVO = "tabuada.txt";
        FileWriter arquivo = new FileWriter(NOME_ARQUIVO);
        PrintWriter escreverArquivo = new PrintWriter(arquivo);
        escreverArquivo.println(resultado);
        arquivo.close();
    }

    private static String escritaTabuada(int numeroTabuada) {
        String resultado = "---- Tabuada ----\n";
        for (int i = 1; i < 11; i++) {
            resultado+=i+" X "+ numeroTabuada +" = " + (i* numeroTabuada)+"\n";
        }
        resultado+= "---------------";
        return resultado;
    }
}

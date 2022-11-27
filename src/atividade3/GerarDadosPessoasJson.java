package atividade3;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Pessoa{
    String nome;
    int idade;
}
public class GerarDadosPessoasJson {
    public static void main(String[] args) {
        try {
            Pessoa[] arrayPessoas = new Pessoa[10];
            for (int i = 0; i < arrayPessoas.length; i++) {
                Pessoa umaPessoa = new Pessoa();
                umaPessoa.nome = gerarNome();
                Random random = new Random();
                umaPessoa.idade = random.nextInt(100);
                arrayPessoas[i]=umaPessoa;
            }
            Gson gson = new Gson();
            String json = gson.toJson(arrayPessoas);
            String NOME_ARQUIVO = "pessoas.json";
            FileWriter fileWriter = new FileWriter(NOME_ARQUIVO);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(json);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Erro ao criar e escrever o arquivo");
        }


    }

    /* método para gerar nome e sobrenome aleatório */
    private static String gerarNome() {

        ThreadLocalRandom gerador = ThreadLocalRandom.current();

        int tamanhoNome = gerador.nextInt(3, 10);
        int tamanhoSobrenome = gerador.nextInt(3, 10);

        char primeiraLetraNome = (char) gerador.nextInt(65, 90);

        StringBuilder nome = new StringBuilder().append(primeiraLetraNome);
        StringBuilder sobreNome = new StringBuilder().append(primeiraLetraNome);

        for (int i = 1; i < tamanhoNome; i++) {
            char letra = (char) gerador.nextInt(97, 122);
            nome.append(letra);
        }

        for (int i = 1; i < tamanhoSobrenome; i++) {
            char letra = (char) gerador.nextInt(97, 122);
            sobreNome.append(letra);
        }

        return nome + " " + sobreNome;
    }
}

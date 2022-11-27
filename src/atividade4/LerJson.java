package atividade4;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

class Pessoa{
    String nome;
    int idade;
}
public class LerJson {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("pessoas.json"));
            Gson gson = new Gson();
            Pessoa[] pessoas = gson.fromJson(bufferedReader, Pessoa[].class);
            for (int i = 0; i < pessoas.length; i++) {
                System.out.println("Registro: "+i);
                System.out.println("Nome: "+pessoas[i].nome);
                System.out.println("Idade: "+pessoas[i].idade);
                System.out.println("------");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        }
    }
}

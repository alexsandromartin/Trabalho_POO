package main.model;

import main.entity.Localizacao;

import java.io.*;



public class InstituicaoModel {

    private String nome;
    private Localizacao localizacao;
    public InstituicaoModel(String nome, Localizacao localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public boolean CadastroInstituicao(){
        String local = localizacao.getLocalizacao();
        System.out.println(local);
        String arquivo = "gpip/database/instituicaoDatabase.txt";
        int contador = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo));
             BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String localizacaoArquivo = partes[2].trim();
                if (localizacaoArquivo.equals(local)){
                    return false;
                }
                contador++;
            }
            String novaInstituicao = contador + "," + nome + "," + local;
            writer.write(novaInstituicao);
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever no arquivo: " + e.getMessage());
        }
        return false;
    }
}
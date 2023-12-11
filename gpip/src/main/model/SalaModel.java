package main.model;

import java.io.*;

public class SalaModel {

    public boolean criarSala(int numSala, int numUnidade, String instituicao){
        try (BufferedReader reader = new BufferedReader(new FileReader("gpip/database/salaDatabase.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("gpip/database/salaDatabase.txt", true))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String [] partes = linha.split(",");
                String numeroSala = partes[0];
                String numeroUnidade = partes[1];
                String numeroInstituicao = partes[2];
                if(numeroSala.equals(String.valueOf(numSala)) && numeroUnidade.equals(String.valueOf(numUnidade)) && numeroInstituicao.equals(instituicao)){
                    return false;
                }
            }if((linha = reader.readLine()) == null ){
                String novaSala = numSala + "," + numUnidade + "," + instituicao;
                writer.write(novaSala);
                writer.newLine();
                return true;
            }
        }catch (IOException e){
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return false;
    }
}

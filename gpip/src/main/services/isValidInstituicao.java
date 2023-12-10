package main.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class isValidInstituicao {
    public static boolean validInstituicao(int id){
        try (BufferedReader reader = new BufferedReader(new FileReader("gpip/database/instituicaoDatabase.txt"))){
            String linha;
            while ((linha = reader.readLine()) != null) {
                String [] partes = linha.split(",");
                if(partes[0].equals(Integer.toString(id))){
                    return true;
                }
            }

            return false;
        }catch (IOException e){
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return false;
    }
}

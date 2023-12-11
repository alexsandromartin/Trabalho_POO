package main.services;

import main.entity.Sala;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuscarSala {
    public Sala buscarSala(String numSala, String numUnidade, String id){
        try (BufferedReader reader = new BufferedReader(new FileReader("gpip/database/salaDatabase.txt"));){
            String linha;
            while ((linha = reader.readLine()) != null) {
                String [] partes = linha.split(",");
                if(numSala.equals(partes[0]) && numUnidade.equals(partes[1]) && id.equals(partes[2])){
                    Sala sala = new Sala(numSala, numUnidade, id);
                    return sala;
                }
            }
        }catch (IOException e){
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return null;
    }
}

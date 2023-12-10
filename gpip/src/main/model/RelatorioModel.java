package main.model;

import main.entity.Patrimonio;
import main.entity.Relatorio;
import main.services.BuscarInstituicao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class RelatorioModel {

    public List<Patrimonio> gerarRelatorio(String email){
        try (BufferedReader reader = new BufferedReader(new FileReader("gpip/database/patrimonioDatabase.txt"))) {
            String linha;
            Relatorio relatorio = new Relatorio();
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length >= 2) {
                    BuscarInstituicao buscarInstituicao = new BuscarInstituicao();
                    String id = buscarInstituicao.buscarInstituicaoByEmail(email);
                    if(id.equals(partes[4])){
                        Patrimonio patrimonio = new Patrimonio(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5], partes[6]);
                        relatorio.addPatrimonio(patrimonio);
                    }
                }
            }
            return relatorio.listarRelatorios();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return null;
    }
}

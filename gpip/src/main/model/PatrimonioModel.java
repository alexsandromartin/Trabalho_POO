package main.model;

import main.entity.Patrimonio;
import main.services.BuscarPatrimonio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PatrimonioModel {

    public void adicionarPatrimonio(Patrimonio patrimonio) {
        BuscarPatrimonio buscarPatrimonio = new BuscarPatrimonio();
        if (!buscarPatrimonio.buscarPatrimonio(patrimonio)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("gpip/database/patrimonioDatabase.txt", true))) {
                writer.write(patrimonio.getPatrimonioCompleto(patrimonio));
                writer.newLine();
                System.out.println("Patrimônio adicionado");
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }
    }

    public void removerPatrimonio(Patrimonio patrimonio) {
        BuscarPatrimonio buscarPatrimonio = new BuscarPatrimonio();
        if (buscarPatrimonio.buscarPatrimonio(patrimonio)) {
            List<String> linhas = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("gpip/database/patrimonioDatabase.txt"))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (!linha.equals(patrimonio.getPatrimonioCompleto(patrimonio))) {
                        linhas.add(linha);
                    }
                }
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("gpip/database/patrimonioDatabase.txt"))) {
                for (String linha : linhas) {
                    writer.write(linha);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            }
        }
    }
    public boolean moverPatrimonio(Patrimonio patrimonio, String sala, String unidade) {
        if (!verificarSalaUnidadeExistente(sala, unidade, patrimonio.getIdInstituicao())) {
            System.out.println("Sala ou unidade não encontrada. Não é possível mover o patrimônio.");
            return false;
        }

        List<String> linhas = new ArrayList<>();
        boolean patrimonioEncontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("gpip/database/patrimonioDatabase.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.equals(patrimonio.getPatrimonioCompleto(patrimonio))) {
                    String[] partes = linha.split(",");
                    partes[5] = sala;
                    partes[6] = unidade;
                    linha = String.join(",", partes);
                    patrimonioEncontrado = true;
                }
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        if (patrimonioEncontrado) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("gpip/database/patrimonioDatabase.txt"))) {
                for (String linha : linhas) {
                    writer.write(linha);
                    writer.newLine();
                }
                System.out.println("Patrimônio movido para a sala " + sala + ", unidade " + unidade);
                return true;
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Patrimônio não encontrado");
        }
        return false;
    }

    private boolean verificarSalaUnidadeExistente(String sala, String unidade, String instituicao) {
        try (BufferedReader reader = new BufferedReader(new FileReader("gpip/database/salaDatabase.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes[0].equals(sala) && partes[1].equals(unidade) && partes[2].equals(instituicao)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de sala: " + e.getMessage());
        }
        return false;
    }
}

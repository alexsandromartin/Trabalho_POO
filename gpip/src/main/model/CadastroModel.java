package main.model;

import main.entity.Usuario;
import java.io.*;

public class CadastroModel {
    public CadastroModel() {
    }
    public static boolean CadastrarUsuario(Usuario usuario) {
        String arquivo = "gpip/database/userDatabase.txt";
        int contador = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo));
             BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length >= 2) {
                    String emailNoArquivo = partes[1].trim();
                    if (emailNoArquivo.equals(usuario.getEmail())) {
                        return false;
                    }
                    contador++;
                }
            }

            String novoUsuario = contador + "," + usuario.getUser(usuario);
            writer.write(novoUsuario);
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever no arquivo: " + e.getMessage());
            return false;
        }
    }
}

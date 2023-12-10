package main.model;

import main.entity.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginModel {
    public static Usuario verificarCredenciais(String caminhoArquivo, String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length >= 2) {
                    String emailNoArquivo = partes[1].trim();
                    String senhaNoArquivo = partes[2].trim();

                    if (emailNoArquivo.equals(email)) {
                        if (senhaNoArquivo.equals(password)) {
                            if(partes.length == 6){
                                Usuario usuario = new Usuario(partes[1], partes[3], partes[2], "Admin");
                                return usuario;
                            }
                            Usuario usuario = new Usuario(partes[1], partes[3], partes[2]);
                            return usuario;
                        } else {
                            return null;
                        }
                    }
                }
            }
            return null;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }

}

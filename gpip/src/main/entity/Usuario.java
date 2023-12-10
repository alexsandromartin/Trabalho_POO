package main.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Usuario {

    private String email;
    private String nome;
    private String senha;
    private String role;
    private int idInstituicao;

    public Usuario(String email, String nome, String senha, String role) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.role = role;
    }
    public Usuario(String email, String nome, String senha, int idInstituicao) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.idInstituicao = idInstituicao;
    }
    public Usuario(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public int getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getRole(){return role;}
    public void setRole(String role){this.role = role;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUser(Usuario usuario){
        return usuario.getEmail() + "," + usuario.getSenha() + "," + usuario.getNome() + "," + usuario.getIdInstituicao();
    }
}

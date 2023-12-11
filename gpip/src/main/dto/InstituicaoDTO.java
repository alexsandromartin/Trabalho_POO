package main.dto;

import main.entity.Localizacao;
import main.entity.Usuario;

public class InstituicaoDTO {

    private int id;
    private String nomeInstituicao;
    private Localizacao localizacao;
    private Usuario usuario;

    public InstituicaoDTO(int id, String nomeInstituicao, Localizacao localizacao, Usuario usuario) {
        this.id = id;
        this.nomeInstituicao = nomeInstituicao;
        this.localizacao = localizacao;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

package main.controller;

import main.entity.Instituicao;
import main.entity.Localizacao;
import main.entity.Usuario;
import main.model.InstituicaoModel;

public class InstituicaoController {

    private Instituicao instituicao;

    public InstituicaoController() {
       }

       public void CadastrarInstituicao(String nome, Localizacao localizacao) {
        InstituicaoModel instituicaoModel = new InstituicaoModel(nome, localizacao);
        if (instituicaoModel.CadastroInstituicao()) {
            System.out.println("Instituição Cadastrada com sucesso!");
        }else {
            System.out.println("Instituição com a mesma localização já existe.");
        }
    }
}
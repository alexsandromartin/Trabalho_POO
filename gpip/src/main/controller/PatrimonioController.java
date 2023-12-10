package main.controller;

import main.entity.Patrimonio;
import main.model.PatrimonioModel;
import main.services.BuscarInstituicao;
import main.services.BuscarPatrimonio;
import main.services.BuscarSala;

import main.view.LogadoView;

import main.view.MenuView;

public class PatrimonioController {

    public PatrimonioController(){}
    Patrimonio patrimonio;

    public void addPatrimonio(String tombo, String descricao, String estado, String dataAquisicao, String idInstituicao, String numSala, String unidadeSala){
        BuscarInstituicao buscarInstituicao = new BuscarInstituicao();
        BuscarSala buscarSala = new BuscarSala();
        String id = buscarInstituicao.buscarInstituicaoByEmail(idInstituicao);
        if(!buscarInstituicao.buscarInstituicaoByEmail(idInstituicao).equals("Nada") && buscarSala.buscarSala(numSala, unidadeSala, id) != null){
            Patrimonio patrimonio = new Patrimonio(tombo, descricao, estado, dataAquisicao, id, numSala, unidadeSala);
            PatrimonioModel patrimonioModel = new PatrimonioModel();

            patrimonioModel.adicionarPatrimonio(patrimonio);

            System.out.println();
            System.out.println("Registro de Patrimônio feito com Sucesso!");
            MenuView.menu();
        }else{
            System.out.println("Instituição ou sala não encontrada");
            MenuView.menu();
        }
        LogadoView.MenuLogado(idInstituicao);
    }

    public void removePatrimonio(String numeroTombo, String email){
        BuscarInstituicao buscarInstituicao = new BuscarInstituicao();
        BuscarPatrimonio buscarPatrimonio = new BuscarPatrimonio();
        patrimonio = buscarPatrimonio.buscarPatrimonioByTombo(numeroTombo, buscarInstituicao.buscarInstituicaoByEmail(email));
        if(patrimonio != null){
            PatrimonioModel patrimonioModel = new PatrimonioModel();
            patrimonioModel.removerPatrimonio(patrimonio);
            System.out.println("Patrimoônio removido");
        }else{
            System.out.println("Patrimonio não encontrado");
        }
        LogadoView.MenuLogado(email);
    }

    public void moverPatrimonio(String numTombo, String email, String sala, String unidade){
        BuscarInstituicao buscarInstituicao = new BuscarInstituicao();
        BuscarPatrimonio buscarPatrimonio = new BuscarPatrimonio();
        patrimonio = buscarPatrimonio.buscarPatrimonioByTombo(numTombo, buscarInstituicao.buscarInstituicaoByEmail(email));
        if(patrimonio != null){
            PatrimonioModel patrimonioModel = new PatrimonioModel();
            patrimonioModel.moverPatrimonio(patrimonio, sala, unidade);
        }else{
            System.out.println("Falha ao encontrar o patrimônio");
        }

        LogadoView.MenuLogado(email);
    }
}

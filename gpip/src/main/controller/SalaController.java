package main.controller;

import main.model.SalaModel;
import main.services.BuscarInstituicao;
import main.view.LogadoView;

public class SalaController {

    public SalaController(){}

    public static void CriarSala(int numSala, int numUnidade, String email){
        if(numSala != 0 && numUnidade != 0){
            SalaModel salaModel = new SalaModel();
            BuscarInstituicao buscarInstituicao = new BuscarInstituicao();
            if(!buscarInstituicao.buscarInstituicaoByEmail(email).equals("Nada")){
                if(salaModel.criarSala(numSala, numUnidade, buscarInstituicao.buscarInstituicaoByEmail(email))){
                    System.out.println("Sala criada com sucesso");
                }else{
                    System.out.println("Erro ao criar sala, já existente");
                }
            }
            LogadoView.MenuLogado(email);
        }
    }
}

package main.controller;

import main.entity.Patrimonio;
import main.entity.Relatorio;
import main.model.RelatorioModel;
import main.view.LogadoView;

import java.util.List;

public class RelatorioController {
    private RelatorioController relatorioController;
    private Relatorio relatorio;
    public RelatorioController(){}

    public void gerarRelatorio(String email){
        RelatorioModel relatorioModel = new RelatorioModel();
        List<Patrimonio> listaPatrimonios = relatorioModel.gerarRelatorio(email);
        if(!listaPatrimonios.isEmpty()){
            for(Patrimonio patrimonio : listaPatrimonios){
                // Obtém as informações do patrimônio
                String numeroTombo = patrimonio.getNumeroTombo();
                String descricao = patrimonio.getDescricao();
                String estado = patrimonio.getEstado();
                String dataAquisicao = patrimonio.getDataAquisicao();
                String instituicao = patrimonio.getIdInstituicao();
                String sala = patrimonio.getSala().getNumeroDaSala();
                String bloco = patrimonio.getSala().getUnidade();

                // Imprime as informações no formato desejado
                System.out.println("Numero Tombo: " + numeroTombo +
                        ", Descrição: " + descricao +
                        ", Estado: " + estado +
                        ", Data de aquisição: " + dataAquisicao +
                        ", Instituição: " + instituicao +
                        ", Sala: " + sala +
                        ", Bloco: " + bloco);
            }
        }else{
            System.out.println("Não existem patrimônios");
        }
        LogadoView.MenuLogado(email);
    }
}

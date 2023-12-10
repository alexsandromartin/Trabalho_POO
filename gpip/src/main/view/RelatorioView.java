package main.view;

import main.controller.RelatorioController;
import main.entity.Relatorio;

public class RelatorioView {


    private RelatorioController relatorioController;
    private Relatorio relatorio;
    public RelatorioView(RelatorioController relatorioController){this.relatorioController = relatorioController;}

    public void gerarRelatorio(String email){
        relatorioController.gerarRelatorio(email);
    }
}

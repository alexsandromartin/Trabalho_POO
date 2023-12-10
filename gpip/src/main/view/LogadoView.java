package main.view;

import main.controller.PatrimonioController;
import main.controller.RelatorioController;
import main.controller.SalaController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LogadoView {
    public static void MenuLogado(String email){
        Scanner scanner = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("|     SISTEMA DE PATRIMÔNIO      |");
        System.out.println("==================================");
        System.out.println("Bem vinde");
        System.out.println("Escolha uma opção: ");
        System.out.println("0- Sair");
        System.out.println("1- Ver relatório");
        System.out.println("2- Registrar Sala");
        System.out.println("3- Registrar patrimônio");
        System.out.println("4- Remover patrimônio");
        System.out.println("5- Movimentar patrimônio");
        System.out.println("==================================");

        try{
            int opcao  = scanner.nextInt();
            switch (opcao){
                case 1:
                    RelatorioController relatorioController = new RelatorioController();
                    RelatorioView relatorioView = new RelatorioView(relatorioController);
                    relatorioView.gerarRelatorio(email);
                    break;
                case 2:
                    SalaController salaController = new SalaController();
                    SalaView salaView = new SalaView(salaController);
                    salaView.CriarSala(email);
                    break;
                case 3:
                    PatrimonioController patrimonioController = new PatrimonioController();
                    AddPatrimonioView addPatrimonioView = new AddPatrimonioView(patrimonioController);
                    addPatrimonioView.AddPatrimonio(email);
                    break;
                case 4:
                    PatrimonioController patrimonioController1 = new PatrimonioController();
                    RemovePatrimonioView removePatrimonioView = new RemovePatrimonioView(patrimonioController1);
                    removePatrimonioView.removerPatrimonio(email);
                    break;
                case 5:
                    PatrimonioController patrimonioController2 = new PatrimonioController();
                    MoverPatrimonioView moverPatrimonioView = new MoverPatrimonioView(patrimonioController2);
                    moverPatrimonioView.MoverPatrimonio(email);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    MenuLogado(email);
                    break;
            }
        }catch (InputMismatchException e){
            System.out.println("Opção inválida");
            MenuLogado(email);
        }
        scanner.close();
    }
}

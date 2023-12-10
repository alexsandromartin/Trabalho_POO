package main.view;

import main.controller.InstituicaoController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminLogado {

    public static void adminLogado(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vinde");
        System.out.println("Deseja cadastrar uma instituição ou sair?");
        System.out.println("1 - Cadastrar Instituição\n2 - Sair");
        try {
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    InstituicaoController instituicaoController = new InstituicaoController();
                    InstituicaoView instituicaoView = new InstituicaoView(instituicaoController);
                    instituicaoView.cadastroInstituicao();
                    break;
                case 2:
                    MenuView.menu();
                    break;
                default:
                    System.out.println("Opção inválida");
                    adminLogado();
            }
        }catch (InputMismatchException e){
            System.out.println("Opção inválida");
            adminLogado();
        }
        scanner.close();
    }
}

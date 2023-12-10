package main.view;

import main.controller.CadastroController;

import java.util.Scanner;

public class CadastroView {
    private final CadastroController cadastroController;

    public CadastroView(CadastroController cadastroController){
        this.cadastroController = cadastroController;
    }

    public void CadastrarUsuario(){
        Scanner scanner = new Scanner(System.in);
        String email, name, password;
        System.out.println("==================================");
        System.out.println("|            CADASTRO            |");
        System.out.println("==================================");
        System.out.print("Digite seu email: ");
        email = scanner.nextLine();
        System.out.print("Digite seu nome e sobrenome: ");
        name = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        password = scanner.nextLine();
        System.out.print("Digite o ID da instituição que faz parte: ");
        int idInstituicao = scanner.nextInt();
        System.out.println("====================================");
        cadastroController.CadastrarUsuario(email, name, password, idInstituicao);
        scanner.close();
    }
}

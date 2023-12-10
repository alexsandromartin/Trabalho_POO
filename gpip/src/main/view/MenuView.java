package main.view;

import main.controller.CadastroController;
import main.controller.LoginController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("|             MENU               |");
        System.out.println("==================================");
        System.out.println("Bem-vindo(a), escolha uma opção:");
        System.out.println("1- Cadastro");
        System.out.println("2- Login");
        System.out.println("==================================");
        try{
            int opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    CadastroController cadastroController = new CadastroController();
                    CadastroView cadastroView = new CadastroView(cadastroController);
                    cadastroView.CadastrarUsuario();
                    break;
                case 2:
                    LoginController loginController = new LoginController();
                    LoginView loginView = new LoginView(loginController);
                    loginView.Login();
                    break;
                default:
                    throw new InputMismatchException();
            }
        }catch (InputMismatchException e){
            System.out.println("Opção inválida");
            menu();
        }
    }
}

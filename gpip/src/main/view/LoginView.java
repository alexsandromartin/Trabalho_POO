package main.view;

import main.controller.LoginController;
import java.util.Scanner;

public class LoginView {
    private final LoginController loginController;

    public LoginView(LoginController loginController){
        this.loginController = loginController;
    }

    public void Login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("|            LOGIN               |");
        System.out.println("==================================");
        System.out.println("Bem-vindo! Por favor, faça login:");

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        loginController.Login(email, senha);

        scanner.close();
    }
}

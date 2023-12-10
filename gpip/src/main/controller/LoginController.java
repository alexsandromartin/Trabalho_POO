package main.controller;

import main.entity.Usuario;
import main.view.AdminLogado;
import main.view.LogadoView;
import main.view.MenuView;

import static main.model.LoginModel.verificarCredenciais;

public class  LoginController {

    public LoginController(){}

    public void Login(String email, String password){
        String arquivo = "gpip/database/userDatabase.txt";
        Usuario user = verificarCredenciais(arquivo, email, password);
        if( user != null){
            if(user.getRole() == null){
                LogadoView.MenuLogado(user.getEmail());
            }else{
                AdminLogado.adminLogado();
            }
        }else{
            System.out.println("Credenciais incorretas, verifique e tente novamente.");
            MenuView.menu();
        }
    }
}

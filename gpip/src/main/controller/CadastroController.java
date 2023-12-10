package main.controller;

import main.entity.Usuario;
import main.model.CadastroModel;
import main.services.isValidEmail;
import main.services.isValidInstituicao;
import main.services.isValidName;
import main.services.isValidPassword;
import main.view.MenuView;

public class CadastroController {
    
    public CadastroController(){
    }
    public void CadastrarUsuario(String email, String name, String password, int id){
        if(isValidEmail.validEmail(email) && isValidName.validName(name) && isValidPassword.validPassword(password) &&
        isValidInstituicao.validInstituicao(id)){
            Usuario usuario = new Usuario(email, name, password, id);
            if(CadastroModel.CadastrarUsuario(usuario)){
                System.out.println("Cadastro realizado com sucesso!");
            }else{
                System.out.println("E-mail já cadastrado.");
            }
        }if(!isValidEmail.validEmail(email)){
            System.out.println("Email em formato inválido (Tente digitar um no formato teste@teste.com)");
        }if(!isValidName.validName(name)){
            System.out.println("Nome em formato inválido (Verifique se não contém números)");
        }
        if(!isValidPassword.validPassword(password)){
            System.out.println("Senha inválida (Sua senha deve conter no mínimo 1 número, 1 letra maiúscula, 1 minúscula e entre 8 a 20 caracteres)");
        }if(!isValidInstituicao.validInstituicao(id)){
            System.out.println("Instituição não encontrada");
        }
        MenuView.menu();
    }
    
}
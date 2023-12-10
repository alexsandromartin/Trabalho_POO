package main.view;

import main.controller.PatrimonioController;


import java.util.Scanner;

public class AddPatrimonioView {

    private final PatrimonioController patrimonioController;

    public AddPatrimonioView(PatrimonioController patrimonioController){
        this.patrimonioController = patrimonioController;
    }

    public void AddPatrimonio(String email){
        Scanner sc = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("|     REGISTRO DE PATRIMONIO     |");
        System.out.println("==================================");
        System.out.print("Digite o número do tombo: ");
        String tombo = sc.next();
        System.out.print("Digite a descrição: ");
        String descricao = sc.next();
        System.out.print("Digite o estado do objeto: ");
        String estado = sc.next();
        System.out.print("Digite a data da aquisição: ");
        String dataAquisicao = sc.next();
        System.out.print("Digite o número da sala: ");
        String numSala = sc.next();
        System.out.print("Digite a unidade da sala: ");
        String unidadeSala = sc.next();
        patrimonioController.addPatrimonio(tombo, descricao, estado, dataAquisicao, email, numSala, unidadeSala);
        sc.close();
    }

}

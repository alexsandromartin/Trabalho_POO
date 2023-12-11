package main.view;

import main.controller.PatrimonioController;
import main.entity.Patrimonio;

import java.util.Scanner;

public class MoverPatrimonioView {
    private PatrimonioController patrimonioController;
    private Patrimonio patrimonio;

    public MoverPatrimonioView(PatrimonioController patrimonioController){
        this.patrimonioController = patrimonioController;
    }

    public void MoverPatrimonio(String email){
        System.out.println("==================================");
        System.out.println("|       MOVER PATRIMONIO         |");
        System.out.println("==================================");
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número do tombo do objeto a ser movido: ");
        String tombo = sc.next();
        System.out.println("Digite o número da sala para que será enviado: ");
        String numSala = sc.next();
        System.out.println("Digite a unidade da sala para que será enviado: ");
        String unidadeSala = sc.next();
        patrimonioController.moverPatrimonio(tombo, email, numSala, unidadeSala);
        sc.close();

    }
}

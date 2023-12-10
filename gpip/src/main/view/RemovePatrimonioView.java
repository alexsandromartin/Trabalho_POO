package main.view;

import main.controller.PatrimonioController;

import java.util.Scanner;

public class RemovePatrimonioView {
    private PatrimonioController patrimonioController;
    public RemovePatrimonioView(PatrimonioController patrimonioController){this.patrimonioController = patrimonioController;}

    public void removerPatrimonio(String email){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o número do tombo: ");
        String numeroTombo = sc.next();

        patrimonioController.removePatrimonio(numeroTombo, email);
        sc.close();
    }
}

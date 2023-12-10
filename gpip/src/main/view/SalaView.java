package main.view;

import main.controller.SalaController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SalaView{
    private SalaController salaController;

    public SalaView(SalaController salaController){
        this.salaController = salaController;
    }

    public void CriarSala(String email){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite o número da sala: ");
            int numeroSala = scanner.nextInt();
            System.out.print("Digite o número da unidade: ");
            int unidadeSala = scanner.nextInt();
            SalaController.CriarSala(numeroSala, unidadeSala, email);
        }catch (InputMismatchException e){
            System.out.println("Número da sala ou unidade inválida (Verifique se inseriu números)");
            CriarSala(email);
        }
        scanner.close();
    }
}

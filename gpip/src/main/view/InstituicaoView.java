package main.view;

import main.controller.InstituicaoController;
import main.entity.Localizacao;

import java.util.Scanner;

public class InstituicaoView {

    private InstituicaoController controller;

    public InstituicaoView(InstituicaoController controller) {
        this.controller = controller;
    }

    public void cadastroInstituicao(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("|    CADASTRO DE INSTITUIÇÃO     |");
        System.out.println("==================================");
        System.out.println("Bem vinde");
        System.out.print("Digite o nome da instituição: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a rua: ");
        String rua =scanner.nextLine();
        System.out.print("Digite o numero: ");
        String numero =scanner.nextLine();
        System.out.print("Digite o bairro: ");
        String bairro =scanner.nextLine();
        System.out.print("Digite a cidade: ");
        String cidade =scanner.nextLine();
        System.out.print("Digite o estado: ");
        String estado =scanner.nextLine();
        System.out.print("Digite o cep: ");
        String cep =scanner.nextLine();

        Localizacao localizacao = new Localizacao(rua, numero, bairro, cidade, estado, cep); // Falta fazer validações
        InstituicaoController instituicaoController = new InstituicaoController();
        instituicaoController.CadastrarInstituicao(nome, localizacao);
        scanner.close();
    }
}

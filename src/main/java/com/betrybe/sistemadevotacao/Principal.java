package com.betrybe.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /** Construtor da classe Principal.
   * @param args null
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamento = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);
    // TODO Auto-generated method stub

    boolean cadastrarCandidatas = true;
    boolean cadastrarEleitoras = true;

    while (cadastrarCandidatas) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      int opcaoCandidata = Integer.parseInt(scanner.nextLine());

      if (opcaoCandidata == 1) {
        System.out.print("Entre com o nome da pessoa candidata: ");
        String name = scanner.nextLine();

        System.out.print("Entre com o número da pessoa candidata: ");
        int number = Integer.parseInt(scanner.nextLine());
        gerenciamento.cadastrarPessoaCandidata(name, number);
      } else {
        cadastrarCandidatas = false;
      }
    }

    while (cadastrarEleitoras) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      int opcaoEleitora = Integer.parseInt(scanner.nextLine());

      if (opcaoEleitora == 1) {
        System.out.print("Entre com o nome da pessoa eleitora: ");
        String name = scanner.nextLine();

        System.out.print("Entre com o CPF da pessoa eleitora: ");
        String cpf = scanner.nextLine();
        gerenciamento.cadastrarPessoaEleitora(name, cpf);
      } else {
        cadastrarEleitoras = false;
      }
    }

    boolean votacaoAtiva = true;
    while (votacaoAtiva) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      int opcaoVotacao = Integer.parseInt(scanner.nextLine());

      switch (opcaoVotacao) {
        case 1:
          System.out.print("Entre com o CPF da pessoa eleitora: ");
          String cpf = scanner.nextLine();

          System.out.print("Entre com o número da pessoa candidata: ");
          int number = Integer.parseInt(scanner.nextLine());

          gerenciamento.votar(cpf, number);
          break;
        case 2:
          gerenciamento.mostrarResultado();
          break;
        case 3:
          gerenciamento.mostrarResultado();
          votacaoAtiva = false;
          break;
        default:
          System.out.println("Opção inválida! Tente novamente.");
          break;
      }
    }

    scanner.close();
  }
}
package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  public static ArrayList<PessoaCandidata> pessoasCandidatas;
  public static ArrayList<PessoaEleitora> pessoasEleitoras;
  public static ArrayList<String> cpfsComputados;

  /**
   * Construtor da Classe Gerenciamento de Votação.
   */
  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
  }

  public ArrayList<PessoaCandidata> getPessoasCandidatas() {
    return pessoasCandidatas;
  }

  public ArrayList<PessoaEleitora> getPessoasEleitoras() {
    return pessoasEleitoras;
  }

  public ArrayList<String> getCpfsComputados() {
    return cpfsComputados;
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (pessoasCandidatas.isEmpty()) {
      PessoaCandidata novaPessoa = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(novaPessoa);
    } else {
      for (PessoaCandidata pessoa : pessoasCandidatas) {
        if (pessoa.getNumero() == numero) {
          System.out.println("Número da pessoa candidata já utilizado!");
          return;
        }
      }
      PessoaCandidata novaPessoa = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(novaPessoa);
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (pessoasEleitoras.isEmpty()) {
      PessoaEleitora novaPessoa = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(novaPessoa);
    } else {
      for (PessoaEleitora pessoa : pessoasEleitoras) {
        if (pessoa.getCpf().equals(cpf)) {
          System.out.println("Pessoa eleitora já cadastrada!");
          return;
        }
      }
      PessoaEleitora novaPessoa = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(novaPessoa);
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (!cpfsComputados.isEmpty()) {
      for (String cpf : cpfsComputados) {
        if (cpf.equals(cpfPessoaEleitora)) {
          System.out.println("Pessoa eleitora já votou!");
          return;
        }
      }
    }
    cpfsComputados.add(cpfPessoaEleitora);
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.getNumero() == numeroPessoaCandidata) {
        pessoa.receberVoto();
      }
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um "
          + " voto para mostrar o resultado");
      return;
    }
    int total = cpfsComputados.size();
    for (PessoaCandidata candidata : pessoasCandidatas) {
      System.out.printf("Nome: %s - %d votos ( %d%% )%n",
          candidata.getNome(),
          candidata.getVotos(),
          Math.round((float) candidata.getVotos() / total * 100)
      );
    }
    System.out.printf("Total de votos: %d%n", total);
  }
}


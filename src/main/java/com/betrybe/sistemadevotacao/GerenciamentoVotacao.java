package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  public ArrayList<PessoaCandidata> pessoasCandidatas;
  public ArrayList<PessoaEleitora> pessoasEleitoras;
  public ArrayList<String> cpfsComputados;

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

  public void setPessoasCandidatas(ArrayList<PessoaCandidata> pessoasCandidatas) {
    this.pessoasCandidatas = pessoasCandidatas;
  }

  public ArrayList<PessoaEleitora> getPessoasEleitoras() {
    return pessoasEleitoras;
  }

  public void setPessoasEleitoras(ArrayList<PessoaEleitora> pessoasEleitoras) {
    this.pessoasEleitoras = pessoasEleitoras;
  }

  public ArrayList<String> getCpfsComputados() {
    return cpfsComputados;
  }

  public void setCpfsComputados(ArrayList<String> cpfsComputados) {
    this.cpfsComputados = cpfsComputados;
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (this.pessoasCandidatas.isEmpty()) {
      PessoaCandidata novaPessoa = new PessoaCandidata(nome, numero);
      this.pessoasCandidatas.add(novaPessoa);
    } else {
      for (PessoaCandidata pessoa : this.pessoasCandidatas) {
        if (pessoa.getNumero() == numero) {
          System.out.println("Número da pessoa candidata já utilizado!");
          return;
        }
      }
      PessoaCandidata novaPessoa = new PessoaCandidata(nome, numero);
      this.pessoasCandidatas.add(novaPessoa);
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (this.pessoasEleitoras.isEmpty()) {
      PessoaEleitora novaPessoa = new PessoaEleitora(nome, cpf);
      this.pessoasEleitoras.add(novaPessoa);
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

  }

  @Override
  public void mostrarResultado() {

  }
}


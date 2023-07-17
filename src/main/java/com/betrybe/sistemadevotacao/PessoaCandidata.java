package com.betrybe.sistemadevotacao;

public class PessoaCandidata extends Pessoa {
  public int numero;
  public int votos;

  /** Construtor da classe PessoaCandidata.
   * @param nome recebe o nome do candidato
   * @param numero recebe o numero do candidato
   */
  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
    this.votos = 0;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    this.votos += 1;
  }
}

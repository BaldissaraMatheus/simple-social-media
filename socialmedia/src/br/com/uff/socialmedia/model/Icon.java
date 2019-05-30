package br.com.uff.socialmedia.model;

public enum Icon {
  AANG("aang", "aang.jpg");
  
  private String nome;
  private String endereco;
  
  private Icon(String nome, String endereco) {
    this.nome = nome;
    this.endereco = endereco;
  }
}

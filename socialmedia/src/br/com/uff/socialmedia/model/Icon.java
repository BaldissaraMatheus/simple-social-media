package br.com.uff.socialmedia.model;

public enum Icon {

	AANG("aang", "assets/img/aang.png"), KATARA("katara", "assets/img/katara.png"), TOPH("toph", "assets/img/toph.png"),
	ZUKO("zuko", "assets/img/zuko.png");

	private String nome;
	private String endereco;

	private Icon(String nome, String endereco) {
		this.setNome(nome);
		this.setEndereco(endereco);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static Icon findIconByNome(String nome) {
		for (Icon icon : Icon.values()) {
			if (icon.getNome().equals(nome))
				return icon;
		}

		return null;
	}
}
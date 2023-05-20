package principal;

import entity.ClienteEntity;

public class Cliente {

	private long codigo;
	
	private String nome;
	
	private String endereco;
	
	private int telefone;
	
	private String email;

	public Cliente(ClienteEntity cliente) {
		this.nome = cliente.getNome();
		this.endereco = cliente.getEndereco();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
	}
	
	public Cliente() {}

	public Cliente(String nome, String endereco, int telefone, String email) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

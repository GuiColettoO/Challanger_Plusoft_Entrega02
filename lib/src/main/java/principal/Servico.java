package principal;

import entity.ServicoEntity;

public class Servico {

	private Integer codigo;
	
	private String nome;
	
	private String descricao;
	
	private float preco;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Servico(ServicoEntity servico) {
		this.nome = servico.getNome();
		this.descricao = servico.getDescricao();
		this.preco = servico.getPreco();
	}
	

	public Servico() {}

	public Servico(String nome, String descricao, float preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}

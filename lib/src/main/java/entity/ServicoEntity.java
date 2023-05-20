package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import principal.Profissional;
import principal.Servico;

@Entity
@Table(name="TB_SERVICO")
@SequenceGenerator(name="servico", sequenceName = "SQ_TB_SERVICO", allocationSize = 1)
public class ServicoEntity {
	
	@Id
	@Column(name="id_servico")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico")
	private Integer codigo;
	
	@Column(name="nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name="descricao", nullable = false, length = 255)
	private String descricao;
	
	@Column(name="preco", precision = 8)
	private float preco;
	
	@ManyToOne
	@JoinColumn(name="id_profissional", nullable = false)
	private Profissional profissional;
	
	public ServicoEntity() {}

	public ServicoEntity(Servico servico) {
		this.nome = servico.getNome();
		this.descricao = servico.getDescricao();
		this.preco = servico.getPreco();
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

	public Profissional getProfissional() {
		return profissional;
	}
	
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}



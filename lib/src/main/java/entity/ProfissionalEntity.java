package entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import principal.Agendamento;
import principal.Contrato;
import principal.Especializacao;
import principal.Profissional;
import principal.Servico;

@Entity
@Table(name="TB_PROFISSIONAL")
@SequenceGenerator(name="profissional", sequenceName = "SQ_TB_PROFISSIONAL", allocationSize = 1)
public class ProfissionalEntity {
	
	@Id
	@Column(name="id_profissional")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profissional")
	private Integer codigo;
	
	@Column(name="nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name="especializacao", nullable = false, length = 30)
	private Especializacao especializacao;
	
	@Column(name="telefone", precision = 12)
	private int telefone;
	
	@Column(name="endereco", nullable = false, length = 80)
	private String endereco;
	

	@Column(name="email", nullable = false, length = 80)
	private String email;
	
	@OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Contrato> contratos = new ArrayList<Contrato>();
	
	@OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Servico> servicos = new ArrayList<Servico>();
	
	@ManyToOne
	@JoinColumn(name="id_agendamento", nullable = false)
	private Agendamento agendamento;
	
	public ProfissionalEntity() {}
	
	public ProfissionalEntity(Profissional profissional) {
		this.nome = profissional.getNome();
		this.especializacao = profissional.getEspecializacao();
		this.telefone = profissional.getTelefone();
		this.endereco = profissional.getEndereco();
		this.email = profissional.getEmail();
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especializacao getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(Especializacao especializacao) {
		this.especializacao = especializacao;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public List<Contrato> getContratos() {
		return contratos;
	}
	
	
	
	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	
	
	
	public List<Servico> getServicos() {
		return servicos;
	}
	
	
	
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	
	
	public Agendamento getAgendamento() {
		return agendamento;
	}
	
	
	
	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
}

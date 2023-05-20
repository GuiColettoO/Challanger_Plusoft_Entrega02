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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import principal.Agendamento;
import principal.Cliente;
import principal.Contrato;

@Entity
@Table(name="TB_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
public class ClienteEntity {
	
	@Id
	@Column(name="id_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private long codigo;
	
	@Column(name="nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name="endereco", nullable = false, length = 80)
	private String endereco;
	
	@Column(name="telefone", precision = 11)
	private int telefone;
	
	@Column(name="email", nullable = false, length = 80)
	private String email;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Agendamento> agendamentos = new ArrayList<Agendamento>();
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Contrato> contratos = new ArrayList<Contrato>();
	
	public ClienteEntity() {}

	public ClienteEntity(Cliente cliente) {
		this.nome = cliente.getNome();
		this.endereco = cliente.getEndereco();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
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

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
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

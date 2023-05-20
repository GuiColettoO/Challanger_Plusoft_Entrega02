package entity;

import java.util.ArrayList;
import java.util.Calendar;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import principal.Agendamento;
import principal.Cliente;
import principal.Profissional;
import principal.Valor;

@Entity
@Table(name="TB_AGENDAMENTO")
@SequenceGenerator(name="agendamento", sequenceName = "SQ_TB_AGENDAMENTO", allocationSize = 1)
public class AgendamentoEntity {
	
	@Id
	@Column(name="id_agendamento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendamento")
	private Integer codigo;
	
	@Column(name="valor_agendamento", nullable = false, precision = 8)
	private int valorAgendamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_agendamento")
	private Calendar dataAgendamento;
	
	@OneToMany(mappedBy = "agendamento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Profissional> profissionais = new ArrayList<Profissional>();
	
	@ManyToOne
	@JoinColumn(name="id_valor", nullable = false)
	private Valor valor;

	@ManyToOne
	@JoinColumn(name="id_cliente", nullable = false)
	private Cliente cliente;

	public AgendamentoEntity() {}
	
	public AgendamentoEntity(Agendamento agendamento) {
		this.valorAgendamento = agendamento.getValorAgendamento();
		this.dataAgendamento = agendamento.getDataAgendamento();
	}
	
	public List<Profissional> getProfissionais() {
		return profissionais;
	}
	
	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}
	
	public Valor getValor() {
		return valor;
	}
	
	public void setValor(Valor valor) {
		this.valor = valor;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public int getValorAgendamento() {
		return valorAgendamento;
	}

	public void setValorAgendamento(int valorAgendamento) {
		this.valorAgendamento = valorAgendamento;
	}

	public Calendar getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Calendar dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}


	
}

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
import principal.Valor;

@Entity
@Table(name="TB_VALOR")
@SequenceGenerator(name="valor", sequenceName = "SQ_TB_VALOR", allocationSize = 1)
public class ValorEntity {
	
	@Id
	@Column(name="id_valor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valor")
	private Integer codigo;
	
	@Column(name="valor_agendamento", precision = 8)
	private float valorAgendamento;
	
	@Column(name="valor_contrato", precision = 8)
	private float valorContrato;
	
	@OneToMany(mappedBy = "valor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Agendamento> agendamentos = new ArrayList<Agendamento>();
	
	@ManyToOne
	@JoinColumn(name="id_contrato", nullable = false)
	private Contrato contrato;

	public ValorEntity() {}
	
	public ValorEntity(Valor valor) {
		this.valorAgendamento = valor.getValorAgendamento();
		this.valorContrato = valor.getValorAgendamento();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public float getValorAgendamento() {
		return valorAgendamento;
	}

	public void setValorAgendamento(float valorAgendamento) {
		this.valorAgendamento = valorAgendamento;
	}

	public float getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(float valorContrato) {
		this.valorContrato = valorContrato;
	}
	
	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}
	
	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
	public Contrato getContrato() {
		return contrato;
	}
	
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
}

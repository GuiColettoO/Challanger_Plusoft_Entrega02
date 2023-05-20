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
import principal.Cliente;
import principal.Contrato;
import principal.Profissional;
import principal.Valor;

@Entity
@Table(name="TB_CONTRATO")
@SequenceGenerator(name="contrato", sequenceName = "SQ_TB_CONTRATO", allocationSize = 1)
public class ContratoEntity {
	

	@Id
	@Column(name="id_contrato")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contrato")
	private Integer codigo;
	
	@Column(name="valor_total", nullable = false, precision = 8)
	private int valorTotal;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_de_inicio")
	private Calendar dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_de_termino")
	private Calendar dataTermino;
	
	@OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Valor> valores = new ArrayList<Valor>();
	
	@ManyToOne
	@JoinColumn(name="id_profissional", nullable = false)
	private Profissional profissional;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", nullable = false)
	private Cliente cliente;

	public ContratoEntity() {}
	
	public ContratoEntity(Contrato contrato) {
		this.valorTotal = contrato.getValorTotal();
		this.dataInicio = contrato.getDataInicio();
		this.dataTermino = contrato.getDataTermino();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public int getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}
	public List<Valor> getValores() {
		return valores;
	}
	
	public void setValores(List<Valor> valores) {
		this.valores = valores;
	}
	
	public Profissional getProfissional() {
		return profissional;
	}
	
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

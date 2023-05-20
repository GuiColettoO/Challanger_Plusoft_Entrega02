package principal;

import java.util.Calendar;

import entity.ContratoEntity;

public class Contrato {
	
	private Integer codigo;
	
	private int valorTotal;
	
	private Calendar dataInicio;
	
	private Calendar dataTermino;
	
	public Contrato(ContratoEntity contrato) {
		this.valorTotal = contrato.getValorTotal();
		this.dataInicio = contrato.getDataInicio();
		this.dataTermino = contrato.getDataTermino();
	}
	
	public Contrato() {}
	
	public Contrato(int valorTotal, Calendar dataInicio, Calendar dataTermino) {
		this.valorTotal = valorTotal;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
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
}

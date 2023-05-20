package principal;

import entity.ValorEntity;

public class Valor {

	private Integer codigo;
	
	private float valorAgendamento;
	
	private float valorContrato;
	
	public Valor(ValorEntity valor) {
		this.valorAgendamento = valor.getValorAgendamento();
		this.valorContrato = valor.getValorContrato();
	}

	public Valor() {}
	
	public Valor(float valorAgendamento, float valorContrato) {
		this.valorAgendamento = valorAgendamento;
		this.valorContrato = valorContrato;
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
}

package principal;

import java.util.Calendar;

import entity.AgendamentoEntity;

public class Agendamento {

	private Integer codigo;
	
	private int valorAgendamento;
	
	private Calendar dataAgendamento;
	
	public Agendamento(AgendamentoEntity agendamento) {
		this.valorAgendamento = agendamento.getValorAgendamento();
		this.dataAgendamento = agendamento.getDataAgendamento();
	}
	
	public Agendamento() {} 
	
	public Agendamento(int valorAgendamento, Calendar dataAgendamento) {
		this.valorAgendamento = valorAgendamento;
		this.dataAgendamento = dataAgendamento;
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

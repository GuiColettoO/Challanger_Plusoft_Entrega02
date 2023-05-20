package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.AgendamentoEntity;
import principal.Agendamento;
import repository.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public Agendamento saveAgendamento(Agendamento agendamento) {
		AgendamentoEntity agendamentoEntity = new AgendamentoEntity(agendamento);
		agendamentoRepository.save(agendamentoEntity);
		return agendamento;
	}
	
	public List<Agendamento> getAllAgendamentos() {
		return agendamentoRepository.findAll()
					.stream().map(entity -> new Agendamento(entity)).toList();
	}
	
	public Agendamento findById(Integer codigo) {
		 Optional<AgendamentoEntity> agendamentoEntity = agendamentoRepository.findById(codigo);
		 if(agendamentoEntity.isPresent()) {
			 return new Agendamento(agendamentoEntity.get());
		 } 
		 return null;
	}

	public Agendamento updateAgendamento(Agendamento newAgendamento, Integer codigo) {
		Optional<AgendamentoEntity> agendamentoEntityOptional = agendamentoRepository.findById(codigo);
		if(agendamentoEntityOptional.isPresent()) {
			AgendamentoEntity agendamentoEntity = agendamentoEntityOptional.get();
			agendamentoEntity.setValorAgendamento(newAgendamento.getValorAgendamento());
			agendamentoEntity.setDataAgendamento(newAgendamento.getDataAgendamento());
			agendamentoRepository.save(agendamentoEntity);
			return newAgendamento;
		}
		return null;
		
	}

	public Agendamento deleteAgendamento(Integer codigo) {
		Optional<AgendamentoEntity> agendamentoEntityOptional = agendamentoRepository.findById(codigo);
		if(agendamentoEntityOptional.isPresent()) {
			AgendamentoEntity agendamentoEntity = agendamentoEntityOptional.get();
			agendamentoRepository.delete(agendamentoEntity);
			return new Agendamento(agendamentoEntity);
		}
		return null;
	}
}

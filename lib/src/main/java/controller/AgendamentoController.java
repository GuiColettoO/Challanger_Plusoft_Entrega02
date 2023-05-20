package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.annotation.PostConstruct;
import principal.Agendamento;
import service.AgendamentoService;

public class AgendamentoController {
	
	private List<Agendamento> agendamentoList = new ArrayList<>();
	
	@Autowired
	private AgendamentoService agendamentoService;

	@PostConstruct
	private void postConstruct() {
		Agendamento dia1 = new Agendamento(6000, Calendar.getInstance());
		Agendamento dia2 = new Agendamento(4000, Calendar.getInstance());
		agendamentoList.add(dia1);
		agendamentoList.add(dia2);
	}

	@GetMapping("/agendamentos")
	ResponseEntity<List<Agendamento>> all() {
		return ResponseEntity.ok(agendamentoService.getAllAgendamentos());
	}

	@PostMapping("/agendamentos")
	public ResponseEntity<Agendamento> newAgendamento(@RequestBody Agendamento newAgendamento) {
		validateAgendamento(newAgendamento);
		agendamentoService.saveAgendamento(newAgendamento);
		return ResponseEntity.ok(newAgendamento);
	}

	private void validateAgendamento(Agendamento newAgendamento) {
		if (newAgendamento.getDataAgendamento() == null) {
			throw new IllegalArgumentException("Não existe agendamento marcado!");
		}

	}

	@GetMapping("/agendamentos/{codigo}")
	public ResponseEntity<Agendamento> one(@PathVariable Integer codigo) {
		return ResponseEntity.ofNullable(agendamentoService.findById(codigo));
	}

	@PutMapping("/agendamentos/{codigo}")
	public ResponseEntity<Agendamento> replaceAgendamento(@RequestBody Agendamento newAgendamento, @PathVariable Integer codigo) {
		Agendamento agendamentoUpdated = agendamentoService.updateAgendamento(newAgendamento,codigo);
		return ResponseEntity.ofNullable(agendamentoUpdated);
	}

	@DeleteMapping("/agendamentos/{id}")
	public ResponseEntity<Agendamento> deleteAgendamento(@PathVariable Integer codigo) {
		return ResponseEntity.ofNullable(agendamentoService.deleteAgendamento(codigo));
	}
}

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
import principal.Contrato;
import service.ContratoService;

public class ContratoController {
	
	private List<Contrato> contratoList = new ArrayList<>();
	
	@Autowired
	private ContratoService contratoService;

	@PostConstruct
	private void postConstruct() {
		Contrato contrato1 = new Contrato(6000, Calendar.getInstance(), Calendar.getInstance());
		Contrato contrato2 = new Contrato(4000, Calendar.getInstance(), Calendar.getInstance());
		contratoList.add(contrato1);
		contratoList.add(contrato2);
	}

	@GetMapping("/contratos")
	ResponseEntity<List<Contrato>> all() {
		return ResponseEntity.ok(contratoService.getAllcontratos());
	}

	@PostMapping("/contratos")
	public ResponseEntity<Contrato> newContrato(@RequestBody Contrato newContrato) {
		validateContrato(newContrato);
		contratoService.saveContrato(newContrato);
		return ResponseEntity.ok(newContrato);
	}

	private void validateContrato(Contrato newContrato) {
		if (newContrato.getDataInicio() == null) {
			throw new IllegalArgumentException("Não existe contrato!");
		}

	}

	@GetMapping("/contratos/{codigo}")
	public ResponseEntity<Contrato> one(@PathVariable Integer codigo) {
		return ResponseEntity.ofNullable(contratoService.findById(codigo));
	}

	@PutMapping("/contratos/{codigo}")
	public ResponseEntity<Contrato> replaceContrato(@RequestBody Contrato newContrato, @PathVariable Integer codigo) {
		Contrato contratoUpdated = contratoService.updateContrato(newContrato,codigo);
		return ResponseEntity.ofNullable(contratoUpdated);
	}

	@DeleteMapping("/contratos/{id}")
	public ResponseEntity<Contrato> deleteContrato(@PathVariable Integer codigo) {
		return ResponseEntity.ofNullable(contratoService.deleteContrato(codigo));
	}
}

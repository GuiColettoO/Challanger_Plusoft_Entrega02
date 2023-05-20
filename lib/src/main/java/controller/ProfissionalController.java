package controller;

import java.util.ArrayList;
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
import principal.Especializacao;
import principal.Profissional;
import service.ProfissionalService;

public class ProfissionalController {
	
	private List<Profissional> profissionalList = new ArrayList<>();
	
	@Autowired
	private ProfissionalService profissionalService;

	@PostConstruct
	private void postConstruct() {
		Profissional alberto = new Profissional("Alberto", Especializacao.CABELEREIRO, 977779999, "rua logo la", "Alberto@alberto.com");
		Profissional roberto = new Profissional("Roberto", Especializacao.JARDINEIRO, 977779929, "rua logo aliii", "Roberto@roberto.com");
		profissionalList.add(alberto);
		profissionalList.add(roberto);
	}

	@GetMapping("/profissionais")
	ResponseEntity<List<Profissional>> all() {
		return ResponseEntity.ok(profissionalService.getAllprofissionals());
	}

	@PostMapping("/profissionais")
	public ResponseEntity<Profissional> newProfissional(@RequestBody Profissional newProfissional) {
		validateProfissional(newProfissional);
		profissionalService.saveProfissional(newProfissional);
		return ResponseEntity.ok(newProfissional);
	}

	private void validateProfissional(Profissional newProfissional) {
		if (newProfissional.getNome() == null) {
			throw new IllegalArgumentException("Não existe o profissional!");
		}

	}

	@GetMapping("/profissionais/{codigo}")
	public ResponseEntity<Profissional> one(@PathVariable Integer codigo) {
		return ResponseEntity.ofNullable(profissionalService.findById(codigo));
	}

	@PutMapping("/profissionais/{codigo}")
	public ResponseEntity<Profissional> replaceProfissional(@RequestBody Profissional newProfissional, @PathVariable Integer codigo) {
		Profissional profissionalUpdated = profissionalService.updateProfissional(newProfissional,codigo);
		return ResponseEntity.ofNullable(profissionalUpdated);
	}

	@DeleteMapping("/profissionais/{id}")
	public ResponseEntity<Profissional> deleteProfissional(@PathVariable Integer codigo) {
		return ResponseEntity.ofNullable(profissionalService.deleteProfissional(codigo));
	}
}

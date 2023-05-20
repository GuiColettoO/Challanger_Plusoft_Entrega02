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
import principal.Servico;
import service.ServicoService;

public class ServicoController {
	
	private List<Servico> servicoList = new ArrayList<>();
	
	@Autowired
	private ServicoService servicoService;

	@PostConstruct
	private void postConstruct() {
		Servico servico1 = new Servico("corta cabelo", "corte do tio patinhas", 66);
		Servico servico2 = new Servico("lavagem de carro", "lavagem de carro com super pano", 266);
		servicoList.add(servico1);
		servicoList.add(servico2);
	}

	@GetMapping("/servicos")
	ResponseEntity<List<Servico>> all() {
		return ResponseEntity.ok(servicoService.getAllservicos());
	}

	@PostMapping("/servicos")
	public ResponseEntity<Servico> newServico(@RequestBody Servico newServico) {
		validateServico(newServico);
		servicoService.saveServico(newServico);
		return ResponseEntity.ok(newServico);
	}

	private void validateServico(Servico newServico) {
		if (newServico.getNome() == null) {
			throw new IllegalArgumentException("Não existe o Servico!");
		}

	}

	@GetMapping("/servicos/{codigo}")
	public ResponseEntity<Servico> one(@PathVariable Integer codigo) {
		return ResponseEntity.ofNullable(servicoService.findById(codigo));
	}

	@PutMapping("/servicos/{codigo}")
	public ResponseEntity<Servico> replaceServico(@RequestBody Servico newServico, @PathVariable Integer codigo) {
		Servico servicoUpdated = servicoService.updateServico(newServico,codigo);
		return ResponseEntity.ofNullable(servicoUpdated);
	}

	@DeleteMapping("/servicos/{id}")
	public ResponseEntity<Servico> deleteServico(@PathVariable Integer codigo) {
		return ResponseEntity.ofNullable(servicoService.deleteServico(codigo));
	}
}

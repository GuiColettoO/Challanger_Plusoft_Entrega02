package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.annotation.PostConstruct;
import principal.Valor;
import service.ValorService;

public class ValorController {
	
	private List<Valor> valorList = new ArrayList<>();
	
	@Autowired
	private ValorService valorService;

	@PostConstruct
	private void postConstruct() {
		Valor valor1 = new Valor(56, 7800);
		Valor valor2 = new Valor(266, 8000);
		valorList.add(valor1);
		valorList.add(valor2);
	}

	@GetMapping("/valores")
	ResponseEntity<List<Valor>> all() {
		return ResponseEntity.ok(valorService.getAllvalors());
	}

	@GetMapping("/valores/{codigo}")
	public ResponseEntity<Valor> one(@PathVariable Integer codigo) {
		return ResponseEntity.ofNullable(valorService.findById(codigo));
	}

	@PutMapping("/valores/{codigo}")
	public ResponseEntity<Valor> replaceValor(@RequestBody Valor newValor, @PathVariable Integer codigo) {
		Valor valorUpdated = valorService.updateValor(newValor,codigo);
		return ResponseEntity.ofNullable(valorUpdated);
	}

	@DeleteMapping("/valores/{id}")
	public ResponseEntity<Valor> deleteValor(@PathVariable Integer codigo) {
		return ResponseEntity.ofNullable(valorService.deleteValor(codigo));
	}
}

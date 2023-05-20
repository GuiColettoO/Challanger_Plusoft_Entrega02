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
import principal.Cliente;
import service.ClienteService;

public class ClienteController {
	
	private List<Cliente> clienteList = new ArrayList<>();
	
	@Autowired
	private ClienteService clienteService;

	@PostConstruct
	private void postConstruct() {
		Cliente Joao = new Cliente("Joao", "Rua Logo ali", 944442222, "Joao@joao.com");
		Cliente Carlos = new Cliente("Carlos", "Rua Logo la", 944441111, "Carlos@carlos.com");
		clienteList.add(Joao);
		clienteList.add(Carlos);
	}

	@GetMapping("/clientes")
	ResponseEntity<List<Cliente>> all() {
		return ResponseEntity.ok(clienteService.getAllClientes());
	}

	@PostMapping("/clientes")
	public ResponseEntity<Cliente> newCliente(@RequestBody Cliente newCliente) {
		validateCliente(newCliente);
		clienteService.saveCliente(newCliente);
		return ResponseEntity.ok(newCliente);
	}

	private void validateCliente(Cliente newCliente) {
		if (newCliente.getNome() == null) {
			throw new IllegalArgumentException("Cliente without name");
		}

	}

	@GetMapping("/clientes/{codigo}")
	public ResponseEntity<Cliente> one(@PathVariable Long codigo) {
		return ResponseEntity.ofNullable(clienteService.findById(codigo));
	}

	@PutMapping("/clientes/{codigo}")
	public ResponseEntity<Cliente> replaceCliente(@RequestBody Cliente newCliente, @PathVariable Long codigo) {
		Cliente clienteUpdated = clienteService.updateCliente(newCliente,codigo);
		return ResponseEntity.ofNullable(clienteUpdated);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable Long codigo) {
		return ResponseEntity.ofNullable(clienteService.deleteCliente(codigo));
	}
}

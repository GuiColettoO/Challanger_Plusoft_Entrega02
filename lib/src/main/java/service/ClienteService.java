package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.ClienteEntity;
import principal.Cliente;
import repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente saveCliente(Cliente cliente) {
		ClienteEntity clienteEntity = new ClienteEntity(cliente);
		clienteRepository.save(clienteEntity);
		return cliente;
	}
	
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll()
					.stream().map(entity -> new Cliente(entity)).toList();
	}
	
	public Cliente findById(Long codigo) {
		 Optional<ClienteEntity> clienteEntity = clienteRepository.findById(codigo);
		 if(clienteEntity.isPresent()) {
			 return new Cliente(clienteEntity.get());
		 } 
		 return null;
	}

	public Cliente updateCliente(Cliente newCliente, Long codigo) {
		Optional<ClienteEntity> clienteEntityOptional = clienteRepository.findById(codigo);
		if(clienteEntityOptional.isPresent()) {
			ClienteEntity clienteEntity = clienteEntityOptional.get();
			clienteEntity.setNome(newCliente.getNome());
			clienteEntity.setEndereco(newCliente.getEndereco());
			clienteEntity.setTelefone(newCliente.getTelefone());
			clienteEntity.setEmail(newCliente.getEmail());
			clienteRepository.save(clienteEntity);
			return newCliente;
		}
		return null;
		
	}

	public Cliente deleteCliente(Long codigo) {
		Optional<ClienteEntity> clienteEntityOptional = clienteRepository.findById(codigo);
		if(clienteEntityOptional.isPresent()) {
			ClienteEntity clienteEntity = clienteEntityOptional.get();
			clienteRepository.delete(clienteEntity);
			return new Cliente(clienteEntity);
		}
		return null;
	}
}

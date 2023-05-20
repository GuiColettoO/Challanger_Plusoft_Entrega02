package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.ValorEntity;
import principal.Valor;
import repository.ValorRepository;

@Service
public class ValorService {

	@Autowired
	private ValorRepository valorRepository;
	
	public Valor saveValor(Valor valor) {
		ValorEntity valorEntity = new ValorEntity(valor);
		valorRepository.save(valorEntity);
		return valor;
	}
	
	public List<Valor> getAllvalors() {
		return valorRepository.findAll()
					.stream().map(entity -> new Valor(entity)).toList();
	}
	
	public Valor findById(Integer codigo) {
		 Optional<ValorEntity> valorEntity = valorRepository.findById(codigo);
		 if(valorEntity.isPresent()) {
			 return new Valor(valorEntity.get());
		 } 
		 return null;
	}

	public Valor updateValor(Valor newValor, Integer codigo) {
		Optional<ValorEntity> valorEntityOptional = valorRepository.findById(codigo);
		if(valorEntityOptional.isPresent()) {
			ValorEntity valorEntity = valorEntityOptional.get();
			valorEntity.setValorAgendamento(newValor.getValorAgendamento());
			valorEntity.setValorContrato(newValor.getValorContrato());
			valorRepository.save(valorEntity);
			return newValor;
		}
		return null;
		
	}

	public Valor deleteValor(Integer codigo) {
		Optional<ValorEntity> valorEntityOptional = valorRepository.findById(codigo);
		if(valorEntityOptional.isPresent()) {
			ValorEntity valorEntity = valorEntityOptional.get();
			valorRepository.delete(valorEntity);
			return new Valor(valorEntity);
		}
		return null;
	}
}

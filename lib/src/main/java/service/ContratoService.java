package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.ContratoEntity;
import principal.Contrato;
import repository.ContratoRepository;

@Service
public class ContratoService {

	@Autowired
	private ContratoRepository contratoRepository;
	
	public Contrato saveContrato(Contrato contrato) {
		ContratoEntity contratoEntity = new ContratoEntity(contrato);
		contratoRepository.save(contratoEntity);
		return contrato;
	}
	
	public List<Contrato> getAllcontratos() {
		return contratoRepository.findAll()
					.stream().map(entity -> new Contrato(entity)).toList();
	}
	
	public Contrato findById(Integer codigo) {
		 Optional<ContratoEntity> contratoEntity = contratoRepository.findById(codigo);
		 if(contratoEntity.isPresent()) {
			 return new Contrato(contratoEntity.get());
		 } 
		 return null;
	}

	public Contrato updateContrato(Contrato newContrato, Integer codigo) {
		Optional<ContratoEntity> contratoEntityOptional = contratoRepository.findById(codigo);
		if(contratoEntityOptional.isPresent()) {
			ContratoEntity contratoEntity = contratoEntityOptional.get();
			contratoEntity.setValorTotal(newContrato.getValorTotal());
			contratoEntity.setDataInicio(newContrato.getDataInicio());
			contratoEntity.setDataTermino(newContrato.getDataTermino());
			contratoRepository.save(contratoEntity);
			return newContrato;
		}
		return null;
		
	}

	public Contrato deleteContrato(Integer codigo) {
		Optional<ContratoEntity> contratoEntityOptional = contratoRepository.findById(codigo);
		if(contratoEntityOptional.isPresent()) {
			ContratoEntity contratoEntity = contratoEntityOptional.get();
			contratoRepository.delete(contratoEntity);
			return new Contrato(contratoEntity);
		}
		return null;
	}
}

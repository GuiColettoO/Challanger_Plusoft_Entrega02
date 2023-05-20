package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.ProfissionalEntity;
import principal.Profissional;
import repository.ProfissionalRepository;

@Service
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public Profissional saveProfissional(Profissional profissional) {
		ProfissionalEntity profissionalEntity = new ProfissionalEntity(profissional);
		profissionalRepository.save(profissionalEntity);
		return profissional;
	}
	
	public List<Profissional> getAllprofissionals() {
		return profissionalRepository.findAll()
					.stream().map(entity -> new Profissional(entity)).toList();
	}
	
	public Profissional findById(Integer codigo) {
		 Optional<ProfissionalEntity> profissionalEntity = profissionalRepository.findById(codigo);
		 if(profissionalEntity.isPresent()) {
			 return new Profissional(profissionalEntity.get());
		 } 
		 return null;
	}

	public Profissional updateProfissional(Profissional newProfissional, Integer codigo) {
		Optional<ProfissionalEntity> profissionalEntityOptional = profissionalRepository.findById(codigo);
		if(profissionalEntityOptional.isPresent()) {
			ProfissionalEntity profissionalEntity = profissionalEntityOptional.get();
			profissionalEntity.setNome(newProfissional.getNome());
			profissionalEntity.setEspecializacao(newProfissional.getEspecializacao());
			profissionalEntity.setTelefone(newProfissional.getTelefone());
			profissionalEntity.setEndereco(newProfissional.getEndereco());
			profissionalEntity.setEmail(newProfissional.getEmail());
			profissionalRepository.save(profissionalEntity);
			return newProfissional;
		}
		return null;
		
	}

	public Profissional deleteProfissional(Integer codigo) {
		Optional<ProfissionalEntity> profissionalEntityOptional = profissionalRepository.findById(codigo);
		if(profissionalEntityOptional.isPresent()) {
			ProfissionalEntity profissionalEntity = profissionalEntityOptional.get();
			profissionalRepository.delete(profissionalEntity);
			return new Profissional(profissionalEntity);
		}
		return null;
	}
}

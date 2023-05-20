package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.ServicoEntity;
import principal.Servico;
import repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	public Servico saveServico(Servico servico) {
		ServicoEntity servicoEntity = new ServicoEntity(servico);
		servicoRepository.save(servicoEntity);
		return servico;
	}
	
	public List<Servico> getAllservicos() {
		return servicoRepository.findAll()
					.stream().map(entity -> new Servico(entity)).toList();
	}
	
	public Servico findById(Integer codigo) {
		 Optional<ServicoEntity> servicoEntity = servicoRepository.findById(codigo);
		 if(servicoEntity.isPresent()) {
			 return new Servico(servicoEntity.get());
		 } 
		 return null;
	}

	public Servico updateServico(Servico newServico, Integer codigo) {
		Optional<ServicoEntity> servicoEntityOptional = servicoRepository.findById(codigo);
		if(servicoEntityOptional.isPresent()) {
			ServicoEntity servicoEntity = servicoEntityOptional.get();
			servicoEntity.setNome(newServico.getNome());
			servicoEntity.setDescricao(newServico.getDescricao());
			servicoEntity.setPreco(newServico.getPreco());
			servicoRepository.save(servicoEntity);
			return newServico;
		}
		return null;
		
	}

	public Servico deleteServico(Integer codigo) {
		Optional<ServicoEntity> servicoEntityOptional = servicoRepository.findById(codigo);
		if(servicoEntityOptional.isPresent()) {
			ServicoEntity servicoEntity = servicoEntityOptional.get();
			servicoRepository.delete(servicoEntity);
			return new Servico(servicoEntity);
		}
		return null;
	}
}

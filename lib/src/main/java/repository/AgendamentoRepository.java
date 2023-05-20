package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.AgendamentoEntity;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Integer>{

}

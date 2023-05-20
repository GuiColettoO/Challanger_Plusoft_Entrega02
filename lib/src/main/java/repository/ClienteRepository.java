package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

}

package javaSpring.ProjectSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javaSpring.ProjectSpring.entity.DesaEntity;

@Repository
public interface DesaRepository extends JpaRepository<DesaEntity, Integer> {
	
}

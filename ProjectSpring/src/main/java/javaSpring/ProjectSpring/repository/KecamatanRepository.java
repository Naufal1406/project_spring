package javaSpring.ProjectSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javaSpring.ProjectSpring.entity.KecamatanEntity;

@Repository
public interface KecamatanRepository extends JpaRepository<KecamatanEntity, Integer>{
	KecamatanEntity findByKodeKecamatan(String kodeKecamatan);
}

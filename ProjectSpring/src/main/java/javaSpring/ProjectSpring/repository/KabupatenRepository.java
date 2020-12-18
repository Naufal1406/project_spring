package javaSpring.ProjectSpring.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javaSpring.ProjectSpring.entity.KabupatenEntity;

@Repository
public interface KabupatenRepository extends JpaRepository<KabupatenEntity, Integer> {
	KabupatenEntity findByKodeKabupaten(String kodeProvinsi);
}

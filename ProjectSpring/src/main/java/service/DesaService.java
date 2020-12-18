package service;

import java.util.List;

import javaSpring.ProjectSpring.dto.DesaDto;
import javaSpring.ProjectSpring.entity.DesaEntity;

public interface DesaService {
	List<DesaEntity> getAllDesa();
	DesaEntity getDesaById(Integer idDesa);
	DesaEntity postDesa(DesaDto dto);
	DesaEntity updateDesa(DesaDto dto, Integer idDesa);
	DesaEntity deleteDesa(Integer idDesa);
}

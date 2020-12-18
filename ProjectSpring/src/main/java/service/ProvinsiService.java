package service;

import java.util.List;

import javaSpring.ProjectSpring.dto.ProvinsiDto;
import javaSpring.ProjectSpring.entity.ProvinsiEntity;

public interface ProvinsiService {
	List<ProvinsiEntity> getAllProvinsi();
	ProvinsiEntity getProvinsiById(Integer idProvinsi);
	ProvinsiEntity insertProvinsi(ProvinsiDto dto, Integer idProvinsi);
	ProvinsiEntity updateProvinsi(ProvinsiDto dto, Integer idProvinsi);
	ProvinsiEntity deleteProvinsi(ProvinsiDto dto, Integer idProvinsi);
}

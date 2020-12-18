package service;

import java.util.List;

import javaSpring.ProjectSpring.dto.KecamatanDto;
import javaSpring.ProjectSpring.entity.KecamatanEntity;


public interface KecamatanService {
	List<KecamatanEntity> getAllKecamatan();
	KecamatanEntity getKecamatanById(Integer idKecamatan);
	KecamatanEntity insertKecamatan(KecamatanDto dto);
	KecamatanEntity updateKecamatan(KecamatanDto dto, Integer idKecamatan);
	KecamatanEntity deleteKecamatan(Integer idKecamatan);
}

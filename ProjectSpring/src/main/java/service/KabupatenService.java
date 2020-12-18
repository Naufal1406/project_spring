package service;


import java.util.List;

import javaSpring.ProjectSpring.dto.KabupatenDto;
import javaSpring.ProjectSpring.entity.KabupatenEntity;

public interface KabupatenService {
	List<KabupatenEntity> getAllKabupaten();
	KabupatenEntity getKabupatenId(Integer idKabupaten);
	KabupatenEntity insertKabupaten(KabupatenDto dto);
	KabupatenEntity updateKabupaten(KabupatenDto dto, Integer idKabupaten);
	KabupatenEntity deleteKabupaten(Integer idKabupaten);
}

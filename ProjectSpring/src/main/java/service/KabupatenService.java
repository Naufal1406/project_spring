package service;


import javaSpring.ProjectSpring.dto.KabupatenDto;
import javaSpring.ProjectSpring.entity.KabupatenEntity;

public interface KabupatenService {
	KabupatenEntity getAllKabupaten();
	KabupatenEntity getKabupatenId(Integer idKabupaten);
	KabupatenEntity insertKabupaten(KabupatenDto dto);
	KabupatenEntity updateKabupaten(KabupatenDto dto, Integer idKabupaten);
	KabupatenEntity deleteKabupaten(KabupatenDto dto, Integer idKabupaten);
}

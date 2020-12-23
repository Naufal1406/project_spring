package javaSpring.ProjectSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javaSpring.ProjectSpring.dto.ProvinsiDto;
import javaSpring.ProjectSpring.entity.ProvinsiEntity;
import javaSpring.ProjectSpring.repository.ProvinsiRepository;

@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService{
	
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	@Override
	public List<ProvinsiEntity> getAllProvinsi() {
		// TODO Auto-generated method stub
		List<ProvinsiEntity> provinsiEntities = provinsiRepository.findAll();
		return provinsiEntities;
	}

	@Override
	public ProvinsiEntity getProvinsiById(Integer idProvinsi) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(idProvinsi).get();
		return provinsiEntity;
	}

	@Override
	public ProvinsiEntity insertProvinsi(ProvinsiDto dto) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = convertToProvinsiEntity(dto);
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}

	@Override
	public ProvinsiEntity updateProvinsi(ProvinsiDto dto, Integer idProvinsi) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(idProvinsi).get();
		provinsiEntity.setNamaProvinsi(dto.getNamaProvinsi());
		provinsiEntity.setKodeProvinsi(dto.getKodeProvinsi());
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}

	@Override
	public ProvinsiEntity deleteProvinsi(Integer idProvinsi) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(idProvinsi).get();
		provinsiRepository.delete(provinsiEntity);
		return provinsiEntity;
	}
	
	//CONVERT METHOD
	public ProvinsiEntity convertToProvinsiEntity(ProvinsiDto dto) {
		ProvinsiEntity provinsiEntity = new ProvinsiEntity();
		provinsiEntity.setNamaProvinsi(dto.getNamaProvinsi());
		provinsiEntity.setKodeProvinsi(dto.getKodeProvinsi());
		return provinsiEntity;

	}

	@Override
	public ProvinsiEntity softDeleteProvinsi(Integer idProvinsi) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(idProvinsi).get();
		provinsiEntity.setStatus(0);
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}




}

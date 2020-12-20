package javaSpring.ProjectSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javaSpring.ProjectSpring.dto.DesaDto;
import javaSpring.ProjectSpring.entity.DesaEntity;
import javaSpring.ProjectSpring.entity.KabupatenEntity;
import javaSpring.ProjectSpring.entity.KecamatanEntity;
import javaSpring.ProjectSpring.entity.ProvinsiEntity;
import javaSpring.ProjectSpring.repository.DesaRepository;
import javaSpring.ProjectSpring.repository.KabupatenRepository;
import javaSpring.ProjectSpring.repository.KecamatanRepository;
import javaSpring.ProjectSpring.repository.ProvinsiRepository;

@Service
@Transactional
public class DesaServiceImpl implements DesaService{
	@Autowired
	private DesaRepository desaRepository;
	@Autowired
	private ProvinsiRepository provinsiRepository;
	@Autowired
	private KabupatenRepository kabupatenRepository;
	@Autowired
	private KecamatanRepository kecamatanRepository;

	@Override
	public List<DesaEntity> getAllDesa() {
		// TODO Auto-generated method stub
		List<DesaEntity> desaEntities = desaRepository.findAll();
		return desaEntities;
	}

	@Override
	public DesaEntity getDesaById(Integer idDesa) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = desaRepository.findById(idDesa).get();
		return desaEntity;
	}

	@Override
	public DesaEntity postDesa(DesaDto dto) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());
		KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(dto.getKodeKecamatan());
		DesaEntity desaEntity = convertToDesaEntity(dto);
		desaEntity.setProvinsiEntity(provinsiEntity);
		desaEntity.setKabupatenEntity(kabupatenEntity);
		desaEntity.setKecamatanEntity(kecamatanEntity);
		desaRepository.save(desaEntity);
		return desaEntity;
	}

	@Override
	public DesaEntity updateDesa(DesaDto dto, Integer idDesa) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = desaRepository.findById(idDesa).get();
		desaEntity.setNamaDesa(dto.getNamaDesa());
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaRepository.save(desaEntity);
		return desaEntity;
	}

	@Override
	public DesaEntity deleteDesa(Integer idDesa) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = desaRepository.findById(idDesa).get();
		desaRepository.delete(desaEntity);
		return desaEntity;
	}
	
	
	public DesaEntity convertToDesaEntity(DesaDto dto) {
		DesaEntity desaEntity = new DesaEntity();
		desaEntity.setNamaDesa(dto.getNamaDesa());
		desaEntity.setKodeDesa(dto.getKodeDesa());
		return desaEntity;
	}


}

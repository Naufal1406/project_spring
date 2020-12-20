package javaSpring.ProjectSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javaSpring.ProjectSpring.dto.KabupatenDto;
import javaSpring.ProjectSpring.entity.KabupatenEntity;
import javaSpring.ProjectSpring.entity.ProvinsiEntity;
import javaSpring.ProjectSpring.repository.KabupatenRepository;
import javaSpring.ProjectSpring.repository.ProvinsiRepository;

@Service
@Transactional
public class KabupatenServiceImpl implements KabupatenService{
		@Autowired
		KabupatenRepository kabupatenRepository;
		@Autowired
		ProvinsiRepository provinsiRepository;
		
		@Override
		public List<KabupatenEntity> getAllKabupaten() {
			// TODO Auto-generated method stub
			List<KabupatenEntity> kabupatenEntities = kabupatenRepository.findAll();
			return kabupatenEntities;
		}
		@Override
		public KabupatenEntity getKabupatenId(Integer idKabupaten) {
			// TODO Auto-generated method stub
			KabupatenEntity kabupatenEntity = kabupatenRepository.findById(idKabupaten).get();
			return kabupatenEntity;
		}
		@Override
		public KabupatenEntity insertKabupaten(KabupatenDto dto) {
			// TODO Auto-generated method stub
			ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
			KabupatenEntity kabupatenEntity = convertToKabupatenEntity(dto);
			kabupatenEntity.setProvinsiEntity(provinsiEntity);
			kabupatenRepository.save(kabupatenEntity);
			return kabupatenEntity;
		}
		
		@Override
		public KabupatenEntity updateKabupaten(KabupatenDto dto, Integer idKabupaten) {
			// TODO Auto-generated method stub
			KabupatenEntity kabupatenEntity = kabupatenRepository.findById(idKabupaten).get();
			kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
			kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
			kabupatenRepository.save(kabupatenEntity);
			return kabupatenEntity;
		}
		
		@Override
		public KabupatenEntity deleteKabupaten(Integer idKabupaten) {
			// TODO Auto-generated method stub
			KabupatenEntity kabupatenEntity = kabupatenRepository.findById(idKabupaten).get();
			kabupatenRepository.delete(kabupatenEntity);
			return kabupatenEntity;
		}
	
		public KabupatenEntity convertToKabupatenEntity(KabupatenDto dto){
			KabupatenEntity kabupatenEntity = new KabupatenEntity();
			kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
			kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
			return kabupatenEntity;
		}
	
		
		
}

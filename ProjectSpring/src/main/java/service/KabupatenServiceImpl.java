package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javaSpring.ProjectSpring.dto.KabupatenDto;
import javaSpring.ProjectSpring.entity.KabupatenEntity;
import javaSpring.ProjectSpring.repository.KabupatenRepository;
import javaSpring.ProjectSpring.repository.ProvinsiRepository;

@Service
@Transactional
public class KabupatenServiceImpl implements KabupatenService{
		@Autowired
		KabupatenRepository kabupatenRepository;
		@Autowired
		ProvinsiRepository provinsiRepository;
		
		
		public KabupatenEntity convertToKabupatenEntity(KabupatenDto dto){
		KabupatenEntity kabupatenEntity = new KabupatenEntity();
		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
		return kabupatenEntity;
	}
}

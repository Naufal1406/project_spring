package javaSpring.ProjectSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaSpring.ProjectSpring.dto.KabupatenDto;
import javaSpring.ProjectSpring.entity.KabupatenEntity;
import javaSpring.ProjectSpring.entity.ProvinsiEntity;
import javaSpring.ProjectSpring.repository.KabupatenRepository;
import javaSpring.ProjectSpring.repository.ProvinsiRepository;

@RestController
@RequestMapping("/kabupaten")
public class KabupatenController {
//	@Autowired
//	KabupatenRepository kabupatenRepository;
//	@Autowired
//	ProvinsiRepository provinsiRepository;
	
	
//	@GetMapping("/get-all-kabupaten")
//	public List<KabupatenEntity> getAllKabupaten(){
//		List<KabupatenEntity> kabupatenEntities = kabupatenRepository.findAll();
//		return kabupatenEntities;
//	}
//	
	@GetMapping("/get-all-kabupaten")
	public ResponseEntity<?> getAllKabupaten(){
		List<KabupatenEntity> kabupatenEntities = kabupatenRepository.findAll();
		return ResponseEntity.ok(kabupatenEntities);
	}
	
	@GetMapping("get-kabupatenById/{idKabupaten}")
	public ResponseEntity<?> getKabupatenById(@PathVariable Integer idKabupaten){
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(idKabupaten).get();
		return ResponseEntity.ok(kabupatenEntity);
	}

	@PostMapping("/post-kabupaten")
	public ResponseEntity<?> insertKabupaten(@RequestBody KabupatenDto dto){
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		KabupatenEntity kabupatenEntity = convertToKabupatenEntity(dto);
		kabupatenEntity.setProvinsiEntity(provinsiEntity);
		kabupatenRepository.save(kabupatenEntity);
		return ResponseEntity.ok(kabupatenEntity);
	}
	
	//UPDATE
	@PutMapping("/update-kabupaten/{idKabupaten}")
	public ResponseEntity<?> updateKabupaten(@PathVariable Integer idKabupaten,
			@RequestBody KabupatenDto dto){
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(idKabupaten).get();
		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
		kabupatenRepository.save(kabupatenEntity);
		return ResponseEntity.ok(kabupatenEntity);
	}
	
	//DELETE
	@DeleteMapping("/delete-kabupaten/{idKabupaten}")
	public ResponseEntity<?> deleteKabupaten(@PathVariable Integer idKabupaten){
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(idKabupaten).get();
		kabupatenRepository.delete(kabupatenEntity);
		return ResponseEntity.ok(kabupatenEntity);
	
	}
	
	//CONVERT METHOD
//	public KabupatenEntity convertToKabupatenEntity(KabupatenDto dto){
//		KabupatenEntity kabupatenEntity = new KabupatenEntity();
//		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
//		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
//		return kabupatenEntity;
//	}
}

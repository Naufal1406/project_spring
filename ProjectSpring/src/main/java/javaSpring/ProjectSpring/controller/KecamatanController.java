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

import javaSpring.ProjectSpring.dto.KecamatanDto;
import javaSpring.ProjectSpring.entity.KabupatenEntity;
import javaSpring.ProjectSpring.entity.KecamatanEntity;
import javaSpring.ProjectSpring.entity.ProvinsiEntity;
import javaSpring.ProjectSpring.repository.KabupatenRepository;
import javaSpring.ProjectSpring.repository.KecamatanRepository;
import javaSpring.ProjectSpring.repository.ProvinsiRepository;

@RestController
@RequestMapping("/kecamatan")
public class KecamatanController {
	@Autowired
	private KecamatanRepository kecamatanRepository;
	@Autowired
	private ProvinsiRepository provinsiRepository;
	@Autowired
	private KabupatenRepository kabupatenRepository;
	
	//GET-ALL
	@GetMapping("/get-all-kecamatan")
	public List<KecamatanEntity> getAllKecamatan(){
		List<KecamatanEntity> kecamatanEntities = kecamatanRepository.findAll();
		return kecamatanEntities;
	}
	
	//GET-BY-ID
	@GetMapping("/get-kecamatanById/{idKecamatan}")
	public ResponseEntity<?> getKecamatanById(@PathVariable Integer idKecamatan){
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(idKecamatan).get();
		return ResponseEntity.ok(kecamatanEntity);
	}
	
	//POST
	@PostMapping("/post-kecamatan")
	public ResponseEntity<?> insertKecamatan(@RequestBody KecamatanDto dto){
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());

		KecamatanEntity kecamatanEntity = convertToKecamatanEntity(dto);
		kecamatanEntity.setProvinsiEntity(provinsiEntity);
		kecamatanEntity.setKabupatenEntity(kabupatenEntity);
		kecamatanRepository.save(kecamatanEntity);
		return ResponseEntity.ok(kecamatanEntity);
	}
	
	//UPDATE
	@PutMapping("/update-kecamatan/{idKecamatan}")
	public ResponseEntity<?> updateKecamatan(@PathVariable Integer idKecamatan,
			@RequestBody KecamatanDto dto){
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(idKecamatan).get();
		kecamatanEntity.setNamaKecamatan(dto.getNamaKecamatan());
		kecamatanEntity.setKodeKecamatan(dto.getKodeKecamatan());
		kecamatanRepository.save(kecamatanEntity);
		return ResponseEntity.ok(kecamatanEntity);
		
	}
	
	//DELETE
	@DeleteMapping("/delete-kecamatan/{idKecamatan}")
	public ResponseEntity<?> deleteKecamatan(@PathVariable Integer idKecamatan){
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(idKecamatan).get();
		kecamatanRepository.delete(kecamatanEntity);
		return ResponseEntity.ok(kecamatanEntity);
	}
	//CONVERT METHOD
	public KecamatanEntity convertToKecamatanEntity(KecamatanDto dto) {
		KecamatanEntity kecamatanEntity = new KecamatanEntity();
		kecamatanEntity.setNamaKecamatan(dto.getNamaKecamatan());
		kecamatanEntity.setKodeKecamatan(dto.getKodeKecamatan());
		return kecamatanEntity;
	}
}

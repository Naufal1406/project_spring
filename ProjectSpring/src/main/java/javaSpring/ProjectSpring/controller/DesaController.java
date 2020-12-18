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


import javaSpring.ProjectSpring.dto.DesaDto;
import javaSpring.ProjectSpring.entity.DesaEntity;
import javaSpring.ProjectSpring.entity.KabupatenEntity;
import javaSpring.ProjectSpring.entity.KecamatanEntity;
import javaSpring.ProjectSpring.entity.ProvinsiEntity;
import javaSpring.ProjectSpring.repository.DesaRepository;
import javaSpring.ProjectSpring.repository.KabupatenRepository;
import javaSpring.ProjectSpring.repository.KecamatanRepository;
import javaSpring.ProjectSpring.repository.ProvinsiRepository;

@RestController
@RequestMapping("/desa")
public class DesaController {
	@Autowired
	private DesaRepository desaRepository;
	@Autowired
	private ProvinsiRepository provinsiRepository;
	@Autowired
	private KabupatenRepository kabupatenRepository;
	@Autowired
	private KecamatanRepository kecamatanRepository;
	
	//get-all
	@GetMapping("get-all-desa")
	public List<DesaEntity> getAllDesa(){
		List<DesaEntity> desaEntities = desaRepository.findAll();
		return desaEntities;
	}
	
	//get-byid
	@GetMapping("/get-desaById/{idDesa}")
	public ResponseEntity<?> getDesaById(@PathVariable Integer idDesa){
		DesaEntity desaEntity = desaRepository.findById(idDesa).get();
		return ResponseEntity.ok(desaEntity);
	}
	
	//POST
	@PostMapping("/post-desa")
	public ResponseEntity<?> postDesa(@RequestBody DesaDto dto){
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());
		KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(dto.getKodeKecamatan());
		DesaEntity desaEntity = convertToDesaEntity(dto);
		desaEntity.setProvinsiEntity(provinsiEntity);
		desaEntity.setKabupatenEntity(kabupatenEntity);
		desaEntity.setKecamatanEntity(kecamatanEntity);
		desaRepository.save(desaEntity);
		return ResponseEntity.ok(desaEntity);
	}
	
	//UPDATE
	@PutMapping("/update-desa/{idDesa}")
	public ResponseEntity<?> updateDesa(@PathVariable Integer idDesa,
			@RequestBody DesaDto dto){
		DesaEntity desaEntity = desaRepository.findById(idDesa).get();
		desaEntity.setNamaDesa(dto.getNamaDesa());
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaRepository.save(desaEntity);
		return ResponseEntity.ok(desaEntity);
	}
	
	//DELETE
	@DeleteMapping("/delete-desa/{idDesa}")
	public ResponseEntity<?> deleteDesa(@PathVariable Integer idDesa){
		DesaEntity desaEntity = desaRepository.findById(idDesa).get();
		desaRepository.delete(desaEntity);
		return ResponseEntity.ok(desaEntity);
	}
	
	//CONVERT METHOD
	public DesaEntity convertToDesaEntity(DesaDto dto) {
		DesaEntity desaEntity = new DesaEntity();
		desaEntity.setNamaDesa(dto.getNamaDesa());
		desaEntity.setKodeDesa(dto.getKodeDesa());
		return desaEntity;
	}
	}

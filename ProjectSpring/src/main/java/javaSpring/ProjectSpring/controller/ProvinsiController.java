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


import javaSpring.ProjectSpring.dto.ProvinsiDto;
import javaSpring.ProjectSpring.entity.ProvinsiEntity;
import service.ProvinsiServiceImpl;

@RestController
@RequestMapping("/provinsi")
public class ProvinsiController  {
	@Autowired
	private ProvinsiServiceImpl provinsiService;
	
	
	@GetMapping("get-all-provinsi")
	public List<ProvinsiEntity> getAllProvinsi(){
		List<ProvinsiEntity> provinsiEntities = provinsiService.getAllProvinsi();
		return provinsiEntities;
	}

//	@GetMapping("get-all-provinsi")
//	public ResponseEntity<?> getAllProvinsi(){
//		List<ProvinsiEntity> provinsiEntities = provinsiRepository.findAll();
//		return ResponseEntity.ok(provinsiEntities);
//	}
	
	@GetMapping("/get-provinsiById/{idProvinsi}")
	public ResponseEntity<?> getProvinsiById(@PathVariable Integer idProvinsi){
		ProvinsiEntity provinsiEntity = provinsiService.getProvinsiById(idProvinsi);
		return ResponseEntity.ok(provinsiEntity);
		
	}
	
	@PostMapping("/post-provinsi")
	public ResponseEntity<?> insertProvinsi(@RequestBody ProvinsiDto dto){
		ProvinsiEntity provinsiEntity = provinsiService.insertProvinsi(dto);
		return ResponseEntity.ok(provinsiEntity);
	}
	
	//UPDATE
	@PutMapping("/update-provinsi/{idProvinsi}")
	public ResponseEntity<?> updateProvinsi(@PathVariable Integer idProvinsi,
			@RequestBody ProvinsiDto dto){
		ProvinsiEntity provinsiEntity = provinsiService.updateProvinsi(dto, idProvinsi);
		return ResponseEntity.ok(provinsiEntity);
		
	}
	
	//DELETE
	@DeleteMapping("/delete-provinsi/{idProvinsi}")
	public ResponseEntity<?> deleteProvinsi(@PathVariable Integer idProvinsi){
		ProvinsiEntity provinsiEntity = provinsiService.deleteProvinsi(idProvinsi);
		return ResponseEntity.ok(provinsiEntity);
	}
	
	
	
	///CONVERT METHOD
	public ProvinsiEntity convertToProvinsiEntity(ProvinsiDto dto) {
		ProvinsiEntity provinsiEntity = new ProvinsiEntity();
		provinsiEntity.setNamaProvinsi(dto.getNamaProvinsi());
		provinsiEntity.setKodeProvinsi(dto.getKodeProvinsi());
		return provinsiEntity;
	}
}

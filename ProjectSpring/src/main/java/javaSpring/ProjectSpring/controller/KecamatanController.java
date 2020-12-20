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
import javaSpring.ProjectSpring.entity.KecamatanEntity;
import javaSpring.ProjectSpring.service.KecamatanServiceImpl;

@RestController
@RequestMapping("/kecamatan")
public class KecamatanController {
	@Autowired
	KecamatanServiceImpl kecamatanService;
	
	//GET-ALL
	@GetMapping("/get-all-kecamatan")
	public ResponseEntity<?> getAllKecamatan(){
		List<KecamatanEntity> kecamatanEntities = kecamatanService.getAllKecamatan();
		return ResponseEntity.ok(kecamatanEntities);
	}
	
	//GET-BY-ID
	@GetMapping("/get-kecamatanById/{idKecamatan}")
	public ResponseEntity<?> getKecamatanById(@PathVariable Integer idKecamatan){
		KecamatanEntity kecamatanEntity = kecamatanService.getKecamatanById(idKecamatan);
		return ResponseEntity.ok(kecamatanEntity);
	}
	
	//POST
	@PostMapping("/post-kecamatan")
	public ResponseEntity<?> insertKecamatan(@RequestBody KecamatanDto dto){
		KecamatanEntity kecamatanEntity = kecamatanService.insertKecamatan(dto);
		return ResponseEntity.ok(kecamatanEntity);
	}
	
	//UPDATE
	@PutMapping("/update-kecamatan/{idKecamatan}")
	public ResponseEntity<?> updateKecamatan(@PathVariable Integer idKecamatan,
			@RequestBody KecamatanDto dto){
		KecamatanEntity kecamatanEntity = kecamatanService.updateKecamatan(dto, idKecamatan);
		return ResponseEntity.ok(kecamatanEntity);
		
	}
	
	//DELETE
	@DeleteMapping("/delete-kecamatan/{idKecamatan}")
	public ResponseEntity<?> deleteKecamatan(@PathVariable Integer idKecamatan){
		KecamatanEntity kecamatanEntity = kecamatanService.deleteKecamatan(idKecamatan);
		return ResponseEntity.ok(kecamatanEntity);
	}

}

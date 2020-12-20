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
import javaSpring.ProjectSpring.service.DesaServiceImpl;

@RestController
@RequestMapping("/desa")
public class DesaController {
	@Autowired 
	private DesaServiceImpl desaService;
	
	//get-all
	@GetMapping("get-all-desa")
	public ResponseEntity<?> getAllDesa(){
		List<DesaEntity> desaEntities = desaService.getAllDesa();
		return ResponseEntity.ok(desaEntities);
	}
	
	//get-byid
	@GetMapping("/get-desaById/{idDesa}")
	public ResponseEntity<?> getDesaById(@PathVariable Integer idDesa){
		DesaEntity desaEntity = desaService.getDesaById(idDesa);
		return ResponseEntity.ok(desaEntity);
	}
	
	//POST
	@PostMapping("/post-desa")
	public ResponseEntity<?> postDesa(@RequestBody DesaDto dto){
		DesaEntity desaEntity = desaService.postDesa(dto);
		return ResponseEntity.ok(desaEntity);
	}
	
	//UPDATE
	@PutMapping("/update-desa/{idDesa}")
	public ResponseEntity<?> updateDesa(@PathVariable Integer idDesa,
			@RequestBody DesaDto dto){
		DesaEntity desaEntity = desaService.updateDesa(dto, idDesa);
		return ResponseEntity.ok(desaEntity);
	}
	
	//DELETE
	@DeleteMapping("/delete-desa/{idDesa}")
	public ResponseEntity<?> deleteDesa(@PathVariable Integer idDesa){
		DesaEntity desaEntity = desaService.deleteDesa(idDesa);
		return ResponseEntity.ok(desaEntity);
	}
	
}

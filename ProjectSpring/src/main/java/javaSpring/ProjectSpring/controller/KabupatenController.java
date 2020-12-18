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
import service.KabupatenServiceImpl;

@RestController
@RequestMapping("/kabupaten")
public class KabupatenController {

	@Autowired
	KabupatenServiceImpl kabupatenService;

	@GetMapping("/get-all-kabupaten")
	public ResponseEntity<?> getAllKabupaten(){
		List<KabupatenEntity> kabupatenEntities = kabupatenService.getAllKabupaten();
		return ResponseEntity.ok(kabupatenEntities);
	}
	
	@GetMapping("get-kabupatenById/{idKabupaten}")
	public ResponseEntity<?> getKabupatenById(@PathVariable Integer idKabupaten){
		KabupatenEntity kabupatenEntity = kabupatenService.getKabupatenId(idKabupaten);
		return ResponseEntity.ok(kabupatenEntity);
	}

	@PostMapping("/post-kabupaten")
	public ResponseEntity<?> insertKabupaten(@RequestBody KabupatenDto dto){
		KabupatenEntity kabupatenEntity = kabupatenService.insertKabupaten(dto);
		return ResponseEntity.ok(kabupatenEntity);
	}
	
	//UPDATE
	@PutMapping("/update-kabupaten/{idKabupaten}")
	public ResponseEntity<?> updateKabupaten(@PathVariable Integer idKabupaten,
			@RequestBody KabupatenDto dto){
		KabupatenEntity kabupatenEntity = kabupatenService.updateKabupaten(dto, idKabupaten);
		return ResponseEntity.ok(kabupatenEntity);
	}
	
	//DELETE
	@DeleteMapping("/delete-kabupaten/{idKabupaten}")
	public ResponseEntity<?> deleteKabupaten(@PathVariable Integer idKabupaten){
		KabupatenEntity kabupatenEntity = kabupatenService.deleteKabupaten(idKabupaten);
		return ResponseEntity.ok(kabupatenEntity);
	
	}

}

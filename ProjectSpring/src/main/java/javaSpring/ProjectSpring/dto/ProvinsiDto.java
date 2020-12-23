package javaSpring.ProjectSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvinsiDto {
	private Integer id;
	private String namaProvinsi;
	private String kodeProvinsi;
	private Integer status;
}

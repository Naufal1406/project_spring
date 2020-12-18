package javaSpring.ProjectSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesaDto {
	private Integer id;
	private String namaDesa;
	private String kodeDesa;
	private String kodeProvinsi;
	private String kodeKabupaten;
	private String kodeKecamatan;
}

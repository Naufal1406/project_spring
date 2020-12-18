package javaSpring.ProjectSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KecamatanDto {
	private Integer id;
	private String kodeKecamatan;
	private String namaKecamatan;
	private String kodeKabupaten;
	private String kodeProvinsi;
}

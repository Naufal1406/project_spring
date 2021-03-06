package javaSpring.ProjectSpring.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kecamatan_entity")
public class KecamatanEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "kode_kecamatan", unique = true, length = 50 , nullable = false)
	private String kodeKecamatan;
	
	@Column(name = "nama_kecamatan", length = 100, nullable = false)
	private String namaKecamatan;
	
	@ManyToOne
	@JoinColumn(name = "kode_kabupaten" , referencedColumnName = "kode_kabupaten")
	private KabupatenEntity kabupatenEntity;
	
	@ManyToOne
	@JoinColumn(name = "kode_provinsi", referencedColumnName = "kode_provinsi")
	private ProvinsiEntity provinsiEntity;

}
		
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
@Table (name = "desa_entity")
public class DesaEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Integer id;
	
	@Column (name = " nama_desa" , length = 100, nullable = false)
	private String namaDesa;
	
	@Column (name = "kode_desa", unique = true, length = 150, nullable = false)
	private String kodeDesa;
	
	@ManyToOne
	@JoinColumn(name = "kode_provinsi" , referencedColumnName = "kode_provinsi")
	private ProvinsiEntity provinsiEntity;
	
	@ManyToOne
	@JoinColumn(name = "kode_kabupaten", referencedColumnName = "kode_kabupaten")
	private KabupatenEntity kabupatenEntity;
	
	@ManyToOne
	@JoinColumn (name= "kode_kecamatan", referencedColumnName = "kode_kecamatan")
	private KecamatanEntity kecamatanEntity;
}

package javaSpring.ProjectSpring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "provinsi_entity")
public class ProvinsiEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Integer Id;
	
	@Column (name = "nama_provinsi", length = 50, nullable = false)
	private String namaProvinsi;
	
	@Column (name = "kode_provinsi", unique = true, length = 100)
	private String kodeProvinsi;
	
	@Column (name = "status")
	private Integer status = 1;
}

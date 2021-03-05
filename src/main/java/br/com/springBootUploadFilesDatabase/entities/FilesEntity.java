package br.com.springBootUploadFilesDatabase.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "files")
public class FilesEntity {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "DATA")
	@Lob
	private byte[] data;

	public FilesEntity() {
		
	}

	public FilesEntity(String name, String type, byte[] data) {
		this.name = name;
		this.type = type;
		this.data = data;
	}
}

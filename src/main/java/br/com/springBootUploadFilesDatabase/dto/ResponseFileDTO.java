package br.com.springBootUploadFilesDatabase.dto;

import lombok.Data;

@Data
public class ResponseFileDTO {

	private String id;
	private String name;
	private String url;
	private String type;
	private long size;

	public ResponseFileDTO(String id, String name, String url, String type, long size) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
	}
}

package br.com.springBootUploadFilesDatabase.dto;

import lombok.Data;

@Data
public class ResponseFileDTO {

	private String name;
	private String url;
	private String type;
	private long size;

	public ResponseFileDTO(String name, String url, String type, long size) {
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
	}
}

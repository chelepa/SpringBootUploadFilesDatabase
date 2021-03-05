package br.com.springBootUploadFilesDatabase.dto;

import lombok.Data;

@Data
public class ResponseMessageDTO {

	private String message;

	public ResponseMessageDTO(String message) {
		this.message = message;
	}
}

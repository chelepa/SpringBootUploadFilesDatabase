package br.com.springBootUploadFilesDatabase.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.springBootUploadFilesDatabase.dto.ResponseFileDTO;
import br.com.springBootUploadFilesDatabase.dto.ResponseMessageDTO;
import br.com.springBootUploadFilesDatabase.services.FileStorageService;

@Controller
@CrossOrigin("http://localhost:8081")
public class FileController {

	@Autowired
	private FileStorageService storageService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessageDTO> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(storageService.store(file));
	}

	@GetMapping("/files")
	public ResponseEntity<List<ResponseFileDTO>> getListFiles() {
		return ResponseEntity.status(HttpStatus.OK).body(storageService.getAllFiles());
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + storageService.getFile(id).getName() + "\"").body(storageService.getFile(id).getData());
	}

	@DeleteMapping("/files/{id}")
	public ResponseEntity<Void> deleteFileId(@PathVariable String id) {
	    return storageService.deleteById(id);
	}
}

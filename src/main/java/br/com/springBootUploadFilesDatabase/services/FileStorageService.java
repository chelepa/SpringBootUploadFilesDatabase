package br.com.springBootUploadFilesDatabase.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.springBootUploadFilesDatabase.dto.ResponseFileDTO;
import br.com.springBootUploadFilesDatabase.dto.ResponseMessageDTO;
import br.com.springBootUploadFilesDatabase.entities.FilesEntity;
import br.com.springBootUploadFilesDatabase.repositories.FilesEntityRepository;

@Service
public class FileStorageService {

	@Autowired
	private FilesEntityRepository filesEntityRepository;

	public ResponseMessageDTO store(MultipartFile file) throws IOException {
		try {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			filesEntityRepository.save(new FilesEntity(fileName, file.getContentType(), file.getBytes()));
			return new ResponseMessageDTO("Uploaded the file successfully: " + file.getOriginalFilename());
		} catch (Exception e) {
			return new ResponseMessageDTO("Could not upload the file: " + file.getOriginalFilename() + "!");
		}
	}

	public FilesEntity getFile(String id) {
		return filesEntityRepository.findById(id).get();
	}

	public List<ResponseFileDTO> getAllFiles() {

		Stream<FilesEntity> files = filesEntityRepository.findAll().stream();

		return files.map(dbFile -> {
			
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(dbFile.getId()).toUriString();

			return new ResponseFileDTO(dbFile.getId(), dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
			
		}).collect(Collectors.toList());
	}
}

package br.com.springBootUploadFilesDatabase.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.springBootUploadFilesDatabase.entities.FilesEntity;
import br.com.springBootUploadFilesDatabase.repositories.FilesEntityRepository;

@Service
public class FileStorageService {

  @Autowired
  private FilesEntityRepository filesEntityRepository;

  public FilesEntity store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FilesEntity FileDB = new FilesEntity(fileName, file.getContentType(), file.getBytes());

    return filesEntityRepository.save(FileDB);
  }

  public FilesEntity getFile(String id) {
    return filesEntityRepository.findById(id).get();
  }
  
  public Stream<FilesEntity> getAllFiles() {
    return filesEntityRepository.findAll().stream();
  }
}

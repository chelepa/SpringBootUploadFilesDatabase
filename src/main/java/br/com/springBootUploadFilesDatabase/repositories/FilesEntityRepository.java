package br.com.springBootUploadFilesDatabase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springBootUploadFilesDatabase.entities.FilesEntity;

public interface FilesEntityRepository extends JpaRepository<FilesEntity, String> {

}

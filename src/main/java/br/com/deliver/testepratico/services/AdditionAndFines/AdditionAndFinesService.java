package br.com.deliver.testepratico.services.AdditionAndFines;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesRequestDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesResponseDTO;
import br.com.deliver.testepratico.entities.AdditionAndFinesEntity;
import br.com.deliver.testepratico.exceptions.AdditionAndFinesNotFoundException;
import br.com.deliver.testepratico.repositories.AdditionAndFinesRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdditionAndFinesService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AdditionAndFinesRepository repository;

	public AdditionAndFinesResponseDTO createAdditionAndFines(AdditionAndFinesRequestDTO request) {
		log.info("AdditionAndFinesService.createAdditionAndFines - Start - AdditionAndFinesRequestDTO: [{}]", request);
		
		AdditionAndFinesEntity entity = modelMapper.map(request, AdditionAndFinesEntity.class);
		
		repository.save(entity);
		
		AdditionAndFinesResponseDTO response = modelMapper.map(entity, AdditionAndFinesResponseDTO.class);
		
		log.info("AdditionAndFinesService.createAdditionAndFines - End - AdditionAndFinesResponseDTO: [{}]", response);
		
		return response;
	}
	
	public List<AdditionAndFinesResponseDTO> getAllAdditionAndFines() {
		log.debug("AdditionAndFinesService.getAllAdditionAndFines - start - ");
		
		List<AdditionAndFinesResponseDTO> response = new ArrayList<>();
		
		repository.findAll().forEach(entity -> response.add(AdditionAndFinesEntityTOAdditionAndFinesResponseDTO(entity)));
		
		log.debug("AdditionAndFinesService.getAllAdditionAndFines - end - response: [{}]", response);
		
		return response;
	}

	public AdditionAndFinesResponseDTO getAdditionAndFinesId(Integer id) {
		log.debug("AdditionAndFinesService.getAdditionAndFinesId - Start - id: {}", id);
		
		AdditionAndFinesEntity entity = getAdditionAndFinesEntity(id);
		
		AdditionAndFinesResponseDTO response = AdditionAndFinesEntityTOAdditionAndFinesResponseDTO(entity);
		
		log.debug("AdditionAndFinesService.getAdditionAndFinesId - End - AdditionAndFinesResponseDTO: [{}]", response);
		
		return response;
	}
	
	public ResponseEntity<Void> deleteAdditionAndFinesId(Integer id) {
		log.info("AdditionAndFinesService.deleteAdditionAndFinesId - Start - id: {}", id);
		
		AdditionAndFinesEntity entity = getAdditionAndFinesEntity(id);
		
		repository.delete(entity);
		
		log.debug("AdditionAndFinesService.deleteAdditionAndFinesId - End - id: {}, AdditionAndFinesEntity: {}",id, entity);
		log.info("AdditionAndFinesService.deleteAdditionAndFinesId - End - id: {}", id);
		
		return ResponseEntity.noContent().build();
	}
	
	public AdditionAndFinesResponseDTO updateAdditionAndFines(Integer id, AdditionAndFinesResponseDTO request) {
		log.info("AdditionAndFinesService.updateAdditionAndFines - Start - request: {}", request);
		
		AdditionAndFinesEntity entity = getAdditionAndFinesEntity(id);
		request.setId(id);

		modelMapper.map(request, entity);
		repository.save(entity);
		
		System.out.println(entity);
		AdditionAndFinesResponseDTO response = AdditionAndFinesEntityTOAdditionAndFinesResponseDTO(entity);
		
		log.info("AdditionAndFinesService.updateAdditionAndFines - End - response: {}", response);
		
		return response;
	}
	
	public AdditionAndFinesResponseDTO getAdditionAndFinesByDaysOfDelay(String daysOfDelay) {
		log.debug("AdditionAndFinesService.getAdditionAndFinesByDaysOfDelay - Start - DaysOfDelay: {}", daysOfDelay);
		
		AdditionAndFinesEntity entity = repository.findByDaysOfDelay(daysOfDelay);
		
		AdditionAndFinesResponseDTO response = AdditionAndFinesEntityTOAdditionAndFinesResponseDTO(entity);
		
		log.debug("AdditionAndFinesService.getAdditionAndFinesByDaysOfDelay - End - AdditionAndFinesResponseDTO: [{}]", response);
		
		return response;
	}
	
	private AdditionAndFinesEntity getAdditionAndFinesEntity(Integer id) {		
		return repository.findById(id).orElseThrow(
				() -> new AdditionAndFinesNotFoundException(String.format("Addition And Fines Entity Not Found - id: %s ",id)));
	}
	
	private AdditionAndFinesResponseDTO AdditionAndFinesEntityTOAdditionAndFinesResponseDTO(AdditionAndFinesEntity entity) {
		AdditionAndFinesResponseDTO response = modelMapper.map(entity, AdditionAndFinesResponseDTO.class);
		return response;
	}
}

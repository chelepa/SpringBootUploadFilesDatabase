package br.com.deliver.testepratico.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesRequestDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesResponseDTO;
import br.com.deliver.testepratico.services.PracticeTestService;
import br.com.deliver.testepratico.services.PracticeTestServiceImpl;

@RestController
public class AdditionAndFinesController {
	
	@Autowired
	private PracticeTestService practiceTestService;
	
    @PostMapping(value = "/v1/AdditionAndFines")
    public ResponseEntity<AdditionAndFinesResponseDTO> createAdditionAndFines(@Valid @RequestBody AdditionAndFinesRequestDTO request) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(practiceTestService.createAdditionAndFines(request));
    }
    
    @GetMapping(value = "/v1/AdditionAndFines")
    public ResponseEntity<List<AdditionAndFinesResponseDTO>> queryAllAdditionAndFines() {
    	return ResponseEntity.status(HttpStatus.OK).body(practiceTestService.getAllAdditionAndFines());
    }
    
    @GetMapping(value = "/v1/AdditionAndFines/{id}")
    public ResponseEntity<AdditionAndFinesResponseDTO> queryAdditionAndFinesId(@PathVariable(value = "id", required = true) Integer id) {
    	return ResponseEntity.status(HttpStatus.OK).body(practiceTestService.getAdditionAndFinesId(id));
    }
    
    @DeleteMapping(value = "/v1/AdditionAndFines/{id}")
    public ResponseEntity<Void> deleteAdditionAndFinesId(@PathVariable(value = "id", required = true) Integer id) {
		return practiceTestService.deleteAdditionAndFinesId(id);
    }
    
    @PutMapping(value = "/v1/AdditionAndFines/{id}")
    public ResponseEntity<AdditionAndFinesResponseDTO> updateAdditionAndFinesId(@PathVariable(value = "id", required = true) Integer id, @Valid @RequestBody AdditionAndFinesResponseDTO request) {
    	return ResponseEntity.status(HttpStatus.OK).body(practiceTestService.updateAdditionAndFines(id, request));
    }
}

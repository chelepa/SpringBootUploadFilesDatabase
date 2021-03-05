package br.com.deliver.testepratico.services.AdditionAndFines;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.deliver.testepratico.constants.Constantes;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesResponseDTO;
import br.com.deliver.testepratico.exceptions.AdditionAndFinesNotFoundException;
import br.com.deliver.testepratico.repositories.AdditionAndFinesRepository;
import builder.TestePraticoBuilder;

@RunWith(MockitoJUnitRunner.class)
public class AdditionAndFinesServiceTest {
	
	private static final Integer ID = 1;
	
	@Spy
	private ModelMapper modelMapper;
	
	@Mock
	private AdditionAndFinesRepository repository;
	
	@InjectMocks
	private AdditionAndFinesService additionAndFinesService;
	
	@Test
	public void ShouldPartnersStatusMessageDTO_When_createAdditionAndFines() {
		AdditionAndFinesResponseDTO response = additionAndFinesService.createAdditionAndFines(TestePraticoBuilder.MockAdditionAndFinesRequest());
		Assert.assertEquals(Constantes.ATE_3_DIAS, response.getDaysOfDelay());
	}
	
	@Test
	public void ShouldListAdditionAndFinesResponseDTO_When_getAllAdditionAndFines() {
		when(repository.findAll()).thenReturn(TestePraticoBuilder.mockEntitiesListAdditionAndFinesResponse());
		List<AdditionAndFinesResponseDTO> response = additionAndFinesService.getAllAdditionAndFines();
		Assert.assertEquals(1, response.size());
	}
	
	@Test
	public void ShouldAdditionAndFinesResponseDTO_When_getAdditionAndFinesId() {
		when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(TestePraticoBuilder.MockAdditionAndFinesEntityResponse()));
		AdditionAndFinesResponseDTO response = additionAndFinesService.getAdditionAndFinesId(ID);
		Assert.assertEquals(Constantes.ATE_3_DIAS, response.getDaysOfDelay());
	}
	
	@Test
	public void ShouldAdditionAndFinesResponseDTO_When_getAdditionAndFinesByDaysOfDelay() {
		when(repository.findByDaysOfDelay(Mockito.anyString())).thenReturn(TestePraticoBuilder.MockAdditionAndFinesEntityResponse());
		AdditionAndFinesResponseDTO response = additionAndFinesService.getAdditionAndFinesByDaysOfDelay(Constantes.ATE_3_DIAS);
		Assert.assertEquals(Constantes.ATE_3_DIAS, response.getDaysOfDelay());
	}
	
	@Test
	public void ShouldAdditionAndFinesResponseDTO_When_updateAdditionAndFines() {
		when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(TestePraticoBuilder.MockAdditionAndFinesEntityResponse()));
		AdditionAndFinesResponseDTO response = additionAndFinesService.updateAdditionAndFines(ID, TestePraticoBuilder.MockAdditionAndFinesResponse());
		Assert.assertEquals(Constantes.ATE_3_DIAS, response.getDaysOfDelay());
	}
	
	@Test
	public void ShouldReturnNoContent_When_deleteAdditionAndFinesId() {
		when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(TestePraticoBuilder.MockAdditionAndFinesEntityResponse()));
		ResponseEntity<Void> response = additionAndFinesService.deleteAdditionAndFinesId(ID);
		Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test(expected = AdditionAndFinesNotFoundException.class)
	public void ExpectedAdditionAndFinesNotFoundException_When_getAdditionAndFinesId() {
		when(repository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		additionAndFinesService.getAdditionAndFinesId(ID);
	}
	

}

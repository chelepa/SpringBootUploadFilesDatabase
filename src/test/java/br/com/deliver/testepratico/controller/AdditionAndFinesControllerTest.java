package br.com.deliver.testepratico.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.deliver.testepratico.controllers.AdditionAndFinesController;
import br.com.deliver.testepratico.services.PracticeTestService;
import br.com.deliver.testepratico.utils.TestUtil;
import builder.TestePraticoBuilder;

@RunWith(MockitoJUnitRunner.class)
public class AdditionAndFinesControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private PracticeTestService practiceTestService;
	
	@InjectMocks
	private AdditionAndFinesController AdditionAndFinesController;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(AdditionAndFinesController).build();
	}
	
	@Test
	public void ValidateStatus_CREATED_When_CreateAdditionAndFines() throws Exception{
		when(practiceTestService.createAdditionAndFines(Mockito.any())).thenReturn(TestePraticoBuilder.MockAdditionAndFinesResponse());
		
        MockHttpServletResponse response = mockMvc.perform(post("/v1/AdditionAndFines").contentType(MediaType.APPLICATION_JSON)
        		.content(TestUtil.mapToJson(TestePraticoBuilder.MockAdditionAndFinesRequest())))
        		.andReturn().getResponse();
        
        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_OK_When_queryAllAdditionAndFines() throws Exception{
		when(practiceTestService.getAllAdditionAndFines()).thenReturn(new ArrayList<>());
		
		MockHttpServletResponse response = mockMvc.perform(get("/v1/AdditionAndFines").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_OK_When_queryAdditionAndFinesId() throws Exception{
		when(practiceTestService.getAdditionAndFinesId(Mockito.any())).thenReturn(TestePraticoBuilder.MockAdditionAndFinesResponse());
		
		MockHttpServletResponse response = mockMvc.perform(get("/v1/AdditionAndFines/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_NO_CONTENT_When_deleteAdditionAndFinesId() throws Exception{
		Mockito.when(practiceTestService.deleteAdditionAndFinesId(Mockito.anyInt())).thenReturn(ResponseEntity.noContent().build());
		
        MockHttpServletResponse response = mockMvc.perform(delete("/v1/AdditionAndFines/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_OK_When_updateJurosMultasId() throws Exception{
		Mockito.when(practiceTestService.updateAdditionAndFines(Mockito.anyInt(), Mockito.any())).thenReturn(TestePraticoBuilder.MockAdditionAndFinesResponse());
		
        MockHttpServletResponse response = mockMvc.perform(put("/v1/AdditionAndFines/1").contentType(MediaType.APPLICATION_JSON)
        		.content(TestUtil.mapToJson(TestePraticoBuilder.MockAdditionAndFinesRequest()))).andReturn().getResponse();
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
}

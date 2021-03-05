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

import br.com.deliver.testepratico.controllers.PaymentAccountController;
import br.com.deliver.testepratico.services.PracticeTestService;
import br.com.deliver.testepratico.utils.TestUtil;
import builder.TestePraticoBuilder;

@RunWith(MockitoJUnitRunner.class)
public class PaymentAccountControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private PracticeTestService practiceTestService;
	
	@InjectMocks
	private PaymentAccountController paymentAccountController;

	@Before
    public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(paymentAccountController).build();
    }
	
	@Test
	public void ValidateStatus_OK_When_queryPaymentAccountId() throws Exception{
		when(practiceTestService.getPaymentAccountId(Mockito.any())).thenReturn(TestePraticoBuilder.MockPaymentAccountResponse());
		
		MockHttpServletResponse response = mockMvc.perform(get("/v1/Payment/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_OK_When_queryAllPaymentAccount() throws Exception{
		when(practiceTestService.getAllPaymentAccount()).thenReturn(new ArrayList<>());
		
		MockHttpServletResponse response = mockMvc.perform(get("/v1/Payment").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_NO_CONTENT_When_deletePaymentAccountId() throws Exception{
		Mockito.when(practiceTestService.deletePaymentAccountId(Mockito.anyInt())).thenReturn(ResponseEntity.noContent().build());
		
        MockHttpServletResponse response = mockMvc.perform(delete("/v1/Payment/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_CREATED_When_createNewPaymentAccount() throws Exception{
		Mockito.when(practiceTestService.createPaymentAccount(Mockito.any())).thenReturn(TestePraticoBuilder.MockPaymentAccountResponse());
        MockHttpServletResponse response = mockMvc.perform(post("/v1/Payment").contentType(MediaType.APPLICATION_JSON)
        		.content(TestUtil.readJsonFile("builder/json/PaymentAccountRequest.json"))).andReturn().getResponse();
        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
	
	@Test
	public void ValidateStatus_OK_When_updatePaymentAccountId() throws Exception{
		Mockito.when(practiceTestService.updatePaymentAccount(Mockito.anyInt(), Mockito.any())).thenReturn(TestePraticoBuilder.MockPaymentAccountResponse());
        MockHttpServletResponse response = mockMvc.perform(put("/v1/Payment/1").contentType(MediaType.APPLICATION_JSON)
        		.content(TestUtil.readJsonFile("builder/json/PaymentAccountRequest.json"))).andReturn().getResponse();
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}

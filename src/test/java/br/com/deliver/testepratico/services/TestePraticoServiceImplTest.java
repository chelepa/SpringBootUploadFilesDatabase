package br.com.deliver.testepratico.services;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.deliver.testepratico.dto.Account.PaymentAccountResponseDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesResponseDTO;
import br.com.deliver.testepratico.services.AdditionAndFines.AdditionAndFinesService;
import br.com.deliver.testepratico.services.PaymentAccount.PaymentAccountService;
import builder.TestePraticoBuilder;

@RunWith(MockitoJUnitRunner.class)
public class TestePraticoServiceImplTest {
	
	private static final Integer ID = 1;
	private static final String NAME_PAYMENT = "Pagamento de Gas";

	@Mock
	private AdditionAndFinesService additionAndFinesService;
	
	@Mock
	private PaymentAccountService paymentAccountService;
	
	@InjectMocks
	private PracticeTestServiceImpl practiceTestServiceImpl;
	
	@Test
	public void ShouldReturnJurosMultasResponse_When_createAdditionAndFines() throws IOException {
	  when(additionAndFinesService.createAdditionAndFines(Mockito.any())).thenReturn(TestePraticoBuilder.MockAdditionAndFinesResponse());
	  AdditionAndFinesResponseDTO response = practiceTestServiceImpl.createAdditionAndFines(TestePraticoBuilder.MockAdditionAndFinesRequest());
	  Assert.assertEquals(ID, response.getId());
	}
	
    @Test
    public void ShouldReturnListJurosMultasResponse_When_getAllAdditionAndFines() throws IOException {
  	  when(additionAndFinesService.getAllAdditionAndFines()).thenReturn(TestePraticoBuilder.mockListAdditionAndFinesResponse());
  	  List<AdditionAndFinesResponseDTO> response = practiceTestServiceImpl.getAllAdditionAndFines();
      Assert.assertEquals(1, response.size());
    } 
    
    @Test
    public void ShouldReturnJurosMultasResponse_When_getAdditionAndFinesId() throws IOException {
    	when(additionAndFinesService.getAdditionAndFinesId(Mockito.anyInt())).thenReturn(TestePraticoBuilder.MockAdditionAndFinesResponse());
    	AdditionAndFinesResponseDTO response = practiceTestServiceImpl.getAdditionAndFinesId(ID);
        Assert.assertEquals(ID, response.getId());
    }
    
    @Test
    public void ShouldReturnVoid_When_deleteAdditionAndFinesId() throws IOException {
    	when(additionAndFinesService.deleteAdditionAndFinesId(Mockito.anyInt())).thenReturn(ResponseEntity.noContent().build());
		ResponseEntity<Void> response = practiceTestServiceImpl.deleteAdditionAndFinesId(ID);
		Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
    
    @Test
    public void ShouldJurosMultasResponse_When_updateAdditionAndFines() throws IOException {
    	when(additionAndFinesService.updateAdditionAndFines(Mockito.any(), Mockito.any())).thenReturn(TestePraticoBuilder.MockAdditionAndFinesResponse());
    	AdditionAndFinesResponseDTO response = practiceTestServiceImpl.updateAdditionAndFines(ID, TestePraticoBuilder.MockAdditionAndFinesResponse());
		Assert.assertEquals(ID, response.getId());
    }
    
    @Test
    public void ShouldReturnContasPagamentoResponse_When_createPaymentAccount() throws IOException {
    	when(paymentAccountService.createPayment(Mockito.any())).thenReturn(TestePraticoBuilder.MockPaymentAccountResponse());
    	PaymentAccountResponseDTO response = practiceTestServiceImpl.createPaymentAccount(TestePraticoBuilder.MockPaymentAccountRequest());
		Assert.assertEquals(NAME_PAYMENT, response.getName());
    }
    
    @Test
    public void ShouldListContasPagamentoResponse_When_getAllPaymentAccount() throws IOException {
    	when(paymentAccountService.getAllPaymentAccount()).thenReturn(TestePraticoBuilder.mockListPaymentAccountResponse());
		List<PaymentAccountResponseDTO> response = practiceTestServiceImpl.getAllPaymentAccount();
		Assert.assertEquals(1, response.size());
    }
    
    @Test
    public void ShouldContasPagamentoResponse_When_getPaymentAccountId() throws IOException {
    	when(paymentAccountService.getPaymentById(Mockito.anyInt())).thenReturn(TestePraticoBuilder.MockPaymentAccountResponseId());
    	PaymentAccountResponseDTO response = practiceTestServiceImpl.getPaymentAccountId(ID);
		Assert.assertEquals(ID, response.getId());
    }
    
    @Test
    public void ShouldResponseVoid_When_deletePaymentAccountId() throws IOException {
    	when(paymentAccountService.deletePaymentById(Mockito.anyInt())).thenReturn(ResponseEntity.noContent().build());
    	ResponseEntity<Void>  response = practiceTestServiceImpl.deletePaymentAccountId(ID);
    	Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
    
    @Test
    public void ShouldContasPagamentoResponse_When_updatePaymentAccount() throws IOException {
    	when(paymentAccountService.updatePaymentById(Mockito.any(), Mockito.any())).thenReturn(TestePraticoBuilder.MockPaymentAccountResponseId());
    	PaymentAccountResponseDTO  response = practiceTestServiceImpl.updatePaymentAccount(ID, TestePraticoBuilder.MockPaymentAccountRequest());
    	Assert.assertEquals(ID, response.getId());
    }
	
}
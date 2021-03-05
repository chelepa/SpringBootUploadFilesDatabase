package br.com.deliver.testepratico.services.PaymentAccount;

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

import br.com.deliver.testepratico.dto.Account.PaymentAccountResponseDTO;
import br.com.deliver.testepratico.repositories.PaymentAccountRepository;
import br.com.deliver.testepratico.services.AdditionAndFines.AdditionAndFinesService;
import builder.TestePraticoBuilder;

@RunWith(MockitoJUnitRunner.class)
public class PaymentAccountServiceTest {
	
	private static final String NAME_PAYMENT = "Pagamento de Gas";
	private static final Integer ID = 1;
	
	@Spy
	private ModelMapper modelMapper;

	@Mock
	private PaymentAccountRepository repository;
	
	@Mock
	private AdditionAndFinesService additionAndFinesService;
	
	@InjectMocks
	private PaymentAccountService paymentAccountService;
	
	@Test
	public void ShouldPaymentAccountResponseDTO_When_createPayment() {
		when(additionAndFinesService.getAdditionAndFinesByDaysOfDelay(Mockito.anyString())).thenReturn(TestePraticoBuilder.MockAdditionAndFinesResponse());
		PaymentAccountResponseDTO response = paymentAccountService.createPayment(TestePraticoBuilder.MockPaymentAccountRequest());
		Assert.assertEquals(NAME_PAYMENT, response.getName());
	}
	
	@Test
	public void ShouldListPaymentAccountResponseDTO_When_getAllPaymentAccount() {
		when(repository.findAll()).thenReturn(TestePraticoBuilder.mockListPaymentAccountEntityResponse());
		List<PaymentAccountResponseDTO> response = paymentAccountService.getAllPaymentAccount();
		Assert.assertEquals(1, response.size());
	}
	
	@Test
	public void ShouldPaymentAccountResponseDTO_When_getPaymentById() {
		when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(TestePraticoBuilder.MockPaymentAccountEntityResponse()));
		PaymentAccountResponseDTO response = paymentAccountService.getPaymentById(ID);
		Assert.assertEquals(NAME_PAYMENT, response.getName());
	}
	
	@Test
	public void ShouldReturnNoContent_When_deletePaymentById() {
		when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(TestePraticoBuilder.MockPaymentAccountEntityResponse()));
		ResponseEntity<Void> response = paymentAccountService.deletePaymentById(ID);
		Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test
	public void ShouldPaymentAccountResponseDTO_When_updatePaymentById() {
		when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(TestePraticoBuilder.MockPaymentAccountEntityResponse()));
		when(additionAndFinesService.getAdditionAndFinesByDaysOfDelay(Mockito.anyString())).thenReturn(TestePraticoBuilder.MockAdditionAndFinesResponse());
		PaymentAccountResponseDTO response = paymentAccountService.updatePaymentById(ID, TestePraticoBuilder.MockPaymentAccountRequest());
		Assert.assertEquals(NAME_PAYMENT, response.getName());
	}
	

}

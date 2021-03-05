package br.com.deliver.testepratico.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.deliver.testepratico.dto.Account.PaymentAccountRequestDTO;
import br.com.deliver.testepratico.dto.Account.PaymentAccountResponseDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesRequestDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesResponseDTO;

public interface PracticeTestService {

	AdditionAndFinesResponseDTO createAdditionAndFines(AdditionAndFinesRequestDTO additionAndFinesRequestDTO);
	
	List<AdditionAndFinesResponseDTO> getAllAdditionAndFines();
	
	AdditionAndFinesResponseDTO getAdditionAndFinesId(Integer id);
	
	ResponseEntity<Void> deleteAdditionAndFinesId(Integer id);
	
	AdditionAndFinesResponseDTO updateAdditionAndFines(Integer id, AdditionAndFinesResponseDTO additionAndFinesResponseDTO);
	
	PaymentAccountResponseDTO createPaymentAccount(PaymentAccountRequestDTO paymentAccountRequestDTO);
	
	List<PaymentAccountResponseDTO> getAllPaymentAccount();
	
	PaymentAccountResponseDTO getPaymentAccountId(Integer id);
	
	ResponseEntity<Void> deletePaymentAccountId(Integer id);
	
	PaymentAccountResponseDTO updatePaymentAccount(Integer id, PaymentAccountRequestDTO paymentAccountRequestDTO);
	
}

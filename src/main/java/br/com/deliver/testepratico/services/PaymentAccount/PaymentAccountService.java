package br.com.deliver.testepratico.services.PaymentAccount;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.deliver.testepratico.dto.Account.PaymentAccountRequestDTO;
import br.com.deliver.testepratico.dto.Account.PaymentAccountResponseDTO;
import br.com.deliver.testepratico.entities.PaymentAccountEntity;
import br.com.deliver.testepratico.exceptions.PaymentAccountNotFoundException;
import br.com.deliver.testepratico.repositories.PaymentAccountRepository;
import br.com.deliver.testepratico.services.BaseService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentAccountService extends BaseService {
		
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PaymentAccountRepository repository;
	
	public PaymentAccountResponseDTO createPayment(PaymentAccountRequestDTO paymentAccountRequestDTO) {
		
		log.info("PaymentAccountService.createPayment - Start - PaymentAccountRequestDTO: [{}]", paymentAccountRequestDTO);
		
		PaymentAccountResponseDTO paymentAccount = populatepaymentAccountResponse(paymentAccountRequestDTO);
		
		PaymentAccountEntity entity = modelMapper.map(paymentAccount, PaymentAccountEntity.class);
		
		repository.save(entity);
		
		PaymentAccountResponseDTO response = converterItemEntityTOItemDTO(entity);
		
		log.info("PaymentAccountService.createPayment - End - PaymentAccountResponseDTO: [{}]", response);
		
		return response;
	}
	
	public List<PaymentAccountResponseDTO> getAllPaymentAccount() {
		
		log.debug("PaymentAccountService.getAllPaymentAccount - Start");
		
		List<PaymentAccountResponseDTO> response = new ArrayList<>();
		
		repository.findAll().forEach(itemEntity -> response.add(converterItemEntityTOItemDTO(itemEntity)));
		
		log.debug("PaymentAccountService.getAllPaymentAccount - End - response: [{}]", response);
		
		return response;
	}

	public PaymentAccountResponseDTO getPaymentById(Integer id) {
		
		log.info("PaymentAccountResponseDTO.getPaymentById - Start - ID: [{}]", id);
		
		PaymentAccountEntity paymentAccountEntity = paymentById(id);
		
		PaymentAccountResponseDTO response = converterItemEntityTOItemDTO(paymentAccountEntity);
		
		log.info("PaymentAccountResponseDTO.getPaymentById - Start - PaymentAccountResponseDTO: [{}]", response);
		
		return response;
	}

	public ResponseEntity<Void> deletePaymentById(Integer id) {
		
		log.info("PaymentAccountResponseDTO.deletePaymentById - Start - ID: [{}]", id);
		
		PaymentAccountEntity paymentAccountEntity = paymentById(id);
		
		repository.delete(paymentAccountEntity);
		
		log.debug("PaymentAccountResponseDTO.deletePaymentById - End - PaymentAccountEntity: [{}]", paymentAccountEntity);
		
		log.info("PaymentAccountResponseDTO.deletePaymentById - End - id: [{}]", id);
		
		return ResponseEntity.noContent().build();
	}
	
	public PaymentAccountResponseDTO updatePaymentById(Integer id, PaymentAccountRequestDTO paymentAccountRequestDTO) {
		
		paymentById(id);
		
		paymentAccountRequestDTO.setId(id);
		
		PaymentAccountResponseDTO paymentAccount = populatepaymentAccountResponse(paymentAccountRequestDTO);
		
		PaymentAccountEntity entity = modelMapper.map(paymentAccount, PaymentAccountEntity.class);
		
		repository.save(entity);
		
		PaymentAccountResponseDTO response = converterItemEntityTOItemDTO(entity);
		
		return response;
	}
	
	private PaymentAccountResponseDTO converterItemEntityTOItemDTO(PaymentAccountEntity itemEntity) {
		PaymentAccountResponseDTO response = modelMapper.map(itemEntity, PaymentAccountResponseDTO.class);
		return response;
	}
	
	private PaymentAccountEntity paymentById(Integer id) {
		return repository.findById(id).orElseThrow(
				() -> new PaymentAccountNotFoundException(String.format("Payment Account Entity Not Found - id: %s ",id)));
	}
}

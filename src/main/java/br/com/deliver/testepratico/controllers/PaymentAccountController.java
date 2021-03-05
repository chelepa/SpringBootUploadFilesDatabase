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

import br.com.deliver.testepratico.dto.Account.PaymentAccountRequestDTO;
import br.com.deliver.testepratico.dto.Account.PaymentAccountResponseDTO;
import br.com.deliver.testepratico.services.PracticeTestService;

@RestController
public class PaymentAccountController {
	
	@Autowired
	private PracticeTestService practiceTestService;
	
	@PostMapping(value = "/v1/Payment")
	public ResponseEntity<PaymentAccountResponseDTO> createNewPaymentAccount(@RequestBody PaymentAccountRequestDTO request) {
		System.out.println(request);
    	return ResponseEntity.status(HttpStatus.CREATED).body(practiceTestService.createPaymentAccount(request));
    }
	
	@GetMapping(value = "/v1/Payment")
    public ResponseEntity<List<PaymentAccountResponseDTO>> queryAllPaymentAccount() {
    	return ResponseEntity.status(HttpStatus.OK).body(practiceTestService.getAllPaymentAccount());
    }
	
    @GetMapping(value = "/v1/Payment/{id}")
    public ResponseEntity<PaymentAccountResponseDTO> queryPaymentAccountId(@PathVariable(value = "id" , required = true) Integer id) {
    	return ResponseEntity.status(HttpStatus.OK).body(practiceTestService.getPaymentAccountId(id));
    }
    
    @DeleteMapping(value = "/v1/Payment/{id}")
    public ResponseEntity<Void> deletePaymentAccountId(@PathVariable(value = "id" , required = true) Integer id) {
		return practiceTestService.deletePaymentAccountId(id);
    }
    
    @PutMapping(value = "/v1/Payment/{id}")
    public ResponseEntity<PaymentAccountResponseDTO> updatePaymentAccountId(@PathVariable(value = "id", required = true) Integer id, @Valid @RequestBody PaymentAccountRequestDTO request){
    	return ResponseEntity.status(HttpStatus.OK).body(practiceTestService.updatePaymentAccount(id, request));
    }
}

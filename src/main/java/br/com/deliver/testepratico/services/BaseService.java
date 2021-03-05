package br.com.deliver.testepratico.services;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.deliver.testepratico.constants.Constantes;
import br.com.deliver.testepratico.dto.Account.PaymentAccountRequestDTO;
import br.com.deliver.testepratico.dto.Account.PaymentAccountResponseDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesResponseDTO;
import br.com.deliver.testepratico.services.AdditionAndFines.AdditionAndFinesService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseService {
	
	@Autowired
	private AdditionAndFinesService additionAndFinesService;
	
	private String regra;

	public PaymentAccountResponseDTO populatepaymentAccountResponse(PaymentAccountRequestDTO request) {	
		int days = lateDays(request.getDayOfDue(),request.getDayOfPayment());
		PaymentAccountResponseDTO paymentAccount = new PaymentAccountResponseDTO();
		
		if (request.getId() != null) {
			paymentAccount.setId(request.getId());
		}
		
		paymentAccount.setName(request.getName());
		paymentAccount.setPrice(request.getPrice());
		paymentAccount.setPriceAdjusted(calculateNewPriceAdjuested(request , days));
		paymentAccount.setDaysDelay(days);
		paymentAccount.setPaymentDate(request.getDayOfPayment());
		return paymentAccount;
	}
	
	private Double calculateNewPriceAdjuested(PaymentAccountRequestDTO request, int days) {
		AdditionAndFinesDTO additionAndFines = searchRules(days);
		double value = request.getPrice();
	    double percentage = (additionAndFines.getAddition() / 100.0) * value;
	    double percentageDay = ((additionAndFines.getAdditionPerDay() * days) / 100.0) * value;
	    double Amount = value + percentage + percentageDay;
		return Amount;
	}

	private AdditionAndFinesDTO searchRules(Integer lateDays) {
		AdditionAndFinesDTO response = new AdditionAndFinesDTO();
		
		if (lateDays < 3) {
			regra = Constantes.ATE_3_DIAS.toString();
		} else if (lateDays > 3 && lateDays <= 5 ) {
			regra = Constantes.SUPERIOR_A_3_DIAS.toString();
		} else if (lateDays > 5) {
			regra = Constantes.SUPERIOR_A_5_DIAS.toString();
		}
		
		AdditionAndFinesResponseDTO additionAndFines = additionAndFinesService.getAdditionAndFinesByDaysOfDelay(regra);
		response.setAddition(additionAndFines.getAddition());
		response.setAdditionPerDay(additionAndFines.getAdditionTheDay());
		return response;
	}

	private Integer lateDays(LocalDate paymentDate, LocalDate dayOfDue) {
		log.info("BaseService.lateDays - Start - paymentDate: {}, dueDate: {} ", paymentDate, dayOfDue);
		
		Period period = Period.between(paymentDate, dayOfDue);
		
		log.info("BaseService.lateDays - End - Periodo: {}", period.getDays());
		
		return period.getDays();
	}
}

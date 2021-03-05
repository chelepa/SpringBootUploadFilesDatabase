package builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.deliver.testepratico.constants.Constantes;
import br.com.deliver.testepratico.dto.Account.PaymentAccountRequestDTO;
import br.com.deliver.testepratico.dto.Account.PaymentAccountResponseDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesRequestDTO;
import br.com.deliver.testepratico.dto.Addition.AdditionAndFinesResponseDTO;
import br.com.deliver.testepratico.entities.AdditionAndFinesEntity;
import br.com.deliver.testepratico.entities.PaymentAccountEntity;

public class TestePraticoBuilder {
	
	public static AdditionAndFinesResponseDTO MockAdditionAndFinesResponse() {
		AdditionAndFinesResponseDTO response = new AdditionAndFinesResponseDTO();
		response.setId(1);
		response.setDaysOfDelay("até 3 dias");
		response.setAddition(2);
		response.setAdditionTheDay(0.1);
		return response;
	}
	
	public static AdditionAndFinesRequestDTO MockAdditionAndFinesRequest() {
		AdditionAndFinesRequestDTO response = new AdditionAndFinesRequestDTO();
		response.setDaysOfDelay("até 3 dias");
		response.setAddition(2);
		response.setAdditionTheDay(0.1);
		return response;
	}
	
	public static PaymentAccountResponseDTO MockPaymentAccountResponse() {
		LocalDate DayOfPayment = LocalDate.of(2020, 12, 12);
		PaymentAccountResponseDTO response = new PaymentAccountResponseDTO();
		response.setName("Pagamento de Gas");
		response.setPrice(10.5);
		response.setPriceAdjusted(10.72);
		response.setDaysDelay(1);
		response.setPaymentDate(DayOfPayment);
		return response;
	}
	
	public static PaymentAccountResponseDTO MockPaymentAccountResponseId() {
		LocalDate DayOfPayment = LocalDate.of(2020, 12, 12);
		PaymentAccountResponseDTO response = new PaymentAccountResponseDTO();
		response.setId(1);
		response.setName("Pagamento de Gas");
		response.setPrice(10.5);
		response.setPriceAdjusted(10.72);
		response.setDaysDelay(1);
		response.setPaymentDate(DayOfPayment);
		return response;
	}
	
	public static PaymentAccountRequestDTO MockPaymentAccountRequest() {
		LocalDate DayOfPayment = LocalDate.of(2020, 12, 12);
		LocalDate DayOfDue = LocalDate.of(2020, 12, 10);
		PaymentAccountRequestDTO response = new PaymentAccountRequestDTO();
		response.setName("Pagamento de Gas");
		response.setPrice(10.5);
		response.setDayOfPayment(DayOfPayment);
		response.setDayOfDue(DayOfDue);
		return response;
	}
	
	public static AdditionAndFinesEntity MockAdditionAndFinesEntityResponse() {
		AdditionAndFinesEntity response = new AdditionAndFinesEntity();
		response.setId(1);
		response.setDaysOfDelay(Constantes.ATE_3_DIAS);
		response.setAddition(2);
		response.setAdditionTheDay(0.1);
		return response;
	}
	
	public static PaymentAccountEntity MockPaymentAccountEntityResponse() {
		LocalDate DayOfPayment = LocalDate.of(2020, 12, 12);
		PaymentAccountEntity response = new PaymentAccountEntity();
		response.setId(1);
		response.setName("Pagamento de Gas");
		response.setPrice(10.5);
		response.setPriceAdjusted(10.72);
		response.setDaysDelay(1);
		response.setPaymentDate(DayOfPayment);
		return response;
	}
	
	public static List<PaymentAccountEntity> mockListPaymentAccountEntityResponse() {
		List<PaymentAccountEntity> lst = new ArrayList<>();
		lst.add(MockPaymentAccountEntityResponse());
		return lst;
	}
	
	public static List<AdditionAndFinesResponseDTO> mockListAdditionAndFinesResponse() {
		List<AdditionAndFinesResponseDTO> lst = new ArrayList<>();
		lst.add(MockAdditionAndFinesResponse());
		return lst;
	}
	
	public static List<PaymentAccountResponseDTO> mockListPaymentAccountResponse() {
		List<PaymentAccountResponseDTO> lst = new ArrayList<>();
		lst.add(MockPaymentAccountResponse());
		return lst;
	}
	
	public static List<AdditionAndFinesEntity> mockEntitiesListAdditionAndFinesResponse() {
		List<AdditionAndFinesEntity> lst = new ArrayList<>();
		lst.add(MockAdditionAndFinesEntityResponse());
		return lst;
	}
	
}

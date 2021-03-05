package br.com.deliver.testepratico.dto.Account;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentAccountResponseDTO {

	private Integer id;
	
	private String name;
	
	private Double price;
	
	@DecimalMin("0.00")
	private Double priceAdjusted;
	
	private Integer daysDelay;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate paymentDate;
}
package br.com.deliver.testepratico.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "payment_account")
public class PaymentAccountEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "VALUE_ORIGINAL")
	private Double price;
	
	@Column(name = "VALUE_ADJUSTED")
	private Double priceAdjusted;
	
	@Column(name = "DAYS_OF_DELAY")
	private Integer daysDelay;
	
	@Column(name = "PAYMENT_DATE")
	private LocalDate paymentDate;
}
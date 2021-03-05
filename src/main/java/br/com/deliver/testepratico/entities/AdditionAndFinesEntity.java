package br.com.deliver.testepratico.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "addition_and_fines")
public class AdditionAndFinesEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "DAYS_OF_DELAY")
	private String daysOfDelay;
	
	@Column(name = "ADDITION")
	private Integer addition;
	
	@Column(name = "ADDITION_THE_DAY")
	private Double additionTheDay;
	
}

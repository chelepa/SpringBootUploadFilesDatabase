package br.com.deliver.testepratico.dto.Addition;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdditionAndFinesRequestDTO {
	
	@NotNull
	@NotEmpty
	private String daysOfDelay;

	@NotNull
	private Integer addition;

	@NotNull
	private Double additionTheDay;
	
}

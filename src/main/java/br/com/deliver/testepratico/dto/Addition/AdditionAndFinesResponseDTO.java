package br.com.deliver.testepratico.dto.Addition;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdditionAndFinesResponseDTO {
	
	private Integer id;
	private String daysOfDelay;
	private Integer addition;
	private Double additionTheDay;
	
}

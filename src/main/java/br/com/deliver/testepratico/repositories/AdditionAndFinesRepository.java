package br.com.deliver.testepratico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deliver.testepratico.entities.AdditionAndFinesEntity;

@Repository
public interface AdditionAndFinesRepository extends JpaRepository<AdditionAndFinesEntity, Integer>{

	AdditionAndFinesEntity findByDaysOfDelay(String daysOfDelay);
}

package br.com.deliver.testepratico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deliver.testepratico.entities.PaymentAccountEntity;

@Repository
public interface PaymentAccountRepository extends JpaRepository<PaymentAccountEntity, Integer>{

}

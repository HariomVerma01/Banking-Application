package com.example.Easy.Local.Bank.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Easy.Local.Bank.DomainModel.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

	Optional<Customer> findByEmail(String email);
}

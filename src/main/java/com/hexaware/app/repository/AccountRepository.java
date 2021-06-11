package com.hexaware.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.app.model.Account;



public interface AccountRepository extends JpaRepository<Account,Long>{
	Account findByEmailAndPassword(String email,String password);
}

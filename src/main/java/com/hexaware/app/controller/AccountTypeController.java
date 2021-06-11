package com.hexaware.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hexaware.app.model.AccountType;
import com.hexaware.app.repository.AccountTypeRepository;
@RestController
@RequestMapping("/accounttype")
public class AccountTypeController {
	
	
		@Autowired
		private AccountTypeRepository accounttypeRepository;
		@GetMapping("/all")
		public List<AccountType> findAllAccount() {
			return accounttypeRepository.findAll();
		}

		@GetMapping("/single/{id}") // localhost:port/customer/single/6
		public AccountType findSingleAccount(@PathVariable("id") Long aid) {
			return accounttypeRepository.getById(aid);
		}

		@PostMapping("/add")
		public AccountType postAccount(@RequestBody AccountType accounttype) {
			return accounttypeRepository.save(accounttype);
		}

		@PutMapping("/edit/{id}")
		public AccountType putAccount(@PathVariable("id")Long aid,@RequestBody AccountType newValueAccount) {
			//go to db and fetch customer based on ID.
			AccountType dbAccount=accounttypeRepository.getById(aid);
			dbAccount.setType(newValueAccount.getType());
			
			
			
			return accounttypeRepository.save(dbAccount);
		}

		@DeleteMapping("/delete/{id}")
		public void deleteAccount(@PathVariable("id")Long aid ) {
			accounttypeRepository.deleteById(aid);
		}
		
		@PutMapping("/credit/{aid}/{balance}")
		public AccountType putCustomer(@PathVariable("id") Long aid,@PathVariable Long balance, @RequestBody AccountType newValueAccount ) {
			AccountType dbAccount=accounttypeRepository.getById(aid);
			
			dbAccount.setAmount(dbAccount.getAmount()+ balance);
			return accounttypeRepository.save(dbAccount);
			
		}
		
		@PutMapping("/debit/{id}/{balance}")
		public AccountType debitCustomerAmount(@PathVariable("id") Long id,@PathVariable Long balance, @RequestBody AccountType newValueAccount ) {
			AccountType dbAccount=accounttypeRepository.getById(id);
			
			dbAccount.setAmount(dbAccount.getAmount()- balance);
			return accounttypeRepository.save(dbAccount);
			
		}

}

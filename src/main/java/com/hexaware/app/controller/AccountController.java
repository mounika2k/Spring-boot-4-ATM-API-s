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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.app.model.Account;
import com.hexaware.app.model.AccountType;
import com.hexaware.app.repository.AccountRepository;
import com.hexaware.app.repository.AccountTypeRepository;






@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountTypeRepository accounttypeRepository;
	
	@GetMapping("/all")
	public List<Account> findAllAccount() {
		return accountRepository.findAll();
	}

	@GetMapping("/single/{id}") // localhost:port/customer/single/6
	public Account findSingleAccount(@PathVariable("id") Long aid) {
		return accountRepository.getById(aid);
	}

	@PostMapping("/add")
	public Account postAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}

	@PutMapping("/edit/{id}")
	public Account putAccount(@PathVariable("id")Long aid,@RequestBody Account newValueAccount) {
		//go to db and fetch customer based on ID.
		Account dbAccount=accountRepository.getById(aid);
		dbAccount.setName(newValueAccount.getName());
		dbAccount.setEmail(newValueAccount.getEmail());
		dbAccount.setAddress(newValueAccount.getAddress());
		dbAccount.setPassword(newValueAccount.getPassword());
		
		
		return accountRepository.save(dbAccount);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteAccount(@PathVariable("id")Long aid ) {
		accountRepository.deleteById(aid);
	}
	@PostMapping("/accounttype/assign/{aid}/{atid}")
	public Account assignAccountToAccountType(@PathVariable("aid") Long aid,@PathVariable("atid") Long atid) {
		Account account=accountRepository.getById(aid);
		AccountType accounttype=accounttypeRepository.getById(atid);
		List<AccountType> AccountList=account.getAccounttype();
		AccountList.add(accounttype);
		return accountRepository.save(account);
		
		}
	@GetMapping("/details/{email}/{password}")
	public Account getAccountDetails(@PathVariable("email")String email,@PathVariable("password")String password){
		return accountRepository.findByEmailAndPassword(email,password);
	}
}

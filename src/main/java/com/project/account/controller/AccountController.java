package com.project.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.account.model.Account;
import com.project.account.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/account/{accID}")
	public ResponseEntity<Account> getAccount(@PathVariable int accID) {
		Account ac = accountService.getAccount(accID);
		return new ResponseEntity<Account>(ac, HttpStatus.OK);
	}

	@PostMapping("/account")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		Account acc = accountService.addAccount(account);
		return new ResponseEntity<Account>(acc, HttpStatus.OK);
	}

	@PutMapping("/account/{id}")
	public ResponseEntity<Account> editAccount(@PathVariable int id, @RequestBody Account account) {
		Account acc = accountService.updateAccount(account, id);
		return new ResponseEntity<>(acc, HttpStatus.OK);
	}

}

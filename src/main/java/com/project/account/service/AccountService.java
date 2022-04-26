package com.project.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.account.dao.AccountRepository;
import com.project.account.model.Account;

@Service
public class AccountService {
	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private AccountRepository accountRepository;

	public Account addAccount(Account account) {
		Account acco =  accountRepository.save(account);
		acco.setMessage("add account");
		
		restTemplate.exchange("http://localhost:8080//notify/useradded", HttpMethod.POST, null, Account.class);
		return acco;
	}
	
	public Account updateAccount(Account account, int id) {
		Account acc = accountRepository.findById(id).get();
		   acc.setAccBalance(account.getAccBalance());
		   acc.setName(account.getName());
		   Account accou = accountRepository.save(acc);
		   accou.setMessage("updated user details");
		   restTemplate.exchange("http://localhost:8080//notify/useradded", HttpMethod.POST, null, Account.class);
		   return accou;
	}

	public Account getAccount(int accID) {
		return accountRepository.getById(accID);
	}
}

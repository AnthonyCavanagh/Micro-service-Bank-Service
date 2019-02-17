package com.cav.spring.service.bank.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cav.spring.service.bank.model.account.AccountRequest;
import com.cav.spring.service.bank.model.account.Accounts;
import com.cav.spring.service.bank.model.bank.BankRequest;
import com.cav.spring.service.bank.model.bank.Banks;
import com.cav.spring.service.bank.model.fund.FundRequest;
import com.cav.spring.service.bank.model.fund.Funds;
import com.cav.spring.service.bank.service.AccountService;
import com.cav.spring.service.bank.service.BankService;
import com.cav.spring.service.bank.service.FundService;



@RestController
@RequestMapping("/bankservice")
public class BankServiceController {


	@Autowired
	BankService bankService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	FundService fundService;
	
	@RequestMapping(value = "/")
	public String home() {
		   return "Bank Service";
	 }
	
	private static final Logger logger = LoggerFactory.getLogger(BankServiceController.class);	


	@RequestMapping(value = "/findbanks/", method = RequestMethod.POST)
	public Banks findBanks(@RequestBody BankRequest request) {
		logger.info("Find Banks");
		Banks banks = bankService.listBanks(request.getBankIds());
		return banks;
	}
	
	
	@RequestMapping(value = "/findaccounts/", method = RequestMethod.POST)
	public Accounts findAccounts(@RequestBody AccountRequest request) {
		logger.info("Find Accounts");
		Accounts accounts = accountService.listAccounts(request.getAccountIds());
		return accounts;
	}
	
	@RequestMapping(value = "/findfunds/", method = RequestMethod.POST)
	public Funds findFunds(@RequestBody FundRequest request) {
		logger.info("Find Funds");
		Funds funds = fundService.listFunds(request.getFundIds());
		return funds;
	}
	
}

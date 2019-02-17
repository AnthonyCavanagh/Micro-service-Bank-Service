package com.cav.spring.service.bank.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.cav.spring.service.bank.service.AccountService;
import com.cav.spring.service.bank.service.BankService;
import com.cav.spring.service.bank.service.FundService;
import com.fasterxml.jackson.core.JsonProcessingException;

public class BankServiceControllerTest extends AbstractControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	BankService bankService;
	
	@MockBean
	AccountService accountService;
	
	@MockBean
	FundService fundService;
	
	@Test
	public void findBankTest() throws Exception{
		String uri = "/bankservice/findbanks/";
		String inputJson;
			inputJson = super.mapToJson(createBankRequest());
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			         .contentType(MediaType.APPLICATION_JSON_UTF8)
			         .content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
		    assertEquals(200, status);
	}
	
	@Test
	public void findAccountTest() throws Exception{
		String uri = "/bankservice/findaccounts/";
		String inputJson;
			inputJson = super.mapToJson(createAccountRequest());
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			         .contentType(MediaType.APPLICATION_JSON_UTF8)
			         .content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
		    assertEquals(200, status);
	}
	
	@Test
	public void findFundTest() throws Exception{
		String uri = "/bankservice/findfunds/";
		String inputJson;
			inputJson = super.mapToJson(createFundRequest());
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			         .contentType(MediaType.APPLICATION_JSON_UTF8)
			         .content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
		    assertEquals(200, status);
	}
}

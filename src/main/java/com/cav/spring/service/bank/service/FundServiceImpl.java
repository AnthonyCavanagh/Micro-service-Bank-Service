package com.cav.spring.service.bank.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cav.spring.service.bank.controller.BankServiceController;
import com.cav.spring.service.bank.entity.Fund;
import com.cav.spring.service.bank.model.bank.BankId;
import com.cav.spring.service.bank.model.fund.FundId;
import com.cav.spring.service.bank.model.fund.FundPOJO;
import com.cav.spring.service.bank.model.fund.Funds;
import com.cav.spring.service.bank.repository.FundRepository;

@Service
public class FundServiceImpl extends MappEntitiesAbstract implements FundService {
	
	@Autowired
	FundRepository repository;
	
	private static final Logger logger = LoggerFactory.getLogger(FundServiceImpl.class);	

	@Override
	public void updateFunds(Funds funds) {
		List<Fund> entities = new ArrayList<Fund>();
		List<FundPOJO> fundList = funds.getFundList();
		for(FundPOJO fund : fundList){
			Fund fundEntity = repository.findOne(fund.getFundId());
			if(fundEntity != null){
				entities.add(updateFundEntity(fund, fundEntity));
			} else {
				//error
			}
		}
		repository.save(entities);
	}

	@Override
	public Funds listFunds(List<FundId> fundIds) {
		List<Fund> funds = new ArrayList<Fund>();
		for(FundId fundId : fundIds){
			logger.debug("Extracting fund from repo "+fundId.getId());
			funds.add(repository.findOne(fundId.getId()));
		}
		return mapFunds(funds);
	}

	@Override
	public void removeFunds(List<FundId> fundIds) {
		for(FundId fundId : fundIds){
			repository.delete(fundId.getId());
		}
	}
	
}

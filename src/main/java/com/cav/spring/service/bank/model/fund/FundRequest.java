package com.cav.spring.service.bank.model.fund;

import java.util.ArrayList;
import java.util.List;

public class FundRequest {
	
	private Long clientId;
	private List <FundId> fundIds = new ArrayList<FundId>();	

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public List<FundId> getFundIds() {
		return fundIds;
	}

	public void setFundIds(List<FundId> fundIds) {
		this.fundIds = fundIds;
	}

}

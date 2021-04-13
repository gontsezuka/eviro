package com.eviro.assessment.grad001.gontsemochoana.model;

import java.math.BigDecimal;

public class CurrentAccount extends Accounts{
	
	BigDecimal overdraftLimit;
	
	
	public void withdraw(String accountNum,BigDecimal amountToWithdraw)
	{
		
	}
	
	public void setOverdraftLimit(BigDecimal overdraftLimit)
	{
		this.overdraftLimit = overdraftLimit;
	}
	
	public BigDecimal getOverdraftLimit()
	{
		return this.overdraftLimit;
	}
	

}

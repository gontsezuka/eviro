package com.eviro.assessment.grad001.gontsemochoana.model;

import java.math.BigDecimal;

import com.eviro.assessment.grad001.gontsemochoana.systemdb.SystemDB;

public class CurrentAccount extends Accounts{
	
	private static final BigDecimal MAXIMUM_OVERDRAFT_LIMIT= new BigDecimal("100000");
	private BigDecimal overdraftLimit;
	private SystemDB systemDB;
	
	public CurrentAccount()
	{
		systemDB = SystemDB.getInstance();
	}
	
	public void withdraw(String accountNum,BigDecimal amountToWithdraw)
	{
		systemDB.withdrawFromCurrentAccount(Integer.parseInt(accountNum), amountToWithdraw);
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

package com.eviro.assessment.grad001.gontsemochoana.model;

import java.math.BigDecimal;

import com.eviro.assessment.grad001.gontsemochoana.systemdb.SystemDB;

public class SavingsAccount extends Accounts {

	
	private final BigDecimal MINIMUM_BALANCE = new BigDecimal("1000");
	
	public SavingsAccount()
	{
		
	}
	
	public void withdraw(String accountNum,BigDecimal amountToWithdraw)
	{
		
		SystemDB systemDB = SystemDB.getInstance();
		systemDB.withdrawFromSavingsAccount(1, amountToWithdraw);
	}
	
	public BigDecimal getMinimumBalance()
	{
		return this.MINIMUM_BALANCE;
	}
}

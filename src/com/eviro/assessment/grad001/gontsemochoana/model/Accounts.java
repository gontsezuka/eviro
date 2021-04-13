package com.eviro.assessment.grad001.gontsemochoana.model;

import java.math.BigDecimal;
import com.eviro.assessment.grad001.gontsemochoana.interfaces.AccountService;

public abstract class Accounts implements AccountService {
	
	int id;
	int accountNum;
	String customerNum;
	BigDecimal balance;
	
	public void calculateInterest()
	{
		
	}

	public void deposit()
	{
		
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setAccountNum(int accountNum)
	{
		this.accountNum=accountNum;
	}
	
	public int getAccountNum()
	{
		return this.accountNum;
	}
	
	public void setCustomerNum(String customerNum)
	{
		this.customerNum = customerNum;
	}
	
	public String getCustomerNum()
	{
		return this.customerNum;
	}
	
	
	public void setBalance(BigDecimal balance)
	{
		this.balance = balance;
	}
	
	
	public BigDecimal getBalance()
	{
		return this.balance;
	}
}

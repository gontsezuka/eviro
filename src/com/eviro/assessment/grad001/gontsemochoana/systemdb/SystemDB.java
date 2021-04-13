package com.eviro.assessment.grad001.gontsemochoana.systemdb;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.eviro.assessment.grad001.gontsemochoana.model.CurrentAccount;
import com.eviro.assessment.grad001.gontsemochoana.model.SavingsAccount;

/**
 * SINGLETON CLASS FOR ACCOUNTS
 * @author zukaLover
 *
 */
public class SystemDB {

	
	private static SystemDB firstInstance = null;
	private Set<SavingsAccount> savingsList = new HashSet<>();
	private Set<CurrentAccount> currentList = new HashSet<>();
	
	private SystemDB()
	{
		
	}
	
	public static SystemDB getInstance()
	{
		/**
		 * LAZY INSTANTIATION
		 */
		if(firstInstance == null)
		{
			firstInstance = new SystemDB();
		}
		
		return firstInstance;
	}
	
	public void setSavingsAccounts(Set<SavingsAccount> savingsList)
	{
		firstInstance.savingsList.addAll(savingsList);
	}
	
	public void setCurrentAccounts(Set<CurrentAccount> currentList)
	{
		firstInstance.currentList.addAll(currentList);
	}
	
	
	public CurrentAccount getCurrentAccount(String customerNum,int accountNum)
	{
		CurrentAccount accReturn = new CurrentAccount();
		
		for(CurrentAccount acc: firstInstance.currentList)
		{
			if(acc.getAccountNum()==accountNum && acc.getCustomerNum()==customerNum)
			{
				accReturn = acc;
			}
		}
		return accReturn;
	}
	
	
	
	public SavingsAccount getSavingsAccount(int accountNum)
	{
		SavingsAccount accReturn = new SavingsAccount();
		
		for(SavingsAccount acc: firstInstance.savingsList)
		{
			if(acc.getAccountNum()==accountNum)
			{
				accReturn = acc;
			}
		}
		
		return accReturn;
	}
	
	public void withdrawFromSavingsAccount(int accountNum,BigDecimal amountToWithdraw)
	{
		
		for(SavingsAccount acc: firstInstance.savingsList)
		{
			if(acc.getAccountNum()==1)
			{
				System.out.println("FOUND");

				//TAKE OUT MINIMUM BALANCE
				BigDecimal amountLeft = acc.getBalance().subtract(acc.getMinimumBalance());
				
				System.out.println(amountLeft.toString()); 
				//IF AMOUNT LEFT IS LESS GREATER THAN MINIMUM THEN CONTINUE
				int res = amountLeft.compareTo(acc.getMinimumBalance());
				
				if(res==1 || res==0)
				{
					/**
					 * IT MEANS AMOUNT LEFT IS GREATER THAN MINIMUM BALANCE
					 */
					System.out.println("WE CAN WITHDRAW"); 
					
					int toWithdraw = amountLeft.compareTo(amountToWithdraw);
					//IF amount left is equal or greater than amount to withdraw continue
					if(toWithdraw ==0 || toWithdraw ==1)
					{
						/**
						 * WE CAN WITHDRAW
						 */
						BigDecimal newBalance= acc.getBalance().subtract(amountToWithdraw);
						acc.setBalance(newBalance);
						System.out.println("WITHDRAWAL SUCCESSFUL");
					}else {
						/**
						 * THROW EXCEPTION
						 */
						System.out.println("WITHDRAWAL UNSUCCESSFUL-EXCEPTION THROWN LARGE AMOUNT");

					}
					
				}
			}else {
				System.out.println("WITHDRAWAL UNSUCCESSFUL-ACCOUNT NOT AVAILABLE");

			}
		}//END LOOP
	}//END METHOD
}

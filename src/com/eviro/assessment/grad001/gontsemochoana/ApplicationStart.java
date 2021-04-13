package com.eviro.assessment.grad001.gontsemochoana;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.eviro.assessment.grad001.gontsemochoana.model.CurrentAccount;
import com.eviro.assessment.grad001.gontsemochoana.model.SavingsAccount;
import com.eviro.assessment.grad001.gontsemochoana.systemdb.SystemDB;

public class ApplicationStart {

	public static void main(String[] args)
	{
		/**
		 * SINGLETON 
		 */
		SystemDB systemDB = SystemDB.getInstance();
		
		/**
		 * SAVINGS ACCOUNT DATA
		 */
		Set<SavingsAccount> setSavings = new HashSet<>();
		SavingsAccount sav1 = new SavingsAccount();
		sav1.setAccountNum(1);
		sav1.setId(101);
		sav1.setCustomerNum("402111");
		sav1.setBalance(new BigDecimal("2000"));
		setSavings.add(sav1);
		
		
		SavingsAccount sav2 = new SavingsAccount();
		sav2.setId(102);
		sav2.setAccountNum(2);
		sav2.setBalance(new BigDecimal(5000));
		sav2.setCustomerNum("402112");
		setSavings.add(sav2);
		
		
		systemDB.setSavingsAccounts(setSavings);
		
		/**
		 * CURRENT ACCOUNT DATA
		 */
		Set<CurrentAccount> setCurrent = new HashSet<>();
		CurrentAccount sav3 = new CurrentAccount();
		sav3.setOverdraftLimit(new BigDecimal("10000"));
		sav3.setBalance(new BigDecimal("1000"));
		sav3.setId(103);
		sav3.setAccountNum(3);
		sav3.setCustomerNum("402113");
		setCurrent.add(sav3);
		
		
		CurrentAccount sav4 = new CurrentAccount();
		sav4.setOverdraftLimit(new BigDecimal("20000"));
		sav4.setBalance(new BigDecimal("5000").negate());
		sav4.setAccountNum(4);
		sav4.setId(104);
		sav4.setCustomerNum("402114");
		setCurrent.add(sav4);
		
		systemDB.setCurrentAccounts(setCurrent);
		
		
		CurrentAccount curr = new CurrentAccount();
		SavingsAccount sav = new SavingsAccount();
		
		sav = systemDB.getSavingsAccount(Integer.parseInt("1"));
		curr = systemDB.getCurrentAccount(4);
	
		//WORKING FOR SAVINGS ACCOUNT
//		System.out.println("Customer:"+sav.getCustomerNum()+ " - account:"+sav.getAccountNum() +" - Balance:"+ sav.getBalance());
//		
//	
//		sav.withdraw("1", new BigDecimal("200"));
//		
//		
//		SavingsAccount savv = new SavingsAccount();
//		savv = systemDB.getSavingsAccount(Integer.parseInt("1"));
//		System.out.println("Customer:"+savv.getCustomerNum()+ " - account:"+savv.getAccountNum() +" - Balance:"+ savv.getBalance());
		
		//CURRENT ACCOUNT
		
		System.out.println("Customer: "+ curr.getCustomerNum()+" - account: "+curr.getAccountNum()+" - Balance: "+ curr.getBalance()+" - overdraft limit: "+ curr.getOverdraftLimit());
		System.out.println("Max withdrawal =R"+(curr.getBalance().add(curr.getOverdraftLimit())));
		System.out.println("----------------------------------------------------------------");
		curr.withdraw("4", new BigDecimal("10000"));
		
		CurrentAccount  curr2 = new CurrentAccount();
		curr2 = systemDB.getCurrentAccount(4);
		
		System.out.println("Customer: "+ curr2.getCustomerNum()+" - account: "+curr2.getAccountNum()+" - Balance: "+ curr2.getBalance()+" - overdraft limit: "+ curr2.getOverdraftLimit());
		System.out.println("Max withdrawal =R"+(curr2.getBalance().add(curr2.getOverdraftLimit())));
	}
		
	
	public static void loadAccounts()
	{
		/**
		 * SAVINGS ACCOUNT DATA
		 */
		Set<SavingsAccount> setSavings = new HashSet<>();
		SavingsAccount sav1 = new SavingsAccount();
		sav1.setAccountNum(1);
		sav1.setId(101);
		sav1.setCustomerNum("402111");
		sav1.setBalance(new BigDecimal("2000"));
		setSavings.add(sav1);
		
		SavingsAccount sav2 = new SavingsAccount();
		sav2.setId(102);
		sav2.setAccountNum(2);
		sav2.setBalance(new BigDecimal(5000));
		sav2.setCustomerNum("402112");
		setSavings.add(sav2);
		
		/**
		 * CURRENT ACCOUNT DATA
		 */
		Set<CurrentAccount> setCurrent = new HashSet<>();
		CurrentAccount sav3 = new CurrentAccount();
		sav3.setOverdraftLimit(new BigDecimal("10000"));
		sav3.setBalance(new BigDecimal("1000"));
		sav3.setId(103);
		sav3.setAccountNum(3);
		sav3.setCustomerNum("402113");
		setCurrent.add(sav3);
		
		
		CurrentAccount sav4 = new CurrentAccount();
		sav4.setOverdraftLimit(new BigDecimal("20000"));
		sav4.setBalance(new BigDecimal("-5000"));
		sav4.setAccountNum(4);
		sav4.setId(104);
		sav4.setCustomerNum("402114");
		setCurrent.add(sav4);
		
		
	}
}

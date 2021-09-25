package Task_1.task2;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


abstract class Accounts {
	protected Customer customer;
	protected String Account_Number;
	protected double Balance;
	protected String DateCreated;
	private static Integer idx=0;
	protected ArrayList<DateTimeFormatter> transactionDate;
	protected ArrayList<Double> transactionAmount;
	protected ArrayList<Double> transactionBalance;
	
	
	public Accounts() {
		customer=new Customer();
		Account_Number="\0";
		Balance=0;
		DateCreated="\0";
		transactionDate=new ArrayList<DateTimeFormatter>();
		transactionAmount = new ArrayList<Double>();
		transactionBalance = new ArrayList<Double>();
			
	}
	public Accounts(Customer customer,double balance){
		//customer = new Customer(customer_id);
		this.customer = new Customer(customer.getName(),customer.getAddress(), customer.getNumber());
		idx++;
		Account_Number = idx.toString();
		Balance = balance;
		//DateCreated = dateCreated;
		transactionDate=new ArrayList<DateTimeFormatter>();
		transactionAmount = new ArrayList<Double>();
		transactionBalance = new ArrayList<Double>();
			
		}

	public int getId() {
	return customer.getId();	
	}
	
	
	public String getAccno() {
		return Account_Number;	
		}
	
	public double getbalance() {
		return Balance;	
		}
	
	public String getdate() {
		return DateCreated;	
		}
	public void makeDeposit(double amount) {
		if(amount<=0) {
		throw new IllegalArgumentException("Cannot deposit 0 amount");
		}
		Balance+=amount;
	}
	public abstract void makeWithdrawal(double amount);
	
	public void checkBalance() {
		System.out.println("name"+customer.getName());
		System.out.println("balance"+ Balance);
	}
	public void printStatement() {
		System.out.println("id"+customer.getId());
		System.out.println("name"+customer.getName());
		System.out.println("address"+customer.getAddress());
		System.out.println("Number"+customer.getNumber());
		LocalDateTime now = LocalDateTime.now();  
		for(int i=0;i<transactionAmount.size();++i) {
			System.out.println( "Transaction amount: " +  transactionAmount.get(i));
			System.out.println( "balance remaining: " +  transactionBalance.get(i));
			System.out.println( "Date of Transaction: " +  transactionDate.get(i).format(now));
			 
		} 
	}
	public void transferAmount(double amount,String bank) {
		if(amount>Balance)
			throw new IllegalArgumentException("Cannot transfer negative balance");
		if(Balance>=amount) {
			Balance-=amount;
			System.out.println("bank"+bank);					
		}
		else {
			System.out.println("insufficient");
		}
	}
	public abstract void displayAllDeductions();
	
}

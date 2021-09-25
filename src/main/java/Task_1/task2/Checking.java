package Task_1.task2;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Checking extends Accounts {

	private int free_transactions;
	private ArrayList<Integer>tax_record;
	public Checking() {
		free_transactions =0;
		tax_record = new ArrayList<Integer>();
	}
	public Checking(Customer customer,double Balance)  {
		super(customer,Balance);
		if(customer.getcheckings()==false) {
			customer.setChk(true);
		free_transactions = 1;
		
		tax_record = new ArrayList<Integer>();
		}
		else
			throw new IllegalArgumentException("Savings acc already exists");

	}
	
	@Override
	public void makeWithdrawal(double amount) {
		// TODO Auto-generated method stub
		if(amount>Balance+5000)
			throw new IllegalArgumentException("Amount cannot be withdrawn");
		if(amount<=Balance) {
			Balance-=amount;
		}
		else if(amount>Balance && amount<5000) {
			Balance-=amount;	
		}
		else {
			System.out.println("Cannot withdraw more than 5000");
		}
		if (free_transactions>=2) {
			Balance-=10;
		}
		free_transactions++;
		transactionAmount.add(amount);
		transactionBalance.add(Balance);
		tax_record.add(transactionAmount.size()-1);
		transactionDate.add(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss") );
	}
	
	

	@Override
	public void displayAllDeductions() {
		// TODO Auto-generated method stub
		System.out.println("Tax of Rs:10.00 applied on withdrawals :");
		for(int i=0;i<tax_record.size();i++) {
			System.out.println("amount withdrawn: " + transactionAmount.get(tax_record.get(i)));
			System.out.println("remaining balance: " + transactionBalance.get(tax_record.get(i)));
		
	}
	

	}
}


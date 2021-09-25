package Task_1.task2;

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);
   	    int choice ;
   	     int Index=-1;
   	 ArrayList<Accounts>List = new ArrayList<Accounts>();
   	   
    	do {
        System.out.println( "Choose a single command" );
        System.out.println( "Press 1 to open an account " );
        System.out.println( "Press 2 to login to an account " );
        System.out.println( "Press 3 for interest rate in Savings account only" );
        System.out.println( "Press 4 for all account details" );
        System.out.println( "Press 5 for all account deductions" );
        System.out.print("Press 0");
   	    choice = scanner.nextInt();

        if(choice<1 || choice>7) {
        	//System.out.print("Invalid input");	
        	throw new IllegalArgumentException("Invalid input");
        }
        if(choice==1) {
        	 String name="\0";
		     String address="\0";
		   	 String number="\0";
		   	 double Balance=0;
		   
        	int choose=0;
        	//boolean cs;
        	do {
        	System.out.println("Which account would you like to open?");
        	System.out.println("Press 1 for checking and Press 2 for savings");
        	choose = scanner.nextInt();
        	scanner.nextLine();
        	System.out.println("Enter the name of the customer");
 			 name = scanner.nextLine();
 			 System.out.println("Enter your address");
 			 address = scanner.nextLine();
 			 System.out.println("Enter number");
 			 number = scanner.nextLine(); 
 			System.out.println("Enter balance");
			 Balance = scanner.nextInt(); 
        	}while(choose<1&&choose>2);
        	if(choose==1) {
        	List.add(new Checking(new Customer(name,address,number),Balance));
        	}
        	else {
        	List.add(new Savings(new Customer(name,address,number),Balance));
        	}
        }
		
		 if(choice==2) {
			 scanner.nextLine();
			 int i;
			 String accno="\0";
			 System.out.println("Enter Account#: ");
			 accno=scanner.nextLine();
			 for(i=0;i<List.size();i++) {
				 if(List.get(i).getAccno().equals(accno)) {
						Index = i;
						break;
					}
				}
			  
			 int choosee=0;
			boolean flag=true;
			while(flag) {
			do{System.out.println("Select the account operations");
		   	System.out.println("Enter 1 to deposit");
		 	System.out.println("Enter 2 to withdraw"); 			
 		    System.out.println("Enter 3 to check balance");
 		    System.out.println("Enter 4 to print statement");
 		    System.out.println("Enter 5 to transfer amount");
 		    System.out.println("Enter 6 to calculate zakat");
 		    
			  choosee =scanner.nextInt();}
			while (choosee<1&&choosee>6);
			if(choosee==1) {
				double amount=0;
				System.out.println("Enter amount to be deposited.");
				amount=scanner.nextDouble();
				scanner.hasNextLine();
				List.get(Index).makeDeposit(amount);
				
			}
			else if(choosee==2) {
				double withdraw=0;
				System.out.println("Enter amount to be withdrawn.");
				withdraw=scanner.nextDouble();
				scanner.hasNextLine();
				List.get(Index).makeWithdrawal(withdraw);
					
			}
			else if(choosee==3) {
				System.out.println("Check Balance.");
				scanner.hasNextLine();
				List.get(Index).checkBalance();
		}
			else if(choosee==4) {
				System.out.println("Print Statement.");
				scanner.hasNextLine();
				List.get(Index).printStatement();
		}
			else if(choosee==5) {
				String t="\0";
				double money=0;
				
				System.out.println("Transfer amount.");
				money=scanner.nextDouble();
				
					
					System.out.println("Enter Bank to which you want to transfer.");
					t=scanner.nextLine();
				   List.get(Index).transferAmount(money, t);
		}
			else if(choosee == 6) {
				((Savings)List.get(Index)).calculateZakat();
				
		}
		    scanner.nextLine();
			String chk = "\0";
			System.out.println("Press y to make more functionality: ");
			System.out.println("or Press n to logout and move to main menu: ");
			chk = scanner.nextLine();
			if(chk.equals("n")  || chk.equals("N")) {
			flag = false;
									}
    	 
	 }	 
}
		 if(choice==3) {
			 double interest=0;
			 System.out.println("Interest");
			 ((Savings)List.get(Index)).calculateInterest(interest);
		 	
		}
		 if(choice==4) {
			 for (int i=0;i<List.size();++i) {
					List.get(i).checkBalance();
					if (List.get(i) instanceof Savings) {
						System.out.println("Savings Account");
					}
					else {
						System.out.println("Checking Account");
					}
		 	
		}
			 }
		 if(choice==5) {
			 //double deduct=0;
			//List.get(Index).displayAllDeductions();
		 	
		} 
	
        
		}
    	while(choice!=0);
    
}}
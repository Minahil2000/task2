package Task_1.task2;

public class Customer {
	private int id;
	private String name;
	private String address;
	private String number;
	private boolean savings;
	private boolean checkings;
	private static int idx=0;
	
	public Customer() {
		
		 id = 0;
		 name="\0";
		 address="\0";
		 number="\0";	
		 savings=false;
		 checkings=false;
		
	}
	public Customer(String name, String address, String number) {
		idx++;
		 this.id =idx;
		 this.name=name;
		 this.address=address;
		 this.number=number;
		 savings=false;
		 checkings=false;
			
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getNumber() {
		return number;
	}
	public boolean getsavings() {
		return savings;
	}
	public boolean getcheckings() {
		return checkings;
	}
	public void setId(int o) {
		if(o<=0)
			throw new IllegalArgumentException("ID acnnot be zero or negative");
		else 
			id=o;
	}
	
	public void setName(String n ) {

		if(n==null) {
			throw new IllegalArgumentException("Name cannot be equal to NULL");
		}
		
		name=n;
	}
	public void setAdd(String a) {
		if(a==null) {
			throw new IllegalArgumentException("Address cannot be equal to NULL");
		}
		
		address=a;
	}
	public void setNum(String num) {
		if(num==null) {
			throw new IllegalArgumentException("Number cannot be equal to NULL");
		}
		
		number=num;
	}
	
	public void setSav(boolean x) {
		savings=x;
		
	}
	public void setChk(boolean y) {
		checkings=y;
	}
	
 public void displaycustomer() {
	 System.out.println( "Account Holder's ID"+id );
	 System.out.println( "Account Holder's Name"+name );
	 System.out.println( "Account Holder's Address"+address );
	 System.out.println( "Account Holder's Number"+number );
 }
}

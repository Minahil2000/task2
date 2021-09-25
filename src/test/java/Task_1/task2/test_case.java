package Task_1.task2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class test_case {
Customer cust;
Customer cust2;
Savings save;
Savings save2;
Savings save3;
Checking check;
Checking check1;
App see;


	@Before
	public void setup() {
		cust= new Customer("Minahil","H41St10","03355527609");
		cust2= new Customer("Saba","H41St90","03300000065");
		save3=new Savings(cust2,10000);
		save= new Savings(cust,50000);
		check= new Checking(cust,40000);
	}
	@Test(expected=IllegalArgumentException.class)
	public void setIdtest() {
		cust.setId(-1);
	}
	@Test
	public void set1Idtest() {
		cust.setId(1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void setNametest() {
	cust.setName(null);
//	assertNull(cust.getName());
	
	}
	@Test
	public void setNametest1() {
		cust.setName("Minahil");
//		assertNull(cust.getName());
		
		}
	@Test(expected=IllegalArgumentException.class)
	public void setAddtest1() {
		cust.setAdd(null);

		}
	@Test
	public void setAddtest() {
		cust.setAdd("H41St10");

		}
	@Test(expected=IllegalArgumentException.class)
	public  void setNumtest() {
		cust.setNum(null);
	}
	@Test
	public  void setNumtest1() {
		cust.setNum("03355527609");
	}
	@Test(expected=IllegalArgumentException.class)
	public void setSavtest() {
		save2= new Savings(cust,50000);
	}
	@Test(expected=IllegalArgumentException.class)
	public void setChktest() {
		check1= new Checking(cust,50000);
	}
	@Test
	public void SavingsmakeWithdrawtest() {
		save.makeWithdrawal(10000);
		double expected = save.getbalance();
		assertTrue(expected==40000);
	}
	@Test
	public void CheckingmakeWithdrawtest() {
		check.makeWithdrawal(10000);
		double expected = check.getbalance();
		assertTrue(expected==30000);
	}
	@Test(expected=IllegalArgumentException.class)
	public void CheckingmakeWithdraw1test() {
		check.makeWithdrawal(50000);
		double expected = check.getbalance();
		assertTrue(expected==-10000);
	}
	@Test(expected=IllegalArgumentException.class)
	public void SavingsmakeWithdraw1test() {
		save.makeWithdrawal(55000);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void Savingsmakedeposittest() {
		save.makeDeposit(-3);
	}
	@Test(expected=IllegalArgumentException.class)
	public void Checkingmakedeposittest() {
		check.makeDeposit(-300);
	}
//	@Test(expected=IllegalArgumentException.class)
//	public void CheckingTransferAmount() {
//		check.tranferAmount(0);
//	}
	@Test(expected=IllegalArgumentException.class)
	public void SavingscalculateZakattest() {
		double z=save3.calculateZakat();
	
	}
	@Test
	public void SavingscalculateZakat1test() {
		double z=save.calculateZakat();
		assertTrue(z==1250.0);
	}
	@Test
	public void CheckingsDisplayAllDeductionsTest() {
		check.makeDeposit(3000);
		check.makeWithdrawal(3000);
		check.makeDeposit(3000);
		check.makeWithdrawal(3000);
		check.makeDeposit(3000);
		check.makeWithdrawal(3000);
		check.displayAllDeductions(); 
	}
	@Test
	public void SavingsDisplayAllDeductionsTest() {
		save.calculateZakat();
		save.displayAllDeductions();		
	}
	@Test
	public void SavingsgetInteresttest() {
		save.calculateInterest(2000);
		assertTrue(save.getInterest()==2000);
	}

	
	
}

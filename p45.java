import java.util.*;
import java.util.Date;
class Bank{
	String bank_name;
	int Bankid;
	long total_balance=100000;
	Scanner s2=new Scanner(System.in);
	public void BankDetail(){
		System.out.println("\n========================BANKNAME======================");
		System.out.print("enter Bankname:");
		bank_name=s2.nextLine();
		System.out.println("\n=======================BANKID======================");
		System.out.print("enter bank id:");
		Bankid=s2.nextInt();
	}
}
class Account extends Bank{
	String customer_name;
	long account_no;
	protected long account_balance = 0;
	protected int transactions;
	Scanner s4=new Scanner(System.in);
	public void Accountdetail(){
		System.out.println("||======================================================");
		System.out.print("||enter customer name:");
		customer_name=s4.nextLine();
		System.out.print("||enter your account no:");
		account_no=s4.nextLong();
		System.out.print("||enter your account balance:");
		account_balance = s4.nextLong();
		System.out.println("||======================================================");
	}
}
class CurrentAccount extends Account{
	//current account maintains min balance of 10000rs
	long min_bal2;
	float ri2;//rate of interest
	long withdrawm2;
	int op2;
	Scanner s5=new Scanner(System.in);
	public void currentop(){
		outer:
			while(true){
				System.out.println("===============Savingoptions=============");
				System.out.println("1)withdraw....");
				System.out.println("2)deposit...");
				System.out.println("3)checkbalance.............");
				System.out.println("4)openingbalance.............");
				System.out.println("5)total transactions:");
				System.out.println("6)exit.............");
				System.out.println("====================================");
				System.out.println("enter your option:");
				op2=s5.nextInt();
				switch(op2){
					case 1:
						this.withdraw2();
						break;
					case 2:
						this.deposit2();
						break;
					case 3:
						this.checkbalance2();
						break;
					case 4:
						this.openingbalance2();
						break;
					case 5:
						this.transactions2();
						break;
					case 6:
						break outer;
				}
		}
	}
	public void withdraw2(){
		if(total_balance>=100000){
			if(min_bal2>=1000){
				System.out.println("how many rupees u want to withdraw:");
				withdrawm2=s5.nextLong();
				//total_balance = total_balance-withdrawm2;
				account_balance = account_balance -  withdrawm2;
			}
			else{
				System.out.println("sorry!you can not withdraw..");
			}
		}
	}
	public void openingbalance2(){
		long opening_balance2;
		System.out.println("enter minimum or opening balance for your current account:");
		opening_balance2=s5.nextLong();
		account_balance+=opening_balance2;
		total_balance=opening_balance2+total_balance;
		min_bal2=opening_balance2;
	}
	public void checkbalance2(){
		System.out.println("dear customr hereby we are displaying your balance in current account="+account_balance);
		
	}
	public void transactions2(){
		System.out.println("total no of transactions till last month:"+transactions);
	}
	public void deposit2(){
		System.out.println("==========deposit in current account======");
		long deposits2;
		System.out.println("how many rupees u want to deposit?");
		deposits2=s5.nextLong();
		total_balance+=deposits2;
		account_balance+=deposits2;
	}
}
class SavingAccount extends Account{
	long min_bal1;//maintains minimum balance of 1000rs
	float ri;
	int op1;
	long withdrawm1;
	Scanner s3=new Scanner(System.in);
	public void savingop(){
		outer:
			while(true){
				System.out.println("===============Savingoptions=============");
				System.out.println("1)withdraw....");
				System.out.println("2)deposit...");
				System.out.println("3)checkbalance.............");
				System.out.println("4)openingbalance.............");
				System.out.println("5)total transactions:");
				System.out.println("6)exit.............");
				System.out.println("====================================");
				System.out.println("enter your option:");
				op1=s3.nextInt();
				switch(op1){
					case 1:
						this.withdraw1();
						break;
					case 2:
						this.deposit1();
						break;
					case 3:
						this.checkbalance1();
						break;
					case 4:
						this.openingbalance1();
						break;
					case 5:
						this.transactions1();
						break;
					case 6:
						break outer;
				}
		}
	}
	public void withdraw1(){
		if(total_balance>=100000){
			if(min_bal1>=1000){
				System.out.println("how many rupees u want to withdraw:");
				withdrawm1=s3.nextLong();
				total_balance=total_balance-withdrawm1;
				account_balance-=withdrawm1;
			}
			else{
				System.out.println("sorry!you can not withdraw..");
			}
		}
	}
	public void openingbalance1(){
		long opening_balance1;
		System.out.println("enter minimum or opening balance for your saving account:");
		opening_balance1=s3.nextLong();
		total_balance=opening_balance1+total_balance;
		min_bal1=opening_balance1;
	}
	public void checkbalance1(){
		System.out.println("dear customer hereby we are displaying your balance in saving account="+account_balance);
		
	}
	public void transactions1(){
		System.out.println("total no of transactions till last month:"+transactions);
	}
	public void deposit1(){
		System.out.println("==========deposit in saving account======");
		long deposits1;
		System.out.println("how many rupees u want to deposit?");
		deposits1=s3.nextLong();
		total_balance+=deposits1;
		account_balance+=deposits1;
	}
}
public class p45{
	public static void main(String args[]){
			int option;
			Bank b=new Bank();
			Account a=new Account();
			CurrentAccount c=new CurrentAccount();
			SavingAccount s=new SavingAccount();
			Scanner s1=new Scanner(System.in);
			System.out.println("=============================BankProgram================================");
			b.BankDetail();
			a.Accountdetail();
			while(true){
				System.out.println("===============options=============");
				System.out.println("1)savingAccount....");
				System.out.println("2)CurrentAccount...");
				System.out.println("3)exit.............");
				System.out.println("====================================");
				System.out.println("enter your option:");
				option=s1.nextInt();
				switch(option){
					case 1:
						System.out.println("Saving account option is selected ..");
						System.out.println("remeber that saving account must have minimum balance of 1000rs");
						System.out.println("if u haven't any saving account then first go for openingbalance option:");
						s.savingop();
						break;
					case 2:
						System.out.println("current account option is selected ..");
						System.out.println("remeber that current account must have minimum balance of 10000rs");
						System.out.println("if u haven't any current account then first go for openingbalance option:");
						c.currentop();
						break;
					case 3:
						System.exit(1);
				}
		}
	}
}

package mylab.bank.entity;
import mylab.bank.entity.Account;
public class SavingAccount extends Account {
	double interestRate;
	
	public SavingAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void applyInterest() {
		double interest = this.getBalance()*this.interestRate/100;
		this.deposit(interest);
		//이자 450.0원이 적용되었습니다. 현재 잔액: 15450.0원
		System.out.println("이자 "+ interest + "원이 적용되었습니다. 현재 잔액: " + this.getBalance() + "원");
	}
	@Override
	public String toString() {
		String msg = super.toString();
		return msg + " 이자율: " + this.interestRate + "%";
	}

}

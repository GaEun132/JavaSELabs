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
		//���� 450.0���� ����Ǿ����ϴ�. ���� �ܾ�: 15450.0��
		System.out.println("���� "+ interest + "���� ����Ǿ����ϴ�. ���� �ܾ�: " + this.getBalance() + "��");
	}
	@Override
	public String toString() {
		String msg = super.toString();
		return msg + " ������: " + this.interestRate + "%";
	}

}

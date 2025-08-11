package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;
import mylab.bank.entity.Account;
public class CheckingAccount extends Account{
	
	double withdrawalLimit;
	
	public CheckingAccount(String accountNumber, String owerName, double balance, double withdrawalLimit) {
		super(accountNumber, owerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}
	
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	public void withdraw(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException {
		if (amount > this.withdrawalLimit) {
			throw new WithdrawalLimitExceededException("���� �߻�: ��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: " + this.withdrawalLimit);
		} else {
			super.withdraw(amount);
		}
		
	}

	@Override
	public String toString() {
		String msg = super.toString();
		return msg + " ��� �ѵ�: " + this.withdrawalLimit + "��";
	}
	
	
	
}

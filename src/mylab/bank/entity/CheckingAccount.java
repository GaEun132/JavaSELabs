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
			throw new WithdrawalLimitExceededException("예외 발생: 출금 한도를 초과했습니다. 한도: " + this.withdrawalLimit);
		} else {
			super.withdraw(amount);
		}
		
	}

	@Override
	public String toString() {
		String msg = super.toString();
		return msg + " 출금 한도: " + this.withdrawalLimit + "원";
	}
	
	
	
}

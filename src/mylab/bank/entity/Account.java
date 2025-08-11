package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public class Account {
	private String accountNumber;
	private String owerName;
	private double balance;
	
	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber  = accountNumber;
		this.owerName = ownerName;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getOwerName() {
		return owerName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println(amount + "원이 입금되었습니다. 현재 잔액: "+ this.balance +"원");
	}
	
	public void withdraw (double amount) throws InsufficientBalanceException {
		if (amount <= this.balance) {
			this.balance-=amount;
			System.out.println(amount + "원이 출금되었습니다. 현재 잔액: "+ this.balance +"원");
		} else {
			throw new InsufficientBalanceException("예외 발생: 잔액이 부족합니다. 잔액: " + this.balance);
		}
	}
	@Override
	public String toString() {
		//계좌번호: AC1001, 소유자: 김철수, 잔액: 20000.0원, 출금 한도: 5000.0원
		return "계좌번호: " + this.accountNumber + ", 소유자: " + this.owerName + ",잔액: " + this.balance + "원";
	}
	
	
}

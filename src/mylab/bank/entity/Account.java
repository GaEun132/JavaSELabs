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
		System.out.println(amount + "���� �ԱݵǾ����ϴ�. ���� �ܾ�: "+ this.balance +"��");
	}
	
	public void withdraw (double amount) throws InsufficientBalanceException {
		if (amount <= this.balance) {
			this.balance-=amount;
			System.out.println(amount + "���� ��ݵǾ����ϴ�. ���� �ܾ�: "+ this.balance +"��");
		} else {
			throw new InsufficientBalanceException("���� �߻�: �ܾ��� �����մϴ�. �ܾ�: " + this.balance);
		}
	}
	@Override
	public String toString() {
		//���¹�ȣ: AC1001, ������: ��ö��, �ܾ�: 20000.0��, ��� �ѵ�: 5000.0��
		return "���¹�ȣ: " + this.accountNumber + ", ������: " + this.owerName + ",�ܾ�: " + this.balance + "��";
	}
	
	
}

package mylab.bank.entity;
import mylab.bank.exception.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;


import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
	List<Account> accounts;
	int nextAccountNumber = 1000;
	
	public Bank() {
		this.accounts = new ArrayList<>();
	}
	public String createSavingsAccount(String ownerName, double interest, double balance){
		SavingAccount savingAccount = new SavingAccount("AC"+this.nextAccountNumber, ownerName, balance,interest);
		this.accounts.add(savingAccount);
		this.nextAccountNumber++;
		return "���� ���°� �����Ǿ����ϴ�: "+savingAccount.toString();
		
	}
	public String createCheckingAccount(String ownerName, double limit, double balance) {
		CheckingAccount checkingAccount = new CheckingAccount("AC"+this.nextAccountNumber, ownerName, balance,limit);
		this.accounts.add(checkingAccount);
		this.nextAccountNumber++;
		return "üŷ ���°� �����Ǿ����ϴ�: "+checkingAccount.toString();
		
	}
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
		Account account1 = null;
		for (Account account2 : this.accounts) {
			if (account2.getAccountNumber().equals(accountNumber)) {
				account1 = account2;
			}
		}
		if (account1 == null) {
			throw new AccountNotFoundException("���� �߻�: ���¹�ȣ "+accountNumber +"�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
		} else {
			return account1;
		}
	}
	public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
		Account account = findAccount(accountNumber);
		account.deposit(amount);
	}
	public void withdraw(String accountNumber, double amount) throws AccountNotFoundException,InsufficientBalanceException {
		Account account = findAccount(accountNumber);
		account.withdraw(amount);
	
	}
	public void transfer(String fromAccount, String toAccount, double amount) throws AccountNotFoundException,InsufficientBalanceException{
		Account account1 = findAccount(fromAccount);
		Account account2 = findAccount(toAccount);
		//5000.0���� AC1002���� AC1001�� �۱ݵǾ����ϴ�.
		account1.withdraw(amount);
		account2.deposit(amount);
		System.out.println(amount + "���� " + account1.getAccountNumber()+"���� "+ account2.getAccountNumber()+"�� �۱ݵǾ����ϴ�.");
	}
	public void printAllAccounts() {
		System.out.println("=== ��� ���� ��� ===");
		for (Account account: this.accounts) {
			System.out.println(account.toString());
			
		}
	}
	
}

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
		return "저축 계좌가 생성되었습니다: "+savingAccount.toString();
		
	}
	public String createCheckingAccount(String ownerName, double limit, double balance) {
		CheckingAccount checkingAccount = new CheckingAccount("AC"+this.nextAccountNumber, ownerName, balance,limit);
		this.accounts.add(checkingAccount);
		this.nextAccountNumber++;
		return "체킹 계좌가 생성되었습니다: "+checkingAccount.toString();
		
	}
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
		Account account1 = null;
		for (Account account2 : this.accounts) {
			if (account2.getAccountNumber().equals(accountNumber)) {
				account1 = account2;
			}
		}
		if (account1 == null) {
			throw new AccountNotFoundException("예외 발생: 계좌번호 "+accountNumber +"에 해당하는 계좌를 찾을 수 없습니다.");
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
		//5000.0원이 AC1002에서 AC1001로 송금되었습니다.
		account1.withdraw(amount);
		account2.deposit(amount);
		System.out.println(amount + "원이 " + account1.getAccountNumber()+"에서 "+ account2.getAccountNumber()+"로 송금되었습니다.");
	}
	public void printAllAccounts() {
		System.out.println("=== 모든 계좌 목록 ===");
		for (Account account: this.accounts) {
			System.out.println(account.toString());
			
		}
	}
	
}

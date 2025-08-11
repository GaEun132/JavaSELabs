package mylab.bank.control;



import mylab.bank.entity.Bank;
import mylab.bank.entity.CheckingAccount;
import mylab.bank.entity.SavingAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {

	public static void main(String[] args) {
	
		Bank bank = new Bank();
		System.out.println("=== 계좌 생성 ===");
		System.out.println(bank.createSavingsAccount("홍길동", 3, 10000));
		System.out.println(bank.createCheckingAccount("김철수", 5000, 20000));
		System.out.println(bank.createSavingsAccount("이영희", 2, 30000));	
		
		try {
		bank.printAllAccounts();
		System.out.println("===================");
		
		System.out.println("=== 입금/출금 테스트 ===");
		bank.deposit("AC1000", 5000);
		bank.withdraw("AC1001", 3000);
		
		System.out.println("=== 이자 적용 테스트 ===");
		SavingAccount account = (SavingAccount)bank.findAccount("AC1000");
		account.applyInterest();
		
		System.out.println("=== 계좌 이체 테스트 ===");
		bank.transfer("AC1002", "AC1001", 5000);
		/*
		 * === 계좌 이체 테스트 === 5000.0원이 출금되었습니다. 현재 잔액: 25000.0원 5000.0원이 입금되었습니다. 현재 잔액:
		 * 22000.0원 5000.0원이 AC1002에서 AC1001로 송금되었습니다.
		 */
		bank.printAllAccounts();
		System.out.println("===================");
		CheckingAccount account2 = (CheckingAccount)bank.findAccount("AC1001");
		//출금 한도를 초과했을때 예외 발생시키기
		account2.withdraw(5001);

		} catch(InsufficientBalanceException e) {
			
			System.out.println(e.getMessage());
			
		}  catch (AccountNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
		
		try {
			//해당 계죄를 찾을 수 없을 때 예외 발생시키기
			bank.findAccount("AC9999");
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		



	}

}

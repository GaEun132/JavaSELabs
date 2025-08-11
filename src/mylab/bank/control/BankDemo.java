package mylab.bank.control;



import mylab.bank.entity.Bank;
import mylab.bank.entity.CheckingAccount;
import mylab.bank.entity.SavingAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {

	public static void main(String[] args) {
	
		Bank bank = new Bank();
		System.out.println("=== ���� ���� ===");
		System.out.println(bank.createSavingsAccount("ȫ�浿", 3, 10000));
		System.out.println(bank.createCheckingAccount("��ö��", 5000, 20000));
		System.out.println(bank.createSavingsAccount("�̿���", 2, 30000));	
		
		try {
		bank.printAllAccounts();
		System.out.println("===================");
		
		System.out.println("=== �Ա�/��� �׽�Ʈ ===");
		bank.deposit("AC1000", 5000);
		bank.withdraw("AC1001", 3000);
		
		System.out.println("=== ���� ���� �׽�Ʈ ===");
		SavingAccount account = (SavingAccount)bank.findAccount("AC1000");
		account.applyInterest();
		
		System.out.println("=== ���� ��ü �׽�Ʈ ===");
		bank.transfer("AC1002", "AC1001", 5000);
		/*
		 * === ���� ��ü �׽�Ʈ === 5000.0���� ��ݵǾ����ϴ�. ���� �ܾ�: 25000.0�� 5000.0���� �ԱݵǾ����ϴ�. ���� �ܾ�:
		 * 22000.0�� 5000.0���� AC1002���� AC1001�� �۱ݵǾ����ϴ�.
		 */
		bank.printAllAccounts();
		System.out.println("===================");
		CheckingAccount account2 = (CheckingAccount)bank.findAccount("AC1001");
		//��� �ѵ��� �ʰ������� ���� �߻���Ű��
		account2.withdraw(5001);

		} catch(InsufficientBalanceException e) {
			
			System.out.println(e.getMessage());
			
		}  catch (AccountNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
		
		try {
			//�ش� ���˸� ã�� �� ���� �� ���� �߻���Ű��
			bank.findAccount("AC9999");
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		



	}

}

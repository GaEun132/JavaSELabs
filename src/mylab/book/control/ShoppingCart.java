package mylab.book.control;

import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ShoppingCart {

	List<Publication> items = new ArrayList<>();

	public ShoppingCart() {

	}

	public void addItem(Publication item) {
		items.add(item);
		System.out.println(item.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
	}

	public boolean removeItem(String title) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getTitle().equals(title)) {
				Publication removed = items.remove(i);
				System.out.println(removed.getTitle() + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
				return true; // ���������� ���ŵ�
			}
		}
		System.out.println("�ش� ������ ���ǹ��� ã�� �� �����ϴ�.");
		return false; // ���� ����
	}
	
	public void displayCart() {
		System.out.println("====== ��ٱ��� ���� ======");
		int count = 0;
		for (Publication pb : items) {
			count++;
			System.out.println(count + ". " + pb.getTitle() + " - " + pb.getPrice() + "��");
		}
		System.out.println("�� ����: " + calculateTotalPrice() +"��");
		System.out.println("���� ���� ����: " + calculateDiscountedPrice() +"��");
	}
	
	public int calculateTotalPrice() {
		int totalPrice = 0;
		for (Publication pb : items) {
			totalPrice += pb.getPrice();
		}
		return totalPrice;
	}
	
	public int calculateDiscountedPrice() {
		int total = 0;
		for (Publication item : items) {
			// ManageBook���� �ٸ� ������ ���� (�뵵�� ����ȭ)
			if (item instanceof Magazine) {
				total += item.getPrice() * 0.9; // 10% ����
			} else if (item instanceof Novel) {
				total += item.getPrice() * 0.85; // 15% ����
			} else if (item instanceof ReferenceBook) {
				total += item.getPrice() * 0.8; // 20% ����
			} else {
				total += item.getPrice(); // �⺻ ���ǹ��� ���� ����
			}
		}
		return total;
	}

	public void printStatistics() {
		int magazineCount = 0;
		int novelCount = 0;
		int referenceBookCount = 0; // instanceof�� Ȱ���� Ÿ�Ժ� ī����
		for (Publication item : items) {
			if (item instanceof Magazine) {
				magazineCount++;
			} else if (item instanceof Novel) {
				novelCount++;
			} else if (item instanceof ReferenceBook) {
				referenceBookCount++;
			}
		}
		// ��� ��� 
        System.out.println("====== ��ٱ��� ��� ======"); 
        System.out.println("����: " + magazineCount + "��"); 
        System.out.println("�Ҽ�: " + novelCount + "��"); 
        System.out.println("����: " + referenceBookCount + "��"); 
        System.out.println("�� ���ǹ�: " + items.size() + "��"); 

	}
	
	public static void main(String[] args) {
		
		Publication pub1 = new Magazine("����ũ�μ���Ʈ","2007-10-01",328,9900,"�ſ�");
		Publication pub2 = new Magazine("�濵����ǻ��","2007-10-03",316,9000,"�ſ�");
		Publication pub3 = new Novel("���߿�","2007-07-01",396,9800,"����������������","����Ҽ�");
		Publication pub4 = new Novel("���ѻ꼺","2007-04-14",383,11000,"����","���ϼҼ�");
		Publication pub5 = new ReferenceBook("�ǿ��������α׷���","2007-01-14",496,25000,"����Ʈ�������");	
		
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(pub1);
		cart.addItem(pub2);
		cart.addItem(pub3);
		cart.addItem(pub4);
		cart.addItem(pub5);
		
		cart.displayCart();
		cart.printStatistics();
		cart.removeItem("���߿�");
		cart.displayCart();
	
	}

}

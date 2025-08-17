package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		
		Publication[] publications = {
	            new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"),
	            new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"),
	            new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"),
	            new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"),
	            new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"),
	            new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"),
	            new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�")
	        };
		
		System.out.println("==== ���� ���� ��� ====");
		int cnt = 0;
		for (Publication pb : publications) {
			System.out.println(cnt+1 +". "+ pb.toString());
			cnt++;
		}
		System.out.println();
		System.out.println("==== ���� ���� ====");
		Publication pb = publications[6];
		int price = pb.getPrice();
		System.out.println(pb.getTitle()+" ���� �� ����:" + price + "��");
		modifyPrice(pb);
		System.out.println(pb.getTitle()+ " ���� �� ����:" + pb.getPrice() + "��");
		
		System.out.println();
		StatisticsAnalyzer statistic = new StatisticsAnalyzer();
		statistic.printStatistics(publications);
		

		
	}
	
	public static void modifyPrice(Publication publication) { 
		int currentPrice = publication.getPrice(); 
		// instanceof�� ���� ��ü Ÿ�� Ȯ�� �� ������ ���� ���� 
		if (publication instanceof Magazine) { 
		publication.setPrice((int)(currentPrice * 0.6)); // 40% ���� 
		} else if (publication instanceof Novel) { 
		publication.setPrice((int)(currentPrice * 0.8)); // 20% ���� 
		} else if (publication instanceof ReferenceBook) { 
		publication.setPrice((int)(currentPrice * 0.9)); // 10% ���� } 
		}

}
	
}
	

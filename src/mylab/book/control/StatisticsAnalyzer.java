package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {
	
	public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
		HashMap<String, int[]> hMap = new HashMap<String, int[]>();
		for (Publication pb: publications) {
			String type = getPublicationType(pb);
			int price = pb.getPrice();
			int[] stats = hMap.getOrDefault(type,new int[]{0, 0});
			stats[0] += price;
            stats[1] += 1;   
            hMap.put(type, stats);
		}
		Map<String, Double> averagePrices = new HashMap<>();
        
		 for (Map.Entry<String, int[]> entry : hMap.entrySet()) {
	            String type = entry.getKey();
	            int[] stats = entry.getValue();
	            double total = stats[0];
	            int count = stats[1];
	            if (count > 0) {
	                averagePrices.put(type, total / count);
	            }
	        }
	        return averagePrices;
	}
	
	public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
		
		HashMap<String,Double> hMap = new HashMap<>();
		for (Publication pb: publications) {
			String type = getPublicationType(pb);
			double count = hMap.getOrDefault(type,0.0);
            count += 1;   
            hMap.put(type, count);
		}
		Map<String, Double> ratioMap = new HashMap<>();
		for (Map.Entry<String,Double> entry : hMap.entrySet()) {
            String type = entry.getKey();
            double count = entry.getValue();
            double ratio = (double)count*100/publications.length;
            if (ratio >= 0) {
                ratioMap.put(type,ratio);
            }
        }
		return ratioMap;
		
	}
	
	public double calculatePublicationRatioByYear(Publication[] publications, String year) {
		
		int count = 0;
		for (Publication pb: publications) {
			if ((pb.getPublishDate().substring(0, 4)).equals(year)) {
				count++;
			}
		}
		double ratio = (double)count*100/publications.length;
		return ratio;
	}
	
	private String getPublicationType(Publication publication) {
		 
		if (publication instanceof Magazine) { 
			return "����";
		} else if (publication instanceof Novel) { 
			return "�Ҽ�";
		} else if (publication instanceof ReferenceBook) { 
			return "����";
		} else {
			return "��Ÿ";
		}
	
	}
	
	public void printStatistics(Publication[] publications) {
		
		System.out.println("===== ���ǹ� ��� �м� =====");
		System.out.println("1. Ÿ�Ժ� ��� ����:");
		DecimalFormat df = new DecimalFormat("#,###");
		Map<String, Double> averagePrices = calculateAveragePriceByType(publications);
		System.out.println("    - �Ҽ�: " + df.format(averagePrices.get("�Ҽ�")) + "��");
	    System.out.println("    - ����: " + df.format(averagePrices.get("����")) + "��");
	    System.out.println("    - ����: " + df.format(averagePrices.get("����")) + "��");
		System.out.println();
		
		DecimalFormat df1 = new DecimalFormat("##.##");
		System.out.println("2. ���ǹ� ���� ����:");
		Map<String, Double> distribution = calculatePublicationDistribution(publications);
		System.out.println("    - �Ҽ�: " + df1.format(distribution.get("�Ҽ�")) + "%");
	    System.out.println("    - ����: " + df1.format(distribution.get("����")) + "%");
	    System.out.println("    - ����: " + df1.format(distribution.get("����")) + "%");
		System.out.println();
		
		System.out.println("3. 2007�⿡ ���ǵ� ���ǹ� ����: " + df1.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
		
		
	}
}

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
			return "잡지";
		} else if (publication instanceof Novel) { 
			return "소설";
		} else if (publication instanceof ReferenceBook) { 
			return "참고서";
		} else {
			return "기타";
		}
	
	}
	
	public void printStatistics(Publication[] publications) {
		
		System.out.println("===== 출판물 통계 분석 =====");
		System.out.println("1. 타입별 평균 가격:");
		DecimalFormat df = new DecimalFormat("#,###");
		Map<String, Double> averagePrices = calculateAveragePriceByType(publications);
		System.out.println("    - 소설: " + df.format(averagePrices.get("소설")) + "원");
	    System.out.println("    - 참고서: " + df.format(averagePrices.get("참고서")) + "원");
	    System.out.println("    - 잡지: " + df.format(averagePrices.get("잡지")) + "원");
		System.out.println();
		
		DecimalFormat df1 = new DecimalFormat("##.##");
		System.out.println("2. 출판물 유형 분포:");
		Map<String, Double> distribution = calculatePublicationDistribution(publications);
		System.out.println("    - 소설: " + df1.format(distribution.get("소설")) + "%");
	    System.out.println("    - 참고서: " + df1.format(distribution.get("참고서")) + "%");
	    System.out.println("    - 잡지: " + df1.format(distribution.get("잡지")) + "%");
		System.out.println();
		
		System.out.println("3. 2007년에 출판된 출판물 비율: " + df1.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
		
		
	}
}

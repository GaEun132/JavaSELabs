package workshop.person.control;

public class PersonManager {
	public static void main(String[] args) {
		PersonManager personMgr = new PersonManager();
		personMgr.printTitle("인물 정보 조회 시스템");
	}
	public void printTitle(String title) {
		System.out.println("@@@@ " + title + " @@@@");
	}
	
}

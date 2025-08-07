package mylab.student.exception;

public class InvalidGradeException  extends Exception{
	public InvalidGradeException(String errMessage) {
		//부모 클래스(Exception) 생성자를 호출하기
		super(errMessage);
	}
}

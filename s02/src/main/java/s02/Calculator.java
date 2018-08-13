package s02;

public class Calculator {
	
	private int firstNum;
	private int secondNum;
	
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	public void addition() {
		System.out.println("addition");
		int result1 = firstNum + secondNum;
		System.out.println(result1);
	}
	
	public void subtraction() {
		System.out.println("subtraction");
		int result2 = firstNum - secondNum;
		System.out.println(result2);
	}
	
	public void multiplication() {
		System.out.println("multiplication");
		int result3 = firstNum * secondNum;
		System.out.println(result3);
	}
	
	public void division() {
		System.out.println("division");
		int result4 = firstNum / secondNum;
		System.out.println(result4);
	}

}

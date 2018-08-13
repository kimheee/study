package s02;

public class MainClass {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		calculator.setFirstNum(10);
		calculator.setSecondNum(2);
		
		calculator.addition();
		calculator.subtraction();
		calculator.multiplication();
		calculator.division();

	}

}

import java.util.Scanner;

public class ArithmeticCalculator {
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("연산>>");
		double num1=sc.nextDouble();
		String operator=sc.next();
		double num2=sc.nextDouble();
		double result=0;
		
		if(operator.equals("+"))result=num1+num2;
		else if(operator.equals("-"))result=num1-num2;
		else if(operator.equals("*"))result=num1*num2;
		else if(operator.equals("/")) {
			result=num1/num2;
			if(num2==0)System.out.print("0으로 나눌수 없습니다");
		}
		if(num2!=0) {
			System.out.print(num1+operator+num2+"의 계산 결과는"+result);
		}
	}
}

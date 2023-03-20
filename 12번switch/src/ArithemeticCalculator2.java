import java.util.Scanner;

public class ArithemeticCalculator2 {
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("연산>>");
		double num1=sc.nextDouble();
		String operator =sc.next();
		double num2=sc.nextDouble();
		double result=0;
		
		switch(operator) {
		case"+":
			result=num1+num2;
			break;
			
		case"-":
			result=num1-num2;
			break;
			
		case"*":
			result=num1*num2;
			break;
			
		case"/":
			result=num1/num2;
			if(num2==0) {
				System.out.print("0으로 나눌수 없습니다.");
			}
			break;
			default:
				System.out.print("잘못입력");
			}
		if(num2!=0) {
			System.out.print(num1+operator+num2+"의 계산결과는 "+result);
		}
	}
}

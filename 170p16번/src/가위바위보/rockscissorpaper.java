package 가위바위보;
import java.util.*;
import java.io.*;

public class rockscissorpaper {
	   static String user;
	   
	   public static void main(String[] args)throws Exception {
	      Scanner sc=new Scanner(System.in);
	      
	      // TODO Auto-generated method stub
	      String[] str= {"가위","바위","보"};
	      System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
	      
	      while(true) {
	      System.out.print("가위 바위 보>> ");
	      user=sc.next();
	      
	      if(user.equals("그만")) {
	         System.out.println("게임을 종료합니다..");
	         break;
	      }
	      
	      
	      int n=(int)(Math.random()*3);
	      
	      System.out.print("사용자 = "+user+", 컴퓨터 = "+str[n]+", 사용자가 ");
	      if(str[n].equals("바위")) {
	         switch(user) {
	         case "바위":
	            System.out.println("비겼습니다");
	            break;
	         case "보":
	            System.out.println("이겼습니다");
	            break;
	         case "가위":
	            System.out.println("졌습니다");
	            break;
	         }
	      }else if(str[n].equals("보")) {
	         switch(user) {
	         case "바위":
	            System.out.println("졌습니다.");
	            break;
	         case "보":
	            System.out.println("비겼습니다.");
	            break;
	         case "가위":
	            System.out.println("이겼습니다");
	            break;
	         }
	      }else if(str[n].equals("가위")) {
	         switch(user) {
	         case "바위":
	            System.out.println("이겼습니다");
	            break;
	         case "보":
	            System.out.println("졌습니다.");
	            break;
	         case "가위":
	            System.out.println("비겼습니다.");
	            break;
	         }
	      }
	      }
	      
	   }

}

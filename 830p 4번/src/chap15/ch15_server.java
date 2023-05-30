package chap15;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class ch15_server extends JFrame {
	JTextArea tf = new JTextArea();
	File file = new File("파일 경로");
	Vector<String> word = new Vector<String>();
	
	ch15_server(){
		setSize(400, 400);
		setTitle("영어 스펠 체크 서버");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		tf.setEnabled(false);
		Font f = new Font("맑은 고딕", Font.PLAIN, 25);
		tf.setFont(f);
		
		add(tf);
		setVisible(true);
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scanner.hasNextLine()) {
			String str = scanner.nextLine();
			word.add(str);
		}
		
		tf.setText("words.txt 읽기 완료\n");
		
		try {
			ServerSocket listener = new ServerSocket(9100);
			
			while(true) {
				Socket socket = listener.accept();
				tf.append("클라이언트 연결됨.\n");
				multyThread th = new multyThread(socket);
				th.start();
			} 
			
		}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
			
	class multyThread extends Thread {
		Socket sk;
		int exist = 0;
				
		multyThread(Socket sk){
			this.sk = sk;
		}
				
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
						
				while(true) {
					exist = 0;
					String inputMessage = in.readLine();
							
					for (int i=0; i<word.size();i++) {
						if (word.get(i).equals(inputMessage)) {
							exist ++;
						}
					}
							
					if (exist ==0) {
						out.write("NO\n");
						out.flush();
					} else if (exist == 1) {
						out.write("YES\n");
						out.flush();
					}
						
				}

			}catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(sk == null)sk.close();
				}catch (IOException e) {
					tf.append("클라이언트와 채팅중 오류가 발생하였습니다.\n");
						}
					}
				}
			}
	
			public static void main(String[] args) {
				new ch15_server();
			}
			
}
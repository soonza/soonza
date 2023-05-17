package nine;

import java.awt.*;
import javax.swing.*;

import javax.swing.JPanel;

public class JLabelEx extends JFrame {
	public JLabelEx() {
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel top = new JPanel();
		JPanel mid = new JPanel(null);
		JPanel bottom = new JPanel();
		
		c.add(top,BorderLayout.NORTH);
		top.setBackground(Color.gray);
		
		JButton bt1 = new JButton("열기");
		JButton bt2 = new JButton("닫기");
		JButton bt3 = new JButton("나가기");
		top.add(bt1);
		top.add(bt2);
		top.add(bt3);
		
		c.add(bottom,BorderLayout.SOUTH);
		bottom.setBackground(Color.yellow);
		
		JButton bt4 = new JButton("Word Input");
		JTextField tf= new JTextField(10);
		bottom.add(bt4);
		bottom.add(tf);
		
		c.add(mid,BorderLayout.CENTER);
		
		JLabel[]label = new JLabel[10];	
		for(int i=0;i<label.length;i++) {
			int x = ((int)(Math.random()*250))+20;
			int y = ((int)(Math.random()*150))+20;
			
			label[i] = new JLabel("*");
			label[i].setOpaque(true);
			label[i].setSize(10,10);
			mid.add(label[i]).setLocation(x, y);
		}
		setTitle("여러개의 패널을 가진 프레임");
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JLabelEx();
	}

}

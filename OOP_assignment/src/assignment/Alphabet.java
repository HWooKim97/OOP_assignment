package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Alphabet extends JFrame {
	JLabel[] txt = new JLabel[26]; // a~z의 단어 출력을 위한 label
	JLabel hint = new JLabel("Let's play!"); // 도움말 출력을 위한 label
	Random r = new Random();
	
	int check = 0; // 삭제한 label의 개수를 세기 위한 변수
	
	public Alphabet() {
		setTitle("2016112661 김현우");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		// 'a'부터 랜덤한 위치에 label 생성
		char alpha = 65;
		for(int i = 0; i < 26; i++) {
			txt[i] = new JLabel(String.valueOf(alpha++));
			txt[i].setLocation(r.nextInt(460) + 10, r.nextInt(400) + 50);
			txt[i].setSize(15,15);
			txt[i].addMouseListener(new txtClick());
			c.add(txt[i]);
		}
		
		hint.setLocation(10, 10);
		hint.setSize(500, 15);
		c.add(hint);
		
		setSize(500,500);
		setResizable(false);
		setVisible(true);
	}
	
	public class txtClick extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			JLabel l = (JLabel)e.getSource();
			
			// 현재 클릭된 label과 check번째 label이 같을 경우 visible을 false로 설정
			if(e.getSource() == txt[check]) {
				txt[check++].setVisible(false);
				hint.setText("You clicked \"" + l.getText() + "\"");
				if(check >= 26) {
					hint.setText("Good Job!");
				}
			}
			// 다른 경우 클릭된 label과 클릭해야할 label의 위치값을 받아 상대적 위치 출력
			else {
				Point clicked = l.getLocation();
				Point target = txt[check].getLocation();
				int x = target.x - clicked.x;
				int y = target.y - clicked.y;
				
				hint.setText("It's not \"" + txt[check].getText() + "\" " + "Go to x : " + x + ", y : " + y);
			}
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Alphabet();
	}

}

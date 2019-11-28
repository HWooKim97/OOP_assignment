package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Alphabet extends JFrame {
	JLabel[] txt = new JLabel[26];				// ���ĺ� ����� ���� label
	JLabel hint = new JLabel("Let's play!");	// ���� ����� ���� label
	int next = 0;								// ������ label�� ������ ���� ���� ����

	public Alphabet() {
		setTitle("2016112661 ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		// A~Z label ������ ��ġ�� ����
		Random r = new Random();
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
		
		JLabel xy = new JLabel("x�� y��");
		xy.setSize(60,15);
		xy.setLocation(440,10);
		c.add(xy);

		setSize(500,500);
		setResizable(false);
		setVisible(true);
	}

	// label�� ���� ���콺 Ŭ�� ������ Ŭ����
	public class txtClick extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			JLabel l = (JLabel)e.getSource();

			// ���� Ŭ���� label�� next��° label�� ���� ��� visible�� false�� ����
			if(e.getSource() == txt[next]) {
				txt[next++].setVisible(false);
				hint.setText("You clicked \"" + l.getText() + "\"");
				if(next >= 26) {
					hint.setText("Good Job!");
					hint.setLocation(210,230);
				}
			}
			// �ٸ� ��� Ŭ���� label�� Ŭ���ؾ��� label�� ��ġ���� �޾� ����� ��ġ ���
			else {
				Point clicked = l.getLocation();
				Point target = txt[next].getLocation();
				int x = target.x - clicked.x;
				int y = target.y - clicked.y;

				hint.setText("You clicked \"" + l.getText() + "\"  " 
								+ "Go to x : " + x + ", y : " + y);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Alphabet();
	}

}

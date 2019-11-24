package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Alphabet extends JFrame {
	JLabel[] txt = new JLabel[26];
	JLabel hint = new JLabel("Let's play!");
	Random r = new Random();

	int check = 0;
	
	public Alphabet() {
		setTitle("2016112661 ±èÇö¿ì");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
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
			if(e.getSource() == txt[check]) {
				txt[check++].setVisible(false);
				hint.setText("You clicked \"" + l.getText() + "\"");
				if(check >= 26) {
					hint.setText("Good Job!");
				}
			}
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

package flag_package;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FlagPanel extends JPanel implements KeyListener {
	private int x, y, x1, y1;
	private boolean b, flag1, flag2;
	private static final long serialVersionUID = 1L;

	public FlagPanel() {
		addKeyListener(this);
		setFocusable(true);
		x = 20;
		y = 400;
		x1 = 740;
		y1 = 400;
		b = false;
		flag1 = false;
		flag2 = false;
	}

	/*
	 * Make a capture the flag game...
	 */

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLUE);
		// purple
		if (flag2 == false) {
			g.setColor(new Color(179, 77, 170));
		} else {
			g.setColor(Color.PINK);
		}
		g.fillOval(x, y, 30, 30);
		// yellow
		if (flag1 == false) {
			g.setColor(Color.YELLOW);
		} else {
			g.setColor(Color.GREEN);
		}
		g.fillOval(x1, y1, 30, 30);
		g.setColor(Color.CYAN);
		g.fillRect(390, 0, 30, 800);
		g.setColor(Color.RED);
		g.fillOval(0, 400, 30, 30);
		g.fillOval(750, 400, 30, 30);
	}

	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			y1 = y1 - 9;

		} else if (key == KeyEvent.VK_DOWN) {
			y1 = y1 + 9;

		} else if (key == KeyEvent.VK_RIGHT) {
			x1 = x1 + 10;
		} else if (key == KeyEvent.VK_LEFT) {
			x1 = x1 - 9;
		} else if (key == KeyEvent.VK_ENTER && b == false) {
			x = 400;
			y = 750;
			b = true;
		} else if (key == KeyEvent.VK_ENTER && b == true) {
			x1 = 20;
			y1 = 20;
			b = false;

		}
		if (y1 < y + 7 && y1 > y - 2 && x1 < x + 7 && x1 > x - 2 && x > 400) {
			flag2 = false;
			x = 20;
			y = 400;
		}
		if (y1 < 407 && y1 > 393 && x1 < 7 && x1 > -7) {
			flag1 = true;
		}
		if (x1 < 757 && x1 > 748 && y1 < 407 && y1 > 398 && flag1 == true) {
			flag1 = false;
			JOptionPane.showMessageDialog(null, "Yellow Wins");
		}

		repaint();
	}

	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();

		if (key == 'w') {
			y = y - 9;
		} else if (key == 's') {
			y = y + 9;
		} else if (key == 'd') {
			x = x + 9;
		} else if (key == 'a') {
			x = x - 9;
		}
		if (y < y1 + 7 && y > y1 - 2 && x < x1 + 7 && x > x1 - 2 && x1 < 400) {
			flag1 = false;
			x1 = 740;
			y1 = 400;
		}
		if (x < 757 && x > 743 && y < 407 && y > 393) {
			flag2 = true;
		}
		if (y < 407 && y > 398 && x < 7 && x > -2 && flag2 == true) {
			flag2 = false;
			JOptionPane.showMessageDialog(null, "Purple Wins");
		}
	}

	public void keyReleased(KeyEvent e) {

	}

}

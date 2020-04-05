package flag_package;

import java.awt.GridLayout;

import javax.swing.JFrame;
//Run here.

public class FlagCaller extends JFrame {
	private static final long serialVersionUID = 1L;

	public FlagCaller() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Capture the flag");
		setSize(800, 800);
		setResizable(false);

		init();
	}

	public void init() {
		setLayout(new GridLayout(1, 1, 0, 0));

		FlagPanel s = new FlagPanel();

		add(s);

		setVisible(true);
	}

	public static void main(String[] args) {
		new FlagCaller();
	}

}

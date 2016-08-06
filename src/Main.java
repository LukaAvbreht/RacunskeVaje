import java.awt.EventQueue;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main{
	
	private JPanel platno;
	private JTextField tezavnost;
	private JButton zacni;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavnoOkno frame = new GlavnoOkno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main(){
		JPanel platno;
	}
}
	

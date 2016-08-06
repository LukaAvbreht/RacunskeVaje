import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ZacetnoOkno extends JFrame{
	
	private JPanel platno;
	private JTextField tezavnost;
	private JButton zacni;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//public void run() {
			//	try {
			//		GlavnoOkno frame = new GlavnoOkno();
			//		frame.setVisible(true);
			//	} catch (Exception e) {
			//		e.printStackTrace();
			//	}
			//}
			public void run() {
				try  {
					ZacetnoOkno okno = new ZacetnoOkno();
					okno.setVisible(true);
				} catch (Exception e)  {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ZacetnoOkno(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Vaje raèunanja!"); //se bo spreminjalo
		setResizable(false);
		setBounds(100, 100, 450, 250);
		Dimension dim = new Dimension(600,250);
		setMinimumSize(dim);
		platno = new JPanel();
		platno.setBorder(new EmptyBorder(5, 5, 5, 5));
		platno.setLayout(new BorderLayout(1, 1));
		setContentPane(platno);
	}
}
	

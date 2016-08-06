import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ZacetnoOkno extends JFrame{
	
	private GlavnoOkno vaje;
	
	private JPanel platno;
	private JTextField vpisiTezavnost;
	private JTextField vpisiStRacunov;
	private JButton btnZacni;
	
	private JLabel navodila_1;
	private JLabel navodila_2;
	
	private int tezavnost = 10;
	private int stRacunov = 10;
	
	
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
		
		btnZacni = new JButton("Start");
		
		JPanel spodnjaVrstica = new JPanel();
		spodnjaVrstica.setLayout(new BoxLayout(spodnjaVrstica, BoxLayout.LINE_AXIS));
		spodnjaVrstica.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		spodnjaVrstica.add(btnZacni);
		
		platno.add(spodnjaVrstica, BorderLayout.SOUTH);
		
		JButton test = new JButton("TEST");
		
		
		btnZacni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				vaje = new GlavnoOkno(tezavnost, stRacunov);
				vaje.setVisible(true);
			}
		});
	}
}
	

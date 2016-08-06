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
		setBounds(100, 100, 200, 200);
		Dimension dim = new Dimension(200,250);
		setMinimumSize(dim);
		platno = new JPanel();
		platno.setBorder(new EmptyBorder(5, 5, 5, 5));
		platno.setLayout(new BoxLayout(platno, BoxLayout.Y_AXIS));
		setContentPane(platno);
		
		btnZacni = new JButton("Start");
		
		navodila_1 = new JLabel();
		navodila_1.setText("Izberi težavnost: (1 - 20)");
		
		navodila_2 = new JLabel();
		navodila_2.setText("Izberi število raèunov: ");
		
		vpisiTezavnost = new JTextField();
		vpisiStRacunov = new JTextField();
		
		platno.add(navodila_1);
		platno.add(vpisiTezavnost);
		platno.add(navodila_2);
		platno.add(vpisiStRacunov);
		platno.add(btnZacni);
		
		btnZacni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String vpis_1 = vpisiTezavnost.getText();
				try {
					tezavnost = Integer.parseInt(vpis_1);
				} catch (NumberFormatException e){}
				String vpis_2 = vpisiStRacunov.getText();
				try {
					stRacunov = Integer.parseInt(vpis_2);
				} catch (NumberFormatException e){}
				vaje = new GlavnoOkno(tezavnost, stRacunov);
				vaje.setVisible(true);
			}
		});
	}
}
	

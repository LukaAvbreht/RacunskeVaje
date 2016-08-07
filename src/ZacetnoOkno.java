import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ZacetnoOkno extends JFrame{
	
	private static GlavnoOkno vaje;
	
	private JPanel platno;
	private JTextField vpisiTezavnost;
	private JTextField vpisiStRacunov;
	private JButton btnZacni;
	
	private JComboBox menuTezavnost;
	
	private JLabel navodila_1;
	private JLabel navodila_2;
	
	private int tezavnost = 10;
	private int stRacunov = 10;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
	
	public static void zapri(){
		vaje.setVisible(false);
	}
	
	public ZacetnoOkno(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Vaje raèunanja!"); //se bo spreminjalo
		setResizable(false);
		setBounds(100, 100, 250, 150);
		platno = new JPanel();
		platno.setBorder(new EmptyBorder(5, 5, 5, 5));
		platno.setLayout(new BoxLayout(platno, BoxLayout.Y_AXIS));
		setContentPane(platno);
		
		btnZacni = new JButton("Start");
		btnZacni.setToolTipText("Zaèni igro!");
		btnZacni.setHorizontalAlignment(SwingConstants.CENTER);
		
		navodila_1 = new JLabel();
		navodila_1.setText("Izberi težavnost: (1 - 20)");
		
		navodila_2 = new JLabel();
		navodila_2.setText("Izberi število raèunov: ");
		
		menuTezavnost = new JComboBox();
		for (int i = 1; i <= 20; i++){ menuTezavnost.addItem(i);}
		menuTezavnost.setSelectedIndex(9);
		
		vpisiTezavnost = new JTextField();
		vpisiTezavnost.setSize(new Dimension(50,50));
		vpisiTezavnost.setToolTipText("Vpiši težavnost med 1 in 20.");
		
		vpisiStRacunov = new JTextField();
		vpisiStRacunov.setToolTipText("Izberi število raèunov, ki jih boš rešil!");
		
		platno.add(navodila_1);
		platno.add(menuTezavnost);
		platno.add(navodila_2);
		platno.add(vpisiStRacunov);
		platno.add(btnZacni);
		
		btnZacni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tezavnost = (int) menuTezavnost.getSelectedItem();
				String vpis_2 = vpisiStRacunov.getText();
				try {
					stRacunov = Math.abs(Integer.parseInt(vpis_2));
				} catch (NumberFormatException e){}
				vaje = new GlavnoOkno(tezavnost, stRacunov);
				vaje.setVisible(true);
			}
		});
	}
}
	

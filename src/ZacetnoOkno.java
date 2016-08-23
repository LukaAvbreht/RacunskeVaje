import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ZacetnoOkno extends JFrame{
	
	private static GlavnoOkno vaje;
	
	private JPanel platno;
	private JPanel vrsticaGumbov;
	private JButton btnZacni;
	private JButton btnZapri;
	
	private JComboBox<Integer> menuTezavnost;
	private static JComboBox<Integer> vpisiStRacunov;
	
	private JCheckBox plus;
	private JCheckBox minus;
	private JCheckBox krat;
	private JCheckBox deljeno;
	private JCheckBox deljenec;
	private JCheckBox prednost;
	
	private JLabel navodila_1;
	private JLabel navodila_2;
	
	private int tezavnost = 10;
	private int stRacunov = 10;
	
	ArrayList<Integer> tipiRacunov;
	
	
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
		vpisiStRacunov.setSelectedIndex(9);
		main(null);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ZacetnoOkno(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Vaje raèunanja!");
		setResizable(false);
		setBounds(400, 450, 300, 290);
		platno = new JPanel();
		platno.setBorder(new EmptyBorder(5, 5, 5, 5));
		platno.setLayout(new BoxLayout(platno, BoxLayout.Y_AXIS));
		setContentPane(platno);
		
		btnZacni = new JButton("Start");
		btnZacni.setToolTipText("Zaèni igro!");
		
		btnZapri = new JButton("Zapri");
		btnZapri.setToolTipText("To bo zaprlo aplikacijo!");
		
		navodila_1 = new JLabel();
		navodila_1.setText("Izberi težavnost: (1 - 20)");
		
		navodila_2 = new JLabel();
		navodila_2.setText("Izberi število raèunov:");
		
		menuTezavnost = new JComboBox();
		for (int i = 1; i <= 20; i++){ menuTezavnost.addItem(i);}
		menuTezavnost.setSelectedIndex(9);
		
		vpisiStRacunov = new JComboBox();
		for (int i = 1; i <= 100; i++){ vpisiStRacunov.addItem(i);}
		vpisiStRacunov.setSelectedIndex(9);
		
		vrsticaGumbov = new JPanel();
		vrsticaGumbov.setLayout(new BoxLayout(vrsticaGumbov, BoxLayout.X_AXIS));
		vrsticaGumbov.add(btnZapri);
		vrsticaGumbov.add(Box.createHorizontalGlue());
		vrsticaGumbov.add(btnZacni);
		
	    plus = new JCheckBox(" x + y = __");
	    plus.setSelected(true);
	    
	    minus = new JCheckBox(" x - y = __");
	    minus.setSelected(true);
	    
	    krat = new JCheckBox(" x * y = __");
	    krat.setSelected(true);
	    
	    deljeno = new JCheckBox(" x / y = __");
	    deljeno.setSelected(true);
	    
	    deljenec = new JCheckBox(" __ / x = y ");
	    deljenec.setSelected(true);
	    
	    prednost = new JCheckBox(" x * ( y + z ) = __ ");
	    prednost.setSelected(true);
	    
	    tipiRacunov = new ArrayList<Integer>();
		
		platno.add(navodila_1);
		platno.add(menuTezavnost);
		platno.add(navodila_2);
		platno.add(vpisiStRacunov);
		platno.add(plus);
		platno.add(minus);
		platno.add(krat);
		platno.add(deljeno);
		platno.add(deljenec);
		platno.add(prednost);
		platno.add(vrsticaGumbov);
		
		btnZacni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (plus.isSelected()){tipiRacunov.add(1);}
				if (minus.isSelected()){tipiRacunov.add(2);}
				if (krat.isSelected()){tipiRacunov.add(3);}
				if (deljeno.isSelected()){tipiRacunov.add(4);}
				if (deljenec.isSelected()){tipiRacunov.add(5);}
				if (prednost.isSelected()){tipiRacunov.add(6);}
				if (tipiRacunov.size() == 0){tipiRacunov.add(1);}
				
				tezavnost = (int) menuTezavnost.getSelectedItem();
				stRacunov = (int) vpisiStRacunov.getSelectedItem();
				vaje = new GlavnoOkno(tezavnost, stRacunov, tipiRacunov);
				vaje.setVisible(true);
				setVisible(false); // Skrije zacetnoOkno
			}
		});
		
		btnZapri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				System.exit(0);
			}
		});
		
	}
}
	

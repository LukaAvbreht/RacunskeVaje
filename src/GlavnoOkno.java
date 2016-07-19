import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GlavnoOkno extends JFrame {

	private JPanel contentPane;
	private JTextField inputRezultat;
	
	private Racun trenutni;
	
	private JButton btnPokaziRacun;
	private JButton btnPotrdi;

	private JLabel labelPrvaStevilka;
	private JLabel labelOperacija;
	private JLabel labelDrugaStevilka;
	private JLabel labelEnakost;
	private JLabel Ocena;
	
	private int Defcon = 0;
	
	private void oceni(){
		String vpisano = inputRezultat.getText();
		boolean ok = false;
		try{
			int vpisanInt = Integer.parseInt(vpisano);
			ok = vpisanInt == trenutni.rezultat;
		}catch(NumberFormatException ex){
		}
		if(ok){
			Ocena.setBackground(Color.green);
			Ocena.setText("Vse OK");
		}else{
			Ocena.setBackground(Color.red);
			Ocena.setText("Nic OK");
		}
	}
	
	private void pokazi(){
		trenutni = Racun.dobiNaklucenRacun(10);
		labelPrvaStevilka.setText(trenutni.prvaStevilka + "");
		labelDrugaStevilka.setText(trenutni.drugaStevilka + "");
		labelOperacija.setText(trenutni.operacija.operator);
		Ocena.setText("");
		inputRezultat.setText("");
		//inputRezultat.setText(trenutni.rezultat + "");
	}

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public GlavnoOkno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnPokaziRacun = new JButton("Pokazi racun");
		

		
		contentPane.add(btnPokaziRacun, BorderLayout.NORTH);
		
		btnPotrdi = new JButton("Potrdi");
		
		contentPane.add(btnPotrdi, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		labelPrvaStevilka = new JLabel("New label");
		panel.add(labelPrvaStevilka);
		
		labelOperacija = new JLabel("New label");
		panel.add(labelOperacija);
		
		labelDrugaStevilka = new JLabel("New label");
		panel.add(labelDrugaStevilka);
		
		labelEnakost = new JLabel("=");
		panel.add(labelEnakost);
		
		inputRezultat = new JTextField();
		panel.add(inputRezultat);
		inputRezultat.setColumns(10);
		
		Ocena = new JLabel("");
		panel.add(Ocena);
		Ocena.setSize(20, 100);
		
		
		btnPokaziRacun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pokazi();
			}
		});

		btnPotrdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				oceni();
				Defcon = 1;
			}
		});
				
		inputRezultat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					if(Defcon == 0){
						oceni();
						Defcon = 1;
					}
					else{
						pokazi();
						Defcon = 0;
					}
				}
			}
		});
		
		pokazi();
	}
}

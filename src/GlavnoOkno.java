import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import java.awt.Font;
import java.awt.Component;
import java.awt.Point;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class GlavnoOkno extends JFrame {

	private JPanel contentPane;
	private JTextField inputRezultat;
	
	private Racun trenutni;
	
	private JButton btnResetiraj;
	private JButton btnPotrdi;

	private JLabel labelPrvaStevilka;
	private JLabel labelOperacija;
	private JLabel labelDrugaStevilka;
	private JLabel labelEnakost;
	private JLabel Ocena;
	
	private JLabel Tocke;
	private int vsehRacunov = 0;
	private int pravilno = 0;
	
	private Color zelena = new Color(51, 204, 0);
	private Color rdeca = new Color(204,0,0);
	private Color rumena = new Color(255,255,0);
	private Color bela = new Color(255, 255, 255);
	
	private int Defcon = 1;
	
	private void oceni(){
		String vpisano = inputRezultat.getText();
		boolean ok = false;
		try{
			int vpisanInt = Integer.parseInt(vpisano);
			ok = vpisanInt == trenutni.rezultat;
		}catch(NumberFormatException ex){
		}
		if(ok){
			Ocena.setBackground(zelena);
			Ocena.setText("OK");
			pravilno += 1;
			Tocke.setText(pravilno + "/" + vsehRacunov);
		}else{
			Ocena.setBackground(rdeca);
			Ocena.setText("XX");
			Tocke.setText(pravilno + "/" + vsehRacunov);
		}
	}

	
	private void pokazi(){
		trenutni = Racun.dobiNaklucenRacun(10);
		labelPrvaStevilka.setText(trenutni.prvaStevilka + "");
		labelDrugaStevilka.setText(trenutni.drugaStevilka + "");
		labelOperacija.setText(trenutni.operacija.operator);
		//Ocena.setText("??");
		//Ocena.setBackground(bela);
		vsehRacunov += 1;
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
		Dimension dim = new Dimension(600,300);
		setMinimumSize(dim);
		//setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnResetiraj = new JButton("Resetiraj");
		
		contentPane.add(btnResetiraj, BorderLayout.NORTH);
		
		btnPotrdi = new JButton("Potrdi");
		
		contentPane.add(btnPotrdi, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		labelPrvaStevilka = new JLabel("New label");
		labelPrvaStevilka.setOpaque(true);
		labelPrvaStevilka.setHorizontalTextPosition(SwingConstants.CENTER);
		labelPrvaStevilka.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrvaStevilka.setMaximumSize(new Dimension(150, 50));
		labelPrvaStevilka.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelPrvaStevilka.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelPrvaStevilka.setMinimumSize(new Dimension(150, 100));
		panel.add(labelPrvaStevilka);
		
		labelOperacija = new JLabel("New label");
		labelOperacija.setOpaque(true);
		labelOperacija.setHorizontalTextPosition(SwingConstants.CENTER);
		labelOperacija.setHorizontalAlignment(SwingConstants.CENTER);
		labelOperacija.setMinimumSize(new Dimension(150, 100));
		labelOperacija.setMaximumSize(new Dimension(150, 50));
		labelOperacija.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(labelOperacija);
		
		labelDrugaStevilka = new JLabel("New label");
		labelDrugaStevilka.setOpaque(true);
		labelDrugaStevilka.setHorizontalTextPosition(SwingConstants.CENTER);
		labelDrugaStevilka.setHorizontalAlignment(SwingConstants.CENTER);
		labelDrugaStevilka.setMinimumSize(new Dimension(150, 100));
		labelDrugaStevilka.setMaximumSize(new Dimension(150, 50));
		labelDrugaStevilka.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(labelDrugaStevilka);
		
		labelEnakost = new JLabel("=");
		labelEnakost.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		labelEnakost.setOpaque(true);
		labelEnakost.setHorizontalTextPosition(SwingConstants.CENTER);
		labelEnakost.setHorizontalAlignment(SwingConstants.CENTER);
		labelEnakost.setMinimumSize(new Dimension(150, 100));
		labelEnakost.setMaximumSize(new Dimension(150, 50));
		panel.add(labelEnakost);
		
		inputRezultat = new JTextField();
		inputRezultat.setFont(new Font("Tahoma", Font.BOLD, 30));
		inputRezultat.setMaximumSize(new Dimension(150,50));
		panel.add(inputRezultat);
		inputRezultat.setColumns(10);
		
		Ocena = new JLabel("??");
		Ocena.setBackground(bela);
		Ocena.setFont(new Font("Tahoma", Font.BOLD, 30));
		Ocena.setOpaque(true);
		Ocena.setHorizontalTextPosition(SwingConstants.CENTER);
		Ocena.setHorizontalAlignment(SwingConstants.CENTER);
		Ocena.setMinimumSize(new Dimension(150, 100));
		Ocena.setMaximumSize(new Dimension(80, 80));
		//Ocena.setPreferredSize(getMaximumSize());
		
		panel.add(Ocena);
		Ocena.setSize(20, 100);
	
		Tocke = new JLabel("0/0");
		Tocke.setBackground(rumena);
		Tocke.setFont(new Font("Tahoma", Font.BOLD, 30));
		Tocke.setOpaque(true);
		Tocke.setHorizontalTextPosition(SwingConstants.CENTER);
		Tocke.setHorizontalAlignment(SwingConstants.CENTER);
		Tocke.setMinimumSize(new Dimension(150, 100));
		Tocke.setMaximumSize(new Dimension(80, 80));
		
		panel.add(Tocke);
		Tocke.setSize(20, 100);
		
		
		btnResetiraj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				vsehRacunov = 0;
				pravilno = 0;
				Tocke.setText(pravilno + "/" + vsehRacunov);
				pokazi();
			}
		});

		btnPotrdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				if (Defcon == 1){
					oceni();
					pokazi();
				}
			}
		});
				
		inputRezultat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					if(Defcon == 1){
						oceni();
						pokazi();
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

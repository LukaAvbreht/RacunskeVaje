import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Box;
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
	
	public Racun trenutni;
	private String vpisano;
	
	private JButton btnResetiraj;
	private JButton btnPotrdi;

	private JLabel labelRacun;
	//private JLabel labelOperacija;
	//private JLabel labelDrugaStevilka;
	//private JLabel labelEnakost;
	//private JLabel labelRezultat;
	private JLabel Ocena;
	
	private JLabel labelPrejsniRacun;
	
	private JLabel Tocke;
	private int vsehRacunov = 0;
	private int pravilno = 0;
	
	private Color zelena = new Color(51, 204, 0);
	private Color rdeca = new Color(255,17,17);
	private Color rumena = new Color(255,255,0);
	private Color bela = new Color(255, 255, 255);
	private Color crna = new Color(0, 0, 0);
	
	private void oceni(){
		vpisano = inputRezultat.getText();
		boolean ok = false;
		try{
			int vpisanInt = Integer.parseInt(vpisano);
			ok = vpisanInt == trenutni.rezultat;
		}catch(NumberFormatException ex){
			vpisano = "FAIL";
		}
		if(ok){
			//Ocena.setBackground(bela);
			Ocena.setText("OK");
			Ocena.setForeground(zelena);
			pravilno += 1;
			Tocke.setText(pravilno + "/" + vsehRacunov);
		}else{
			//Ocena.setBackground(bela);
			Ocena.setText("X");
			Ocena.setForeground(rdeca);
			Tocke.setText(pravilno + "/" + vsehRacunov);
		}
	}
	
	private void zgodovina(){
		String vpisi;
		vpisi = trenutni.zgodovina + "     (" + vpisano + ")";
		labelPrejsniRacun.setText(vpisi);
	}

	
	private void pokazi(){
		trenutni = new Racun();
		labelRacun.setText(trenutni.vStringu);
		vsehRacunov += 1;
		inputRezultat.setText("");
	}

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				GlavnoOkno frame = new GlavnoOkno();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the frame.
	 */
	public GlavnoOkno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Vaje raèunanja - zahtevnost 10"); //se bo spreminjalo
		setResizable(false);
		setBounds(100, 100, 450, 250);
		Dimension dim = new Dimension(600,250);
		setMinimumSize(dim);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(1, 1));
		setContentPane(contentPane);
		
		btnResetiraj = new JButton("Resetiraj");
		
		btnPotrdi = new JButton("Potrdi");
		
		Tocke = new JLabel("0/0");
		Tocke.setBackground(rumena);
		Tocke.setFont(new Font("Tahoma", Font.BOLD, 30));
		Tocke.setOpaque(true);
		Tocke.setHorizontalTextPosition(SwingConstants.CENTER);
		Tocke.setHorizontalAlignment(SwingConstants.CENTER);
		Tocke.setMinimumSize(new Dimension(150, 100));
		Tocke.setMaximumSize(new Dimension(150, 50));
		
		JPanel gumbi = new JPanel();
		gumbi.setLayout(new BoxLayout(gumbi, BoxLayout.LINE_AXIS));
		gumbi.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		gumbi.add(Tocke);
		gumbi.add(Box.createHorizontalGlue());
		gumbi.add(btnResetiraj);
		gumbi.add(Box.createRigidArea(new Dimension(10, 0)));
		gumbi.add(btnPotrdi);
		
		contentPane.add(gumbi, BorderLayout.SOUTH);
		
		labelPrejsniRacun = new JLabel("Prejšni raèun");
		labelPrejsniRacun.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrejsniRacun.setHorizontalTextPosition(SwingConstants.CENTER);
		labelPrejsniRacun.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelPrejsniRacun.setFont(new Font("Arial", Font.ITALIC, 20));
		labelPrejsniRacun.setOpaque(true);
		
		Ocena = new JLabel("??");
		//Ocena.setBackground(bela);
		Ocena.setFont(new Font("Tahoma", Font.BOLD, 30));
		Ocena.setOpaque(true);
		Ocena.setHorizontalTextPosition(SwingConstants.CENTER);
		Ocena.setHorizontalAlignment(SwingConstants.CENTER);
		Ocena.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Ocena.setMinimumSize(new Dimension(200, 100));
		//Ocena.setMaximumSize(new Dimension(80, 50));
		//Ocena.setSize(200, 100);
		
		JPanel bivsi = new JPanel();
		bivsi.setLayout(new BoxLayout(bivsi, BoxLayout.LINE_AXIS));
		bivsi.setBorder(BorderFactory.createEmptyBorder(0, 180, 10, 10));
		//bivsi.add(Box.createHorizontalGlue());
		bivsi.add(labelPrejsniRacun);
		bivsi.add(Box.createRigidArea(new Dimension(60, 0)));
		bivsi.add(Ocena);
		bivsi.add(Box.createHorizontalGlue());
		
		contentPane.add(bivsi, BorderLayout.NORTH);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		
		labelRacun = new JLabel("");
		labelRacun.setOpaque(true);
		labelRacun.setHorizontalTextPosition(SwingConstants.CENTER);
		labelRacun.setHorizontalAlignment(SwingConstants.CENTER);
		//labelRacun.setMaximumSize(new Dimension(150, 50));
		labelRacun.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelRacun.setFont(new Font("Tahoma", Font.BOLD, 30));
		//labelRacun.setMinimumSize(new Dimension(150, 100));
		panel.add(labelRacun);
		panel.add(Box.createHorizontalGlue());
		
		//labelOperacija = new JLabel("");
		//labelOperacija.setOpaque(true);
		//labelOperacija.setHorizontalTextPosition(SwingConstants.CENTER);
		//labelOperacija.setHorizontalAlignment(SwingConstants.CENTER);
		//labelOperacija.setMinimumSize(new Dimension(150, 100));
		//labelOperacija.setMaximumSize(new Dimension(150, 50));
		//labelOperacija.setFont(new Font("Tahoma", Font.BOLD, 30));
		//panel.add(labelOperacija);
		
		//labelDrugaStevilka = new JLabel("");
		//labelDrugaStevilka.setOpaque(true);
		//labelDrugaStevilka.setHorizontalTextPosition(SwingConstants.CENTER);
		//labelDrugaStevilka.setHorizontalAlignment(SwingConstants.CENTER);
		//labelDrugaStevilka.setMinimumSize(new Dimension(150, 100));
		//labelDrugaStevilka.setMaximumSize(new Dimension(150, 50));
		//labelDrugaStevilka.setFont(new Font("Tahoma", Font.BOLD, 30));
		//panel.add(labelDrugaStevilka);
		
		//labelEnakost = new JLabel("=");
		//labelEnakost.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		//labelEnakost.setOpaque(true);
		//labelEnakost.setHorizontalTextPosition(SwingConstants.CENTER);
		//labelEnakost.setHorizontalAlignment(SwingConstants.CENTER);
		//labelEnakost.setMinimumSize(new Dimension(150, 100));
		//labelEnakost.setMaximumSize(new Dimension(150, 50));
		//panel.add(labelEnakost);
		
		//labelRezultat = new JLabel("");
		//labelRezultat.setOpaque(true);
		//labelRezultat.setFont(new Font("Tahoma", Font.BOLD, 30));
		//labelRezultat.setHorizontalTextPosition(SwingConstants.CENTER);
		//labelRezultat.setHorizontalAlignment(SwingConstants.CENTER);
		//labelRezultat.setMinimumSize(new Dimension(150, 100));
		//labelRezultat.setMaximumSize(new Dimension(150, 50));
		//panel.add(labelRezultat);
		
		inputRezultat = new JTextField();
		inputRezultat.setFont(new Font("Tahoma", Font.BOLD, 30));
		inputRezultat.setMaximumSize(new Dimension(150,50));
		panel.add(inputRezultat);
		inputRezultat.setColumns(10);
		
		btnResetiraj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				vsehRacunov = 0;
				pravilno = 0;
				Tocke.setText(pravilno + "/" + vsehRacunov);
				labelPrejsniRacun.setText("Prejšni raèun");
				Ocena.setText("??");
				Ocena.setForeground(crna);
				pokazi();
			}
		});

		btnPotrdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				oceni();
				zgodovina();
				System.out.println(trenutni);
				pokazi();
			}
		});
				
		inputRezultat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					oceni();
					zgodovina();
					System.out.println(trenutni);
					pokazi();
				}
			}
		});

		pokazi();
	}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GlavnoOkno extends JFrame {

	private JPanel contentPane;
	private JTextField inputRezultat;
	
	private Racun trenutni;
	private String vpisano;
	
	public JFrame koncnoOkno;
	
	private JButton btnResetiraj;
	private JButton btnPotrdi;

	private JLabel labelRacun;
	private JLabel Ocena;
	
	private JLabel labelPrejsniRacun;
	
	private JLabel labelCas;
	private long zacetniCas;
	private Timer merilec;
	
	private JLabel Tocke;
	private int vsehRacunov = 0;
	private int pravilno = 0;
	
	private int zahtevnost = 10;
	private int steviloRacunov = 10;
	
	private Color zelena = new Color(51, 204, 0);
	private Color rdeca = new Color(255,17,17);
	private Color rumena = new Color(255,255,150);
	private Color bela = new Color(255, 255, 255);
	private Color svetloZelena = new Color(230,255,230);
	private Color svetloRdeca = new Color(255,230,230);
	
	ArrayList<Integer> tipiRacunov;
	
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
			Ocena.setText("OK");
			Ocena.setForeground(zelena);
			pravilno += 1;
			Tocke.setText(pravilno + "/" + vsehRacunov + " (" + steviloRacunov + ") ");
			inputRezultat.setBackground(svetloZelena);
		}else{
			Ocena.setText("X");
			Ocena.setForeground(rdeca);
			Tocke.setText(pravilno + "/" + vsehRacunov + " (" + steviloRacunov + ") ");
			inputRezultat.setBackground(svetloRdeca);
		}
		if (vsehRacunov == steviloRacunov){
			koncnoSporocilo();
		}
	}
	
	private void koncnoSporocilo(){
		koncnoOkno = new JFrame();
		
		koncnoOkno.setTitle("Rezultat!");
		koncnoOkno.setBounds(300, 300, 600, 150);
		
		JLabel sporocilo = new JLabel();
		sporocilo.setFont(new Font("Tahoma", Font.BOLD, 20));
		sporocilo.setHorizontalTextPosition(SwingConstants.CENTER);
		sporocilo.setHorizontalAlignment(SwingConstants.CENTER);
		
		if (pravilno*Math.pow(steviloRacunov, -1) >= 0.9){
			double cas = (double) (0.001*(System.currentTimeMillis() - zacetniCas));
			String casString = String.format("%.2f", cas);
			sporocilo.setText("Bravo! Pravilno si re�il " + pravilno + " od " + steviloRacunov + " ra�unov v " + casString + " sec!");
		}
		else {
			double cas = (double) (0.001*(System.currentTimeMillis() - zacetniCas));
			String casString = String.format("%.2f", cas);
			sporocilo.setText("Pravilno si re�il " + pravilno + " od " + steviloRacunov + " ra�unov v " + casString + " sec!");
		}
		
		koncnoOkno.add(sporocilo);
		
		koncnoOkno.setVisible(true);
		ZacetnoOkno.zapri();
	}
	
	private void zgodovina(){
		String vpisi;
		vpisi = trenutni.zgodovina + "     (" + vpisano + ")";
		labelPrejsniRacun.setText(vpisi);
	}

	
	private void pokazi(){
		trenutni = new Racun(zahtevnost, tipiRacunov);
		labelRacun.setText(trenutni.vStringu);
		vsehRacunov += 1;
		inputRezultat.setText("");
	}

	/**
	 * Create the frame.
	 */
	public GlavnoOkno(int tezavnost, int stRacunov, ArrayList<Integer> tipi) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(200, 200, 450, 250);
		Dimension dim = new Dimension(600,250);
		setMinimumSize(dim);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(1, 1));
		setContentPane(contentPane);
		
		zahtevnost = tezavnost;
		steviloRacunov = stRacunov;
		tipiRacunov = tipi;
		zacetniCas = System.currentTimeMillis();
        
		setTitle("Vaje ra�unanja - Zahtevnost: " + zahtevnost + "  - �tevilo ra�unov: " + steviloRacunov);
		
		btnResetiraj = new JButton("Spremeni nastavitve");
		btnResetiraj.setToolTipText("Klik bo zaprl trenutno okno!");
		
		btnPotrdi = new JButton("Potrdi");
		
		Tocke = new JLabel("0/" + vsehRacunov + " (" + steviloRacunov + ")");
		Tocke.setBackground(rumena);
		Tocke.setFont(new Font("Tahoma", Font.BOLD, 30));
		Tocke.setOpaque(true);
		Tocke.setHorizontalTextPosition(SwingConstants.CENTER);
		Tocke.setHorizontalAlignment(SwingConstants.CENTER);
		Tocke.setMinimumSize(new Dimension(150, 100));
		Tocke.setMaximumSize(new Dimension(150, 50));
		
		labelCas = new JLabel();
		labelCas.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelCas.setText("0 s");
		
		JPanel gumbi = new JPanel();
		gumbi.setLayout(new BoxLayout(gumbi, BoxLayout.LINE_AXIS));
		gumbi.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		gumbi.add(Tocke);
		gumbi.add(Box.createHorizontalGlue());
		gumbi.add(labelCas);
		gumbi.add(Box.createHorizontalGlue());
		gumbi.add(btnResetiraj);
		gumbi.add(Box.createRigidArea(new Dimension(10, 0)));
		gumbi.add(btnPotrdi);
		
		contentPane.add(gumbi, BorderLayout.SOUTH);
		
		labelPrejsniRacun = new JLabel("Prej�ni ra�un");
		labelPrejsniRacun.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrejsniRacun.setHorizontalTextPosition(SwingConstants.CENTER);
		labelPrejsniRacun.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelPrejsniRacun.setFont(new Font("Arial", Font.ITALIC, 20));
		labelPrejsniRacun.setOpaque(true);
		
		Ocena = new JLabel("??");
		Ocena.setFont(new Font("Tahoma", Font.BOLD, 30));
		Ocena.setOpaque(true);
		Ocena.setHorizontalTextPosition(SwingConstants.CENTER);
		Ocena.setHorizontalAlignment(SwingConstants.CENTER);
		Ocena.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel bivsi = new JPanel();
		bivsi.setLayout(new BoxLayout(bivsi, BoxLayout.LINE_AXIS));
		bivsi.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		bivsi.add(Box.createHorizontalGlue());
		bivsi.add(labelPrejsniRacun);
		bivsi.add(Box.createRigidArea(new Dimension(60, 0)));
		bivsi.add(Ocena);
		bivsi.add(Box.createHorizontalGlue());
		
		contentPane.add(bivsi, BorderLayout.NORTH);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		labelRacun = new JLabel("");
		labelRacun.setOpaque(true);
		labelRacun.setHorizontalTextPosition(SwingConstants.CENTER);
		labelRacun.setHorizontalAlignment(SwingConstants.CENTER);
		labelRacun.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelRacun.setFont(new Font("Tahoma", Font.BOLD, 30));

		inputRezultat = new JTextField();
		inputRezultat.setFont(new Font("Tahoma", Font.BOLD, 30));
		inputRezultat.setMaximumSize(new Dimension(150,50));
		inputRezultat.setBackground(bela);
		inputRezultat.setColumns(8);
		
		panel.add(labelRacun);
		panel.add(Box.createHorizontalGlue());
		panel.add(inputRezultat);
		
		btnResetiraj.addMouseListener(new MouseAdapter() {   // ta bi mogu odpret ponovno osnovno okno
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ZacetnoOkno.zapri();
			}
		});

		btnPotrdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				oceni();
				zgodovina();
				pokazi();
			}
		});
				
		inputRezultat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					oceni();
					zgodovina();
					pokazi();
				}
			}
		});
		
		// Stvari namenjene stopanju casa
		ActionListener osveziCas = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double cas = (double) (0.001*(System.currentTimeMillis() - zacetniCas));
				String casString = String.format("%.2f", cas);
				labelCas.setText(casString + " s");
			}
		};
		
		merilec = new Timer(10, osveziCas);
		merilec.start();
		
		//Zacetni racun
		pokazi();
	}
}

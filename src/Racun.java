import java.util.concurrent.ThreadLocalRandom;

public class Racun {
	final int prvaStevilka;
	final int drugaStevilka;
	final Operacija operacija;
	final int rezultat;
	String vStringu;
	
	public Racun(int prvaStevilka, int drugaStevilka, Operacija operacija, String vStringu, int rezultat){
		this.prvaStevilka = prvaStevilka;
		this.drugaStevilka = drugaStevilka;
		this.operacija = operacija;
		this.rezultat = rezultat;
		this.vStringu = vStringu;
	}

	@Override
	public String toString() {
		return "Racun [prvaStevilka=" + prvaStevilka + ", drugaStevilka=" + drugaStevilka + ", operacija=" + operacija
				+ ", rezultat=" + rezultat + "]";
	}
	
	
	private static int randInt(int min, int max) {
	    return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	public static Racun dobiNaklucenRacun(int zah){
		Operacija operacija = new Operacija(randInt(1,5));
		if (operacija.stevilo == 1){
			int prva = randInt(0, 10*zah);
			int druga = randInt(0, 10*zah);
			String vrni = prva + " + " + druga + " = ";
			int rez = prva + druga;
			return new Racun(prva, druga, operacija, vrni, rez);
		}
		else if (operacija.stevilo == 2){
			int prva = randInt(0, 10*zah);
			int druga = randInt(0, 10*zah);
			String vrni = prva + " - " + druga + " = ";
			int rez = prva - druga;
			return new Racun(prva, druga, operacija, vrni, rez);
		}
		else if (operacija.stevilo == 3){
			int prva = randInt(0, 2*zah);
			int druga = randInt(0, 2*zah);
			String vrni = prva + " * " + druga + " = ";
			int rez = prva * druga;
			return new Racun(prva, druga, operacija, vrni, rez);
		}
		else if (operacija.stevilo == 4){
			int prva = randInt(1, 2*zah);
			int druga = randInt(0,2*zah);
			String vrni = prva*druga + " / " + prva + " = ";
			int rez = druga;
			return new Racun(prva*druga, prva, operacija, vrni, rez);
		}
		else {
			int kolicnik = randInt(0,2*zah);
			int delitelj = randInt(1,2*zah);
			String vrni = "__ / " + delitelj + " = " + kolicnik + " ";
			int rez = kolicnik * delitelj;
			return new Racun(delitelj, kolicnik, operacija, vrni, rez);
		}
	}
	
}

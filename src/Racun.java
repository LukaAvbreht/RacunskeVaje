import java.util.concurrent.ThreadLocalRandom;

public class Racun {
	final int prvaStevilka;
	final int drugaStevilka;
	final Operacija operacija;
	final int rezultat;
	
	public Racun(int prvaStevilka, int drugaStevilka, Operacija operacija){
		this.prvaStevilka = prvaStevilka;
		this.drugaStevilka = drugaStevilka;
		this.operacija = operacija;
		this.rezultat = this.operacija.izracunaj(this.prvaStevilka, this.drugaStevilka);
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
		int prva = randInt(zah, 10*zah);
		int druga = randInt(zah, 10*zah);
		Operacija operacija = new Operacija(randInt(1,3));
		return new Racun(prva, druga, operacija);
	}
	
}

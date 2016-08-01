import java.util.concurrent.ThreadLocalRandom;

public class Racun {
	int tip;
	final int prvaStevilka;
	final int drugaStevilka;
	final int rezultat;
	String vStringu;
	
	public Racun(){
		int zah = 10;
		tip = randInt(1,5);
		if (tip == 1){
			prvaStevilka = randInt(0, 10*zah);
			drugaStevilka = randInt(0, 10*zah);
			vStringu = prvaStevilka + " + " + drugaStevilka + " = ";
			rezultat = prvaStevilka + drugaStevilka;
		}
		else if (tip == 2){
			prvaStevilka = randInt(0, 10*zah);
			drugaStevilka = randInt(0, 10*zah);
			vStringu = prvaStevilka + " - " + drugaStevilka + " = ";
			rezultat = prvaStevilka - drugaStevilka;
		}
		else if (tip == 3){
			prvaStevilka = randInt(0, 2*zah);
			drugaStevilka = randInt(0, 2*zah);
			vStringu = prvaStevilka + " * " + drugaStevilka + " = ";
			rezultat = prvaStevilka * drugaStevilka;
		}
		else if (tip == 4){
			prvaStevilka = randInt(1, 2*zah);
			drugaStevilka = randInt(0,2*zah);
			vStringu = prvaStevilka*drugaStevilka + " / " + prvaStevilka + " = ";
			rezultat = drugaStevilka;
		}
		else {
			drugaStevilka = randInt(0,2*zah);
			prvaStevilka = randInt(1,2*zah);
			vStringu = "__ / " + prvaStevilka + " = " + drugaStevilka + " ";
			rezultat = prvaStevilka*drugaStevilka;
		}
		//this.prvaStevilka = prvaStevilka;
		//this.drugaStevilka = drugaStevilka;
		//this.operacija = operacija;
		//this.rezultat = rezultat;
		//this.vStringu = vStringu;
	}

	@Override
	public String toString() {
		return "Racun [prvaStevilka=" + prvaStevilka + ", drugaStevilka=" + drugaStevilka
				+ ", rezultat=" + rezultat + "]";
	}
	
	
	private static int randInt(int min, int max) {
	    return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Racun {
	int tip;
	final int prvaStevilka;
	final int drugaStevilka;
	final int rezultat;
	String vStringu;
	String zgodovina;
	ArrayList<Integer> tipiRacunov;
	
	public Racun(int zah, ArrayList<Integer> tipiRacunov){
		tip = nakljucniElement(tipiRacunov);
		if (tip == 1){
			prvaStevilka = randInt(10, 10 + 10*zah);
			drugaStevilka = randInt(10, 10 + 10*zah);
			vStringu = prvaStevilka + " + " + drugaStevilka + " = ";
			rezultat = prvaStevilka + drugaStevilka;
			zgodovina = vStringu + rezultat;
		}
		else if (tip == 2){
			prvaStevilka = randInt(0, 10*zah);
			drugaStevilka = randInt(0, 10*zah);
			vStringu = prvaStevilka + " - " + drugaStevilka + " = ";
			rezultat = prvaStevilka - drugaStevilka;
			zgodovina = vStringu + rezultat;
		}
		else if (tip == 3){
			prvaStevilka = randInt(3, 3 + 2*zah);
			drugaStevilka = randInt(3, 3 + 2*zah);
			vStringu = prvaStevilka + " * " + drugaStevilka + " = ";
			rezultat = prvaStevilka * drugaStevilka;
			zgodovina = vStringu + rezultat;
		}
		else if (tip == 4){
			prvaStevilka = randInt(10, 10 + 2*zah);
			drugaStevilka = randInt(1,2*zah);
			vStringu = prvaStevilka*drugaStevilka + " / " + prvaStevilka + " = ";
			rezultat = drugaStevilka;
			zgodovina = vStringu + rezultat;
		}
		else {
			drugaStevilka = randInt(0,2*zah);
			prvaStevilka = randInt(1,2*zah);
			vStringu = "__ / " + prvaStevilka + " = " + drugaStevilka + " ";
			rezultat = prvaStevilka*drugaStevilka;
			zgodovina = rezultat + " / " + prvaStevilka + " = " + drugaStevilka + " ";
		}
	}

	@Override
	public String toString() {
		return "Racun [prvaStevilka=" + prvaStevilka + ", drugaStevilka=" + drugaStevilka
				+ ", rezultat=" + rezultat + "]";
	}
	
	private static int nakljucniElement(ArrayList<Integer> tipi){
		int rnd = randInt(0, tipi.size() - 1);
		return tipi.get(rnd);
	}
	
	
	private static int randInt(int min, int max) {
	    return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
}

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i < 20; i++){
		System.out.println(dobiRacun(9));
		}
	}
	
	//kle bomo generirali random operacije in stevilke ter preverjali ce je vneseni rezultat enak kot dobljena zadeva
	public static int randInt(int min, int max) {
	    return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	public static Racun dobiRacun(int zah){	
		int prva = randInt(zah, 10*zah);
		int druga = randInt(zah, 10*zah);
		Operacija operacija = new Operacija(randInt(1,3));
		return new Racun(prva, druga, operacija);
	}
}

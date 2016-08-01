import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

	public static void main(String[] args) {
	}
	
	//kle bomo generirali random operacije in stevilke ter preverjali ce je vneseni rezultat enak kot dobljena zadeva
	public static int randInt(int min, int max) {
	    return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
}

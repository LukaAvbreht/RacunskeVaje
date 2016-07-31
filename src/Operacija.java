
public class Operacija {
	final int stevilo;
	final String operator;
	
	public Operacija(int stevilo){
		this.stevilo = stevilo;
		
		if(stevilo == 1){
			this.operator = "+";
		}else if(stevilo == 2){
			this.operator = "-";
		}else if(stevilo == 3){
			this.operator = "*";
		}else if(stevilo == 4){
			this.operator = "/";
		}else if(stevilo == 5){
			this.operator = "/";
		}
		else{
			assert false;
			this.operator = "";
		}
	}
	
	public int izracunaj(int prvaStevilka, int drugaStevilka){
		if(this.stevilo == 1){
			return prvaStevilka + drugaStevilka;
		}else if(this.stevilo == 2){
			return prvaStevilka - drugaStevilka;
		}else if(this.stevilo == 3){
			return prvaStevilka * drugaStevilka;
		}else if(this.stevilo == 4){
			return prvaStevilka / drugaStevilka;
		}
		else if(this.stevilo == 5){
			return drugaStevilka * prvaStevilka;
		}
		else{
			assert false;
			return 0;
		}
	}
	
}

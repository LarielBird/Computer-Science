public class Foods {
	
	public String output;
	public Boolean fastfood;
	public Boolean light;
	public Boolean cost;
	public Boolean salty;
	public Boolean healthy;
	
	public Foods(String output, Boolean fastfood, Boolean light, Boolean cost, Boolean salty, Boolean healthy){
		this.output = output;
		this.fastfood = fastfood;
		this.light = light;
		this.cost = cost;
		this.salty = salty;
		this.healthy = healthy;
	}
	public Boolean compareTo(Foods other){
		if(fastfood != other.fastfood){
			return false;
		}
		if(light != other.light){
			return false;
		}
		if(cost != other.cost){
			return false;
		}
		if(salty != other.salty){
			return false;
		}
		if(healthy != other.healthy){
			return false;
		}
		return true;
	}
	public String toString(Foods other){
		return "Your result is" + other.output;
	}
	public static void main (String[] args) {
		
	}
}


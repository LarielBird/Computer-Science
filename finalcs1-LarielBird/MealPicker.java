import java.util.*;
import java.io.*;

public class MealPicker {
	
	public static void main (String[] args)throws FileNotFoundException {
		
		start();
	}
	public static void start(){
		Scanner scan = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		//Intro Message
		System.out.println("""
		Welcome to Meal Picker!
		
		This program helps you decide what you
		would like to eat.
		
		A series of questions will be given and
		at the end a meal idea will be given based
		on your answers.
		--------------------------------------------
		""");
		//Confirmation so user knows how to input data
		System.out.print("\nAre you ready? Enter \"yes\" when you are ready: ");
		String answer = ask(scan);
		while(!answer.equals("yes")&&!answer.equals("y")){
			System.out.print("\nSeriously? Enter \"yes\" when you are ready: ");
			answer = ask(scan);
		}
		//~~Start Quiz~~
		try{
			quizAnswers(scan);
		}catch(FileNotFoundException fnfe){
			
		}
	}


	//Quiz questions:
	public static Boolean healthy(Scanner scan){
		System.out.print("\nWould you like a healthy meal?: ");
		return calc(scan);
	}
	public static Boolean light(Scanner scan){
		System.out.print("\nWould you like something light?: ");
		return calc(scan);
	}
	public static Boolean sweetOrSalty(Scanner scan){
		System.out.print("\nWould you like something salty?: ");
		return calc(scan);

	}
	public static Boolean cost(Scanner scan){
		System.out.print("\nWould you like to treat yourself? (fancy expensive meal)?: ");
		return calc(scan);
	}
	public static Boolean eatInOrOut(Scanner scan){
		System.out.print("\nWould you like to eat out?: ");
		return calc(scan);
	}
	public static Boolean fastFood(Scanner scan){
		System.out.print("\nWould you like fast food?: ");
		return calc(scan);
	}
	//Methods for reused code
	public static String ask(Scanner scan){
		String answer = scan.nextLine();
		answer = answer.toLowerCase();
		return answer;
	}
	public static Boolean calc(Scanner scan){
		String answer = ask(scan);
		while(!answer.equals("yes")&& !answer.equals("no")&& !answer.equals("n")&& !answer.equals("y")){
			System.out.print("\nInvalid input Please enter either Y/N or Yes/No: ");
			answer = ask(scan);
		}
		if(answer.equals("yes")|| answer.equals("y")){
			return true;
		}
		else{
			return false;
		}
	}
	//Calculation for output

	public static void quizAnswers(Scanner scan)throws FileNotFoundException{
		//Intilize quiz answers
		Boolean eatInOrOut = eatInOrOut(scan);
		Boolean cost = cost(scan);
		Boolean light = light(scan);
		Boolean sweetOrSalty = sweetOrSalty(scan);
		Boolean healthy = healthy(scan);
		
		//Initialize food options
		Foods choices = new Foods("Unknown", eatInOrOut,cost,light,sweetOrSalty,healthy);
		//Fast foods
		Foods burger = new Foods("McDonalds or Burger King",true,false,false,true,false);
		Foods tacoBell = new Foods("Taco Bell",true,false,false,true,false);
		Foods pizza = new Foods("Pizza Hut, Dominos, or Little Caesars",true,false,false,true,false);
		Foods wendys = new Foods("Wendy's",true,false,true,true,false);
		Foods fastchicken = new Foods("KFC or Popeyes",true, false, true, true, false);
		Foods arbys = new Foods("Arby's", true, false, false, true, false);
		Foods sandwich = new Foods("Jimmy Johns or Subway", true, false, false, true, true);
		Foods icecream = new Foods("Baskin Robins or Dairy Queen", true, false, true, false, false);
		//Restaurants
		Foods breakfastRestaurant = new Foods("IHOP or Pancake House", true, true, false, false, false);
		Foods diner = new Foods("Applebees or Red Robin",true, false, true, true, false);
		Foods bWW = new Foods("Buffalo Wild Wings",true, false, true, true, false);
		Foods panera = new Foods("Panera",true, true, true, true, true);
		Foods redLobster = new Foods("Red Lobster", true, false, true, true, true);
		Foods oliveGarden = new Foods("Olive Garden", true,true,true,true,false);
		Foods tacoTruck = new Foods("Local Taco Truck", true, false, false, true, true);
		//Sweet foods
		Foods pancakes = new Foods("Pancakes or Waffles",false, false, false, false, false);
		Foods parfait = new Foods("Parfait", false, true, false, false, true);
		Foods cake = new Foods("Cake or Cupcakes", false, false, false, false, false);
		Foods fruitTart = new Foods("Fruit Tart", false, true, false, false, true);
		Foods brownies = new Foods("Brownies", false, false, false, false, false);
		Foods cookies = new Foods("Cookies", false, false, false, false, false);
		Foods pie = new Foods("Pie", false, true, false, false, false);
		//Meals
		Foods katsu = new Foods("Katsu", false, false, false, true, true);
		Foods curry = new Foods("Curry", false, false, false, true, true);
		Foods spaghetti = new Foods("Spaghetti and Meatballs", false, false, false, true, false);
		Foods chicken = new Foods("Rotisserie Chicken", false, false, false, true, true);
		Foods dumplings = new Foods("Dumplings", false, true, false, true, true);
		Foods tacos = new Foods("Carne Asada Tacos", false, false, false, true, true);
		Foods steak = new Foods("Steak with potatos", false, false, true,  true, true);
		Foods salmon = new Foods("Baked salmon with vegies", false, true, true,  true, true);
		Foods bbqPork = new Foods("BBQ Pulled Pork", false, false, true, false,true);
		//Quick
		Foods grilledCheese = new Foods("Grilled Cheese", false, false, false, true, false);
		Foods macAndCheese= new Foods("Mac and Cheese", false, false, false, true, false);
		Foods instantRamen = new Foods("Instant Ramen", false, false, false, true, false);
		Foods overnightOats = new Foods("Overnight Oats", false, true, false, false, true);
		Foods poptart = new Foods("Poptart", false, true, false, false, false);
		Foods yogurt = new Foods("Yogurt", false, true, false, false, true);
		Foods salad = new Foods("Salad", false, true, false, true, true);
		Foods lunchSandwich = new Foods("Lunch Sandwich", false, true, false, true, true);
		Foods hotPocket = new Foods("Hot pocket", false, false, false, true, false);
		Foods soup = new Foods("Instant Soup", false, false, false, true, false);
		
		Foods[] options = {burger, tacoBell,pizza,fastchicken,arbys,sandwich,icecream,breakfastRestaurant,diner,bWW,panera,redLobster,oliveGarden,tacoTruck,
			pancakes,parfait,cake,fruitTart,brownies,cookies,pie,katsu,curry,spaghetti,chicken,dumplings,tacos,steak,salmon,bbqPork,grilledCheese,instantRamen,
			overnightOats,poptart,yogurt,salad,lunchSandwich,hotPocket,soup};
		String[] names = new String[7];
		//Logic
		System.out.println("Your choices are: ");
		//prepare file
		File output = new File("foodOptions.txt");
		PrintStream out = new PrintStream(output);
		
		for(int j = 0; j <= options.length - 1; j++){
			if(choices.compareTo(options[j])== true){
				Foods placeholder = options[j];
				System.out.print(placeholder.output + ", ");
				out.print(placeholder.output + ", ");
		
			}
		}
		
	}
}

import java.util.Random;
import java.util.Scanner;

public class hello{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Random random = new Random();

		int secret = random.nextInt(100) + 1;
		int attempts = 0;
		int guess = 0;
		System.out.println("I'm thinking of a number between 1 and 100.");
		
		while (guess != secret){
			System.out.println("You guess: ");
			guess = input.nextInt();
			attempts++;

			if (guess < secret){
				System.out.println("Too low!");
			}else if (guess > secret) {
				System.out.println("Too high!");
			}else{
				System.out.println("Correct! You got it in " + attempts + " tries. ");
			}
		}
		System.out.println(rating(attempts));
		input.close();
	}

	static String rating(int attempts){
		if (attempts <= 5){
			return "Amazing!";
		} else if (attempts <= 10){
			return "Good job!";
		} else {
			return "Keep practicing!";
		}
	}	
}



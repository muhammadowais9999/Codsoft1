package yyy;
	import java.util.Random;
	import java.util.Scanner;

	public class numbergame {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        
	        int minRange = 1;
	        int maxRange = 100;
	        int maxAttempts = (int) (Math.log(maxRange - minRange + 1) / Math.log(2)) + 1;
	        int score = 0;
	        
	        boolean playAgain = true;
	        while (playAgain) {
	            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
	            System.out.println("Welcome to the Number Guessing Game!");
	            System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". You have " + maxAttempts + " attempts.");
	            
	            int attempts = 0;
	            int lowerBound = minRange;
	            int upperBound = maxRange;
	            
	            while (attempts < maxAttempts) {
	                System.out.print("Enter your guess: ");
	                int userGuess = scanner.nextInt();
	                attempts++;
	                
	                if (userGuess == targetNumber) {
	                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
	                    score++;
	                    break;
	                } else if (userGuess < targetNumber) {
	                    System.out.println("Your guess is too low. Attempts remaining: " + (maxAttempts - attempts));
	                    lowerBound = userGuess + 1;
	                } else {
	                    System.out.println("Your guess is too high. Attempts remaining: " + (maxAttempts - attempts));
	                    upperBound = userGuess - 1;
	                }
	                
	                if (lowerBound > upperBound) {
	                    System.out.println("Oops, you've exhausted your attempts. The correct number was: " + targetNumber);
	                    break;
	                }
	            }
	            
	            System.out.print("Do you want to play again? (yes/no): ");
	            String playAgainInput = scanner.next();
	            playAgain = playAgainInput.equalsIgnoreCase("yes");
	        }
	        
	        System.out.println("Game over! Your final score: " + score);
	    }
	

}


public class Game {

	public String playGame(String playerHand, String computerHand) {

		String result;
		if (playerHand == "rock" && computerHand == "scissors" || playerHand == "scissors" && computerHand == "paper" 
				|| playerHand == "paper" && computerHand == "rock") {
			result = "Win";
			return result;
		}
		else if (computerHand == "rock" && playerHand == "scissors" || computerHand == "scissors" && playerHand == "paper" 
				|| computerHand == "paper"  && playerHand == "rock") {
			result = "Lose";
			return result;
		}
		else {
			result = "Tie";
			return result;
		}
	}
}

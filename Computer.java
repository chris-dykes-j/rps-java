import java.util.Random;

public class Computer {

	public String makeMove() {

		Random random = new Random();
		String hand;
		int num = random.nextInt(2);

		if (num == 0) {
			hand = "rock";
		}
		else if (num == 1) {
			hand = "paper";
		}
		else {
			hand = "scissors";
		}
		return hand;
	}
}

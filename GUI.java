import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {

	public String move;
	public String gameResult = "Welcome to Rock, Paper, Scissors!";
	public int pWin = 0;
	public int cWin = 0;
	public Computer computer;
	public Game game;

	JFrame window = new JFrame();
	JPanel panel = new JPanel();
	JPanel panelTwo = new JPanel();
	JPanel panelThree = new JPanel();
	JButton rock = new JButton("ROCK");
	JButton paper = new JButton("PAPER");
	JButton scissors = new JButton("SCISSORS");
	JLabel result = new JLabel(gameResult);
	JLabel playerWin = new JLabel("Player Wins: " + pWin);
	JLabel computerWin = new JLabel("Computer Wins: " + cWin);

	public GUI(Computer pc, Game rps) {

		rock.addActionListener(this);
		paper.addActionListener(this);
		scissors.addActionListener(this);		
		rock.setActionCommand("rock");
		paper.setActionCommand("paper");
		scissors.setActionCommand("scissors");

		panel.setBorder(BorderFactory.createEmptyBorder(250, 50, 10, 30));
		panel.setLayout(new FlowLayout());		
		panel.add(rock);
		panel.add(paper);
		panel.add(scissors);

		panelTwo.setBounds(0,0, 250, 250);
		panelTwo.setLayout(new FlowLayout());
		panelTwo.add(playerWin);
		panelTwo.add(computerWin);		

		panelThree.setBounds(200, 200, 200, 200);
		panelThree.add(result);

		window.setTitle("Rock Paper Scissors");
		window.setSize(400, 400);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel, BorderLayout.SOUTH);
		window.add(panelTwo, BorderLayout.NORTH);
		window.add(panelThree, BorderLayout.CENTER);
		window.setVisible(true);

		computer = pc;
		game = rps;

	}

	public void onInput(String hand) {

		String move = hand;
		String moveTwo = computer.makeMove();
		String word = game.playGame(move, moveTwo);

		if (word == "Win") {
			pWin++;
			playerWin.setText("Player Wins: " + Integer.toString(pWin));
			gameResult = "You Win";
		}
		else if (word == "Lose" ) {
			cWin++;
			computerWin.setText("Computer Wins: " + Integer.toString(cWin));
			gameResult = "You Lose";
		}	
		else {
			gameResult = "Tie";
		}
		result.setText(gameResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String hand = e.getActionCommand();
		onInput(hand);
	}

}

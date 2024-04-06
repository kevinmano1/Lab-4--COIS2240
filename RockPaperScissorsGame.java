import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsGame extends JFrame {
    private int wins = 0, losses = 0, draws = 0;
    private final JLabel scoreLabel;
    private final Random random = new Random();

    public RockPaperScissorsGame() {
        setTitle("Rock Paper Scissors Game");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");
        scoreLabel = new JLabel("Wins: 0 Losses: 0 Draws: 0");

        rockButton.addActionListener(e -> playRound("Rock"));
        paperButton.addActionListener(e -> playRound("Paper"));
        scissorsButton.addActionListener(e -> playRound("Scissors"));

        add(rockButton);
        add(paperButton);
        add(scissorsButton);
        add(scoreLabel);
    }

    private void playRound(String playerChoice) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        String computerChoice = choices[random.nextInt(choices.length)];
        String result;

        if (playerChoice.equals(computerChoice)) {
            draws++;
            result = "You drew :/";
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                   (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                   (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            wins++;
            result = "You won :)";
        } else {
            losses++;
            result = "You lost :(";
        }

        scoreLabel.setText("Wins: " + wins + " Losses: " + losses + " Draws: " + draws);
        JOptionPane.showMessageDialog(this, "Computer chose: " + computerChoice + "\n" + result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RockPaperScissorsGame().setVisible(true));
    }
}

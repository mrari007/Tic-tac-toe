import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicGui extends  JFrame implements ActionListener {
    private String output = "";
    private Game game = new Game();
    private JFrame frame = new JFrame();   //frame for the pop up window
    private JPanel firstPanel = new JPanel();
    private JPanel secondPanel = new JPanel();
    private JLabel turnLab = new JLabel();
    private JLabel resultLab = new JLabel();
    private JButton [] buttonsArr = new JButton [9];

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        TicGui window = new TicGui();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    /**
     * Constructor
     */
    public TicGui() {
        super("Tic Tac Toe");
        setLayout(new BorderLayout());
        firstPanel.setBounds(0,0,510, 70);
        firstPanel.setBackground(Color.lightGray);
        secondPanel.setLayout(new GridLayout(3,3));;
        secondPanel.setBounds(0,70,510, 450);
        turnLab.setFont(new Font("Ariel",Font.PLAIN, 45));
        RandomP();
        firstPanel.add(turnLab);
        resultLab.setFont(new Font("Ariel",Font.PLAIN, 18));
        resultLab.setText("                       result: " + game.getPlayerOneScore() + "-" + game.getPlayerTwoScore());
        firstPanel.add(resultLab);
        add(firstPanel,BorderLayout.NORTH);

        //loops through the array of buttons
        for(int i = 0; i < 9; i ++) {
            buttonsArr[i] = new JButton();  //creating the buttons
            secondPanel.add(buttonsArr[i]);
            buttonsArr[i].setFont(new Font("Ariel",Font.PLAIN, 70));
            buttonsArr[i].addActionListener(this);
        }

        add(secondPanel);
        setSize(510, 520);
        setVisible(true);
    }

    /**
     *
     * @param event
     */
    public void actionPerformed(ActionEvent event) {
        for (int i = 0; i < 9; i++) {

            //filling the buttons with the appropriate text
            if (event.getSource() == buttonsArr[i]) {
                if (buttonsArr[i].getText() == "" && turnLab.getText().contains("1")) {
                    buttonsArr[i].setText("X");
                    turnLab.setText("Player 2 turn");
                } else if (buttonsArr[i].getText() == "" && turnLab.getText().contains("2")) {
                    buttonsArr[i].setText("O");
                    turnLab.setText("Player 1 turn");
                }
            }
        }
        output = game.winner(buttonsArr);
        if (output == "") {
            output = game.draw(buttonsArr);
        }

        if (output != "") {
            JOptionPane.showMessageDialog(frame, output, "Result", JOptionPane.PLAIN_MESSAGE);

            // When the ok button is clicked - calculates the result and determines who's turn will be the next game
            if(JOptionPane.OK_OPTION == 0) {
                blank();
                resultLab.setText("                       result: " + game.getPlayerOneScore() + "-" + game.getPlayerTwoScore());
                if(game.getPlayerOneScore() > game.getPlayerTwoScore()) {
                    turnLab.setText("Player 2 turn");
                } else if (game.getPlayerOneScore() < game.getPlayerTwoScore()) {
                    turnLab.setText("Player 1 turn");
                } else {
                    RandomP();
                }
            }
        }
    }

    /**
     * Clears the texts of the buttons
     */
    public void blank () {
        for (int i = 0; i < 9; i ++) {
            buttonsArr[i].setText("");
        }
    }

    /**
     * Randomly setting which player is on turn
     */
    public void RandomP () {
        if(game.randomTurn() == 0) {
            turnLab.setText("Player 1 turn");
        } else {
            turnLab.setText("Player 2 turn");
        }
    }
}

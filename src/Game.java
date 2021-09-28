import javax.swing.*;
import java.util.Random;

public class Game {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    /**
     * Defines the winning combinations
     * @param arr
     * @return
     */
    public String winner (JButton[] arr) {
        String result = "";
        if((arr[0].getText() == "X" &&  arr[1].getText() == "X" &&  arr[2].getText() == "X") ||
                (arr[3].getText() == "X" &&  arr[4].getText() == "X" &&  arr[5].getText() == "X") ||
                (arr[6].getText() == "X" &&  arr[7].getText() == "X" &&  arr[8].getText() == "X") ||
                (arr[0].getText() == "X" &&  arr[3].getText() == "X" &&  arr[6].getText() == "X") ||
                (arr[1].getText() == "X" &&  arr[4].getText() == "X" &&  arr[7].getText() == "X") ||
                (arr[2].getText() == "X" &&  arr[5].getText() == "X" &&  arr[8].getText() == "X") ||
                (arr[0].getText() == "X" &&  arr[4].getText() == "X" &&  arr[8].getText() == "X") ||
                (arr[2].getText() == "X" &&  arr[4].getText() == "X" &&  arr[6].getText() == "X")) {
            playerOneScore++;
            result = "Player 1 wins";
        } else  if((arr[0].getText() == "O" &&  arr[1].getText() == "O" &&  arr[2].getText() == "O") ||
                (arr[3].getText() == "O" &&  arr[4].getText() == "O" &&  arr[5].getText() == "O") ||
                (arr[6].getText() == "O" &&  arr[7].getText() == "O" &&  arr[8].getText() == "O") ||
                (arr[0].getText() == "O" &&  arr[3].getText() == "O" &&  arr[6].getText() == "O") ||
                (arr[1].getText() == "O" &&  arr[4].getText() == "O" &&  arr[7].getText() == "O") ||
                (arr[2].getText() == "O" &&  arr[5].getText() == "O" &&  arr[8].getText() == "O") ||
                (arr[0].getText() == "O" &&  arr[4].getText() == "O" &&  arr[8].getText() == "O") ||
                (arr[2].getText() == "O" &&  arr[4].getText() == "O" &&  arr[6].getText() == "O")) {
            playerTwoScore++;
            result = "Player 2 wins";
        }
        return result;
    }

    /**
     * Checks if there is a draw
     * @param arr
     * @return
     */
    public String draw (JButton[] arr) {
        String result = "";
        int count = 0;
        for(int i=0; i < 9;i ++) {
            if (arr[i].getText() == "") {
                count++;
            }
        }
        if(winner(arr) == "" && count == 0) {
            result = "Draw";
        }
        return result;
    }

    /**
     *
     * @return
     */
    public int getPlayerOneScore() {
        return playerOneScore;
    }

    /**
     *
     * @return
     */
    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    /**
     * determines which player start in the beginning of the game or if the result is even
     * @return
     */
    public int randomTurn() {
        Random r =  new Random();
        int turn = r.nextInt(2);
        return turn;
    }
}

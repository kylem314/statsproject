package FRQS;
import java.util.Scanner;

public class CoinGameCZ {
    private int startingCoins; // starting number of coins

    private int maxRounds; // maximum number of rounds played



    public CoinGameCZ(int s, int r)

    {

        startingCoins = s;

        maxRounds = r;

    }



    /** Returns the number of coins (1, 2, or 3) that player 1 will spend.

     */

    public int getPlayer1Move(int round){
        int result = 1;

        if (round % 3 == 0){
            result = 3;
        }
        else if (round % 2 == 0){
            result = 2;
        }
        return result;
    }



    /** Returns the number of coins (1, 2, or 3) that player 2 will spend, as described in part (a).

     */

    public int getPlayer2Move(int round){
        int result = 1;

        if (round % 3 == 0){
            result = 3;
        }
        else if (round % 2 == 0){
            result = 2;
        }
        return result;
    }



    /** Plays a simulated game between two players, as described in part (b).

     */

    public void playGame() {
        int Roundnumber = 1;
        int r = 1;
        int p1coins = startingCoins;
        int p2coins = startingCoins;
        while (Roundnumber <= maxRounds && p1coins >= 3 && p2coins >= 3){
            p1coins -= getPlayer1Move(r);
            p2coins -= getPlayer2Move(r);
            if(Math.abs(getPlayer1Move(r) - getPlayer2Move(r)) == 1){
                p2coins += 1;
            }
            else if(Math.abs(getPlayer1Move(r) - getPlayer2Move(r)) == 2){
                p1coins += 2;
            }

        }
        if (p1coins > p2coins){
            System.out.println("player 1 wins");
        }
        else if (p1coins < p2coins){
            System.out.println("player 2 wins");
        }
        else{
            System.out.println("tie game");
        }

    }
    public static void main(String[] args) {
        CoinGameCZ name = new CoinGameCZ(30,10);
        Scanner myObj = new Scanner(System.in);
        int p1input;
        int p2input;
    }
}


package FRQS;
import java.util.Scanner;

/** Question 1

 */

public class CoinGameEW {

    public static void longestStreak(String str)
    {
        int len = str.length();
        int count = 0;

        char res = str.charAt(0);
        for (int i=0; i<str.length(); i++) {
            int countSoFar = 1;
            for (int j=i+1; j<len; j++)
            {
                if (str.charAt(i) != str.charAt(j))
                    break;
                countSoFar++;
            }

            if (countSoFar > count)
            {
                count = countSoFar;
                res = str.charAt(i);
            }
        }
        System.out.println( res+" : "+count);
    }

    public void main(String args[])
    {

        String str = "CCAAAAATTT!";
        longestStreak(str);
    }

    /** Question 2 Part A

     */

        public int getPlayer2Move(int round) {
            int result = 0;

            //If round is divided by 3
            if (round % 3 == 0) {
                result = 3;
            }
            //if round is not divided by 3 and is divided by 2
            else if (round % 3 != 0 && round % 2 == 0) {
                result = 2;
            }
            //if round is not divided by 3 or 2
            else {
                result = 1;
            }

            return result;

        }

        /**
         * Question 2 Part B
         */



            private int startingCoins;
            private int maxRounds;
            public int getPlayer1Move;

            public void playGame() {

                //Initializing player 1 coins
                int player1Coins = startingCoins;

                //Initializing player 2 coins
                int player2Coins = startingCoins;


                for (int round = 1; round <= maxRounds; round++) {

                    //if the player 1 or player 2 coins are less than 3
                    if (player1Coins < 3 || player2Coins < 3) {
                        break;
                    }

                    //The number of coins player 1 spends
                    int player1Spends = getPlayer1Move;

                    //The number of coins player 2 spends
                    int player2Spends = getPlayer2Move(round);

                    //Remaining coins of player 1
                    player1Coins -= player1Spends;

                    //Remaining coins of player 2
                    player2Coins -= player2Spends;

                    //If player 2 spends the same number of coins as player 2 spends
                    if (player1Spends == player2Spends) {
                        player2Coins += 1;
                        continue;
                    }

                    //positive difference between the number of coins spent by the two players
                    int difference = Math.abs(player1Spends - player2Spends);

                    //if difference is 1
                    if (difference == 1) {
                        player2Coins += 1;
                        continue;
                    }

                    //If difference is 2
                    if (difference == 2) {
                        player1Coins += 2;
                        continue;
                    }


                }

                // At the end of the game
                //If player 1 coins is equal to player two coins
                if (player1Coins == player2Coins) {
                    System.out.println("tie game");
                }
                //If player 1 coins are greater than player 2 coins
                else if (player1Coins > player2Coins) {
                    System.out.println("player 1 wins");
                }
                //If player 2 coins is greater than player 2 coins
                else if (player1Coins < player2Coins) {
                    System.out.println("player 2 wins");
                }

            }
        }

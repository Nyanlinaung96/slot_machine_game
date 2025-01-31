import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // JAVA SLOT GAME

        // CREATE VARIABLES
        Scanner scanner = new Scanner(System.in);
        int balance=100;
        int bet;
        String[] row;
        int payout;
        boolean value = true;

        // WELCOME MESSAGE
        System.out.println("*************************");
        System.out.println("  Welcome to JAVA Slots  ");
        System.out.println("Symbols: 🌾 🌽 🍉 ⭐️ 👑  ");
        System.out.println("*************************");
        // PLAY IF BET > 0
        while(balance > 0){
            System.out.println("Current balance: $" + balance);
            System.out.print("Place your bet amount: ");
            bet = scanner.nextInt();
            scanner.nextLine();
            if(bet > balance){
                System.out.println("******************");
                System.out.println("INSUFFICIENT FUNDS");
                System.out.println("******************");

                continue;
            }
            else if (bet <= 0) {
                System.out.println("**************************");
                System.out.println("Bet must be greater than 0");
                System.out.println("**************************");
                continue;

            }
            else{
                balance -= bet;

            }
            System.out.println("Spinning...");
            row = spinRow();
            printRow(row);
            payout = getPayout(row,bet);
            if(payout > 0){
                System.out.println("You won $:" + payout);
                balance += payout;

            }
            else{
                System.out.println("Sorry you lost this round:");

            }
            System.out.print("Do you want to play again? (Y/N):");
            String playAgain = scanner.nextLine();
            if (playAgain.equalsIgnoreCase("Y")) {
                continue;
            }

            else {
                System.out.println("Bye Bye");
                break;

            }

        }



        // ENTER BET AMOUNT
        //  VERIFY IF BET > BALANCE
        //  VERIFY IF BET > 0
        //  SUBTRACT BET FROM BALANCE
        // SPIN ROW
        // PRINT ROW
        // GET PAYOUT
        // ASK TO PLAY AGAIN
        // DISPLAY EXIT MESSAGE
        scanner.close();
    }
    static String[] spinRow(){
        String[] symbols = {"🌾","🌽","🍉","⭐","👑"};
        String[] row = new String[3];
        Random random = new Random();
        for(int i=0;i<3;i++){
            row[i] = symbols[random.nextInt(symbols.length)];
        }
        return row;
    }
    static void printRow(String[] row){
        System.out.println("*************************");
        System.out.println(" "+ String.join(" | ", row));
        System.out.println("*************************");
    }
    static int getPayout(String[] row, int bet){
        if(row[0].equals(row[1]) && row[1].equals(row[2])){
            return switch(row[0]){
                case "🌾" -> bet * 30;
                case "🌽" -> bet * 40;
                case "🍉" -> bet * 50;
                case "⭐️" -> bet * 100;
                case "👑" -> bet * 200;
                default -> 0;
            };
        }
        else if(row[0].equals(row[1])){
            return switch(row[0]){
                case "🌾" -> (bet * 3) + bet;
                case "🌽" -> (bet * 4) + bet;
                case "🍉" -> (bet * 5) + bet;
                case "⭐️" -> (bet * 10) + bet;
                case "👑" -> (bet * 20) + bet;
                default -> 0;
            };
        }
        else if(row[1].equals(row[2])){
            return switch(row[1]){
                case "🌾" -> (bet * 3) + bet;
                case "🌽" -> (bet * 4) + bet;
                case "🍉" -> (bet * 5) + bet;
                case "⭐️" -> (bet * 10) + bet;
                case "👑" -> (bet * 20) + bet;
                default -> 0;
            };
        }
        return 0;

    }
}
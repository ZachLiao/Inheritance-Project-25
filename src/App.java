import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    private static Scanner in = new Scanner(System.in);
    private static String name;
    private static int position = 0;
    private static Slots s;
    private static Roulette r;
    private static Player p;
    private static int previousPosition;

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, Geffen!");
        // Roulette r1 = new Roulette("r1", 0, 0);
        // r1.intro();
        // r1.play();
        // System.out.println("Hi zach");
        System.out.println(
                "Welcome to the Casino! \n You will have the option of playing multiple different games tonight. \n First, lets get your name. Please type it in");
        name = in.nextLine();
        System.out.println(
                "Welcome to the Casino " + name + "! \n We have given you $10,000 to gamble with tonight. Enjoy!");
        p = new Player(name, 10000);
        outerLoop: while (true) {

            if (position == 0) {
                System.out.println("""
                        Which game would you like to play?
                        1) Roulette
                        2) Slots
                        3) End Game
                        """);
                while (true) {
                    String input = in.nextLine();
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(input);

                    if (matcher.find()) {
                        int number = Integer.parseInt(matcher.group());
                        if (number > 0 && number < 4) {
                            position = number;
                            previousPosition = number;
                            break;
                        }
                        System.out.println("Not a valid choice");
                    } else {
                        System.out.println("No number found.");
                        System.out.println("Please try again");
                    }
                }
            }
            //if position = 1, play roulette
            if (position == 1) {
                int chooseBetSize;
                System.out.println("""
                        What would you like your bet size to be?
                        type a number between $1 and $5000
                        You can change it later
                        type 0 to end the code
                        """);
                while (true) {
                    String input = in.nextLine();
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(input);

                    if (matcher.find()) {
                        int number = Integer.parseInt(matcher.group());
                        if (number == 0) {
                            break outerLoop;
                        }
                        if (number > 0 && number < 5001) {
                            chooseBetSize = number;
                            break;
                        }
                        System.out.println("Not a valid choice");
                    } else {
                        System.out.println("No number found.");
                        System.out.println("Please try again");
                    }
                }
                r = new Roulette("Roulette", chooseBetSize, 1);
                r.intro();
                r.play(p);
                position = 4;
            }
            
            // if position = 2, play slots
            if (position == 2) {
                int chooseBetSize;
                System.out.println("""
                        What would you like your bet size to be?
                        type a number between $1 and $5000
                        You can change it later
                        type 0 to end the code
                        """);
                while (true) {
                    String input = in.nextLine();
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(input);

                    if (matcher.find()) {
                        int number = Integer.parseInt(matcher.group());
                        if (number == 0) {
                            break outerLoop;
                        }
                        if (number > 0 && number < 5001) {
                            chooseBetSize = number;
                            break;
                        }
                        System.out.println("Not a valid choice");
                    } else {
                        System.out.println("No number found.");
                        System.out.println("Please try again");
                    }
                }
                s = new Slots("Slots", chooseBetSize, 1);
                s.play1D(p);
                position = 4;
            }
            
            // if position = 3, end code
            if (position == 3) {
                break;
            }
            
            // if position = 4, ask player what to do next
            if (position == 4) {
                System.out.println("""
                        What would you like to do next?
                        1) play again
                        2) change bet size
                        3) play a different game
                        4) End Game
                        5) get Player and slots bet size info
                            """);
                while (true) {
                    String input = in.nextLine();
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(input);

                    if (matcher.find()) {
                        int number = Integer.parseInt(matcher.group());
                        if (number == 4) {
                            break outerLoop;
                        }
                        if (number == 1 && previousPosition == 1) {
                            position = 8;
                            break;
                        }
                        else if (number == 1 && previousPosition == 2) {
                            position = 5;
                            break;
                        }
                        if (number == 2) {
                            position = 6;
                            break;
                        }
                        if (number == 3) {
                            position = 0;
                            break;
                        }
                        if (number == 5) {
                            position = 7;
                            break;
                        }
                        System.out.println("Not a valid choice");
                    } else {
                        System.out.println("No number found.");
                        System.out.println("Please try again");
                    }
                }
            }
           
            // if position = 5, play slots again
            if (position == 5) {
                s.play1D(p);
                position = 4;
            }
            
            //if position = 8, play roulette again
            if (position == 8) {
                r.intro();
                r.play(p);
                position =4;
            }

            //if position = 6, change bet size
            if (position == 6) {
                System.out.println("""
                        What would you like to change your betsize to for Slots?
                        Type a number 1 - 5000
                        Type 0 to end the code
                            """);
                while (true) {
                    String input = in.nextLine();
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(input);

                    if (matcher.find()) {
                        int number = Integer.parseInt(matcher.group());
                        if (number == 0) {
                            break outerLoop;
                        }
                        if (number > 0 && number < 5001) {
                            s.setBetSize(number);
                            break;
                        }
                        System.out.println("Not a valid choice");
                    } else {
                        System.out.println("No number found.");
                        System.out.println("Please try again");
                    }
                }
                System.out.println("you are now betting with a bet size of $" + s.getBetSize());
                position = 4;
            }
            
            //if position = 7, prints out the toString in Roulette and Slots
            if (position == 7) {
                p.setTotalHandsPlayed(Slots.slotsPlayed + Roulette.roulettesPlayed);
                System.out.println(p);
                System.out.println(s);
                position = 4;
            }
            if (p.getWallet() <= 0) {
                System.out.println("You ran out of money!");
                break outerLoop;
            }
            
        }
       
    }

}

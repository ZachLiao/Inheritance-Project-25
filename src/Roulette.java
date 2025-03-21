import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Roulette extends Game {
    private Scanner in = new Scanner(System.in);
    private int choice;
    private int tile;
    private int color;
    private int EvenOrOdd;
    // private int redSquares = 18;
    // private int blackSquares = 18;
    // private int greenSquares = 1;
    private int selectedTile;
    private int selectedColor;
    private int selectedEvenOrOdd;

    public Roulette(String name, int betSize, double payout) {
        super(name, betSize, payout);
    }

    public void play() {
        // asks user how much they want to bet
        System.out.println("How much would you like to bet?");
        while (true) {
            String input = in.nextLine();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                setBetSize(number);
                break;
            } else {
                System.out.println("No number found.");
                System.out.println("Please try again");
            }
        }
        // if choice = 1, user chooses to bet on a color
        if (choice == 1) {
            System.out.println(getName() + " chooses to bet on COLOR");
            System.out.println("""
                    What color do you want to choose:
                    Option 1: Red
                    Option 2: Black
                    Option 3: Green
                    Type "1", "2" or "3" to indicate your choice.
                    """);
            while (true) {
                String input = in.nextLine();
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(input);

                if (matcher.find()) {
                    int number = Integer.parseInt(matcher.group());
                    if (number > 0 && number < 4) {
                        color = number;
                        break;
                    }
                    System.out.println("Not a valid choice");
                } else {
                    System.out.println("No number found.");
                    System.out.println("Please try again");
                }
            }

            if (selectedColor == color && color != 3) {
                System.out.println("You Won" + getBetSize());
            }
            
        }
        // if choice = 2, user chooses to bet on a tile
        if (choice == 2) {
            System.out.println(getName() + " chooses to bet on TILE");
            System.out.println("What tile would you like to choose? (0 through 36 inclusive)");
            while (true) {
                String input = in.nextLine();
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(input);

                if (matcher.find()) {
                    int number = Integer.parseInt(matcher.group());
                    if (number > -1 && number < 37) {
                        tile = number;
                        break;
                    }
                    System.out.println("Not a valid choice");
                } else {
                    System.out.println("No number found.");
                    System.out.println("Please try again");
                }
            }
        }
        // if choice = 3, user chooses to bet on a even or odd
        if (choice == 3) {
            System.out.println(getName() + " chooses to bet on EVEN/ODD");
            System.out.println("""
                    Choose Even or Odd:
                    Option 1: ODD
                    Option 2: EVEN
                    Type "1" or "2" to indicate your choice
                    """);
            while (true) {
                String input = in.nextLine();
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(input);

                if (matcher.find()) {
                    int number = Integer.parseInt(matcher.group());
                    if (number > 0 && number < 3) {
                        EvenOrOdd = number;
                        break;
                    }
                    System.out.println("Not a valid choice");
                } else {
                    System.out.println("No number found.");
                    System.out.println("Please try again");
                }
            }
        }
    }

    public void intro() {
        System.out.println("""
                You chose to play Roulette. You have 3 options to play:
                Option 1: bet on COLOR
                Option 2: bet on TILE
                Option 3: bet on EVEN/ODD
                Type "1", "2" or "3" to indicate your choice.
                """);
        while (true) {
            String input = in.nextLine();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                if (number > 0 && number < 4) {
                    choice = number;
                    break;
                }
                System.out.println("Not a valid choice");
            } else {
                System.out.println("No number found.");
                System.out.println("Please try again");
            }
        }
    }

    public void roll() {
        selectedTile = (int) Math.random()*38;
        if (selectedTile == 0) {
            selectedColor = 3;
        }
        else if (selectedTile % 2 == 0) {
            selectedColor = 1;
        }
        else if (selectedColor % 2 == 1) {
            selectedColor = 2;
        }
        if (selectedTile % 2 == 0) {
            selectedEvenOrOdd = 2;
        }
        else {
            selectedEvenOrOdd = 1;
        }
    }
}
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class App {
    private static Scanner in = new Scanner(System.in);
    private static String name;
    private static int position = 0;
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, Geffen!");
        // Roulette r1 = new Roulette("r1", 0, 0);
        // r1.intro();
        // r1.play();
        // System.out.println("Hi zach");
        System.out.println("Welcome to the Casino! \n You will have the option of playing multiple different games tonight. \n First, lets get your name. Please type it in");
        name = in.nextLine();
        System.out.println("Welcome to the Casino " + name + "! \n We have given you $10,000 to gamble with tonight. Enjoy!");
        Player p = new Player(name, 10000);
        while (true) { 
            if (position == 3){
                break;
            }
            if (position == 0){
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
                            break;
                        }
                        System.out.println("Not a valid choice");
                    } else {
                        System.out.println("No number found.");
                        System.out.println("Please try again");
                    }
                }
            }
            if (position ==2){
                
            }
            
        }
    }
}

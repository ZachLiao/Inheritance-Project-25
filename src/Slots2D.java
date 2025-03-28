import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Slots2D  extends Game{
    private int rows;
    private int cols;
    private Scanner in = new Scanner(System.in);
    public Slots2D(String name, int betSize, int payout, int rows, int columns){
        super(name, betSize, payout);
        this.rows = rows;
        this.cols = columns;

    }
    public void intro2D(Player a){
        System.out.println("""
                You chose to play 2DSlots. You may choose from 3 to 7 rows.
                Type a number 3 through 7 to confirm your choice.
                """);
        while (true) {
            String input = in.nextLine();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                if (number > 2 && number < 8) {
                    rows = number;
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

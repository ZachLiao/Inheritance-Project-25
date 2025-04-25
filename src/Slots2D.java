import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Slots2D  extends Game{
    private int rows;
    private int cols;
    private int numberOfSymbols;
    public static int slots2DPlayed = 0;
    private String[] symbolsToChooseFrom = {"7️⃣", "🔔", "🍫", "🍇", "🍒", "🍀", "🍋", "💎", "🍊", "🍉", "🧲", "🍋‍🟩"};
    private String[] symbols;
    private Scanner in = new Scanner(System.in);
    public Slots2D(String name, int betSize, int payout){
        super(name, betSize, payout);
        intro2D();
        symbols = new String[numberOfSymbols];
        for (int i=0; i<numberOfSymbols; i++){
            symbols[i] = symbolsToChooseFrom[i];
        }
        System.out.println("You have selected to play a slots game with " + cols + " columns and " + rows + " rows and " + numberOfSymbols + " symbols");

    }
    public int getRows(){
        return rows;
    }
    public void setRows(int a){
        rows = a;
    }
    public int getColumns(){
        return cols;
    }
    public void setColumns(int a){
        cols = a;
    }
    public int getNumberOfSymbols(){
        return numberOfSymbols;
    }
    public void setNumberOfSymbols(int b){
        numberOfSymbols = b;
        symbols = new String[numberOfSymbols];
        for (int i=0; i<numberOfSymbols; i++){
            symbols[i] = symbolsToChooseFrom[i];
        }
    }
    public void intro2D(){
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
        System.out.println("""
                Now you may choose from 3 to 7 rows.
                Type a number 3 through 7 to confirm your choice.
                """);
        while (true) {
            String input = in.nextLine();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                if (number > 2 && number < 8) {
                    cols = number;
                    break;
                }
                System.out.println("Not a valid choice");
            } else {
                System.out.println("No number found.");
                System.out.println("Please try again");
            }
        }
        System.out.println("""
                Now please choose from 3 to 12 symbols in each square.
                Type a number from 3 to 12 to confirm your choice.
                """);
        while (true) {
            String input = in.nextLine();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(input);
        
            if (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                if (number > 2 && number < 13) {
                    numberOfSymbols = number;
                    break;
                }
                System.out.println("Not a valid choice");
            } else {
                System.out.println("No number found.");
                System.out.println("Please try again");
            }
        }
    }
    public void play2D(Player a){
        String[][] result = new String[rows][cols];
        for (int r=0; r<rows; r++){
            for (int c=0; c<cols; c++){
                result[r][c] = symbols[(int)(Math.random()*numberOfSymbols)];
            }
        }
        for (String[] r: result){
            for (String c: r){
                System.out.print(c + "  ");
            }
            System.out.println();
        }
        a.setWallet(a.getWallet() - getBetSize() + SlotsPayoutCalculator.calculatePayout2D(result, cols, rows, numberOfSymbols, getBetSize()));
        slots2DPlayed++;
    }
    @Override
    public String toString(){
        return "You are currently betting $" + getBetSize() + " on Slots2D";
    }
}

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Slots extends Game{
    private Scanner in = new Scanner(System.in);
    private int choice;
    private int columns;
    private int numberOfSymbols;
    public static int slotsPlayed = 0;
    private String[] symbolsToChooseFrom = {"7️⃣", "🔔", "🍫", "🍇", "🍒", "🍀", "🍋", "💎", "🍊", "🍉", "🧲", "🍋‍🟩"};
    private String[] symbols;
    public Slots(String name, int betSize, double payout){
        super(name, betSize, payout);
        intro1D();
        symbols = new String[numberOfSymbols];
        for (int i=0; i<numberOfSymbols; i++){
            symbols[i] = symbolsToChooseFrom[i];
        }
        System.out.println("You have selected to play a slots game with " + columns + " columns and " + numberOfSymbols + " symbols");
        
    }
    public int getColumns(){
        return columns;
    }
    public void setColumns(int a){
        columns = a;
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
    public void play1D(Player a) throws InterruptedException{
        String[] result = new String[columns];
        for (int i=0; i< result.length; i++){
            result[i] = symbols[(int)(Math.random()*numberOfSymbols)];
        }
        // for (String result1 : result) {
        //     System.out.print(result1 + " ");
        // }

        SlotsAnimation animation = new SlotsAnimation(symbols, result, 30);
        animation.start();
        System.out.println();
        System.out.println();
        a.setWallet(a.getWallet() - getBetSize() + SlotsPayoutCalculator.calculatePayout(result, columns, numberOfSymbols, getBetSize()));
        slotsPlayed++;
        
        
    }
    public void intro1D() {
        System.out.println("""
                You chose to play Slots. You may choose from 3 to 7 columns.
                Type a number 3 through 7 to confirm your choice.
                """);
        while (true) {
            String input = in.nextLine();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                if (number > 2 && number < 8) {
                    columns = number;
                    break;
                }
                System.out.println("Not a valid choice");
            } else {
                System.out.println("No number found.");
                System.out.println("Please try again");
            }
        }
        System.out.println("""
                Now please choose from 3 to 12 symbols in each column.
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
    @Override
    public String toString(){
        return "You are currently betting $" + getBetSize() + " on Slots";
    }
}

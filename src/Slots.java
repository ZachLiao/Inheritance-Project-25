import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Slots extends Game{
    private Scanner in = new Scanner(System.in);
    private int choice;
    private int columns;
    private int numberOfSymbols;
    private String[] symbolsToChooseFrom = {"7", "bell", "bar", "bell", "cherry", "clover", "lemon", "diamond", "orange", "watermelon", "horseshoe", "lime"};
    private String[] symbols;
    public Slots(String name, int betSize, double payout){
        super(name, betSize, payout);
        setTimesPlayed(0);
        intro();
        symbols = new String[numberOfSymbols];
        for (int i=0; i<numberOfSymbols; i++){
            symbols[i] = symbolsToChooseFrom[i];
        }
        
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
    @Override
    public void play(){

    }
    public void intro() {
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
}

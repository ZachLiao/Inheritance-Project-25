public class Slots extends Game{
    private int columns;
    private int numberOfSymbols;
    private String[] symbols;
    public Slots(String name, int betSize, double payout){
        super(name, betSize, payout);
        setTimesPlayed(0);
    }
}

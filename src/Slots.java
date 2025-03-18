public class Slots extends Game{
    private int columns;
    private int numberOfSymbols;
    private String[] symbolsToChooseFrom = {"7", "bell", "bar", "bell", "cherry", "clover", "lemon", "diamond", "orange", "watermelon", "horseshoe", "lime"};
    private String[] symbols;
    public Slots(String name, int betSize, double payout, int columns, int numberOfSymbols){
        super(name, betSize, payout);
        setTimesPlayed(0);
        this.numberOfSymbols = numberOfSymbols;
        this.columns = columns;
        if (numberOfSymbols<=12 && numberOfSymbols>0){
            symbols = new String[numberOfSymbols];
            for (int i=0; i<numberOfSymbols; i++){
                symbols[i] = symbolsToChooseFrom[i];
            }
        }
        else{
            System.out.println("An out of bounds number of symbols was imputed so the number of symbols has been defaulted to 12");
            symbols = symbolsToChooseFrom;
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
}

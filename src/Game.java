public class Game {
    private double payout;
    private int timesPlayed;
    private String name;
    private int betSize;
    public Game(String name, int betSize, double payout){
        this.name = name;
        this.betSize = betSize;
        this.payout = payout;
        this.timesPlayed = 0;
    }
    public int getBetSize(){
        return betSize;
    }
    public void setBetSize(int bet){
        betSize = bet;
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
    public double getPayout(){
        return payout;
    }
    public void setPayout(double d){
        payout = d;
    }
    public int getTimesPlayed(){
        return timesPlayed;
    }
    public void setTimesPlayed(int t){
        timesPlayed = t;
    }
    public String toString(){
        return name + " is a game with a payout of " + payout + " and a current bet size of " + betSize + " and has been played " + timesPlayed + " times";
    }
    public void play(){
        timesPlayed++;
    }
}

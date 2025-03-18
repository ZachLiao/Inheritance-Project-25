import java.util.Scanner;

public class Roulette extends Game{
    private int redSquares = 18;
    private int blackSquares = 18;
    private int greenSquares = 2;

    public Roulette(String name, int betSize, double payout) {
        super(name, betSize, payout);
    }

    public void play(int d) {
        //if d=1, user chooses to bet on a color
        if (d == 1) {
            System.out.println(getName() + " chooses to bet on a color");
        }
    }
}

public class Player {
    private String name;
    private int wallet;
    private int totalHandsPlayed;

    public Player(String n, int b) {
        name = n;
        wallet = b;
        totalHandsPlayed = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalHandsPlayed() {
        return totalHandsPlayed;
    }

    public void addTotalHandsPlayed() {
        totalHandsPlayed++;
    }

    public int getWallet() {
        return wallet;
    }
    public void setWallet(int amount) {
        wallet = amount;
    }

    public void addToWallet(int amount) {
        wallet += amount;
    }

    public String toString() {
        return "Player " + name + " has $" + wallet + " and has played " + totalHandsPlayed;
    }
}

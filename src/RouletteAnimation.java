

public class RouletteAnimation {
    // European roulette wheel layout (clockwise)
    private static final int[] ROULETTE_WHEEL = {
        0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27,
        13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1,
        20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26
    };
    private static final String[] ROULETTE_COLORS = {
        "green", "red", "black", "red", "black", "red", "black", "red", "black", "red",
        "black", "red", "black", "red", "black", "red", "black", "red", "black", "red",
        "black", "red", "black", "red", "black", "red", "black", "red", "black", "red",
        "black", "red", "black", "red", "black", "red", "black"
    };

    private int winning;

    public int getNumber(int index) {
        return ROULETTE_WHEEL[index];
    }

    public String getColor(int index) {
        return ROULETTE_COLORS[index];
    }

    // public static void main(String[] args) throws InterruptedException {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.print("Enter winning number (0-36): ");
    //     int winningNumber = scanner.nextInt();

    //     if (!isValidNumber(winningNumber)) {
    //         System.out.println("Invalid number. Must be between 0 and 36.");
    //         return;
    //     }

    //     spinToWin(winningNumber);
    // }

    // private static boolean isValidNumber(int number) {
    //     for (int n : ROULETTE_WHEEL) {
    //         if (n == number) return true;
    //     }
    //     return false;
    // }

    public RouletteAnimation(int winning) {
        this.winning = winning;
    }


    public void spinToWin() throws InterruptedException {
        int currentIndex = (int) (Math.random() * ROULETTE_WHEEL.length);
        int steps = 50 + (int) (Math.random() * 20);

        // Spin quickly first
        for (int i = 0; i < steps; i++) {
            currentIndex = (currentIndex + 1) % ROULETTE_WHEEL.length;
            printSpin(currentIndex, "Spinning");
            Thread.sleep(20 + i);
        }

        // Slow down until we hit the winning number
        while (ROULETTE_WHEEL[currentIndex] != winning) {
            currentIndex = (currentIndex + 1) % ROULETTE_WHEEL.length;
            printSpin(currentIndex, "Slowing ");
            Thread.sleep(250);
        }

        System.out.println("\n🎉 The ball lands on: " + winning + " (" + ROULETTE_COLORS[currentIndex] + ") 🎉");
    }

    private static void printSpin(int index, String label) {
        System.out.print("\r" + label + ": " + ROULETTE_WHEEL[index] + " (" + ROULETTE_COLORS[index] + ")   ");
    }
}

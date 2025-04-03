import java.util.Random;

public class SlotsAnimation {

    private final String[] symbols;
    private final String[] winners;
    private final int spinCount;
    private final Random random = new Random();

    public SlotsAnimation(String[] symbols, String[] winners, int spinCount) {
        this.symbols = symbols;
        this.winners = winners;
        this.spinCount = spinCount;
    }

    public void start() throws InterruptedException {
        int reels = winners.length;

        String[] display = new String[reels];

        System.out.println("🎰 Spinning the reels...\n");

        for (int i = 0; i < spinCount; i++) {
            for (int j = 0; j < reels; j++) {
                display[j] = symbols[random.nextInt(symbols.length)];
            }

            printLine(display);

            Thread.sleep(100 + i * 5); // gradual slowdown
        }

        // Final winning state
        System.arraycopy(winners, 0, display, 0, reels);
        printLine(display);

    }

    private void printLine(String[] display) {
        System.out.print("\r");
        for (String s : display) {
            System.out.print("[" + s + "] ");
        }
        System.out.flush();
    }

    // For quick test
    public static void main(String[] args) throws InterruptedException {
        String[] symbols = {"🍒", "🍋", "🔔", "💎", "7️⃣", "🍀"};
        String[] winners = {"💎", "7️⃣", "💎"};

        SlotsAnimation animation = new SlotsAnimation(symbols, winners, 30);
        animation.start();
    }
}

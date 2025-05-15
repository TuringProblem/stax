
import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

public class Matrix {
    private final int WIDTH = termWidth();
    private static final int HEIGHT = 20;
    private static final int SPEED = 50;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%&*";
    private static final Random RANDOM = new Random();

    public void downFall() throws InterruptedException {
        int[] drops = new int[WIDTH];

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            IntStream.range(0, HEIGHT).forEach(row -> {
                StringBuilder line = new StringBuilder();
                IntStream.range(0, WIDTH).forEach(col -> {
                    if (RANDOM.nextInt(10) < 2)
                        drops[col] = 0;
                    if (drops[col] == row) {
                        line.append("\033[32m")
                                .append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())))
                                .append("\033[0m");
                        drops[col]++;
                    } else {
                        line.append(" ");
                    }
                });
                System.out.println(line);
            });

            Thread.sleep(SPEED);
        }
    }

    private static int termWidth() {
        try {
            Process process = new ProcessBuilder("sh", "-c", "tput cols").start();
            process.waitFor();
            String output = new String(process.getInputStream().readAllBytes());
            int num = Integer.parseInt(output.trim());
            System.out.println(num);
            return num;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

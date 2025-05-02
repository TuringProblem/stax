
import java.nio.charset.StandardCharsets;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import game.login.UserManager;

import java.util.Random;
import java.util.Base64;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.BiConsumer;

/**
 * @author { @Override } | 20:46 ; 20250216
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public class TerminalApp {

  public static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) throws InterruptedException {
    TUIUtility util = new TUIUtility();

    final String CLEAR_SCREEN = "\033[H\033[2J"; // Clears the terminal
    final String REDTEXT = "\033[31m"; // Sets text to red
    final String RESET = "\033[0m"; // Resets text color

    System.out.print(CLEAR_SCREEN);
    System.out.flush(); // Ensures the screen is cleared immediately

    System.out.printf("%s Welcome to My Java Terminal App!%s", REDTEXT, RESET);

    prettyHome();
    Thread.sleep(1000);
    // initializeUser(); -> my method is sooooo much better :* (initializeUser()
    // originally was void and just did imperative way) -> new way is functional
    System.out.println("Enter mode: ");

    String mode = scan.nextLine();

    switch (mode) {

      case "main" -> {
        UserManager.initializePlayer();

      }
      case "dev" -> {
        System.out.print(CLEAR_SCREEN);
        System.out.flush();
        homeInterface();

      }
      default -> System.out.println("fuck out");
    }
  }

  // HashMap<>
  //
  public static int homeInterface() {
    BiSupplier<String, String, String> interfaceConsumer = (x, text) -> {
      return switch (x) {
        case "red" -> String.format("\033[31m%s\033[0m", text);
        case "green" -> String.format("\033[32m%s\033[0m", text);
        case "yellow" -> String.format("\033[33m%s\033[0m", text);
        case "blue" -> String.format("\033[34m%s\033[0m", text);
        case "purple" -> String.format("\033[35m%s\033[0m", text);
        case "teal" -> String.format("\033[36m%s\033[0m", text);
        case "wildcard" -> String.format("\033[36m%s\033[0m", text);
        default -> "";
      };
    };

    String top = interfaceConsumer.get("red", "=========");
    String green = interfaceConsumer.get("green", "=========");
    String yellow = interfaceConsumer.get("yellow", "=========");
    String blue = interfaceConsumer.get("blue", "=========");
    String purple = interfaceConsumer.get("purple", "=========");
    String rando = interfaceConsumer.get("wildcard", "=========");

    System.out.println(top);
    System.out.println(green);
    System.out.println(yellow);
    System.out.println(blue);
    System.out.println(purple);
    System.out.println(rando);
    /**
     * String logo = """
     * \033[31m╔════════════════════════════╗\033[0m
     * \033[31m║\033[0m [Welcome to Stax] \033[31m║\033[0m
     * ║--------------------------- ║
     * ║ --Main Menu-- ║
     * ║----------------------------║
     * ║ [1]: Matchmaking ║
     * ║ [2]: Card stash ║
     * ║ [3]: Something... ║
     * ║ [4]: Settings ║
     * ╚════════════════════════════╝""";
     **/

    // System.out.println(logo);
    try {
      int value = scan.nextInt();

      return switch (value) {
        case 1 -> 1;
        case 2 -> {
          System.out.println("Let's go, switching to Card Stash");
          yield 2;
        }
        default -> {
          System.out.println("Stop fucking around\n");
          yield 0;
        }
      };

    } catch (MissingFormatArgumentException e) {
      System.out.println(e.getMessage());
    }
    return 0;
  }

  private static void prettyHome() {

    System.out.println("");
    System.out.println("╔════════════════╗");
    System.out.println("║   Welcome!     ║");
    System.out.println("╠════════════════╣");
    System.out.println("║ Developed:     ║");
    System.out.println("║ @Override      ║");
    System.out.println("╚════════════════╝");
  }

  /**
   * {@code resetPassword() -> handles replacing the text (i.e: "Hey" -> converted "***")}
   *
   **/

  // NOTE: !{ 20250225 : @14:55} This might need to be change which is a little
  // upsetting but I understand for the archtiecture of the whole program it makes
  // sense.

  static Function<String, String> applyHashingPass = pass -> abstractPassword(pass, generateSalt());

  private static String abstractPassword(String password, byte[] salt) {
    try {
      final int STOREDL = 40;
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      digest.update(salt);
      byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
      byte[] combined = new byte[salt.length + hashBytes.length];
      System.arraycopy(salt, 0, combined, 0, salt.length);
      System.arraycopy(hashBytes, 0, combined, salt.length, hashBytes.length);
      String base64Enc = Base64.getEncoder().encodeToString(combined);
      return base64Enc.substring(0, Math.min(base64Enc.length(), STOREDL));
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("SHA-256 algorithm is not available", e);
    }
  }

  private static byte[] generateSalt() {
    Random rand = new Random();
    byte[] salt = new byte[16];
    rand.nextBytes(salt);
    return salt;
  }
}

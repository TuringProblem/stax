
import java.nio.charset.StandardCharsets;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import game.login.UserManager;

import java.util.Random;
import java.util.Base64;
import java.util.HashMap;
//import java.util.MissingFormatArgumentException;
import java.util.Scanner;
import java.util.function.Function;

/**
 * @author { @Override } | 20:46 ; 20250216
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public class TerminalApp {

  public static Scanner scan = new Scanner(System.in);

  public HashMap<String, Function<String, String>> myMap = new HashMap<>();

  public static BiSupplier<String, String, String> interfaceConsumer = (x, text) -> {
    return switch (x) {
      case "red" -> String.format("%s%s%s", x, text, TUI.RESET.getAnsiCode());
      case "green" -> String.format("%s", text);
      case "yellow" -> String.format("\033[33m%s\033[0m", text);
      case "blue" -> String.format("\033[34m%s\033[0m", text);
      case "purple" -> String.format("\033[35m%s\033[0m", text);
      case "teal" -> String.format("\033[36m%s\033[0m", text);
      case "wildcard" -> String.format("\033[36m%s\033[0m", text);
      default -> "";
    };
  };

  public static Function<String, String> printWithColor = str -> {
    System.out.println("Enter the color you want your text to come out with: ");
    String nextColor = scan.nextLine();
    return interfaceConsumer.get(nextColor, str);
  };

  /**
   * private static final String RESET = ""; // Resets text color
   * private final String CLEAR_SCREEN = ""; // Clears the terminal
   * private final String REDTEXT = ""; // Sets text to red
   * private static final String BLUEBACKGROUND = ""; // Sets text to red
   * private final String STROBE = "";
   **/
  // final String MIXED = REDTEXT + BLUEBACKGROUND;
  // private static final String MIXED = REDTEXT.concat(BLUEBACKGROUND);

  public static void main(String[] args) throws InterruptedException {
    TUIUtility util = new TUIUtility();
    System.out.print(TUI.CLEAR_SCREEN.getAnsiCode());
    System.out.flush(); // Ensures the screen is cleared immediately

    System.out.printf("%s Welcome to My Java Terminal App!%s\n", TUI.MIXED.getAnsiCode(), TUI.RESET.getAnsiCode());
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
        System.out.print(TUI.CLEAR_SCREEN.getAnsiCode());
        System.out.flush();
        homeInterface();

      }
      default -> System.out.println("fuck out");
    }
  }

  // HashMap<Sting, Functio<Does something...>
  //
  //
  public static int homeInterface() {

    System.out.println("Enter some text! :)");
    String thatText = scan.nextLine();
    printWithColor.apply(thatText);
    System.out.println("Please tell me something :)");
    String something = scan.nextLine();
    while (!something.equals("exit")) {
      if (something.equalsIgnoreCase("daddy")) {
        System.out.println("I'm very interested, matter fact hold up...");
        // this is where I'm going to test the hashMap :p
        break;
      }
    }
    System.out.println("We out");
    // * \033[31m║\033[0m [Welcome to Stax] \033[31m║\033[0m
    // System.out.println(logo);
    /**
     * try {
     * int value = scan.nextInt();
     * 
     * return switch (value) {
     * case 1 -> 1;
     * case 2 -> {
     * System.out.println("Let's go, switching to Card Stash");
     * yield 2;
     * }
     * default -> {
     * System.out.println("Stop fucking around\n");
     * yield 0;
     * }
     * };
     * 
     * } catch (MissingFormatArgumentException e) {
     * System.out.println(e.getMessage());
     * }
     **/
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

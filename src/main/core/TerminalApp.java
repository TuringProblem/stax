
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

  private static Scanner scan = new Scanner(System.in);

  public HashMap<String, Function<String, String>> myMap = new HashMap<>(){{

  }};


  private static BiSupplier<String, String, String> interfaceConsumer = (x, text) -> {
    return switch (x) {
      case "red" -> String.format("%s%s%s", TUI.RED.getAnsiCode(), text, TUI.RESET.getAnsiCode());
      case "green" -> String.format("%s%s%s", TUI.GREEN.getAnsiCode(), text, TUI.RESET.getAnsiCode());
      case "yellow" -> String.format("%s%s%s", TUI.YELLOW.getAnsiCode(), text, TUI.RESET.getAnsiCode());
      case "blue" -> String.format("%s%s%s", TUI.BLUE.getAnsiCode(), text, TUI.RESET.getAnsiCode());
      case "purple" -> String.format("%s%s%s", TUI.PURPLE.getAnsiCode(), text, TUI.RESET.getAnsiCode());
      case "cyan" -> String.format("%s%s%s", TUI.CYAN.getAnsiCode(), text, TUI.RESET.getAnsiCode());
      case "wildcard" -> String.format("%s%s%s", TUI.WHITE_BACKGROUND.getAnsiCode(), text, TUI.RESET.getAnsiCode());
      default -> "";
    };
  };

  private static String hand
  private static Function<String, String> printWithColor = str -> {
    if (str == null || str.isEmpty()) {
      System.out.println("Please enter a valid string.");
      return "";
    }
    if (str.equalsIgnoreCase("multiple")) {


    }
    System.out.println("Enter the color you want your text to come out with: ");
    String nextColor = scan.nextLine();
    while ()
    System.out.println(interfaceConsumer.get(nextColor, str));
    scan.close(); // BUG: (POTENTIAL): I should wrap this in a try{}catch() but fuck it we ball. 
    return interfaceConsumer.get(nextColor, str);
  };

  // cache the color
  // how are we going to do that: ? -> memoization? 

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

    while (!thatText.equalsIgnoreCase("quit")) {
      System.out.println("Enter some text! :)");
      thatText = scan.nextLine();
      printWithColor.apply(thatText);
      System.out.println("If you want to quit type 'quit'");
    }
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
    scan.close();
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


import java.nio.charset.StandardCharsets;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import game.login.UserManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;
import java.util.Base64;
import java.util.HashMap;
import java.util.Objects;
//import java.util.MissingFormatArgumentException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author { @Override } | 20:46 ; 20250216
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public class TerminalApp {

  // ColorHandler myHandler = new ColorHandler();

  private static Scanner scan = new Scanner(System.in);
  public HashMap<String, Function<String, String>> myMap = new HashMap<>() {
    {
    }
  };

  // why is this color system importatnt? -> it's going to be with the hitting
  // system :) but also going to be for other systems... this is going to be an
  // api.
  private static BiSupplier<String, String, String> interfaceConsumer = (x, text) -> {
    return switch (x) {
      case "red" -> String.format("%s%s%s", TUI.Foreground.RED.getAnsiCode(), text, TUI.Utils.RESET.getAnsiCode());
      case "green" -> String.format("%s%s%s", TUI.Foreground.GREEN.getAnsiCode(), text, TUI.Utils.RESET.getAnsiCode());
      case "yellow" ->
        String.format("%s%s%s", TUI.Foreground.YELLOW.getAnsiCode(), text, TUI.Utils.RESET.getAnsiCode());
      case "blue" -> String.format("%s%s%s", TUI.Foreground.BLUE.getAnsiCode(), text, TUI.Utils.RESET.getAnsiCode());
      case "purple" ->
        String.format("%s%s%s", TUI.Foreground.PURPLE.getAnsiCode(), text, TUI.Utils.RESET.getAnsiCode());
      case "cyan" -> String.format("%s%s%s", TUI.Foreground.CYAN.getAnsiCode(), text, TUI.Utils.RESET.getAnsiCode());
      case "wildcard" ->
        String.format("%s%s%s", TUI.Background.WHITE.getAnsiCode(), text, TUI.Utils.RESET.getAnsiCode());
      default -> "";
    };
  };

  /**
   * private static String handleCaching(String value) {
   * return "";
   * }
   **/
  /**
   * private static Supplier<String> regexSupplier = str -> {
   * return switch (str) {
   * case "\\^[g:]\\s" ->
   * }
   * };
   **/

  private static Function<String, String> printWithColor = str -> {
    if (str == null || str.isEmpty()) {
      System.out.println("Please enter a valid string.");
      return "";
    }
    if (str.equalsIgnoreCase("multiple")) {

    }
    String regexColorFromStr = "^((r:)|(g:)|(b:))"; // this is something that I want to figure out
    Pattern pattern = Pattern.compile(regexColorFromStr);
    Matcher matcher = pattern.matcher(str);
    boolean matchFound = matcher.find(); 
    if (matchFound){
      System.out.printf("Regex matched!: %s\n", pattern);
      return interfaceConsumer.get("red"/*returnRegexToStringFormat(str)*/, str);
    } else {
      System.out.println("please enter a color: ");
      String nextColor = scan.nextLine();
      return interfaceConsumer.get(nextColor, str);
    }
  };
  public static String returnRegexToStringFormat(String regexCode) {
    System.out.println("We made it here");
    return switch(regexCode) {
      case "^r:" -> "red";
      case "^g:" -> "green";
      case "^b:" -> "blue";
      case "^w:" -> "white";
      case "^bl:" -> "black";
      default -> "";
    };
  }

  // cache the color
  // how are we going to do that: ? -> memoization?

  public static void main(String[] args) throws InterruptedException {
    TUIUtility util = new TUIUtility();
    System.out.print(TUI.Utils.CLEAR_SCREEN.getAnsiCode());
    System.out.flush(); // Ensures the screen is cleared immediately

    System.out.printf("%s Welcome to My Java Terminal App!%s\n",
        TUI.Foreground.WHITE.getAnsiCode() + TUI.Background.BLACK.getAnsiCode(),
        TUI.Utils.RESET.getAnsiCode());
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
        System.out.print(TUI.Utils.CLEAR_SCREEN.getAnsiCode());
        System.out.flush();
        homeInterface();

      }
      default -> System.out.println("fuck out");
    }
  }

  // HashMap<Sting, Functio<Does something...>
  //
  public static int homeInterface() {
    // #this is where
    System.out.println("continue: ");
    String thatText = scan.nextLine();
    while (!thatText.equalsIgnoreCase("quit")) {
      System.out.println("Enter some text! :)");
      System.out.println("--[Home interface]--");
      System.out.println("Enter text: ");
      String colorOutput = printWithColor.apply(scan.nextLine());
      System.out.println(colorOutput);
      System.out.println("If you want to quit type 'quit'");
      thatText = scan.nextLine();
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

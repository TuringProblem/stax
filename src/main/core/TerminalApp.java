
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
import java.util.function.Consumer;

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
      case "foreground:red" -> TUI.Foreground.RED.getAnsiCode() + text + TUI.Utils.RESET.getAnsiCode();
      case "foreground:green" -> TUI.Foreground.GREEN.getAnsiCode() + text + TUI.Utils.RESET.getAnsiCode();
      case "foreground:yellow" -> TUI.Foreground.YELLOW.getAnsiCode() + text + TUI.Utils.RESET.getAnsiCode();
      case "foreground:blue" -> TUI.Foreground.BLUE.getAnsiCode() + text + TUI.Utils.RESET.getAnsiCode();
      case "foreground:black" -> TUI.Foreground.BLACK.getAnsiCode() + text + TUI.Utils.RESET.getAnsiCode();
      case "foreground:purple" -> TUI.Foreground.PURPLE.getAnsiCode() + text + TUI.Utils.RESET.getAnsiCode();
      case "foreground:white" -> TUI.Foreground.WHITE.getAnsiCode() + text + TUI.Utils.RESET.getAnsiCode();
      case "foreground:cyan" -> TUI.Foreground.CYAN.getAnsiCode() + text + TUI.Utils.RESET.getAnsiCode();
      case "r::b" -> TUI.ComboColors.RED_W_BLUE.getAnsiCode() + text + TUI.Utils.RESET.getAnsiCode();
      case "r::bl" -> TUI.ComboColors.RED_W_BLACK.getAnsiCode() + text + TUI.Utils.RESET.getAnsiCode();
      case "w::bl" -> TUI.ComboColors.WHITE_W_BLACK.getAnsiCode() + text + TUI.Utils.RESET.getAnsiCode();
      case "wildcard" ->
        String.format("%s%s%s", TUI.Background.WHITE.getAnsiCode(), text, TUI.Utils.RESET.getAnsiCode());
      default -> "";
    };
  };

  /**
   *
   * f:r;b:b;f:r;
   *
   **/
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
  // structure design:
  // f:{color} -> foreground
  // b:{color} -> background
  // f:{color};b:{color} -> combo (of both parties)

  private static Function<String, String> printWithColor = str -> {
    if (str == null || str.isEmpty()) {
      System.out.println("Please enter a valid string.");
      return "";
    }
    if (str.equalsIgnoreCase("multiple")) {

    }
    // need to make the regex allow for {f:{text};b:{text}}
    String availableColors = "(?:b|bl|w|r|g|cy|y|p)"; // this
    String prefix = String.format("(?:(?:f:%1$s)(?:;b:%1$ss)?|b:%1$s)", availableColors);
    // this regex above is working but for some reason it's not allowing me to do
    // the full f:{color}... then assume that I wanted to have a background ->
    // f:{color}b:{color}
    String fullFormatted = String.format("^%s;(.+)$", prefix);
    Pattern p = Pattern.compile(fullFormatted);
    Matcher m = p.matcher(str);
    boolean matchFound = m.find();

    if (matchFound) {
      String text = m.group(1);
      String prefixedValueGrouped = str.substring(0, str.indexOf(';'));// grabbing the g: ... b: etc... I want to delete
                                                                       // out
      System.out.printf("prefixedValuedGrouped: %s\n", prefixedValueGrouped);
      System.out.printf("text: %s\n", text);
      // System.out.printf("Prefix=%s\nText=:%s", prefixedValueGrouped, text);
      String content = str.substring(prefixedValueGrouped.length()).trim();
      System.out.printf("content: %s\n", content);
      String output = returnRegexToStringFormat(prefix);// gonna send this to

      return interfaceConsumer.get(output, text);
    } else {
      System.out.println("please enter a color: ");
      String nextColor = scan.nextLine();
      return interfaceConsumer.get(nextColor, str);
    }
  };

  public static String groundHandler(String text) {
    System.out.printf("text from groundHandler: %s\n", text);
    String subString = text.substring(0, text.indexOf(':'));
    // System.out.println(subString);
    String mytext = text.equalsIgnoreCase("f:") ? "foreground" : "background";
    System.out.printf("groundHandler(text:%s)\n", mytext);
    return mytext;
  }

  public static String returnRegexToStringFormat(String sourceText) {
    String subText = sourceText.substring();
    System.out.printf("SubText: %s", subText);

    return switch (sourceText) {
      case "f:r" -> String.format("%sred", groundHandler(subText));
      case "f:g" -> String.format("%s:green", groundHandler(subText));
      case "f:b" -> String.format("%s:blue", groundHandler(subText));
      case "f:y" -> String.format("%s:blue", groundHandler(subText));
      case "f:w" -> String.format("%s:white", groundHandler(subText));
      case "f:p" -> String.format("%s:purple", groundHandler(subText));
      case "f:bl" -> String.format("%s:black", groundHandler(subText));
      case "f:cy" -> String.format("%s:cyan", groundHandler(subText));
      default -> "";
    };
  }

  // cache the color
  // how are we going to do that: ? -> memoization?
  public static void fancyPrint(String text) {
    System.out.println(printWithColor.apply(text));
  }

  public static void main(String[] args) throws InterruptedException {
    TUIUtility util = new TUIUtility();
    System.out.print(TUI.Utils.CLEAR_SCREEN.getAnsiCode());
    System.out.flush(); // Ensures the screen is cleared immediately

    fancyPrint("w::bl; Welmcome to my Java Terminal App");
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
    int count = 0;
    System.out.println("continue: ");
    String thatText = scan.nextLine();
    while (!thatText.equalsIgnoreCase("quit")) {
      if (count == 0) {
        System.out.println("--[Home interface]--");
        System.out.println("Enter text: ");
        String colorOutput = printWithColor.apply(scan.nextLine());
        System.out.println(colorOutput);
        ++count;

        System.out.println("If you want to quit type 'quit'");
        thatText = scan.nextLine();
      }
      if (count >= 1) {
        System.out.println(printWithColor.apply("f:r;--[Home interface]--"));
        System.out.println("Enter text: ");
        String colorOutput = printWithColor.apply(scan.nextLine());
        System.out.println(colorOutput);
        System.out.println(TUI.Utils.RESET.getAnsiCode());
      }
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
    // fancyPrint("r::w;╔════════════════╗");
    // fancyPrint("w::r;║ Welcome! ║");
    // fancyPrint("b::w;║ ║");
    fancyPrint("f:r;╔════════════════╗");
    // System.out.println(printWithColor.apply("r;╔════════════════╗"));
    fancyPrint("f:w;║   Welcome!     ║");
    // System.out.println(printWithColor.apply("w;║ Welcome! ║"));
    fancyPrint("f:b;║                ║");
    // System.out.println(printWithColor.apply("b;╠════════════════╣"));
    fancyPrint("f:b;╠════════════════╣");
    // System.out.println(printWithColor.apply("r;║ Developed: ║"));
    fancyPrint("f:r;║ Developed:     ║");
    // System.out.println(printWithColor.apply("w;║ @Override ║"));
    fancyPrint("f:w;║ @Override      ║");
    // System.out.println(printWithColor.apply("b;╚════════════════╝"));
    fancyPrint("f:b;╚════════════════╝");
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

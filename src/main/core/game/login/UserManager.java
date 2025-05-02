package game.login;

import java.nio.charset.StandardCharsets;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import game.login.User;
import game.login.Player;

import game.card.CardChamber;
import game.card.CardRarity;
import game.card.CardStyle;
import game.card.CardType;
import game.card.Card;

import java.util.Random;
import java.util.Base64;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

  public static Player initializePlayer() throws InterruptedException {
    Scanner scan = new Scanner(System.in);
    final String CLEAR_SCREEN = "\033[H\033[2J"; // Clears the terminal
    User user = User.initializeUser(() -> {
      System.out.println("\nPlease Enter your userName: ");
      return scan.nextLine();
    }, () -> {
      System.out.println("Enter Password: ");
      return applyHashingPass.apply(scan.nextLine());
    });

    System.out.printf("\nUser Credentials: %s\n", user.toString());
    Thread.sleep(3000);
    System.out.print(CLEAR_SCREEN);
    System.out.flush();

    scan.close();

    List<Card> cards = new ArrayList<>();
    cards.add(new Card("69", "name", CardType.randomType(), CardRarity.getRandomRarity(),
        CardStyle.getRandomCardStyle(), 0));

    Player player = new Player(user, new CardChamber(cards), 0);

    System.out.printf("Player: %s\n", player.printPlayer());
    return player;

  }

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

import java.nio.charset.StandardCharsets;
import java.io.Serializable;
//import java.io.Console;
import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

import java.util.Random;
import java.util.Base64;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * @author { @Override } | 20:46 ; 20250216
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public class TerminalApp {
    public record User(String userName, String passWord) implements Serializable {}
    public static void main(String[] args) throws InterruptedException {
	Scanner scan = new Scanner(System.in);
	//Console console = System.console();

        final String CLEAR_SCREEN = "\033[H\033[2J";  // Clears the terminal
        final String REDTEXT = "\033[31m";  // Sets text to red
        final String RESET = "\033[0m";  // Resets text color

        System.out.print(CLEAR_SCREEN);
        System.out.flush(); // Ensures the screen is cleared immediately

        System.out.printf("%s Welcome to My Java Terminal App!%s", REDTEXT, RESET);

	prettyHome();

	Thread.sleep(1000);


	//initializeUser(); -> my method is sooooo much better :* (initializeUser() originally was void and just did imperative way) -> new way is functional
	User user = initializeUser(() -> {
		System.out.println("\nPlease Enter your userName: ");
		return scan.nextLine();
		
	}, () -> {
		//char[] passwordArray = console.readPassword("Enter your password: ");
		//return new String(passwordArray);
		System.out.println("Enter Password: ");
		String pass = scan.nextLine();
		return abstractPassword(pass, generateSalt());
	});

	System.out.printf("\nUser Credentials: %s\n", user.toString()); 

	Thread.sleep(10000);
        System.out.print(CLEAR_SCREEN);
        System.out.flush();
	
    }

    private static User initializeUser(Supplier<String> name, Supplier<String> password) {
	return new User(name.get(), password.get());
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


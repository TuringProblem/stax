import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author { @Override } : 20250228 | @16:32
 *
 **/

public class TestRandom {
    public static void main(String[] args) {
        char[] outcomes = { 'r', 'p', 's', 'l', 'k' };
        Map<Character, Set<Character>> myMap = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        char computerOutput = outcomes[rand.nextInt(4)];

        myMap.put('p', Set.of('r', 'k'));
        myMap.put('r', Set.of('s', 'l'));
        myMap.put('s', Set.of('p', 'l'));
        myMap.put('l', Set.of('k', 'p'));
        myMap.put('k', Set.of('r', 's'));

        System.out.printf("Computer selected %c\n", computerOutput);
        System.out.println("Please enter a value between\n[r][p][s][l][k]: ");
        String input = scan.nextLine();
        char userInput = input.charAt(0);// converts the char[] value into char individual value

        while (new String(outcomes).indexOf(userInput) == -1) {
            System.out.println("Yeahhhhhhhhhhh Try again");
            input = scan.nextLine();
            userInput = input.charAt(0);
        }

        boolean tie = userInput == computerOutput;
        boolean userWin = myMap.get(userInput).contains(computerOutput);
        boolean computerWin = myMap.get(computerOutput).contains(userInput);

        if (tie) {
            System.out.println("Fuck, it's a tie");
        }
        if (userWin) {
            System.out.println("User wins!");
        }
        if (computerWin) {
            System.out.println("Computer wins!");
        }
    }
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

  public static void main(String[] args) {

    String text = "Hello, user123! Welcome—today is 2025-05-11.";
    // 1) Remove all punctuation except letters/numbers/spaces:
    String cleaned = text.replaceAll("[^\\p{Alnum} ]+", "");
    System.out.println(cleaned);
    // → "Hello user123 Welcome today is 20250511"

    // 2) Find words that don't contain the letter 'e':
    Pattern p = Pattern.compile("\\b(?!.*e)\\w+\\b", Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(text);

    if (m.find()) {
      String firstWord = m.group();
      System.out.printf("The first word without 'e': %s\n", firstWord);
      System.out.printf("A word without 'e': %s\n", m.group());
    }
    while (m.find()) {
      System.out.println("Word without 'e': " + m.group());
    }

  }
}

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

class DumbTest {

  public static void main(String[] args) {

    Consumer<String> wassgudName = System.out::println;
    try (Scanner scan = new Scanner(System.in)) {
      String urName = scan.nextLine();
      String name = String.format("%s sup?", urName);

      wassgudName.accept(name);
    } catch (InputMismatchException e) {
      wassgudName.accept(e.getMessage());
    }

    System.out.println("abc");
    String cde = "cde";
    System.out.println("abc" + cde);
    String c = "\033[31m abc\033m".substring(1, 4);
    String d = cde.substring(1, 2);
    System.out.println(c);
    System.out.println(d);
  }
}

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
      wassgudName.accept(e.getMessage())
    }

  }

}

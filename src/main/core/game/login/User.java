package game.login;

import java.io.Serializable;
import java.util.function.Supplier;

/**
 * @author { @Override } | 17:26 ; 20250218
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public record User(String userName, String passWord) implements Serializable {
  public static User initializeUser(Supplier<String> name, Supplier<String> password) {
    return new User(name.get(), password.get());
  }

}

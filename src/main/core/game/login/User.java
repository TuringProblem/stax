package game.login;

import java.io.Serializable;

/**
 * @author { @Override } | 17:26 ; 20250218
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public record User(String userName, String passWord) implements Serializable {

}

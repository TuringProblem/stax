/**
 * @author { @Override } | 13:31 : 20250217
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public class TUIUtility {
	private char[] block = {'▉'};  
	public void loadingScreen(int percent) throws InterruptedException {
		for (int i = 0; i < percent; i++) {
			System.out.printf("%c", block[0]);
			Thread.sleep(50);
		}
	}
	
}

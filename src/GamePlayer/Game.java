package GamePlayer;

public class Game {
	
	public int score;
	public static int highestScore;
	
	
	class Player {
		
		public void play(Game game, int score) {
			game.score = score;
			isHighestScore();
		}
	}
	
	void isHighestScore() {
		
		if(score > highestScore) {
			System.out.println("Wow! Highest Score...");
			highestScore = score;
		}
		else if(score == highestScore) {
			System.out.println("Wow! Highest Socre!");
		}
		else {
			System.out.println("Good Keep it up, It wasn't the Highest Score!");
		}
	}
}

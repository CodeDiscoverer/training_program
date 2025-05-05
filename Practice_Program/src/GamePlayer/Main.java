package GamePlayer;

public class Main {

	public static void main(String[] args) {
		
		Game game = new Game();
		Game.Player player = game.new Player();
		
		player.play(game, 10);
		player.play(game, 9);
		player.play(game, 10);
		player.play(game, 15);

	}

}

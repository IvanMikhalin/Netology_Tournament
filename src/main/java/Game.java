import java.util.ArrayList;

public class Game {

    protected ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Player> getAllPlayers() {
        return players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public ArrayList<Player> findByName(String playerName) {
        Game searchResult = new Game();
        for (Player player : getAllPlayers()) {
            if (player.getName().contains(playerName)) {
                searchResult.register(player);
            }
        }
        return searchResult.getAllPlayers();
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(
                    "игрок " + playerName1 + " не зарегистрирован"
            );
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "игрок " + playerName2 + " не зарегистрирован"
            );
        }
        if (player1.getStrenght() > player2.getStrenght()) {
            return 1;
        }
        if (player1.getStrenght() < player2.getStrenght()) {
            return 2;
        } else {

        }

        return 0;


    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Player player1 = new Player(1, "player1", 90);
    Player player2 = new Player(2, "player2", 30);
    Player player3 = new Player(3, "player3", 40);
    Player player4 = new Player(4, "player4", 50);
    Player player5 = new Player(5, "player5", 100);
    Player player6 = new Player(6, "player6", 100);

    Game game = new Game();

    @Test
    public void shouldAddNewPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        ArrayList<Player> expected = new ArrayList<>();
        ArrayList<Player> actual = game.getAllPlayers();
        expected.add(player1);
        expected.add(player2);
        expected.add(player3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayer1() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round(player1.getName(), player2.getName());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        game.register(player4);
        game.register(player5);

        int expected = 2;
        int actual = game.round(player4.getName(), player5.getName());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDraw() {
        game.register(player6);
        game.register(player5);

        int expected = 0;
        int actual = game.round(player6.getName(), player5.getName());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowTheMessageIfFirstPlayerNotRegistered() {
        game.register(player1);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player6.getName(), player5.getName());
        });
    }

    @Test
    public void shouldThrowTheMessageIfSecondPlayerNotRegistered() {
        game.register(player6);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player6.getName(), player5.getName());
        });
    }

    @Test
    public void shouldFindByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        ArrayList<Player> expected = new ArrayList<>();
        ArrayList<Player> actual = game.findByName("player1");
        expected.add(player1);

        Assertions.assertEquals(expected, actual);
    }
}
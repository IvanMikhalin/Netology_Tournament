import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "player1", 90, true);
    Player player2 = new Player(2, "player2", 30, false);
    Player player3 = new Player(3, "player3", 40, true);
    Player player4 = new Player(4, "player4", 50, false);
    Player player5 = new Player(5, "player5", 100, true);
    Player player6 = new Player(6, "player6", 100, true);

    Game game = new Game();

    @Test
    public void shouldAddNewPlayers() {
        game.save(player1);
        game.save(player2);
        game.save(player3);

        Player[] expected = {player1, player2, player3};
        Player[] actual = game.getItems();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldThrowMessageIfNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.showAllRegistered(player4);
        });
    }

    @Test
    public void shouldCompareIfFirstHigher() {

        int expected = 1;
        int actual = game.round(player1, player3);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldCompareIfFirstLess() {

        int expected = 2;
        int actual = game.round(player1, player5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareIfEqual() {

        int expected = 0;
        int actual = game.round(player5, player6);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowMessageEvenOneNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player2, player6);
        });
    }

    @Test
    public void shouldFindByName() {
        game.save(player1);
        game.save(player2);
        game.save(player3);

        Player[] expected = {player1};
        Player[] actual = game.findByName("player1");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldThrowMessageWhenBothNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player2, player4);
        });
    }

}
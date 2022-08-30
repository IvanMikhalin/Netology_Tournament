public class Game {

    private Player[] items = new Player[0];

    public Player[] findByName(String name) {
        Game searchResult = new Game();
        for (Player player : getItems()) {
            if (player.getName().contains(name)) {
                searchResult.save(player);
            }
        }
        return searchResult.getItems();
    }

    public void save(Player item) {
        Player[] tmp = new Player[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Player[] getItems() {
        return items;
    }

    public Player[] showAllRegistered(Player player) {
        if (player.isRegistered() == false) {
            throw new NotRegisteredException(
                    "игрок " + player.getName() + " не зарегистрирован"
            );
        } else {
            return null;
        }
    }

    public int round(Player player1, Player player2) {
        if (showAllRegistered(player1) == null | showAllRegistered(player2) == null) {

            if (player1.getStrenght() > player2.getStrenght()) {
                return 1;
            }
            if (player1.getStrenght() < player2.getStrenght()) {
                return 2;
            } else {

            }
        }
        return 0;
    }
}

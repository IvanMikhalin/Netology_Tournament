public class Player {

    int id;
    String name;
    int strenght;
    boolean registered;

    public String getName() {
        return name;
    }

    public int getStrenght() {
        return strenght;
    }

    public boolean isRegistered() {
        return registered;
    }

    public Player(int id, String name, int strenght, boolean registered) {
        this.id = id;
        this.name = name;
        this.strenght = strenght;
        this.registered = registered;
    }
}

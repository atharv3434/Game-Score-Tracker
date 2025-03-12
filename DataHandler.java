import java.io.*;
import java.util.*;

public class DataHandler {
    private static final String FILE_PATH = "players.txt";

    public static void savePlayers(List<Player> players) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(players);
        } catch (IOException e) {
            System.out.println("❌ Error saving player data.");
        }
    }

    public static List<Player> loadPlayers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Player>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}

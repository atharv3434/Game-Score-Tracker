import java.util.*;

public class ScoreManager {
    private List<Player> players;
    private Scanner sc;

    public ScoreManager() {
        this.players = DataHandler.loadPlayers();
        this.sc = new Scanner(System.in);
    }

    public void addPlayer() {
        System.out.print("Enter player name: ");
        String name = sc.nextLine();

        players.add(new Player(name));
        DataHandler.savePlayers(players);
        System.out.println("✅ Player Added Successfully!");
    }

    public void updateScore() {
        viewLeaderboard();
        System.out.print("Enter player number to update score: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < players.size()) {
            System.out.print("Enter score to add: ");
            int score = sc.nextInt();
            sc.nextLine();

            players.get(index).addScore(score);
            DataHandler.savePlayers(players);
            System.out.println("✅ Score Updated!");
        } else {
            System.out.println("❌ Invalid player number.");
        }
    }

    public void viewLeaderboard() {
        if (players.isEmpty()) {
            System.out.println("📄 No players found.");
            return;
        }

        players.sort(Comparator.comparingInt(Player::getTotalScore).reversed());

        System.out.println("\n🏆 Leaderboard:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i));
        }
    }

    public void viewPlayerHistory() {
        System.out.print("Enter player name to view history: ");
        String name = sc.nextLine();

        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                System.out.println("\n📜 Score History for " + player.getName() + ": " + player.getScoreHistory());
                return;
            }
        }
        System.out.println("❌ Player not found.");
    }

    public void deletePlayer() {
        viewLeaderboard();
        System.out.print("Enter player number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < players.size()) {
            players.remove(index);
            DataHandler.savePlayers(players);
            System.out.println("✅ Player Deleted Successfully!");
        } else {
            System.out.println("❌ Invalid player number.");
        }
    }
}

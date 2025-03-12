import java.util.Scanner;

public class GameApp {
    private static ScoreManager scoreManager = new ScoreManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🎮 Welcome to Game Score Tracker 🎮");

        while (true) {
            System.out.println("\n1. Add Player");
            System.out.println("2. Update Score");
            System.out.println("3. View Leaderboard");
            System.out.println("4. View Player History");
            System.out.println("5. Delete Player");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    scoreManager.addPlayer();
                    break;
                case 2:
                    scoreManager.updateScore();
                    break;
                case 3:
                    scoreManager.viewLeaderboard();
                    break;
                case 4:
                    scoreManager.viewPlayerHistory();
                    break;
                case 5:
                    scoreManager.deletePlayer();
                    break;
                case 6:
                    System.out.println("Exiting... Keep playing! 🏆");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}

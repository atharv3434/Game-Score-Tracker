import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int totalScore;
    private List<Integer> scoreHistory;

    public Player(String name) {
        this.name = name;
        this.totalScore = 0;
        this.scoreHistory = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getTotalScore() { return totalScore; }
    public List<Integer> getScoreHistory() { return scoreHistory; }

    public void addScore(int score) {
        this.totalScore += score;
        this.scoreHistory.add(score);
    }

    @Override
    public String toString() {
        return "🏅 Player: " + name + " | 🎯 Total Score: " + totalScore;
    }
}

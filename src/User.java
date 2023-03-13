import static java.lang.Math.abs;

public class User {
    int rank;
    int progress;

    public User() {
        rank = -8;
        progress = 0;
    }

    public int getProgress() {
        return progress;
    }

    public int getRank() {
        return rank;
    }

    public void incProgress(int n) {
        int difference;

        if (n > 0) {
            difference = n - rank - 1;
        }
        else {
            difference = n - rank;
        }
        if (n == -1 && rank == 1) {
            difference = -1;
        }

        if (n < -8 || n > 8 || n == 0) {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        if (difference == 0) {
            progress = progress + 3;
            checkStats();
        }
        if (difference == -1) {
            progress = progress + 1;
            checkStats();
        }
        if (difference > 0) {
            progress = progress + (10 * difference * difference);
            checkStats();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "rank=" + rank +
                ", progress=" + progress +
                '}';
    }

    private void checkStats() {
        while (progress >= 100) {
            rank = rank + 1;
            progress = progress - 100;
        }
        if (rank == 0) {
            rank = rank + 1;
        }
    }
}

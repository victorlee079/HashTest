import java.util.HashSet;
import java.util.Set;

public class RateInfo {
    private int prime;
    private long collision;
    private Set<Integer> hashValues;

    public RateInfo(int prime) {
        hashValues = new HashSet<>();
    }

    public void addValue(int value) {
        if (hashValues.contains(value)) {
            collision++;
        } else {
            hashValues.add(value);
        }
    }

    public int getPrime() {
        return prime;
    }

    public long getCollision() {
        return collision;
    }
}

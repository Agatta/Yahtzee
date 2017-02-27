import java.util.Random;
/**
 * Created by Agata on 23.02.2017.
 */
public class Dice {
    private Random random = new Random();
    private int value;

    public int getValue() {
        return value;
    }

    public void rollDice() {
        this.value = 1+random.nextInt(6);
    }
}

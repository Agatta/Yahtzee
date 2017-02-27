import java.lang.reflect.Array;
import java.util.*;

public class ResultTable {

    private String name;
    private Map<String, Integer> categhoryScores = new HashMap<String, Integer>();
    List<String> aviableCathegories = new ArrayList<String>(Arrays.asList("Aces", "Twos", "Threes", "Fours", "Fives", "Sixes"));

    public void calculateAndSaveResult(String cathegory, Dice[] diceSet) {

        int chosenNum = 0;
        int counter = 0;
        switch (cathegory) {
            case "Aces":
                chosenNum = 1;
                break;
            case "Twos":
                chosenNum = 2;
                break;
            case "Threes":
                chosenNum = 3;
                break;

            case "Fours":
                chosenNum = 4;
                break;

            case "Fives":
                chosenNum = 5;
                break;

            case "Sixes":
                chosenNum = 6;
                break;

        }
        for (Dice i : diceSet) {
            if (i.getValue() == chosenNum) {
                counter++;
            }

        }
        categhoryScores.put(cathegory, counter * chosenNum);
        aviableCathegories.remove(aviableCathegories.indexOf(cathegory));
    }

    public void printAviableCathegories() {
        for (int i = 0; i < aviableCathegories.size(); i++) {

            System.out.println(i + 1 + ":" + (aviableCathegories.get(i)));
        }
    }

    public void printResultTable() {
        System.out.println("--------------------");
        for (String key : categhoryScores.keySet()) {
            int score = categhoryScores.get(key);
            System.out.println(key + "  " + score);
        }
        System.out.println("--------------------");
    }

    public int sumResultTable() {
        int result = 0;
        for (int score : categhoryScores.values()) {
            result += score;

        }

        return result;
    }

}


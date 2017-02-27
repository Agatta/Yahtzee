import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {

    private Random random = new Random();

    @Override
    public String chooseCathegoryToSave() {
        String answer = "";
        answer = resultTable.aviableCathegories.get(random.nextInt(resultTable.aviableCathegories.size()));
        return answer;
    }

    @Override
    public List<Integer> chooseDicesToReroll() {
        List<Integer> numList = new ArrayList<Integer>();

        int val = random.nextInt(1);
        if (val == 0) {
            return numList;
        } else {
            int count = random.nextInt(5);
            for (int i = 0; i < count; i++) {
                numList.add(1 + random.nextInt(6));
            }
            return numList;
        }

    }

    public ComputerPlayer() {
        this.name = "Komputer";
    }
}

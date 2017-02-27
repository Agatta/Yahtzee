import java.util.List;

public abstract class Player {
    public String name;
    public ResultTable resultTable;

    abstract String chooseCathegoryToSave();
    abstract List<Integer> chooseDicesToReroll();

    public Player() {
        this.resultTable = new ResultTable();

    }
}



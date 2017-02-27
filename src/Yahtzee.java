import java.util.List;
import java.util.Scanner;

public class Yahtzee {

    private Dice[] createDiceSet() {
        Dice[] diceSet = new Dice[6];

        for (int i = 0; i < 6; i++) {
            diceSet[i] = new Dice();
        }
        return diceSet;
    }

    private void rollDiceSet(Dice[] diceSet) {
        for (Dice i : diceSet) {
            i.rollDice();
        }

    }

    private void rerollDices(Dice[] diceSet, List<Integer> selectedNumbers) {
        for (Integer i : selectedNumbers) {
            diceSet[i - 1].rollDice();
        }
    }

    private void printDicesValues(Dice[] diceSet) {
        for (Dice i : diceSet) {
            System.out.print(" [" + i.getValue() + "] ");
        }
        System.out.println("\n");
    }

    public Player swapPlayer(Player currentPlayer, Player playerA, Player playerB) {
        if (currentPlayer.equals(playerA)) {
            return playerB;
        } else

            return playerA;
    }

    public String askAboutName() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (name == "") {
            System.out.println("Podaj swoje imię");
            name = scanner.nextLine();
        }
        return name;
    }

    public void printWinner(Player playerA, Player playerB) {
        int resultA = playerA.resultTable.sumResultTable();
        int resultB = playerB.resultTable.sumResultTable();

        if (resultA > resultB) {
            System.out.println("Wygrał gracz: " + playerA.name + " uzyskując " + resultA + " punktów");
            System.out.println("Gracz: " + playerB.name + " uzyskał " + resultB + " punktów");
        } else if (resultA < resultB) {
            System.out.println("Wygrał gracz: " + playerB.name + " uzyskując " + resultB + " punktów");
            System.out.println("Gracz: " + playerA.name + " uzyskał " + resultA + " punktów");

        } else {
            System.out.println("Remis, obaj gracze uzyslali po " + playerA.resultTable + " punktów");
        }


    }


    public static void main(String[] args) {
        Yahtzee game = new Yahtzee();
        int moves = 12;
        Player player1 = new HumanPlayer(game.askAboutName());
        Player player2 = new ComputerPlayer();
        Player currentPlayer = player1;
        Dice[] diceSet = game.createDiceSet();

        while (moves > 0) {
            System.out.println("Ruch ma gracz: " + currentPlayer.name);
            game.rollDiceSet(diceSet);
            System.out.println("Wylosowano w rzucie 1:");
            game.printDicesValues(diceSet);
            int rerollCount = 2;
            while (rerollCount > 0) {
                List<Integer> selectedToReroll = currentPlayer.chooseDicesToReroll();
                if (selectedToReroll.size() > 0) {
                    game.rerollDices(diceSet, selectedToReroll);
                    System.out.println("Wylosowano w rzucie: " + (4 - rerollCount));
                    game.printDicesValues(diceSet);
                    rerollCount--;
                } else {
                    rerollCount = 0;
                }
            }
            String selectedCathegory = currentPlayer.chooseCathegoryToSave();
            currentPlayer.resultTable.calculateAndSaveResult(selectedCathegory, diceSet);
            currentPlayer.resultTable.printResultTable();
            currentPlayer = game.swapPlayer(currentPlayer, player1, player2);
            moves--;

        }
        game.printWinner(player1, player2);
        System.out.println("Koniec gry");
    }


}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {

    @Override
    public String chooseCathegoryToSave() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do jakiej kategorii chcesz zapisać?");
        resultTable.printAviableCathegories();
        String answer = "";
        while (answer == "") {
            try {
                answer = resultTable.aviableCathegories.get(scanner.nextInt() - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Wybierz liczby z zakresu 1-" + resultTable.aviableCathegories.size());
            } catch (InputMismatchException e) {
                System.out.println("Nie wpisałeś liczby.");
            }

        }
        return answer;
    }

    @Override
    public List<Integer> chooseDicesToReroll() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = new ArrayList<Integer>();
        while (numList.size() == 0) {
            System.out.println("Wybierz kości do ponownego rzutu (wypisz numery 1-6 oddzielone przecinkiem). Wpisz 0 jeśli rezygnujesz(zatrzymujesz wszystkie).");
            String userInput = scanner.nextLine();
            if (userInput.toString().equals("0")) {
                break;

            } else {
                String[] selectedNumbers = userInput.split(",");

                try {
                    for (int i = 0; i < selectedNumbers.length; i++) {
                        int value = Integer.parseInt(selectedNumbers[i]);
                        if (value < 7 && value > 0) {
                            numList.add(value);
                        } else {
                            System.out.println("Pominięto liczbę: " + value + " gdyż nie odpowiada żanej kosci");

                        }

                    }
                    System.out.println("Wybrano następująca liczbe kości do ponownego rzutu: " + numList.size());


                } catch (NumberFormatException e) {
                    System.out.println("To nie jest poprawna warość, podaj numery kości jak liczby oddzielone przecinkiem.");
                }

            }

        }
        return numList;
    }

    public HumanPlayer(String name) {
        this.name = name;
    }
}

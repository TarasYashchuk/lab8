package gift;

import command.*;
import dao.GiftDao;
import dao.GiftDaoImpl;
import org.apache.log4j.Logger;
import sweets.Sweets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GiftRunner {

    public static Logger logger = Logger.getLogger(GiftRunner.class);

    public static void main(String[] args) {

        List<Sweets> sweetsList = Sweets.getSweetsList();
        List<Sweets> gift = Sweets.getGiftList();

        GiftDao giftDao = new GiftDaoImpl(sweetsList,gift);
        GiftCommands command = new GiftCommands(giftDao, sweetsList, gift);

        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("add", new AddCandyToGiftCommand(command));
        commandMap.put("weight", new CalculateGiftWeightCommand(command));
        commandMap.put("contain", new CompositionOfTheGiftCommand(command));
        commandMap.put("find", new FindCandyBySugarContentCommand(command));
        commandMap.put("info", new PrintSweetsInfoCommand(command));
        commandMap.put("remove", new RemoveCandyFromGiftCommand(command));
        commandMap.put("sort", new SortCandiesCommand(command));


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введіть команду (або 'help' для виведення списку команд): ");
            String choice = scanner.nextLine();

            logger.info("Користувач ввів команду: " + choice);

            try{
                if (choice.equals("help")) {
                    System.out.println("Доступні команди:");
                    for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
                        System.out.println(entry.getKey() + " >> " + entry.getValue().getDescription());
                    }
                } else if (choice.equals("exit")) {
                    System.out.println("Дякую за використання програми!");
                    logger.info("Програма завершила роботу.");
                    System.exit(0);
                } else if (commandMap.containsKey(choice)) {
                    String commandDescription = commandMap.get(choice).getDescription();
                    System.out.println("Ви обрали команду: " + commandDescription);
                    logger.info("Виконується обробка команди " + commandDescription);
                    commandMap.get(choice).execute();
                } else {
                    throw new IllegalArgumentException("Неправильна команда. Введіть 'help' для виведення списку команд.");
                }
            } catch (Exception e){
                logger.error("Помилка: " + e.getMessage());
                e.printStackTrace();

            }
        }
    }
}
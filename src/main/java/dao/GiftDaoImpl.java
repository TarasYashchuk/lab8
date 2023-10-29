package dao;

import gift.GiftRunner;
import sweets.Sweets;
import sweets.candies.caramel.CaramelCandy;
import sweets.candies.caramel.Gum;
import sweets.candies.chocolatecandy.DarkChocolate;
import sweets.candies.chocolatecandy.MilkChocolate;
import sweets.candies.marmalade.FruitMarmalade;
import sweets.candies.marmalade.JellyMarmalade;
import sweets.candies.popsicles.FruitPopsicles;
import sweets.candies.popsicles.MilkPopsicles;
import sweets.other.chocolatebars.CaramelChocolateBar;
import sweets.other.chocolatebars.NutChocolateBar;
import sweets.other.cookies.ButterCookie;
import sweets.other.cookies.ChocolateCookie;
import sweets.other.gingerbread.HoneyGingerbread;
import sweets.other.gingerbread.OrangeGingerbread;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static gift.GiftRunner.logger;

public class GiftDaoImpl implements GiftDao {

    List<Sweets> sweetsList;
    List<Sweets> gift;

    public GiftDaoImpl() {
        this.sweetsList = getSweetsList();
        this.gift = getGiftList();
    }

    @Override
    public void printSweetsInfo() {
        for (Sweets sweets : sweetsList) {
            System.out.println(sweets.toString());
        }
    }
    @Override
    public void addCandyToGift() throws Exception {

        logger.info("Команда 'addCandyToGift' почала роботу.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть цукерки (exit для завершення) ");

        for (int i = 0; i < sweetsList.size(); i++) {
            System.out.println((i + 1) + ". " + sweetsList.get(i).getName());
        }
        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                logger.info("Команда 'addCandyToGift' закінчила роботу.");
                break;
            }

            try {
                int candyIndex = Integer.parseInt(input) - 1;
                if (candyIndex >= 0 && candyIndex < sweetsList.size()) {
                    Sweets selectedCandy = sweetsList.get(candyIndex);
                    gift.add(selectedCandy);
                    System.out.println("Цукерка " + "'" + selectedCandy.getName() + "'" + " додана до подарунку");

                    logger.info("Додана цукерка до подарунку: " + selectedCandy.getName());
                } else {
                    System.out.println("Неправильний номер. Спробуйте ще раз");

                    logger.warn("Спроба додати цукерку за неправильним номером: " + input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Некоректне введення. Спробуйте ще раз");
                logger.warn("Помилка при спробі додати цукерку: " + e.getMessage());

            }
        }
    }

    @Override
    public void removeCandyFromGift() throws Exception {
        Scanner scanner = new Scanner(System.in);

        logger.info("Команда 'removeCandyFromGift' почала роботу.");
        compositionOfTheGift();
        System.out.println("Введіть номер цукерки, яку хочете вилучити, або 'exit' для виходу:");

        while (true) {

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                logger.info("Команда 'removeCandyFromGift' закінчила роботу.");
                break;
            }

            try {
                int candyIndex = Integer.parseInt(input) - 1;
                if (candyIndex >= 0 && candyIndex < gift.size()) {
                    Sweets selectedCandy = gift.remove(candyIndex);
                    System.out.println("Цукерка " + selectedCandy.getName() + " вилучена із вашого подарунку");
                    compositionOfTheGift();
                    logger.info("Цукерка " + selectedCandy.getName() + " вилучена із подарунку");
                } else {
                    System.out.println("Неправильний номер. Спробуйте ще раз.");
                    logger.warn("Неправильний номер: " + input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Невірний ввід. Спробуйте ще раз");
                logger.warn("Неправильний ввід: " + input);

            }
        }
    }

    @Override

    public void calculateGiftWeight() throws Exception {

        logger.info("Команда 'calculateGiftWeight' почала роботу.");
        double totalWeight = 0.0;
        try {
            for (Sweets sweets : gift) {
                totalWeight += sweets.getWeight();
            }
            System.out.println("Загальна вага подарунка = " + totalWeight + " грам");

            logger.info("Загальна вага подарунка = " + totalWeight + " грам");
        } catch (Exception e) {
            System.out.println("Сталася помилка при обчисленні ваги подарунка: " + e.getMessage());
            logger.warn("Помилка при обчисленні ваги подарунка: " + e.getMessage());
        }
        logger.info("Команда 'calculateGiftWeight' закінчила роботу.");
    }

    @Override
    public void sortCandies() {

        logger.info("Команда 'sortCandies' почала роботу.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть тип сортування:");
        System.out.println("1. за назвою цукерки");
        System.out.println("2. за вмістом цукру");
        System.out.println("3. за вагою");

        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> sortByName();
                case 2 -> sortBySugarContent();
                case 3 -> sortByWeight();
                default -> System.out.println("Такого пункту немає");
            }
        } catch (InputMismatchException e) {
            System.out.println("Неправильний ввід. Введіть числове значення.");
            logger.warn("Неправильний ввід при сортуванні цукерок: " + e.getMessage());
        }
        logger.info("Команда 'sortCandies' закінчила роботу.");
    }

    @Override
    public void findCandyBySugarContent() throws Exception {
        List<Sweets> candyBySugar = new ArrayList<>();

        logger.info("Команда 'findCandyBySugarContent' почала роботу.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть діапазон цукру (у відсотках):");

        try {
            System.out.print("Від: ");
            double choice1 = scanner.nextDouble();
            System.out.print("До: ");
            double choice2 = scanner.nextDouble();

            logger.info("Введено діапазон цукру: Від " + choice1 + " До " + choice2);

            for (Sweets candy : gift) {
                if (candy.getSugarContent() >= choice1 && candy.getSugarContent() <= choice2) {
                    candyBySugar.add(candy);
                }
            }

            if (candyBySugar.isEmpty()) {
                System.out.println("Таких цукерок немає");

                logger.info("Таких цукерок немає у діапазоні [" + choice1 + ";" + choice2 + "]");

                logger.info("Команда 'findCandyBySugarContent' закінчила роботу.");
            } else {
                System.out.println("Цукерки за вмістом цукру в діапазоні [" + choice1 + ";" + choice2 + "]:");
                for (Sweets candy : candyBySugar) {
                    System.out.println(candy.getName() + " - Вміст цукру: " + candy.getSugarContent() + "%");
                }

                logger.info("Знайдено цукерок у діапазоні [" + choice1 + ";" + choice2 + "]");
            }
        } catch (InputMismatchException e) {
            System.out.println("Невірний ввід. Введіть числове значення.");

            logger.warn("Невірний ввід при пошуку цукерок за вмістом цукру: " + e.getMessage());
        }
    }

    @Override
    public void compositionOfTheGift() {
        System.out.println("Склад вашого подарунку:");
        for (int i = 0; i < gift.size(); i++) {
            System.out.println((i + 1) + ". " + gift.get(i).getName());
        }
    }

    @Override
    public void sortBySugarContent() {
        gift.sort((candy1, candy2) -> Double.compare(candy1.getSugarContent(), candy2.getSugarContent()));
        System.out.println("Цукерки відсортовано за вмістом цукру:");
        for (Sweets candy : gift) {
            System.out.println(candy.getName() + " - Вміст цукру: " + candy.getSugarContent() + "%");
        }
    }

    @Override
    public void sortByName() {
        gift.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println("Цукерки відсортовано за назвою:");
        for (Sweets candy : gift) {
            System.out.println(candy.getName());
        }
    }

    @Override
    public void sortByWeight() {
        gift.sort((candy1, candy2) -> Double.compare(candy1.getWeight(), candy2.getWeight()));

        System.out.println("Цукерки відсортовано за вагою");
        for (Sweets candy : gift) {
            System.out.println(candy.getName() + " - Вага: " + candy.getWeight() + "грам");
        }
    }

    public List<Sweets> getSweetsList() {

        List<Sweets> sweets = new ArrayList<>();

        sweets.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));
        sweets.add(new Gum("Золотий шарм", 15.0, 0.4));

        sweets.add(new DarkChocolate("Шоколадний розкіш", 40.0, 0.25));
        sweets.add(new MilkChocolate("Кокосова мрія", 35.0, 0.5));

        sweets.add(new FruitMarmalade("Фруктовий експрес", 10.0, 0.3));
        sweets.add(new JellyMarmalade("Сонячні мармелади", 10.0, 0.4));

        sweets.add(new FruitPopsicles("Апельсиновий відпочинок", 15.0, 0.6));
        sweets.add(new MilkPopsicles("Молочний куш", 10.0, 0.6));

        sweets.add(new CaramelChocolateBar("Шоколадний спокусник", 70.0, 0.5));
        sweets.add(new NutChocolateBar("Горішкова феєрія", 65.0, 0.4));

        sweets.add(new ButterCookie("Вишукана ніжність", 30.0, 0.6));
        sweets.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));

        sweets.add(new HoneyGingerbread("Медова кульбаба", 55.0, 0.3));
        sweets.add(new OrangeGingerbread("Мандаринова історія", 50.0, 0.4));

        return sweets;
    }
    public  List<Sweets> getGiftList() {
        List<Sweets> gift = new ArrayList<>();
        return gift;
    }


}

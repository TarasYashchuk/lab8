import command.GiftCommands;
import dao.GiftDao;
import dao.GiftDaoImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import sweets.Sweets;
import sweets.candies.caramel.CaramelCandy;
import sweets.other.cookies.ChocolateCookie;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class GiftCommandsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

   /* @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    public void printSweetsInfoTest() {

        GiftDao giftDao = Mockito.mock(GiftDao.class);
        List<Sweets> sweetsList = new ArrayList<>();
        sweetsList.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        GiftCommands giftCommands = new GiftCommands(giftDao, sweetsList, new ArrayList<>());


        // Mockito.when(giftDao.someMethod()).thenReturn(someValue);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        giftCommands.printSweetsInfo();

        String expectedOutput = "------------------------------------------------------------------\n" +
                "Назва цукерки: Карамельна мелодія\n" +
                "Тип: карамель \n" +
                "Вага: 25.0\n" +
                "Вміст цукру: 20.0%\r\n";

        String consoleOutput = outContent.toString();
        assertEquals(expectedOutput, consoleOutput);

    }



   // @Test
   /* void addCandyToGiftTest() throws Exception {
        List<Sweets> sweetsList = new ArrayList<>();
        sweetsList.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));
        sweetsList.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        List<Sweets> gift = new ArrayList<>();

        String input = "1\n2\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        GiftDao giftDao = new GiftDaoImpl(sweetsList, gift);
        GiftCommands giftCommands = new GiftCommands(giftDao,sweetsList,gift);
        giftCommands.addCandyToGift();

        List<Sweets> expectedGift = new ArrayList<>();
        expectedGift.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));
        expectedGift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        System.out.println("Цукерка 'Шоколадний трепет' додана до подарунку");
        System.out.println("Цукерка 'Карамельна мелодія' додана до подарунку");

        String expectedOutput = outContent.toString();

        String actualOutput = outContent.toString();

        assertEquals(expectedOutput, actualOutput);

        assertEquals(expectedGift,gift);
    }

    */

//    @Test
   /* void removeCandyFromGiftTest() throws Exception {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));
        gift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        String input = "1\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        GiftCommands giftCommands = new GiftCommands();
        giftCommands.removeCandyFromGift(gift);

        System.out.println("Цукерка Шоколадний трепет вилучена із вашого подарунку");

        String expectedOutput = outContent.toString();

        String actualOutput = outContent.toString();
        assertEquals(expectedOutput, actualOutput);

        assertTrue(gift.contains(new CaramelCandy("Карамельна мелодія", 25.0, 0.2)));
    }


    */

    /*
   @Test
     void calculateGiftWeightTest() throws Exception {
       List<Sweets> gift = new ArrayList<>();
       gift.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));
       gift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));


       GiftDao giftDao = Mockito.mock(GiftDao.class);


       double expectedTotalWeight = 75.0;
       Mockito.when(giftDao.calculateGiftWeight(Mockito.anyList())).thenReturn(expectedTotalWeight);


       GiftCommands giftCommands = new GiftCommands(null, null, null);
       giftCommands.setGiftDao(giftDao);
       giftCommands.calculateGiftWeight(gift);

       giftCommands.calculateGiftWeight(gift);


       Mockito.verify(giftDao).calculateGiftWeight(gift);

       // Перевіряємо результат
       double actualTotalWeight = giftCommands.calculateGiftWeight(gift);
       assertEquals(expectedTotalWeight, actualTotalWeight, 0.01); // Перевірка на рівність з деякою точністю
    }

     */



   /* @Test
    void findCandyBySugarContentTest() throws Exception {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));
        gift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));


        String input = "0.1\n0.3\n"; // Замість "0,1\n0,3\n"
        System.setIn(new ByteArrayInputStream(input.getBytes()));


        GiftCommands giftCommands = new GiftCommands();
        giftCommands.findCandyBySugarContent(gift);

        System.out.println("Цукерки за вмістом цукру в діапазоні [0.1;0.3]:");
        System.out.println("Карамельна мелодія - Вміст цукру: 0.2%");

        String expectedOutput = outContent.toString();


        String actualOutput = outContent.toString();
        assertEquals(expectedOutput, actualOutput);

    }

    */

    /*@Test
    void compositionOfTheGiftTest() {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));
        gift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));


        GiftCommands giftCommands = new GiftCommands();
        giftCommands.compositionOfTheGift(gift);


        String expectedOutput = "Склад вашого подарунку:" + System.lineSeparator() +
                "1. Шоколадний трепет" + System.lineSeparator() +
                "2. Карамельна мелодія" + System.lineSeparator();

        String actualOutput = outContent.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void sortBySugarContentTest() {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("Шоколадний розкіш", 40.0, 0.25));
        gift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        GiftCommands giftCommands = new GiftCommands();
        giftCommands.sortBySugarContent(gift);

        List<Sweets> expectedGift = new ArrayList<>();
        expectedGift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));
        expectedGift.add(new ChocolateCookie("Шоколадний розкіш", 40.0, 0.25));

        assertEquals(expectedGift, gift);
    }

    @Test
    void sortByNameTest() throws Exception {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("B", 20, 0.6));
        gift.add(new CaramelCandy("C", 15, 0.4));
        gift.add(new ChocolateCookie("A", 30, 0.5));


        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));


        GiftCommands giftCommands = new GiftCommands();
        giftCommands.sortCandies(gift);


        List<Sweets> expectedGift = new ArrayList<>();
        expectedGift.add(new ChocolateCookie("A", 30, 0.5));
        expectedGift.add(new ChocolateCookie("B", 20, 0.6));
        expectedGift.add(new CaramelCandy("C", 15, 0.4));

        assertEquals(expectedGift, gift);
    }

    @Test
    void sortByWeightTest() {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("Шоколадний розкіш", 40.0, 0.25));
        gift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        GiftCommands giftCommands = new GiftCommands();
        giftCommands.sortByWeight();

        List<Sweets> expectedGift = new ArrayList<>();
        expectedGift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));
        expectedGift.add(new ChocolateCookie("Шоколадний розкіш", 40.0, 0.25));

        assertEquals(expectedGift,gift);
    }

     */
}
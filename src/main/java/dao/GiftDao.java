package dao;

import gift.GiftRunner;
import sweets.Sweets;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public interface GiftDao {



    void printSweetsInfo();

    void addCandyToGift() throws Exception;

    void removeCandyFromGift() throws Exception;

    void calculateGiftWeight() throws Exception;

    void sortCandies() throws Exception;

    void findCandyBySugarContent() throws Exception;

    void compositionOfTheGift();

    void sortBySugarContent();

    void sortByName();

    void sortByWeight();


}

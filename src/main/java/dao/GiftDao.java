package dao;

import gift.GiftRunner;
import sweets.Sweets;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public interface GiftDao {

    void printSweetsInfo(List<Sweets> sweetsList);

    void addCandyToGift(List<Sweets> sweetsList, List<Sweets> gift) throws Exception;

    void removeCandyFromGift(List<Sweets> gift) throws Exception;

    void calculateGiftWeight(List<Sweets> gift) throws Exception;

    void sortCandies(List<Sweets> gift) throws Exception;

    void findCandyBySugarContent(List<Sweets> gift) throws Exception;

    void compositionOfTheGift(List<Sweets> gift);

    void sortBySugarContent(List<Sweets> gift);

    void sortByName(List<Sweets> gift);

    void sortByWeight(List<Sweets> gift);


}

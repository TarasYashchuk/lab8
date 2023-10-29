package command;

import dao.GiftDao;
import sweets.*;

import java.util.*;


    public class GiftCommands {
        private GiftDao giftDao;
        public GiftCommands(GiftDao giftDao) {
            this.giftDao = giftDao;

        }
        public void printSweetsInfo() {
            giftDao.printSweetsInfo();
        }

        public void addCandyToGift() throws Exception {
            giftDao.addCandyToGift();
        }

        public void removeCandyFromGift() throws Exception {
            giftDao.removeCandyFromGift();
        }

        public void calculateGiftWeight() throws Exception {
            giftDao.calculateGiftWeight();
        }

        public void sortCandies() throws Exception {
            giftDao.sortCandies();
        }

        public void findCandyBySugarContent() throws Exception {
            giftDao.findCandyBySugarContent();
        }

        public void compositionOfTheGift() {
            giftDao.compositionOfTheGift();
        }

        public void sortBySugarContent() {
            giftDao.sortBySugarContent();
        }

        public void sortByName() {
            giftDao.sortByName();
        }

        public void sortByWeight() {
            giftDao.sortByWeight();
        }

}
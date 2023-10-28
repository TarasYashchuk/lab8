package command;

import dao.GiftDao;
import sweets.*;

import java.util.*;


    public class GiftCommands {
        private GiftDao giftDao;
        private List<Sweets> sweetsList;
        private List<Sweets> gift;

        public GiftCommands(GiftDao giftDao, List<Sweets> sweetsList, List<Sweets> gift) {
            this.giftDao = giftDao;
            this.sweetsList = sweetsList;
            this.gift = gift;
        }

        public void printSweetsInfo() {
            giftDao.printSweetsInfo(sweetsList);
        }

        public void addCandyToGift() throws Exception {
            giftDao.addCandyToGift(sweetsList,gift);
        }

        public void removeCandyFromGift() throws Exception {
            giftDao.removeCandyFromGift(gift);
        }

        public void calculateGiftWeight() throws Exception {
            giftDao.calculateGiftWeight(gift);
        }

        public void sortCandies() throws Exception {
            giftDao.sortCandies(gift);
        }

        public void findCandyBySugarContent() throws Exception {
            giftDao.findCandyBySugarContent(gift);
        }

        public void compositionOfTheGift() {
            giftDao.compositionOfTheGift(gift);
        }

        public void sortBySugarContent() {
            giftDao.sortBySugarContent(gift);
        }

        public void sortByName() {
            giftDao.sortByName(gift);
        }

        public void sortByWeight() {
            giftDao.sortByWeight(gift);
        }

}
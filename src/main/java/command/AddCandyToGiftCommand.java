package command;

import dao.GiftDao;
import dao.GiftDaoImpl;
import gift.GiftRunner;
import sweets.Sweets;

import java.util.List;

public class AddCandyToGiftCommand implements Command {

    private GiftCommands giftCommands;

    public AddCandyToGiftCommand(GiftCommands giftCommands) {
        this.giftCommands = giftCommands;
    }

    @Override
    public void execute() throws Exception {
        giftCommands.addCandyToGift();
    }

    @Override
    public String getDescription() {
        return "Додати цукерку до подарунка";
    }
}
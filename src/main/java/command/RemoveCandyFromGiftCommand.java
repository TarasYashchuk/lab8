package command;

import dao.GiftDao;
import sweets.Sweets;

import java.util.List;

public class RemoveCandyFromGiftCommand implements Command{
    private GiftCommands command;

    public RemoveCandyFromGiftCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute() throws Exception {
        command.removeCandyFromGift();
    }

    @Override
    public String getDescription() {
        return "Вилучити цукерку з подарунка";
    }
}
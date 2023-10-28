package command;

import dao.GiftDao;
import sweets.Sweets;

import java.util.List;

public class CompositionOfTheGiftCommand implements Command{
    private GiftCommands command;

    public CompositionOfTheGiftCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute() throws Exception {
        command.compositionOfTheGift();
    }

    @Override
    public String getDescription() {
        return "Вміст подарунка";
    }
}
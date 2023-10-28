package command;

import dao.GiftDao;
import sweets.Sweets;

public class CalculateGiftWeightCommand implements Command{
    private GiftCommands command;

    public CalculateGiftWeightCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute() throws Exception {
        command.calculateGiftWeight();
    }
    @Override
    public String getDescription() {
        return "Вага всього подарунка";
    }
}
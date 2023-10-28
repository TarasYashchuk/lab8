package command;

import dao.GiftDao;
import sweets.Sweets;

import java.util.InputMismatchException;
import java.util.List;

public class FindCandyBySugarContentCommand implements Command {
    private GiftCommands command;

    public FindCandyBySugarContentCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute() throws Exception {
        command.findCandyBySugarContent();
    }

    @Override
    public String getDescription() {
        return "Знайти цукерку за певним вмістом цукру";
    }
}
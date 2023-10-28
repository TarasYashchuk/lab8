package command;

import dao.GiftDao;
import sweets.Sweets;

import java.util.List;

public class SortCandiesCommand implements Command {
    private GiftCommands command;

    public SortCandiesCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute() throws Exception {
        command.sortCandies();
    }

    @Override
    public String getDescription() {
        return "Відсортувати цукерки";
    }
}
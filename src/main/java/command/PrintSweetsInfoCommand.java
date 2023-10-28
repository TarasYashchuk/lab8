package command;

import dao.GiftDao;
import dao.GiftDaoImpl;
import sweets.*;

import java.io.IOException;
import java.util.List;

public class PrintSweetsInfoCommand implements Command{
    private GiftCommands command;

    public PrintSweetsInfoCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute() throws Exception {
        command.printSweetsInfo();
    }

    @Override
    public String getDescription() {
        return "Інформація про всі солодощі";
    }
}
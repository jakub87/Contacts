package contacts.controler;

import contacts.command.contracts.Command;

public class ContractsController {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand() {
        command.execute();
    }
}

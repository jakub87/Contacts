package contacts.controler;

import contacts.command.record.RecordCommand;
import contacts.model.Contract;

public class RecordController {
    private RecordCommand recordCommand;
    public void setCommand(RecordCommand recordCommand) {
        this.recordCommand = recordCommand;
    }
    public void executeCommand(Contract contract) {
        recordCommand.execute(contract);
    }
}

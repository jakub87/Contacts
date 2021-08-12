package contacts.command.record;

import contacts.model.Contract;

public interface RecordCommand {
    void execute(Contract contract);
}

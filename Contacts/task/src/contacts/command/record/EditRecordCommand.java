package contacts.command.record;

import contacts.model.Contract;

public class EditRecordCommand implements RecordCommand{

    @Override
    public void execute(Contract contract) {
          contract.edit();
          System.out.println("Saved");
    }
}

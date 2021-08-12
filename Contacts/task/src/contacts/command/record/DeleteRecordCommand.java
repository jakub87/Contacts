package contacts.command.record;

import contacts.model.Contract;

import java.util.List;

public class DeleteRecordCommand implements RecordCommand{

    private List<Contract> contractList;

    public DeleteRecordCommand(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public void execute(Contract contract) {
        contractList.remove(contract);
        System.out.println("The record removed!\n");
    }
}

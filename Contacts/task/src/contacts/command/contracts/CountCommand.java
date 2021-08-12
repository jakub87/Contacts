package contacts.command.contracts;

import contacts.model.Contract;

import java.util.List;

public class CountCommand implements Command {
    private List<Contract> contractList;
    public CountCommand(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public void execute() {
        System.out.println("The Phone Book has " + contractList.size() + " records.\n");
    }
}

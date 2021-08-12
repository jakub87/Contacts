package contacts.command.contracts;

import contacts.model.Contract;
import contacts.service.RecordService;

import java.util.List;
import java.util.Scanner;

public class InfoCommand implements Command {

    private List<Contract> contractList;
    private Scanner scanner;

    public InfoCommand(List<Contract> contractList) {
        scanner = new Scanner(System.in);
        this.contractList = contractList;
    }

    @Override
    public void execute() {
        String userAction;
        do {
            if (contractList.isEmpty()) {
                System.out.println("No records in list!\n");
                break;
            } else {
                for (int i = 0; i < contractList.size(); i++) {
                    System.out.println(i + 1 + ". " + contractList.get(i).getShortInfo());
                }
                System.out.println("\n[list] Enter action ([number], back):");
                userAction = scanner.nextLine();
                if (userAction.matches("\\d+") && Integer.parseInt(userAction) >= 1 && Integer.parseInt(userAction) <= contractList.size()) {
                    new RecordService(contractList).recordAction(contractList.get(Integer.parseInt(userAction) - 1));
                    break;
                } else if (userAction.equalsIgnoreCase("back")) {
                    break;
                } else {
                    System.out.println("Wrong action\n");
                }
            }
        } while (true);
    }
}











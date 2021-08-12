package contacts.service;


import contacts.command.record.DeleteRecordCommand;
import contacts.command.record.EditRecordCommand;
import contacts.controler.RecordController;
import contacts.model.Contract;

import java.util.List;
import java.util.Scanner;

public class RecordService {
    private RecordController recordController;
    private Scanner scanner;
    private List<Contract> contractList;

    public RecordService(List<Contract> contractList) {
        this.contractList = contractList;
        this.scanner = new Scanner(System.in);
        recordController = new RecordController();
    }

    private void recordMenu() {
        System.out.println("[record] Enter action (edit, delete, menu):");
    }

    public void recordAction(Contract contract) {
        String recordAction;
        do {
            System.out.println(contract);
            recordMenu();
            recordAction = scanner.nextLine();
            if (recordAction.equalsIgnoreCase("menu")) {
                break;
            } else if (recordAction.equalsIgnoreCase("delete")) {
                recordController.setCommand(new DeleteRecordCommand(contractList));
                recordController.executeCommand(contract);
                break;
            } else if (recordAction.equalsIgnoreCase("edit")) {
                recordController.setCommand(new EditRecordCommand());
                recordController.executeCommand(contract);
            } else {
                System.out.println("Wrong action\n");
            }
        }while(true);
    }
}

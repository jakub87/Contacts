package contacts;

import contacts.command.contracts.SearchCommand;
import contacts.command.contracts.AddCommand;
import contacts.command.contracts.CountCommand;
import contacts.command.contracts.InfoCommand;

import contacts.controler.ContractsController;
import contacts.model.Contract;
import contacts.service.SerializationService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookApp {
    private Scanner scanner;
    private List<Contract> contractList;
    private ContractsController contractsController;
    private SerializationService serializationService;
    private String [] args;
    private final String pathFile = "C:\\Users\\A593191\\IdeaProjects\\Contacts\\";

    public PhoneBookApp(String [] args) {
        scanner = new Scanner(System.in);
        contractList = new ArrayList<>();
        contractsController = new ContractsController();
        serializationService = new SerializationService();
        this.args = args;
    }

    private void mainMenu() {
        System.out.println("[menu] Enter action (add, list, search, count, exit):");
    }

    private void saveContracts() {
        if (args.length > 0) {
            serializationService.serialize(contractList, pathFile + args[0]);
        }
    }

    private void loadContracts() {
        if (args.length > 0) {
            if (!new File(args[0]).exists()) {
                File file = new File(pathFile + args[0]);
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                serializationService.deserialize(pathFile + args[0]);
            }
        }
    }

    public void startApp() {
        String userAction;
        loadContracts();
        do {
            mainMenu();
            userAction = scanner.nextLine();
            switch (userAction.toLowerCase()) {
                case "add":
                    contractsController.setCommand(new AddCommand(contractList));
                    contractsController.executeCommand();
                    break;
                case "list":
                    contractsController.setCommand(new InfoCommand(contractList));
                    contractsController.executeCommand();
                    break;
                case "search":
                    contractsController.setCommand(new SearchCommand(contractList));
                    contractsController.executeCommand();
                    break;
                case "count":
                    contractsController.setCommand(new CountCommand(contractList));
                    contractsController.executeCommand();
            }
        } while(!userAction.equals("exit"));
        saveContracts();
    }
}

package contacts.command.contracts;

import contacts.model.Contract;
import contacts.service.RecordService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SearchCommand implements Command {

    private List<Contract> contractList;

    public SearchCommand(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public void execute() {
        Map<Integer, Integer> idContractMapping = new HashMap<>();
        StringBuilder searchResult = new StringBuilder();
        String userAction;
        do {
            if (contractList.isEmpty()) {
                System.out.println("No records in list!\n");
                break;
            } else {
                idContractMapping.clear();
                System.out.println("Enter search query: ");
                String searchQuery = new Scanner(System.in).nextLine();
                for (int i = 0; i < contractList.size(); i++) {
                    if (contractList.get(i).search(searchQuery)) {
                        idContractMapping.put(idContractMapping.size() + 1, i);
                        searchResult.append(idContractMapping.size() + ". " + contractList.get(i).getShortInfo() + "\n");
                    }
                }
                System.out.println("Found " + idContractMapping.size() + " results:\n" + searchResult);

                System.out.println("[search] Enter action ([number], back, again):");
                userAction = new Scanner(System.in).nextLine();
                if (userAction.equalsIgnoreCase("again")) {
                    continue;
                } else if (userAction.equalsIgnoreCase("back")) {
                    break;
                } else if (userAction.matches("\\d+") && Integer.parseInt(userAction) >= 1 && Integer.parseInt(userAction) <= idContractMapping.size()) {
                        new RecordService(contractList).recordAction(contractList.get(idContractMapping.get(Integer.parseInt(userAction))));
                        break;
                } else {
                    System.out.println("Wrong action\n");
                }
            }
        }while (true);
    }
}

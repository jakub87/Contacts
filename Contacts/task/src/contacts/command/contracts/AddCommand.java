package contacts.command.contracts;

import contacts.model.Contract;
import contacts.model.Organization;
import contacts.model.Person;

import java.util.List;
import java.util.Scanner;

public class AddCommand implements Command {

    private List<Contract> contractList;
    private Scanner scanner;

    public AddCommand(List<Contract> contractList) {
        this.contractList = contractList;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.println("Enter the type (person, organization):");
        String contractType = scanner.nextLine();
        if (contractType.equalsIgnoreCase("person")) {
            contractList.add(addPerson());
        } else if (contractType.equalsIgnoreCase("organization")) {
            contractList.add(addOrganization());
        }
        System.out.println("The record added.\n");
     }

    private Contract addPerson() {
        Person person = new Person();
        System.out.println("Enter the name:");
        person.setName(scanner.nextLine());
        System.out.println("Enter the surname:");
        person.setSurname(scanner.nextLine());
        System.out.println("Enter the birth date:");
        person.setBirthDate(scanner.nextLine());
        System.out.println("Enter the gender (M, F):");
        person.setGender(scanner.nextLine());
        System.out.println("Enter the number:");
        person.setPhoneNumber(scanner.nextLine());
        return person;
    }

    private Contract addOrganization() {
        Organization organization = new Organization();
        System.out.println("Enter the organization name:");
        organization.setOrganizationName(scanner.nextLine());
        System.out.println("Enter the address:");
        organization.setAddress(scanner.nextLine());
        System.out.println("Enter the number:");
        organization.setPhoneNumber(scanner.nextLine());
        return organization;
    }
}

package contacts.model;


import java.time.LocalDateTime;

public class Organization extends Contract{
    private String organizationName;
    private String address;

    @Override
    public void edit() {
        System.out.println("Select a field (organization name, address, number): ");
        String fieldName = scanner.nextLine();
        System.out.println("Enter " + fieldName + ":");
        String newValue = scanner.nextLine();
        if (fieldName.equalsIgnoreCase("organization name")) {
            setOrganizationName(newValue);
        } else if (fieldName.equalsIgnoreCase("address")) {
            setAddress(newValue);
        } else if (fieldName.equalsIgnoreCase("number")) {
            setPhoneNumber(newValue);
        }
        setLastEditTime(LocalDateTime.now());
    }

    @Override
    public String getShortInfo() {
        return organizationName;
    }

    @Override
    public boolean search(String searchValue) {
          String contractData = getOrganizationName() + " " + getAddress() + " " + getPhoneNumber();
          if (contractData.toLowerCase().contains(searchValue.toLowerCase())) {
              return true;
          } else {
              return false;
          }
    }

    @Override
    public String toString() {
        return "Organization name: " + organizationName + "\n" +
                "Address: " + address + "\n" +
                "Number: " + getPhoneNumber() + "\n" +
                "Time created: " + getCreatedTime() + "\n" +
                "Time last edit: " + getLastEditTime() + "\n";
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

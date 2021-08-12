package contacts.repository;

public interface ContractRepository {
    void edit();
    String getShortInfo();
    boolean search(String searchValue);
}

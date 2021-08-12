package contacts.model;

import contacts.repository.ContractRepository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contract implements ContractRepository, Serializable {
    protected String phoneNumber;
    protected LocalDateTime createdTime;
    protected LocalDateTime lastEditTime;
    transient protected Scanner scanner;

    transient private final String phoneNumberRegex = "^[+]?([\\d\\w]{1,}([ -]?[\\d\\w]{2,})*$|[(][\\w\\d]{1,}[)]([ -]?[\\d\\w]{2,})*$|[\\d\\w]{1,}([ -][(][\\w\\d]{2,}[)])([ -]?[\\d\\w]{2,})*$)";
    transient protected Matcher matcher;

    public Contract() {
        this.createdTime = LocalDateTime.now();
        this.lastEditTime = LocalDateTime.now();
        scanner = new Scanner(System.in);
    }

    public String getPhoneNumber() {
        if (phoneNumber.isEmpty()) {
            return "[no number]";
        } else {
            return this.phoneNumber;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        matcher = Pattern.compile(phoneNumberRegex).matcher(phoneNumber);
        if (matcher.matches() && !phoneNumber.isEmpty()) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "";
        }
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(LocalDateTime lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}

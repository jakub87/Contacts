package contacts.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Person extends Contract {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender;

    private transient final String genderRegex =  "^[(m|f)]{1}$";
    private transient final String birthDateRegex = "^\\d{4}-\\d{2}-\\d{2}$";

    @Override
    public void edit() {
        System.out.println("Select a field (name, surname, birth, gender, number): ");
        String fieldName = scanner.nextLine();
        System.out.println("Enter " + fieldName + ":");
        String newValue = scanner.nextLine();
        if (fieldName.equalsIgnoreCase("name")) {
            setName(newValue);
        } else if (fieldName.equalsIgnoreCase("surname")) {
            setSurname(newValue);
        } else if (fieldName.equalsIgnoreCase("birth date")) {
            setBirthDate(newValue);
        } else if (fieldName.equalsIgnoreCase("gender")) {
            setGender(newValue);
        } else if (fieldName.equalsIgnoreCase("number")) {
            setPhoneNumber(newValue);
        }
        setLastEditTime(LocalDateTime.now());
    }

    @Override
    public String getShortInfo() {
        return name + " " + surname;
    }

    @Override
    public boolean search(String searchValue) {
        String contractData = getName() + " " + getSurname() + " " + getPhoneNumber();
        if (contractData.toLowerCase().contains(searchValue.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\n" +
               "Surname: " + getSurname() + "\n" +
               "Birth date: " + getBirthDate()+ "\n" +
               "Gender: " + getGender() + "\n" +
               "Number: " + getPhoneNumber() + "\n" +
               "Time created: " + getCreatedTime() + "\n" +
               "Time last edit: " + getLastEditTime() + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        if (birthDate == null) {
            return "[no data]";
        } else {
          return this.birthDate.toString();
        }
    }

    public void setBirthDate(String birthDate) {
        matcher = Pattern.compile(birthDateRegex).matcher(birthDate);
        if (matcher.matches() && !birthDate.isEmpty()) {
            this.birthDate = LocalDate.parse(birthDate);
        } else {
            System.out.println("Bad birth date!");
            this.birthDate = null;
        }
    }

    public String getGender() {
        if (this.gender.isEmpty()) {
            return "[no data]";
        } else {
            return this.gender;
        }
    }

    public void setGender(String gender) {
        matcher = Pattern.compile(genderRegex, Pattern.CASE_INSENSITIVE).matcher(gender);
        if (matcher.matches() && !gender.isEmpty()) {
            this.gender = gender;
        } else {
            System.out.println("Bad gender!");
            this.gender = "";
        }

    }
}

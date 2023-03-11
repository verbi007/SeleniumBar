package pages.threadQA;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WebTablesRow {

    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int salary;
    private String department;

    public WebTablesRow(String firstName, String lastName, String email, int age, int salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }
}

package haowei.springframework.sfgpetclinic.model;

/**
 * Created by haoweili on 11/4/2020
 */

public class Person extends BaseEntity{


    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

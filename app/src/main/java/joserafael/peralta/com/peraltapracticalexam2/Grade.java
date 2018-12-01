package joserafael.peralta.com.peraltapracticalexam2;

public class Grade {

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getAverage() {
        return average;
    }

    public Grade(String firstName, String lastName, long average) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.average = average;
    }

    String firstName;
    String lastName;
    long average;

    public Grade(){

    }


}

package laba_2;

        import java.io.Serializable;
        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.util.Date;
        import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String middleName;
    private LocalDate birthday;
    private int phoneNumber;
    private float salary;
    private String passportNumber;

// конструктор для Employee

    public Employee(String name,String surname,String middleName,
                    LocalDate birthday,int phoneNumber,float salary,String passportNumber) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.passportNumber = passportNumber;
    }

    public Employee(){

    }


    @Override
    public String toString() {
        return name + " | " + surname + " | " + middleName + " | " + birthday + " | " + phoneNumber + " | " + salary + " | " + passportNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Employee employee = (Employee) obj;
        return (employee.name.equals(this.name) &&
                employee.surname.equals(this.surname) &&
                employee.middleName.equals(this.middleName)
        );
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.surname);
        result = 31 * result + Objects.hashCode(this.middleName);
        return result;
    }

    /**
     * name getter
     */
    public String getName(){
        return name;
    }

    /**
     * surname getter
     */
    public String getSurname(){
        return surname;
    }

    /**
     * middle_name getter
     */
    public String getMiddleName (){
        return middleName;
    }

    /**
     * age getter
     */
    public LocalDate getBirthday(){
        return birthday;
    }

    /**
     * phone_number getter
     */
    public int getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * salary getter
     */

    public float getSalary(){
        return salary;
    }

    /**
     * passport_number getter
     */

    public String getPassportNumber(){
        return passportNumber;
    }



    /**
     * name setter
     */
    public void setName(String name) { this.name = name; }

    /**
     *
     * surname setter
     */
    public void setSurname(String surname) { this.surname = surname; }

    /**
     * middle_name setter
     */
    public void setMiddleName(String middle_name) { this.middleName = middle_name ; }

    /**
     * age setter
     */
    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

    /**
     * phone_number setter
     */
    public void setPhoneNumber(int phone_number) { this.phoneNumber = phone_number; }

    /**
     * salary setter
     */
    public void setSalary(float salary) { this.salary = salary; }


    /**
     * passport_number setter
     */
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }



}// до класу дужка

package Laba_1;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String middleName;
    private LocalDate age;
    private int phoneNumber;
    private float salary;
    private String passportNumber;

// конструктор для Employee

    private Employee(EmployeeBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.middleName = builder.middleName;
        this.age = builder.age;
        this.phoneNumber = builder.phoneNumber;
        this.salary = builder.salary;
        this.passportNumber = builder.passportNumber;
        this.animals = builder.animals;
    }

    private List<Animal> animals;

    @Override
    public String toString() {
        return name + " | " + surname + " | " + middleName + " | " + age + " | " + phoneNumber + " | " + salary + " | " + passportNumber + " | " + animals;
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
     * Builder pattern
     */
    public static class EmployeeBuilder {

        private String name = " ";
        private String surname = " ";
        private String middleName = " ";
        private LocalDate age = LocalDate.now();
        private int phoneNumber = 0;
        private float salary = 0;
        private String passportNumber = " ";

        private List<Animal> animals;


        /**
         * Builder constructor with required parameters
         *
         * @param name
         */
        public EmployeeBuilder(String name) {
            this.name = name;
        }


        /**
         * Builder surname setter
         *
         * @param surname
         * @return object
         */

        public EmployeeBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        /**
         * Builder middle_name setter
         *
         * @param middleName
         * @return object
         */

        public EmployeeBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public EmployeeBuilder setAnimals(List<Animal> animals) {
            this.animals = animals;
            return this;
        }
        /**
         * Builder age setter
         *
         * @param age
         * @return object
         */

        public EmployeeBuilder setAge(LocalDate age) {
            this.age = age;
            return this;
        }

        /**
         * Builder phone_number setter
         *
         * @param phoneNumber
         * @return object
         */


        public EmployeeBuilder setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Builder salary setter
         *
         * @param salary
         * @return object
         */


        public EmployeeBuilder setSalary(float salary) {
            this.salary = salary;
            return this;
        }


        /**
         * Builder passport_number setter
         *
         * @param passportNumber
         * @return object
         */

        public EmployeeBuilder setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
            return this;
        }
        //}    !!!!!!!!!!!!!!!!!!!!!!!!!!!

        /**
         * Builder build method
         *
         * @return instance of Employee class
         */

        public Employee build() {
            return new Employee(this);
        }

    }// до білдера
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
    public LocalDate getAge(){
        return age;
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
    public void setAge(LocalDate age) { this.age = age; }

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

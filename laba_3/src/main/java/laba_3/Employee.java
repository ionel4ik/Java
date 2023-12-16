package laba_3;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Employee {
    @NotBlank(message = "Name is mandatory")
    private String name;

    private String surname;
    private String middleName;

    @Positive(message = "Age must be a positive number")
    private int age;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number")
    private String phoneNumber;

    @Positive(message = "Salary must be a positive number")
    private float salary;

    @Pattern(regexp = "\\d{10}", message = "Passport number must be a 9-digit number")
    private String passportNumber;

    private List<Animal> animals;

    /**
     * Employee constructor
     *
     * @param builder
     */
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


    @Override
    public String toString() {
        return name + " | " + surname + " | " + middleName + " | " + age + " | " +
                phoneNumber + " | " + salary + " | " + passportNumber + " | " + animals;
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
        int result = 7;
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.surname);
        result = 31 * result + Objects.hashCode(this.middleName);
        return result;
    }


    /**
     * Builder pattern
     */
    public static class EmployeeBuilder {
        /**
         * @param name is mandatory, others are optional
         */

        private String name;

        private String surname = " ";

        private String middleName = " ";


        private int age = 0;


        private String phoneNumber = " ";


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


        // Setters :


        /**
         * Builder salary setter
         *
         * @param surname
         * @return object
         */
        public EmployeeBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        /**
         * Builder salary setter
         *
         * @param middleName
         * @return object
         */
        public EmployeeBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        /**
         * Builder Age setter
         *
         * @param age
         * @return object
         */
        public EmployeeBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        /**
         * Builder phoneNumber setter
         *
         * @param phoneNumber
         * @return object
         */
        public EmployeeBuilder setPhoneNumber(String phoneNumber) {
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

        private void validate() throws IllegalArgumentException {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Employee employee = new Employee(this);
            Set<ConstraintViolation<Employee>> violations = validator.validate(employee);

            StringBuilder mb = new StringBuilder();

            for (ConstraintViolation<Employee> violation : violations) {
                mb.append("Error for field ").append(violation.getPropertyPath()).append(": ").append(violation.getInvalidValue()).append(" ").append(violation.getMessage())
                ;
            }

            if (!mb.isEmpty()) {
                throw new IllegalArgumentException(mb.toString());
            }
        }

        /**
         * Builder passportNumber setter
         *
         * @param passportNumber
         * @return object
         */
        public EmployeeBuilder setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
            return this;
        }

        public EmployeeBuilder setAnimals(List<Animal> animals) {
            this.animals = animals;
            return this;
        }

        /**
         * Builder build method
         *
         * @return instance of Employee class
         */
        public Employee build() {
            validate();
            return new Employee(this);
        }

    }


    // Getters:

    /**
     * name getter
     */
    public String getName() {
        return name;
    }

    /**
     * surname getter
     */
    public String getSurname() {
        return surname;
    }

    /**
     * middle_name getter
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * age getter
     */
    public int getAge() {
        return age;
    }

    /**
     * phone_number getter
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * salary getter
     */

    public float getSalary() {
        return salary;
    }

    /**
     * passport_number getter
     */

    public String getPassportNumber() {
        return passportNumber;
    }


//Setters:


    /**
     * name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * surname setter
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * middle_name setter
     */
    public void setMiddleName(String middle_name) {
        this.middleName = middle_name;
    }

    /**
     * age setter
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * phone_number setter
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * salary setter
     */
    public void setSalary(float salary) {
        this.salary = salary;
    }


    /**
     * passport_number setter
     */
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

}// до класу дужка

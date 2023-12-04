package laba1test;

import Laba_1.Employee;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.*;

public class EmployeeTest {


    Employee employee1 = new Employee.EmployeeBuilder("Tanya")
            .setSurname("Tkach")
            .setMiddleName("Olegivna")
            .setAge(LocalDate.of(1984, 07, 15))
            .setPhoneNumber(990167811)
            .setSalary(4500)
            .setPassportNumber("18023")
            .build();

    Employee employee2 = new Employee.EmployeeBuilder("Maryana")
            .setSalary(5000)
            .build();

    Employee employee3 = new Employee.EmployeeBuilder("Tanya")
            .setSurname("Tkach")
            .setMiddleName("Olegivna")
            .setAge(LocalDate.of(1984, 07, 15))
            .setPhoneNumber(990167811)
            .setSalary(4500)
            .setPassportNumber("18023")
            .build();



    // початок

    @Test(dataProvider = "employeeEqualsProvider")
    public void employeeEqualsTest(Employee e1, Employee e2) {
        assertEquals(e1, e2);
    }

    @DataProvider
    public Object[][] employeeEqualsProvider() {
        return new Object[][]{{employee1, employee3}};
    }

    @Test(dataProvider = "employeeNotEqualsProvider")
    public void employeeNotEqualsTest(Employee e1, Employee e2) {
        assertNotEquals(e1,e2);
        assertNotSame(e1,e2);
    }

    @DataProvider
    public Object[][] employeeNotEqualsProvider() {
        return new Object[][]{{employee1, employee2}};
    }

    @Test(dataProvider = "employeeToStringProvider")
    public void employeeToStringTest(Employee e1, String st) {
        assertEquals(e1.toString(), st);
    }

    @DataProvider
    public Object[][] employeeToStringProvider() {
        return new Object[][]{{employee1, "Tanya | Tkach | Olegivna | 1984-07-15 | 990167811 | 4500.0 | 18023"}};
    }

    // кінець



}


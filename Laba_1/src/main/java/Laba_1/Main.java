package Laba_1;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Animal animal1 = new Animal.AnimalBuilder("Chichi")
                .setKind("Parrot")
                .setBirthday(LocalDate.of(2021,07,15))
                .setWeight(0.2F)
                .setHeight( 0.15F)
                .setWidth(0.1F)
                .build();
        Animal animal2 = new Animal.AnimalBuilder("Klava")
                .setKind("dog")
                .setBirthday(LocalDate.of(2020,05,25))
                .setWeight(4.5F)
                .setHeight(0.8F)
                .setWidth(0.5F)
                .build();
        Animal animal3 = new Animal.AnimalBuilder("Mili")
                .setKind("mouse")
                .setBirthday(LocalDate.of(2019,11,10))
                .setWeight(0.2F)
                .setHeight(0.15F)
                .setWidth(0.1F)
                .build();


        Employee employee1 = new Employee.EmployeeBuilder("Tanya")
                .setSurname("Tkach")
                .setMiddleName("Olegivna")
                .setAnimals(List.of(animal3))
                .setAge(LocalDate.of(1984,07,15))
                .setPhoneNumber(990167811)
                .setSalary(4500)
                .setPassportNumber("18023")
                .build();


        Employee  employee2 = new Employee.EmployeeBuilder("Maryana")
                .setSurname("Mukutey")
                .setMiddleName("Andriyivna")
                .setAnimals(List.of(animal1,animal2))
                .setAge(LocalDate.of(2000,04,12))
                .setPhoneNumber(559383293)
                .setSalary(5000)
                .setPassportNumber("28834")
                .build();

        Employee  employee3 = new Employee.EmployeeBuilder("Stepan")
                .setSurname("Turetskuy")
                .setMiddleName("Vasulovuch")
                .setAge(LocalDate.of(1999,01,20))
                .setPhoneNumber(55022277)
                .setSalary(4000)
                .setPassportNumber("83763")
                .build();



        Medicine medicine1 = new Medicine.MedicineBuilder( "Laykozut")
                .setCompany("Unisec")
                .setCountry("Germany")
                .setDoseAmount(125)
                .setPrice(5)
                .build();

        Medicine medicine2 = new Medicine.MedicineBuilder( "Redflik")
                .setCompany("Rog")
                .setCountry("Italy")
                .setDoseAmount(145)
                .setPrice(8)
                .build();

        Medicine medicine3 = new Medicine.MedicineBuilder( "Minta")
                .setCompany("Treba")
                .setCountry("Spain")
                .setDoseAmount(135)
                .setPrice(7)
                .build();

        System.out.println("Animals:");
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal3);
        System.out.println("");


        System.out.println("Employee:");
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println("");

        System.out.println("Medicine:");
        System.out.println(medicine1);
        System.out.println(medicine2);
        System.out.println("");
    }

}// до класу

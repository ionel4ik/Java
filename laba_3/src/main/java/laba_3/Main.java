package laba_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static laba_3.Animal.*;
import static laba_3.AnimalService.*;

public class Main {
    public static void main(String[] args) {

        // Employee

        Employee employee1 = new Employee.EmployeeBuilder("Stepan")
                .setSurname("Tkach")
                .setMiddleName("Viktorovich")
                .setAge(35)
                .setPhoneNumber("0499576533")
                .setSalary(2800)
                .setPassportNumber("3287879237")
                .build();

        Employee employee2 = new Employee.EmployeeBuilder("Masha")
                .setSurname("Orlezka")
                .setMiddleName("Tarasivna")
                .setAge(23)
                .setPhoneNumber("0748737844")
                .setSalary(2500)
                .setPassportNumber("7838728989")
                .build();

        Employee employee3 = new Employee.EmployeeBuilder("Stepan")
                .setSurname("Tkach")
                .setMiddleName("Viktorovich")
                .setAge(35)
                .setPhoneNumber("0499576533")
                .setSalary(2800)
                .setPassportNumber("3287879237")
                .build();

        // Animal

        Animal animal = new Animal.AnimalBuilder("Rex")
                .setKind("Dog")
                .setWeight(3.5f)
                .setHeight(0.5f)
                .setWidth(0.3f)
                .build();


        Animal animal1 = new Animal.AnimalBuilder("Rex")
                .setKind("Dog")
                .setWeight(3.5f)
                .setHeight(0.5f)
                .setWidth(0.3f)
                .build();

        Animal animal2 = new Animal.AnimalBuilder("Miki")
                .setKind("Mouse")
                .setWeight(0.2f)
                .setHeight(0.1f)
                .setWidth(0.07f)
                .build();

        Animal animal3 = new Animal.AnimalBuilder("Lina")
                .setKind("Parrot")
                .setWeight(0.25f)
                .setHeight(0.3f)
                .setWidth(0.16f)
                .build();

        Animal animal4 = new Animal.AnimalBuilder("Deni")
                .setKind("Cat")
                .setWeight(1.2f)
                .setHeight(0.5f)
                .setWidth(0.4f)
                .build();




        // Medicine


        Medicine medicine1 = new Medicine.MedicineBuilder("Likoza")
                .setCompany("Vila")
                .setCountry("Germany")
                .setDoseAmount(200)
                .setPrice(250)
                .build();

        Medicine medicine2 = new Medicine.MedicineBuilder( "Fruktoza")
                .setCompany("Swansy")
                .setCountry("France")
                .setDoseAmount(300)
                .setPrice(410)
                .build();

        Medicine medicine3 = new Medicine.MedicineBuilder( "Brighton")
                .setCompany("Otodo")
                .setCountry("Spain")
                .setDoseAmount(150)
                .setPrice(200)
                .build();

        Medicine medicine4 = new Medicine.MedicineBuilder( "Newcastle")
                .setCompany("Birmingem")
                .setCountry("England")
                .setDoseAmount(200)
                .setPrice(250)
                .build();





        List<Medicine> medicines = new ArrayList<>();
        medicines.add(medicine1);
        medicines.add(medicine2);
        medicines.add(medicine3);
        medicines.add(medicine4);
        System.out.println(medicines);


        animal.setMedicines(medicines);

        AnimalService service = new AnimalService(animal);

//        Collections.sort(medicines);
//        for(Medicine medicine : medicines){
//            System.out.println(medicine);
//        }
//        System.out.println();
//        Collections.sort(medicines, new MedicineComparator());
//        for(Medicine medicine : medicines){
//            System.out.println(medicine);
//        }


//        List<Animal> animals = new ArrayList<>();
//        animals.add(animal1);
//        animals.add(animal2);
//        animals.add(animal3);
//        animals.add(animal4);
//
//        for(Animal a : animals){
//            System.out.println(a);
//        }

//        Collections.sort(animals);
//        for(Animal a : animals){
//            System.out.println(a);
//        }





    }
}



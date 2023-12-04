package laba1test;

import Laba_1.Animal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;


public class AnimalTest {


    Animal animal1 = new Animal.AnimalBuilder("Chichi")
            .setKind("Parrot")
            .setBirthday(LocalDate.of(2021, 07, 15))
            .setWeight(0.2F)
            .setHeight(0.15F)
            .setWidth(0.1F)
            .build();

    Animal animal2 = new Animal.AnimalBuilder("Klava")
            .setWeight(4.5F)
            .build();

    Animal animal3 = new Animal.AnimalBuilder("Chichi")
            .setKind("Parrot")
            .setBirthday(LocalDate.of(2021, 07, 15))
            .setWeight(0.2F)
            .setHeight(0.15F)
            .setWidth(0.1F)
            .build();

    // початок

    @Test(dataProvider = "animalEqualsProvider")
    public void animalEqualsTest(Animal an1, Animal an2) {
        assertEquals(an1, an2);
    }

    @DataProvider
    public Object[][] animalEqualsProvider() {
        return new Object[][]{{animal1, animal3}};
    }

    @Test(dataProvider = "animalNotEqualsProvider")
    public void animalNotEqualsTest(Animal an1, Animal an2) {
        assertNotEquals(an1, an2);
    }

    @DataProvider
    public Object[][] animalNotEqualsProvider() {
        return new Object[][]{{animal1, animal2}};
    }

    @Test(dataProvider = "animalToStringProvider")
    public void animalToStringTest(Animal an1, String st) {
        assertEquals(an1.toString(), st);
    }

    @DataProvider
    public Object[][] animalToStringProvider() {
        return new Object[][]{{animal1, "Chichi | Parrot | 2021-07-15 | 0.2 | 0.15 | 0.1"}};
    }

    // кінець









}

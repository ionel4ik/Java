package laba_test;



        import static laba_3.Animal.*;
      //  import static laba_3.Animal.getSumOfPrices;
        import static org.testng.Assert.assertEquals;

        import laba_3.Animal;
        import laba_3.AnimalService;
        import laba_3.Employee;
        import laba_3.Medicine;
        import org.testng.annotations.DataProvider;
        import org.testng.annotations.Test;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;


public class laba_test {
    public boolean checkList(List<Medicine> l1, List<Medicine> l2) {
        if (l1.size() != l2.size()) return false;
        int i = 0;
        while (i < l1.size()) {
            if (!l1.get(i).equals(l2.get(i))) return false;
            i++;
        }
        return true;
    }

    Employee employee1 = new Employee.EmployeeBuilder("Stepan")
            .setSurname("Tkach")
            .setMiddleName("Viktorovich")
            .setAge(35)
            .setPhoneNumber("0499576533")
            .setSalary(2800)
            .setPassportNumber("3287879237")
            .build();

    Medicine medicine1 = new Medicine.MedicineBuilder("Likoza")
            .setCompany("Vila")
            .setCountry("Germany")
            .setDoseAmount(200)
            .setPrice(250)
            .build();

    Medicine medicine2 = new Medicine.MedicineBuilder("Fruktoza")
            .setCompany("Swansy")
            .setCountry("France")
            .setDoseAmount(300)
            .setPrice(410)
            .build();

    Medicine medicine3 = new Medicine.MedicineBuilder("Brighton")
            .setCompany("Otodo")
            .setCountry("Spain")
            .setDoseAmount(150)
            .setPrice(200)
            .build();

    Medicine medicine4 = new Medicine.MedicineBuilder("Newcastle")
            .setCompany("Birmingem")
            .setCountry("England")
            .setDoseAmount(200)
            .setPrice(250)
            .build();

    List<Medicine> products = Arrays.asList(medicine1, medicine2, medicine3, medicine4);

    Animal animal = new Animal.AnimalBuilder("Rex")
            .setKind("Dog")
            .setWeight(3.5f)
            .setHeight(0.5f)
            .setWidth(0.3f)
            .build();


    Animal animal1 = new Animal.AnimalBuilder("Coco") // !!
            .setKind("Dog")
            .setWeight(3.5f)
            .setHeight(0.5f)
            .setWidth(0.3f)
            .build();


    Animal animal3 = new Animal.AnimalBuilder("Rex")
            .setKind("Dog")
            .setWeight(3.5f)
            .setHeight(0.5f)
            .setWidth(0.3f)
            .build();

    AnimalService service = new AnimalService(animal);


    // Тести:

    @Test(dataProvider = "medicineCompareProvider")
    public void medicineCompareTest(Medicine m1, Medicine m2, int res) {
        assertEquals(m1.compareTo(m2), res);
    }


    @DataProvider
    public Object[][] medicineCompareProvider() {
        return new Object[][]{{medicine1, medicine2, -1}, {medicine1, medicine3, 1},
                {medicine1, medicine1, 0}};
    }

    @Test(dataProvider = "getMedicinesWithPriceLessThanProvider")
    public void getMedicinesWithPriceLessThanTest(Animal a, double price, List<Medicine> l) {
        assertEquals(checkList(service.getMedicinesWithPriceLessThanStream(price), l), true);
    }


    @DataProvider
    public Object[][] getMedicinesWithPriceLessThanProvider() {
        return new Object[][]{{animal, 100, Arrays.asList(medicine3, medicine1)}};
    }


    // ???

    @Test(dataProvider = "getMedicinesWithPriceLessThanForProvider")
    public void getMedicinesWithPriceLessThanForTest(double price, List<Medicine> l) {
        assertEquals(checkList(service.getMedicinesWithPriceLessThanStream(price), l), true);
    }

    @DataProvider
    public Object[][] getMedicinesWithPriceLessThanForProvider() {
        return new Object[][]{{animal, 100, Arrays.asList(animal3, animal1)}};
    }


    @DataProvider
    public Object[][] getMedicinesWithQuantityLessThanProvider() {
        return new Object[][]{{animal, 20, Arrays.asList(medicine2, medicine1)}};
    }


    @DataProvider
    public Object[][] getMedicinesWithQuantityLessThanForProvider() {
        return new Object[][]{{animal, 20, Arrays.asList(medicine2, medicine1)}};
    }

    @Test(dataProvider = "getSumOfPricesProvider")
    public void getSumOfPricesTest(Animal a, double sum) {
        assertEquals(service.getSumOfPrices(), sum);
    }

    @DataProvider
    public Object[][] getSumOfPricesProvider() {
        return new Object[][]{{animal, 792.23}};
    }

    @Test(dataProvider = "getSumOfPricesForProvider")
    public void getSumOfPricesForTest(Animal a, double sum) {
        assertEquals(service.getSumOfPricesCycle(), sum);
    }

    @DataProvider
    public Object[][] getSumOfPricesForProvider() {
        return new Object[][]{{animal, 792.23}};
    }

}


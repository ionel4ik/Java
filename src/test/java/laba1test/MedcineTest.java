package laba1test;

import Laba_1.Medicine;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class MedcineTest {


    Medicine medicine1 = new Medicine.MedicineBuilder("Laykozut")
            .setCompany("Unisec")
            .setCountry("Germany")
            .setDoseAmount(125)
            .setPrice(5)
            .build();

    Medicine medicine2 = new Medicine.MedicineBuilder("Redflik")
            .setPrice(8)
            .build();

    Medicine medicine3 = new Medicine.MedicineBuilder("Laykozut")
            .setCompany("Unisec")
            .setCountry("Germany")
            .setDoseAmount(125)
            .setPrice(5)
            .build();


    // початок

    @Test(dataProvider = "medicineEqualsProvider")
    public void medicineEqualsTest(Medicine m1, Medicine m2) {
        assertEquals(m1, m2);
    }

    @DataProvider
    public Object[][] medicineEqualsProvider() {
        return new Object[][]{{medicine1, medicine3}};
    }

    @Test(dataProvider = "medicineNotEqualsProvider")
    public void medicineNotEqualsTest(Medicine m1, Medicine m2) {
        assertNotEquals(m1, m2);
    }

    @DataProvider
    public Object[][] medicineNotEqualsProvider() {
        return new Object[][]{{medicine1, medicine2}};
    }

    @Test(dataProvider = "medicineToStringProvider")
    public void medicineToStringTest(Medicine m1, String st) {
        assertEquals(m1.toString(), st);
    }

    @DataProvider
    public Object[][] medicineToStringProvider() {
        return new Object[][]{{medicine1, "Laykozut | Unisec | Germany | 125.0 | 5"}};
    }

    // кінець


}

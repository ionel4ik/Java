package laba_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class AnimalService {

    private Animal a;

    public AnimalService(Animal a){
        this.a = a;
    }


    public List<Medicine> getMedicinesWithPriceLessThanStream(double price){
        return this.a.getMedicines().stream()
                .filter(medicine -> medicine.getPrice() < price)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Medicine> getMedicinesWithPriceLessThanCycle(double price){
        List<Medicine> medicines = new ArrayList<>();
        for(Medicine m : this.a.getMedicines()){
            if (m.getPrice() < price) medicines.add(m);
        }
        Collections.sort(medicines);
        return medicines;
    }

    public List<Medicine> getMedicinesWithDoseBiggerThanStream(float doseAmount){
        return this.a.getMedicines().stream()
                .filter(medicine -> medicine.getDoseAmount() > doseAmount)
                .sorted(new MedicineComparator())
                .collect(Collectors.toList());
    }

//    public List<Medicine> getMedicinesWithSameCompanyStream(String Company){
//        return this.a.getMedicines().stream()
//                .filter(medicine -> medicine.getCompany()  )
//                .sorted(new MedicineComparator())
//                .collect(Collectors.toList());
//    }


    public List<Medicine> getMedicinesByCompanyNameCycle(String company){
        List<Medicine> medicines = new ArrayList<>();
        for(Medicine m : this.a.getMedicines()){
            if (m.getCompany().equals(company)) medicines.add(m);
        }
        Collections.sort(medicines);
        return medicines;
    }




    public double getSumOfPrices(){
        return this.a.getMedicines().stream()
                .map(Medicine::getPrice)
                .reduce(0.0, (sum, price) -> sum + price);
    }

    public double getSumOfPricesCycle(){
        double sum = 0.0;
        for (Medicine p: this.a.getMedicines()) {
            sum += p.getPrice();
        }
        return sum;
    }


}
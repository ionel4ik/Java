package laba_3;


import java.util.Comparator;

public class MedicineComparator implements Comparator<Medicine> {

    @Override
    public int compare(Medicine m1, Medicine m2){
        return Double.compare(m2.getPrice(),m1.getPrice());

    }
}



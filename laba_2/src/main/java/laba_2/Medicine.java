package laba_2;

        import java.io.Serializable;
        import java.util.Objects;

public class Medicine {
    private String name;
    private String company;// клас
    private String country; // клас
    private float doseAmount;
    private int price;


    // конструктор для Medicine

    public Medicine(String name,String company,String country,float doseAmount,int price) {
        this.name = name;
        this.company = company;
        this.country = country;
        this.doseAmount = doseAmount;
        this.price = price;

    }


    public Medicine(){

    }


    @Override
    public String toString() {
        return name + " | " + company + " | " + country + " | " + doseAmount + " | " + price;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Medicine medicine  = (Medicine ) obj;
        return (medicine.name.equals(this.name) &&
                medicine.company.equals(this.company) &&
                medicine.country.equals(this.country)
        );
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.company);
        result = 31 * result + Objects.hashCode(this.country);
        return result;
    }


    /**
     * name getter
     */
    public String getName(){
        return name;
    }

    /**
     * company getter
     */
    public String getCompany(){
        return company;
    }

    /**
     * country getter
     */
    public String getCountry  (){
        return country  ;
    }

    /**
     * dose_amount getter
     */
    public  float getDoseAmount (){
        return doseAmount;
    }

    /**
     * price getter
     */
    public int getPrice(){
        return price;
    }




    /**
     * name setter
     */
    public void setName(String name) { this.name = name; }

    /**
     *
     * company setter
     */
    public void setCompany(String company) { this.company = company; }

    /**
     *  country setter
     */
    public void setCountry(String country) { this. country =  country ; }

    /**
     * dose_amount setter
     */
    public void setDoseAmount(float dose_amount) { this.doseAmount = dose_amount; }

    /**
     * price setter
     */
    public void setPrice(int price ) { this.price  = price ; }


}// до класу дужка




package laba_3;


import java.util.Objects;


public class Medicine implements Comparable<Medicine>{
    private String name;
    private String company;
    private String country;
    private float doseAmount;
    private double price;  // !!!
    private String category;



    // final
    private int amount;

    /**
     * Medicine constructor
     * @param builder
     */
    private Medicine(MedicineBuilder builder){
        this.name = builder.name;
        this.company = builder.company;
        this.country = builder.country;
        this.doseAmount = builder.doseAmount;
        this.price = builder.price;
        this.amount = builder.amount;
        this.price = builder.price;
        this.category = builder.category;

    }


    @Override
    public String toString() {
        return name + " | " + company + " | " + country + " | " + doseAmount + " | " + price
                + " | " + amount;
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

    @Override
    public int compareTo(Medicine m) {
        return Double.compare(this.price, m.getPrice());
    }




    /**
     * Builder pattern
     */
    public static class MedicineBuilder {
        /**
         * @param name is mandatory, others are optional
         */

        private String name;
        private String company = " ";
        private String country = " ";
        private float doseAmount = 0;
        private int amount = 0;
        private double price = 0.0 ;
        private String category = "NULL";




        /**
         * Builder constructor with required parameters
         * params name
         */
        public MedicineBuilder( String name){

            this.name = name;
        }



        // Setters:

        /**
         * Builder company setter
         */

        public MedicineBuilder setCompany(String company) {
            this.company = company;
            return this;
        }



        public MedicineBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        /**
         * Builder doseAmount setter
         *
         * @param
         * @return object
         */
        public MedicineBuilder setDoseAmount(float doseAmount) {
            this.doseAmount = doseAmount;
            return this;
        }

        /**
         * Builder price setter
         * @param
         * @return object
         */
        public MedicineBuilder setPrice(int price) {
            this.price = price;
            return this;
        }


        /**
         * Builder amount setter
         * @param amount
         * @return object
         */
        public MedicineBuilder setAmount(int amount) {
            this.amount = amount;
            return this;
        }







        /**
         * Builder build method
         * @return instance of Medicine class
         */
        public Medicine build(){
            return new Medicine(this);
        }

    }// дужка builder



    // Getters:



        /**
     * name getter
     */
    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }


    /**
     * category getter
     */
    public String getCategory(){
        return category;
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
     *  amount getter
     */
    public int getAmount(){
        return amount;
    }


// Setters:

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

    /**
     * amount setter
     */
    public void setAmount(int amount) { this.amount = amount; }


}// до класу дужка




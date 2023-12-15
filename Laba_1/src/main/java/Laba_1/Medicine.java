package Laba_1;

import java.util.Objects;

public class Medicine  {
  private String name;
  private String company;
  private String country;
  private float doseAmount;
  private int price;


   // конструктор для Medicine

   private Medicine(MedicineBuilder builder) {
      this.name = builder.name;
       this.company = builder.company;
       this.country = builder.country;
      this.doseAmount = builder.doseAmount;
      this.price = builder.price;


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
     * Builder pattern
     */
    public static class MedicineBuilder {

        private String name = " ";
        private String company = " ";
        private String country = " ";
        private float doseAmount = 0;
        private int price = 0;


        /**
         * Builder constructor with required parameters
         * @param name
         */
        public MedicineBuilder(String name){
            this.name = name;
        }


        /**
         * Builder company setter
         *
         * @param company
         * @return object
         */

        public MedicineBuilder setCompany(String company) {
            this.company = company;
            return this;
        }

        /**
         * Builder country setter
         *
         * @param country
         * @return object
         */

        public MedicineBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        /**
         * Builder dose_amount setter
         *
         * @param doseAmount
         * @return object
         */

        public MedicineBuilder setDoseAmount(float doseAmount) {
            this.doseAmount = doseAmount;
            return this;
        }

        /**
         * Builder price setter
         *
         * @param price
         * @return object
         */


        public MedicineBuilder setPrice(int price) {
            this.price = price;
            return this;
        }



    /**
     * Builder build method
     *
     * @return instance of Medicine class
     */

    public Medicine build() {
        return new Medicine(this);
    }
    }// до білдера

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




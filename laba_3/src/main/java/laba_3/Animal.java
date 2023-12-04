package laba_3;

import java.util.*;
import java.util.stream.Collectors;


public class Animal implements Comparable<Animal> {
    private String name;
    private String kind;
    private float weight;
    private float height;
    private float width;

    private List<Medicine> medicines;

   Animal(){

   }

    /**
     * animal constructor
     */
    private Animal(AnimalBuilder builder) {
        this.name = builder.name;
        this.kind = builder.kind;
        this.weight = builder.weight;
        this.height = builder.height;
        this.width = builder.width;

       // this.medicines = builder.medicines;
    }

// без medicines
    @Override
    public String toString() {
        return name + " | " + kind + "  | " + weight + " | " + height + " | " + width;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Animal animals = (Animal) obj;
        return (animals.name.equals(this.name) &&
                animals.kind.equals(this.kind)

        );
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.kind);
        return result;
    }


    @Override
    public int compareTo(Animal a) {
        return this.name.toLowerCase().compareTo(a.name.toLowerCase());
    }




    /**
     * Builder pattern
     */
    public static class AnimalBuilder {

        /**
         * @param name is mandatory, others are optional
         */

        private String name;

        private String kind = " ";
        private float weight = 0;
        private float height = 0;
        private float width = 0;

        private List<Medicine> medicines = new ArrayList<>(); // @



        /**
         * Builder constructor with required parameters
         * @param name
         */
        public AnimalBuilder(String name) {
            this.name = name;
        }


        // Setters:


        /**
         * Builder kind setter
         * @param kind
         * @return object
         */

        public AnimalBuilder setKind(String kind) {
            this.kind = kind;
            return this;
        }


        public AnimalBuilder setWeight(float weight) {
            this.weight = weight;
            return this;
        }

        public AnimalBuilder setHeight(float height) {
            this.height = height;
            return this;
        }

        public AnimalBuilder setWidth(float width) {
            this.width = width;
            return this;
        }

        /**
         * Builder medicine setter
         * @return object
         */
        public AnimalBuilder setMedicines(List<Medicine> medicines){
            this.medicines.addAll(medicines);
            return this;
        }

        /**
         * Builder product setter
         * @return object
         */
        public AnimalBuilder setMedicine(Medicine medicine){
            this.medicines.add(medicine);
            return this;
        }



        /**
         * Builder build method
         * @return instance of Employee class
         */
        public Animal build() {
            return new Animal(this);
        }


    }


    //Getters:


    /**
     * name getter
     */
    public String getName() {
        return name;
    }

    /**
     * kind getter
     */
    public String getKind() {
        return kind;
    }


    /**
     * weight getter
     */
    public float getWeight() {
        return weight;
    }

    /**
     * height getter
     */
    public float getHeight() {
        return height;
    }

    /**
     * width getter
     */

    public float getWidth() {
        return width;
    }

    /**
     * medicines getter
     */
   public List<Medicine> getMedicines(){
        return medicines;
   }



//Setters:


    /**
     * name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * kind setter
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * height setter
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * weight setter
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * width setter
     */
    public void setWidth(float width) {
        this.width = width;
    }



   // ---------------- оп

    /**
     * medicine setter
     */
   public void setMedicines(List<Medicine> medicines) { this.medicines = medicines; }






} // до класу дужка





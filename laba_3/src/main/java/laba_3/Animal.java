package laba_3;

import jakarta.validation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Animal implements Comparable<Animal> {
    @NotBlank(message = "Name is mandatory")
    private String name;

    private String kind;

    @Positive(message = "Weight must be a positive number")
    private float weight;

    @Positive(message = "Height must be a positive number")
    private float height;

    @Positive(message = "Width must be a positive number")
    private float width;

    private List<Medicine> medicines;

    Animal() {

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
        private String name;

        private String kind = " ";


        private float weight = 0;


        private float height = 0;


        private float width = 0;

        private List<@Valid Medicine> medicines = new ArrayList<>();


        /**
         * Builder constructor with required parameters
         *
         * @param name
         */
        public AnimalBuilder(String name) {
            this.name = name;
        }


        // Setters:
        private void validate() throws IllegalArgumentException {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Animal animal = new Animal(this);
            Set<ConstraintViolation<Animal>> violations = validator.validate(animal);

            StringBuilder mb = new StringBuilder();

            for (ConstraintViolation<Animal> violation : violations) {
                mb.append("Error for field ").append(violation.getPropertyPath()).append(": ").append(violation.getInvalidValue()).append(" ").append(violation.getMessage())
                ;
            }

            if (!mb.isEmpty()) {
                throw new IllegalArgumentException(mb.toString());
            }
        }

        /**
         * Builder kind setter
         *
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
         *
         * @return object
         */
        public AnimalBuilder setMedicines(List<Medicine> medicines) {
            this.medicines.addAll(medicines);
            return this;
        }

        /**
         * Builder product setter
         *
         * @return object
         */
        public AnimalBuilder setMedicine(Medicine medicine) {
            this.medicines.add(medicine);
            return this;
        }


        /**
         * Builder build method
         *
         * @return instance of Employee class
         */
        public Animal build() {
            validate();
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
    public List<Medicine> getMedicines() {
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
    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }


} // до класу дужка


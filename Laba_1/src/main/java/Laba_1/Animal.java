package Laba_1;

import java.time.LocalDate;
import java.util.Objects;

public class Animal  {
   private String name;
   private String kind;
   private LocalDate birthday;
   private float weight;
   private float height;
   private float width;


   private Animal (AnimalBuilder builder) {
        this.name = builder.name;
        this.kind = builder.kind;
        this.birthday = builder.birthday;
        this.weight = builder.weight;
        this.height = builder.height;
        this.width = builder.width;
    }


    @Override
    public String toString(){
        return name + " | " + kind + " | " + birthday + " | " + weight + " | " + height + " | " + width ;
    }


    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Animal animals = (Animal) obj;
        return (animals.name.equals(this.name) &&
                animals.kind.equals(this.kind) &&
                animals.birthday.equals(this.birthday)
        );
    }

    @Override
    public int hashCode(){
        int result = name == null ? 0 : name.hashCode();
        result =  31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.kind);
        result = 31 * result + Objects.hashCode(this.birthday);
        return result;
    }


    /**
     * Builder pattern
     */
    public static class AnimalBuilder{

        private String name;
        private String kind = " ";
        private LocalDate birthday =  LocalDate.now();
        private float weight = 0;
        private float height = 0;
        private float width = 0;

        /**
         * Builder constructor with required parameters
         * @param name
         */
        public AnimalBuilder(String name){
            this.name = name;
        }

        /**
         * Builder kind setter
         * @param  kind
         *
         * @return object
         */
        public AnimalBuilder setKind(String kind) {
            this.kind = kind;
            return this;
        }

        /**
         * Builder birthday setter
         * @param birthday
         * @return object
         */
        public AnimalBuilder setBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        /**
         * Builder weight setter
         * @param weight
         * @return object
         */
        public AnimalBuilder setWeight(float weight) {
            this.weight = weight;
            return this;
        }

        /**
         * Builder height setter
         * @param height
         * @return object
         */
        public AnimalBuilder setHeight(float height) {
            this.height = height;
            return this;
        }


        /**
         * Builder height setter
         * @param width
         * @return object
         */

        public AnimalBuilder setWidth(float width) {
            this.width = width;
            return this;
        }



        /**
         * Builder build method
         * @return instance of Animals class
         */
        public Animal build(){
            return new Animal(this);
        }

    } // до білдер

    /**
     * name getter
     */
    public String getName(){
        return name;
    }

    /**
     * kind getter
     */
    public String getKind(){
        return kind;
    }

    /**
     * birthday getter
     */
    public LocalDate getBirthday(){
        return birthday;
    }

    /**
     * weight getter
     */
    public float getWeight(){
        return weight;
    }

    /**
     * height getter
     */
    public float getHeight(){
        return height;
    }

    /**
     * width getter
     */

    public float getWidth(){
        return width;
    }


    /**
     * name setter
     */
    public void setName(String name) { this.name = name; }

    /**
     *
     * kind setter
     */
    public void setKind(String kind) { this.kind = kind; }

    /**
     * birthday setter
     */
    public void setBirthday(LocalDate Birthday) { this.birthday = birthday ; }

    /**
     *height setter
     */
    public void setHeight(float height) { this.height = height; }

    /**
     * weight setter
     */
    public void setWeight(float weight) { this.weight = weight; }

    /**
     * width setter
     */
    public void setWidth(float width) { this.width = width; }

} // до класу дужка




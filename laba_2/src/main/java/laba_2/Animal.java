package laba_2;

        import java.io.Serializable;
        import java.time.LocalDate;
        import java.util.Objects;

   public class Animal  {
    private String name;
    private String kind;
    private float weight;
    private float height;
    private float width;




       /**
        * Employee constructor
        */
       public Animal(String name,String kind , LocalDate birthday, float weight, float height,float width){
           this.name = name;
           this.kind = kind;
           this.weight = weight;
           this.height = height;
           this.width = width;
       }

       public Animal(){

       }





    @Override
    public String toString(){
        return name + " | " + kind + "  | " + weight + " | " + height + " | " + width ;
    }


    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Animal animals = (Animal) obj;
        return (animals.name.equals(this.name) &&
                animals.kind.equals(this.kind)

        );
    }

    @Override
    public int hashCode(){
        int result = name == null ? 0 : name.hashCode();
        result =  31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.kind);
        return result;
    }



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




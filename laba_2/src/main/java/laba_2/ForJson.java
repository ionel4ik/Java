package laba_2;

        import com.fasterxml.jackson.databind.JavaType;
        import  com.fasterxml.jackson.databind.ObjectMapper;
        import com.fasterxml.jackson.databind.SerializationFeature;
        import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

        import java.io.File;
        import java.io.IOException;
        import java.util.List;


public class ForJson<T> implements Interface<T> {
    private ObjectMapper objectMapper;


    public ForJson() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JSR310Module());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public List<T> listReading(String fileName, Class<T> name) throws IOException{

       // String json = new String(Files.readAllBytes(Paths.get( fileName)));
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, name);
        return objectMapper.readValue(new File(fileName), type);
    }


    @Override
    public void listWriting(List<T> instanceList, String fileName) throws IOException{
        objectMapper.writeValue(new File( fileName), instanceList);
    }


    @Override
    public T objectReading(String fileName, Class<T> name) throws IOException {
        return objectMapper.readValue(new File( fileName), name);
    }


    @Override
    public void objectWriting(T entity, String fileName) throws IOException {
        objectMapper.writeValue(new File( fileName), entity);
    }

}
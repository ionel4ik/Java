package laba_2;

        import com.fasterxml.jackson.databind.JavaType;
        import  com.fasterxml.jackson.databind.ObjectMapper;
        import java.io.File;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.util.List;


public class ForJson<T> implements Interface<T> {


    @Override
    public List<T> listReading(String fileName, Class<T> name) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
       // String json = new String(Files.readAllBytes(Paths.get( fileName)));
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, name);
        return objectMapper.readValue(new File(fileName), type);
    }


    @Override
    public void listWriting(List<T> instanceList, String fileName) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File( fileName), instanceList);
    }


    @Override
    public T objectReading(String fileName, Class<T> name) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File( fileName), name);
    }


    @Override
    public void objectWriting(T entity, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File( fileName), entity);
    }

}
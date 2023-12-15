package laba_2;

        import com.fasterxml.jackson.core.type.TypeReference;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.fasterxml.jackson.databind.SerializationFeature;
        import com.fasterxml.jackson.dataformat.xml.XmlMapper;
        import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

        import java.io.File;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.util.List;

public class ForXml<T> implements Interface<T> {
    private XmlMapper xmlMapper;
    public ForXml() {
        xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    @Override
    public void objectWriting(T entity, String fileName) throws IOException {
        xmlMapper.writeValue(new File( fileName), entity);
    }

    @Override
    public T objectReading(String fileName, Class<T> name) throws IOException {
        String xml = new String(Files.readAllBytes(Paths.get( fileName)));
        return xmlMapper.readValue(xml, name);
    }

    @Override
    public void listWriting(List<T> instanceList, String fileName) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File( fileName), instanceList);
    }

    @Override
    public List<T> listReading(String fileName, Class<T> name) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        String json = new String(Files.readAllBytes(Paths.get( fileName)));
        return objectMapper.readValue(json, new TypeReference<List<T>>(){});
    }
}
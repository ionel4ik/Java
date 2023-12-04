package laba_2;

        import com.fasterxml.jackson.core.type.TypeReference;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.fasterxml.jackson.dataformat.xml.XmlMapper;

        import java.io.File;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.util.List;

public class ForXml<T> implements Interface<T> {
    @Override
    public void objectWriting(T entity, String fileName) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File( fileName), entity);
    }

    @Override
    public T objectReading(String fileName, Class<T> name) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
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
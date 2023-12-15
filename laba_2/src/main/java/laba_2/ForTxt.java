package laba_2;


        import com.fasterxml.jackson.databind.JavaType;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.fasterxml.jackson.databind.SerializationFeature;
        import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

        import java.io.*;
        import java.lang.reflect.Field;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.util.List;

public class ForTxt implements Interface<Employee> {
    private ObjectMapper objectMapper;


    public ForTxt() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JSR310Module());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
    public void objectWriting(Employee instance, String fileName) throws  FileNotFoundException {
        Class<?> classFields = instance.getClass();
        File myFile = new File(  fileName);
        PrintWriter writer = new PrintWriter(myFile);
        String json = "";
        try {
            for (Field field : classFields.getDeclaredFields()) {
                field.setAccessible(true);
                json += field.getName() + ": " + field.get(instance) + "\n";
            }
        }
        catch (IllegalAccessException ex){
            throw new RuntimeException(ex);
        }
            json = json.substring(0, json.length() - 1);
            writer.println(json);
            writer.close();

    }

    public Employee objectReading(String fileName) throws IOException {
        String json = "{";
        String tempString = "";
        List<String> allLines = Files.readAllLines(Paths.get(  fileName));
        for (String line : allLines) {
            String[] arrOfStr = line.split(":", 0);

            for (String a : arrOfStr) {
                a = a.replaceFirst("\\s","");
                tempString += "\"" + a + "\"" + ":";
            }
            tempString = tempString.substring(0, tempString.length() - 1);
            tempString += ",";
            json += tempString;
            tempString = "";
        }
        json = json.substring(0, json.length() - 1) + "}";
        return objectMapper.readValue(json, Employee.class);
    }

    public void listWriting(List<Employee> instanceList, String fileName) throws FileNotFoundException {
        if(instanceList.size() == 0){
            return;
        }
        Class<?> classFields = instanceList.get(0).getClass();
        File myFile = new File( fileName);
        PrintWriter writer = new PrintWriter(myFile);
        String json = "";
        try {
        for (int i = 0; i < instanceList.size(); i++) {
            for(Field field : classFields.getDeclaredFields()) {
                field.setAccessible(true);
                json += field.getName() + ": " + field.get(instanceList.get(i)) + "\n";
            }
            json += "\n";
        }}
        catch (IllegalAccessException ex){
            throw new RuntimeException(ex);
        }
        writer.println(json.substring(0, json.length()-1));
        writer.close();
    }

    @Override
    public Employee objectReading(String fileName, Class<Employee> name) throws IOException {
        return null;
    }

    @Override
    public List<Employee> listReading(String fileName, Class<Employee> name) throws IOException {
        return null;
    }

    public List<Employee> listReading(String fileName) throws IOException{
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class);
        String json = "[";
        String tempString = "{";
        List<String> allLines = Files.readAllLines(Paths.get(fileName));
        for (String line : allLines) {
            if(line.length() > 0) {
                String[] arrOfStr = line.split(":", 0);
                for (String a : arrOfStr) {
                    a = a.replaceFirst("\\s", "");
                    tempString += "\"" + a + "\"" + ":";
                }
                tempString = tempString.substring(0, tempString.length() - 1);
                tempString += ",";
            }
            else{
                tempString = tempString.substring(0, tempString.length() -1) +  "},";
                json += tempString;
                tempString = "{";
            }
        }
        json = json.substring(0, json.length() - 1) + "]";
        return objectMapper.readValue(json, type);
    }
}
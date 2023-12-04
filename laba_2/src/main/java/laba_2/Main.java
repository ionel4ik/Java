package laba_2;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException {
        Employee employee = new Employee("Tanya", "Tkach", "Olegivna"
                , 34, 990167811,4500,"18035");


        Employee employee1 = new Employee("Maryana", "Mukutey", "Andriyivna"
                , 28, 996456541,5000,"32221");

        Employee employee2 = new Employee("Stepan", "Tuyretskuy", "Vasulovuch"
                , 30, 990384900,4000,"90898");



        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        list.add(employee2);

        Animal animal = new Animal();
        Medicine medicine = new Medicine("Laykozut", "Unisec", "Germany",
                125, 5);

        ForJson json = new ForJson();
       ForXml xml = new ForXml();
        ForTxt txt = new ForTxt();

        json.listWriting(list, "files/x.json");
        List<Employee> employeeJsonList = json.listReading("files/x.json", Employee.class);
        System.out.println(employeeJsonList);

        json.objectWriting(employee, "files/y.json");
        Employee employeeJson = (Employee) json.objectReading("files/y.json", Employee.class);
        System.out.println(employeeJson);
        xml.objectWriting(employee, "files/y.xml");
        Employee employeeXml = (Employee) xml.objectReading("files/y.xml", Employee.class);
        System.out.println(employeeXml);

        json.objectWriting(animal, "files/z.json");
        Animal animalJson = ( Animal) json.objectReading("files/z.json", Animal.class);
        System.out.println(animalJson);
        xml.objectWriting(animal, "files/z.xml");
        Animal animalXml = (Animal) xml.objectReading("files/z.xml", Animal.class);
        System.out.println(animalXml);

        json.objectWriting(medicine, "files/a.json");
        Medicine  medicineJson = ( Medicine) json.objectReading("files/a.json",  Medicine.class);
        System.out.println( medicineJson);
        xml.objectWriting( medicine, "files/a.xml");
        Medicine  medicineXml = ( Medicine) xml.objectReading("files/a.xml",  Medicine.class);
        System.out.println( medicineXml);

        txt.objectWriting(employee, "files/y.txt");
        Employee employeeTxt = txt.objectReading("files/y.txt");
        System.out.println(employeeTxt);
        txt.listWriting(list, "files/x.txt");
        List<Employee> employeeTxtList = txt.listReading("files/x.txt");
        System.out.println(employeeTxtList);
    }
}


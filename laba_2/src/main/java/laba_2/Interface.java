package laba_2;

        import java.io.IOException;
        import java.util.List;

public interface Interface<T> {

    void objectWriting(T instance, String fileName) throws IOException;

    void listWriting(List<T> instanceList, String fileName) throws IOException;

    T objectReading(String fileName, Class<T> name) throws IOException;

    List<T> listReading(String fileName, Class<T> name) throws IOException;
}
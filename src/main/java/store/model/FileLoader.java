package store.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileLoader {

    public static final String PRODUCTS_FILE = "src/main/resources/products.md";
    public static final String PROMOTIONS_FILE = "src/main/resources/products.md";

    public static List<String> load(String filePath) {
        List<String> FileData = null;
        try {
            FileData = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return FileData;
    }
}

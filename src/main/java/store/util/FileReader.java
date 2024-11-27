package store.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private Scanner scanner;
    private final List<String> targets;

    public FileReader() {
        targets = new ArrayList<>();
    }

    public List<String> read(FileType type) throws FileNotFoundException {
        setTarget(type);
        readFile();
        scanner.close();
        return targets;
    }

    private void setTarget(FileType type) throws FileNotFoundException {
        String path = type.getFilePath();
        scanner = new Scanner(new File(path));
    }

    private void readFile() {
        String str = scanner.nextLine();
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            targets.add(str);
        }
    }
}

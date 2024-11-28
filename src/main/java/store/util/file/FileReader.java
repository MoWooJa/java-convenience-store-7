package store.util.file;

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

    //파일 타입과 함께 호출 => 데이터 처리 및 저장 방법 분리해서 진행
    public List<String> read(FileType type) throws FileNotFoundException {
        // 파일 위치 지정
        setTarget(type);
        // 한 줄 씩 List에 추가함
        readFile();
        // Scanner 닫음
        scanner.close();
        return targets;
    }

    private void setTarget(FileType type) throws FileNotFoundException {
        String path = type.getFilePath();
        // Scanner 이용
        scanner = new Scanner(new File(path));
    }

    private void readFile() {
        // 첫 줄을 무시하는 경우
        String str = scanner.nextLine();
        //파일 전체 읽기 => (hasNextLine() == false)까지
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            targets.add(str);
        }
    }
}

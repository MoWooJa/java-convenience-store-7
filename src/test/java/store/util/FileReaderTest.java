package store.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileReaderTest {
    @Test
    @DisplayName("파일 타입을 통해 파일을 List 형태로 불러올 수 있다.")
    public void readPproductTest() throws FileNotFoundException {
        // given
        List<String> result = List.of("콜라,1000,10,탄산2+1",
                "콜라,1000,10,null",
                "사이다,1000,8,탄산2+1");
        FileType type = FileType.PRODUCTS_FILE_PATH;
        // when
        FileReader reader = new FileReader();
        // then
        assertThat(reader.read(type)).contains(result.get(0));
        assertThat(reader.read(type)).contains(result.get(1));
        assertThat(reader.read(type)).contains(result.get(2));
    }

    @Test
    @DisplayName("파일 타입을 통해 파일을 List 형태로 불러올 수 있다.")
    public void readPromotionTest() throws FileNotFoundException {
        // given
        List<String> result = List.of("탄산2+1,2,1,2024-01-01,2024-12-31",
                "MD추천상품,1,1,2024-01-01,2024-12-31",
                "반짝할인,1,1,2024-11-01,2024-11-30");
        FileType type = FileType.PROMOTIONS_FILE_PATH;
        // when
        FileReader reader = new FileReader();
        // then
        assertThat(reader.read(type)).contains(result.get(0));
        assertThat(reader.read(type)).contains(result.get(1));
        assertThat(reader.read(type)).contains(result.get(2));
    }
}

package store.util.file;

public enum FileType {
    PROMOTIONS_FILE_PATH("src/main/resources/promotions.md"),
    PRODUCTS_FILE_PATH("src/main/resources/products.md");

    public final String filePath;

    FileType(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}

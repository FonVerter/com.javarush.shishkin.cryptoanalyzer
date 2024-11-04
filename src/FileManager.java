import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    private static int count = 0;

    private final String pathToOriginalFile;
    private Path pathIn;
    private Path pathOut;

    public Path getPathIn() {
        return pathIn;
    }

    public Path getPathOut() {
        return pathOut;
    }

    public FileManager(String pathToOriginalFile) {
        this.pathToOriginalFile = pathToOriginalFile;
    }


    public String readUserFile() {
        pathIn = Path.of(pathToOriginalFile);

        String lineFromFile = " ";

        try {
            lineFromFile = Files.readString(pathIn);
        } catch (IOException e) {
            e.getMessage();
        }

        return lineFromFile;
    }

    public void writeTheUserFile(String modifiedString) {

        count++;

        String newFileName = "modified_"  + count + "_" + pathIn.getFileName();
        pathOut = Path.of(newFileName);

        try {
            Files.createFile(pathOut);
        } catch (IOException e) {
            e.getMessage();
        }

        try {
            Files.writeString(pathOut, modifiedString);
        } catch (IOException e) {
            e.getMessage();
        }


    }


}

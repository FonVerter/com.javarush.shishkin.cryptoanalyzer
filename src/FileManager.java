import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    private static int count = 0;

    private final String pathToOriginalFile;
    private Path pathIn;
    private Path pathOut;


    public FileManager(String pathToOriginalFile) {
        this.pathToOriginalFile = pathToOriginalFile;
    }


    public String readUserFile() {
        pathIn = Path.of(pathToOriginalFile);
        String lineFromFile = " ";

        try {
            if (Files.size(pathIn) == 0){
                System.out.println("Указанный файл был пустым. Так и задумано?");
            }
            lineFromFile = Files.readString(pathIn);
        } catch (IOException e) {
            System.out.println("Пустой файл или некорректный путь");
            System.out.println("Проверьте путь и попробуйте заново");
        }

        return lineFromFile;
    }

    public void writeTheUserFile(String modifiedString, String pathToModifiedPath) {
        String newNameFiles = pathToModifiedPath + File.separator + "key" + count + ".txt";
        pathOut = Path.of(newNameFiles);
        pathOut.toAbsolutePath();
        count++;

        try {
            Files.createFile(pathOut);
            Files.writeString(pathOut, modifiedString);
        } catch (IOException e) {
            System.out.println("Вы ввели некорректный путь");
            System.out.println("Проверьте путь и попробуйте заново");
        }


    }


}

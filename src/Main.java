import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Привет! Что будем делать?\n-1 Шифровать \n-2 Расшифровывать\n-3 Расшифруем послание с помощью подбора");

        Scanner helloScanner = new Scanner(System.in);

        switch (helloScanner.nextInt()) {
            case 1:

                System.out.println("Введи путь к файлу который надо зашифровать:");
                Scanner pathToOriginalFile = new Scanner(System.in);
                String pathToFile = pathToOriginalFile.nextLine();
                System.out.println("Укажите директорию, в которой нужно сохранить зашифрованный файл");
                Scanner pathToModifiedFiles = new Scanner(System.in);
                String pathToModifiedFilesStr = pathToModifiedFiles.nextLine();
                System.out.println("Введи секретный ключ:");
                Scanner secretKey = new Scanner(System.in);
                int shiftValue = secretKey.nextInt();
                FileManager fileManagerTest = new FileManager(pathToFile);
                String readingFilesString = fileManagerTest.readUserFile();
                Cipher russianAlphabet = new Cipher();
                HashMap<Character, Character> newAlphabet = russianAlphabet.createNewAlphabet(shiftValue);
                String s = russianAlphabet.encryptTheString(readingFilesString, newAlphabet);
                fileManagerTest.writeTheUserFile(s, pathToModifiedFilesStr);
                System.out.println("Файл успешно зашифрован и сохранен в указанной директории.");

                break;

            case 2:
                System.out.println("Введи путь к файлу который надо расшифровать:");
                Scanner pathToEncryptedFile = new Scanner(System.in);
                String pathToFile2 = pathToEncryptedFile.nextLine();
                System.out.println("Введи секретный ключ:");
                Scanner secretKey2 = new Scanner(System.in);
                int shiftValue2 = secretKey2.nextInt();
                System.out.println("Укажите директорию, в которой нужно сохранить расшифрованный файл");
                Scanner pathToModifiedFiles2 = new Scanner(System.in);
                String pathToModifiedFilesStr2 = pathToModifiedFiles2.nextLine();


                if (shiftValue2 > 0) {
                    shiftValue2 = -shiftValue2;
                } else {
                    shiftValue2 = shiftValue2;
                }

                FileManager fileManagerTest2 = new FileManager(pathToFile2);
                String readingFilesString2 = fileManagerTest2.readUserFile();
                Cipher russianAlphabet2 = new Cipher();
                HashMap<Character, Character> newAlphabet2 = russianAlphabet2.createNewAlphabet(shiftValue2);
                String s2 = russianAlphabet2.encryptTheString(readingFilesString2, newAlphabet2);
                fileManagerTest2.writeTheUserFile(s2, pathToModifiedFilesStr2);
                System.out.println("Файл успешно расшифрован и сохранен в указанной директории.");
                break;

            case 3:
                System.out.println("Введи путь к файлу, который будем расшифровывать");
                Scanner scannerBruteForce = new Scanner(System.in);
                String pathToFile3 = scannerBruteForce.nextLine();
                System.out.println("Укажите директорию, в которой нужно сохранить файлы расшифрованные разными ключами");
                Scanner pathToModifiedFiles3 = new Scanner(System.in);
                String pathToModifiedFilesStr3 = pathToModifiedFiles3.nextLine();

                for (int i = 0; i < 40; i++) {
                    FileManager fileManager3 = new FileManager(pathToFile3);
                    String readingFilesString3 = fileManager3.readUserFile();
                    Cipher russianAlphabet3 = new Cipher();
                    HashMap<Character, Character> newAlphabet3 = russianAlphabet3.createNewAlphabet(i);
                    String s3 = russianAlphabet3.encryptTheString(readingFilesString3, newAlphabet3);
                    fileManager3.writeTheUserFile(s3, pathToModifiedFilesStr3);

                }
                System.out.println("Файлы сохранены в указанной директории.");
        }


    }
}
import java.util.HashMap;

public class Cipher {


    public Cipher() {

    }

    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};


    public HashMap<Character, Character> createNewAlphabet(int userShiftSymbol) {

        if (userShiftSymbol == 0) {
            System.out.println("При нулевом ключе шифр Цезаря не работает.");
            System.out.println("Повторите попытку с другим ключом.");
        }
        HashMap<Character, Character> newAlphabet = new HashMap<>();
        int alphabetLength = ALPHABET.length;

        for (int i = 0; i < alphabetLength; i++) {

            int newIndex = (i + userShiftSymbol) % alphabetLength;
            if (newIndex < 0) {
                newIndex += alphabetLength;
            }
            newAlphabet.put(ALPHABET[i], ALPHABET[newIndex]);
        }

        return newAlphabet; // В
    }


    public String encryptTheString(String string, HashMap<Character, Character> modifiedAlphabet) {

        StringBuilder outputStringBuilder = new StringBuilder();

        char[] inputCharacterArray = string.toCharArray();

        for (int i = 0; i < inputCharacterArray.length; i++) {
            char currentChar = Character.toLowerCase(inputCharacterArray[i]);
            Character encryptedChar = modifiedAlphabet.get(currentChar);

            if (encryptedChar != null) {
                outputStringBuilder.append(encryptedChar);
            } else {
                outputStringBuilder.append(inputCharacterArray[i]);
            }
        }


        return outputStringBuilder.toString();

    }


}

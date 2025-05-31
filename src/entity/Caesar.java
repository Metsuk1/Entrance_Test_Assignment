package entity;

public class Caesar {
    private static final String RUS_UPPER = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String RUS_LOWER = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static String encrypt(String text,int shift){
        StringBuilder result = new StringBuilder();
        for(char ch : text.toCharArray()){
            result.append(shiftChar(ch,shift));
        }

        return result.toString();
    }

    public static String decrypt(String text,int shift){
        return encrypt(text,-shift);
    }

    private static char shiftChar(char ch,int shift){
        // latine
        if(ch >= 'A' && ch <= 'Z'){
            return (char)('A' + (ch-'A' + shift + 26) % 26);
        }else if(ch >= 'a' && ch <= 'z'){
            return (char)('a' + (ch-'a' + shift) % 26);
        }

        // Cyrillic uppercase
        int indexUpper = RUS_UPPER.indexOf(ch);
        if (indexUpper != -1) {
            int newIndex = (indexUpper + shift + 33) % 33;
            return RUS_UPPER.charAt(newIndex);
        }

        // Cyrillic lowercase
        int indexLower = RUS_LOWER.indexOf(ch);
        if (indexLower != -1) {
            int newIndex = (indexLower + shift + 33) % 33;
            return RUS_LOWER.charAt(newIndex);
        }

        else{ // Other symbols (spaces, numbers, signs)
            return ch;
        }
    }
}

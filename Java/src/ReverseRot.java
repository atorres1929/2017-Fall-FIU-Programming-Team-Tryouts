import java.util.Scanner;

/**
 * Created by Adam Torres on 12/18/2017
 */
public class ReverseRot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String encryption = scanner.nextLine();
            String pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";
            String[] parts = encryption.split(" ");
            int rotations = Integer.parseInt(parts[0]);
            if (rotations == 0){
                scanner.close();
                break;
            }
            char[] plainText = parts[1].toCharArray();
            char[] encryptedText = new char[plainText.length];
            for (int i = 0; i < plainText.length; i++){
                char c = plainText[i];
                int index = pattern.indexOf(c);
                index = (index + rotations) % pattern.length();
                encryptedText[i] = pattern.charAt(index);
            }
            for (int i = encryptedText.length - 1; i >= 0; i--){
                System.out.print(encryptedText[i]);
            }
            System.out.println();
        }
    }
}

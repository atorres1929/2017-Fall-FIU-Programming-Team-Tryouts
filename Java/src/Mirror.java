import java.util.Scanner;
import java.util.regex.Pattern;

public class Mirror {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        int z = 0;
        int test = 1;
        Pattern delimeter = scanner.delimiter();
        while (z <= times) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            scanner.nextLine();
            scanner.useDelimiter("");
            String[][] image = new String[rows][cols];
            for (int i = 0; i < rows; ) {
                for (int j = 0; j < cols; j++) {
                    image[i][j] = scanner.next();
                }
                i++;
                if (z == times && i == rows) {
                    scanner.close();
                } else {
                    scanner.nextLine();
                }
            }
            System.out.println("Test " + test);
            test++;
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 0; j--) {
                    System.out.print(image[i][j]);
                }
                System.out.println();
            }
            scanner.useDelimiter(delimeter);
            z++;
        }
    }
}

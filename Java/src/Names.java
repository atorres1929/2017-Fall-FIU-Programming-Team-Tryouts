import java.util.Scanner;

public class Names {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int set = 1;
        while (scanner.hasNext() && !scanner.hasNext("0")) {
            int size = scanner.nextInt();
            String[] x = new String[size];
            for (int i = 0; i < size; i++) {
                x[i] = scanner.next();
            }

            String[] y = new String[size];
            boolean flip = size % 2 == 0;
            boolean flipTop = false;
            boolean flipBottom = false;
            boolean increment = true;
            for (int i = size - 1, j = 0; i >= 0; i--) {
                if (flipTop && flipBottom) {
                    j++;
                    flipTop = false;
                    flipBottom = false;
                }
                if (flip) {
                    y[size / 2 + j] = x[i];
                    flip = false;
                    flipTop = true;
                } else {
                    y[size / 2 - j] = x[i];
                    flip = true;
                    flipBottom = true;
                }
                if (increment) {
                    j++;
                    increment = false;
                    flipTop = false;
                    flipBottom = false;
                }
            }

            System.out.println("SET " + set);
            set++;
            for (int i = 0; i < size; i++) {
                System.out.println(y[i]);
            }
        }
    }
}
/*
7
Bo
Pat
Jean
Kevin
Claude
William
Marybeth
6
Jim
Ben
Zoe
Joey
Frederick
Annabelle
5
John
Bill
Fran
Stan
Cece
0
 */
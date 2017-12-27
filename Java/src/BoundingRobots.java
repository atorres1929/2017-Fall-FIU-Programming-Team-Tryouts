import java.util.Scanner;

public class BoundingRobots {

    private static int thinksRow = 0;
    private static int thinksCol = 0;
    private static int currRow = 0;
    private static int currCol = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int w = scanner.nextInt();
            int l = scanner.nextInt();

            if (w == 0 && l == 0){
                scanner.close();
                break;
            }
            scanner.nextLine();

            boolean[][] room = new boolean[w][l];
            room[0][0] = true;

            int moves = scanner.nextInt();
            scanner.nextLine();

            while (moves > 0) {
                String direction = scanner.next();
                int steps = scanner.nextInt();
                scanner.nextLine();

                step(room, steps, direction);

                moves--;
            }

            if (currRow != 0 && currCol != 0){
                room[0][0] = false;
                room[currRow][currCol] = true;
            }
            System.out.println("Robot thinks " + thinksRow + " " + thinksCol);
            System.out.println("Actually at " + currRow + " " + currCol);
            System.out.println();

            thinksRow = 0;
            thinksCol = 0;
            currRow = 0;
            currCol = 0;
        }
    }

    private static void step(boolean[][] board, int steps, String direction) {

        switch (direction) {
            case "u":
                while (steps > 0) {
                    if (currCol != board[0].length - 1) {
                        currCol++;
                    }
                    thinksCol++;
                    steps--;
                }
                break;
            case "d":
                while (steps > 0) {
                    if (currCol != 0) {
                        currCol--;
                    }
                    thinksCol--;
                    steps--;
                }
                break;
            case "l":
                while (steps > 0) {
                    if (currRow != 0) {
                        currRow--;
                    }
                    thinksRow--;
                    steps--;
                }
                break;
            case "r":
                while (steps > 0) {
                    if (currRow != board.length - 1) {
                        currRow++;
                    }
                    thinksRow++;
                    steps--;
                }
                break;
        }
    }
}

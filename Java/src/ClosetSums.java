import java.util.Scanner;

public class ClosetSums {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int caseNumber = 1;
        while (scanner.hasNextInt()) {
            System.out.println("Case " + caseNumber + ":");
            int numSet = scanner.nextInt();
            int[] set = new int[numSet];
            for (int i = 0; i < numSet; i++) {
                set[i] = scanner.nextInt();
            }
            int numQueries = scanner.nextInt();
            int closestSum = -1;
            for (int q = 0; q < numQueries; q++) {
                int query = scanner.nextInt();
                int minimum = Integer.MAX_VALUE;
                for (int i = 0; i < set.length; i++) {
                    int currSubject = set[i];
                    for (int j = 0; j < set.length; j++){
                        if (i != j) {
                            int closer = Math.abs(query - (currSubject + set[j]));
                            if (closer < minimum) {
                                minimum = closer;
                                closestSum = currSubject + set[j];
                                if (minimum == 0) {
                                    i = set.length;
                                    break;
                                }
                            }
                        }
                    }
                }
                System.out.println("Closest sum to "+ query + " is " + closestSum+".");
            }
            caseNumber++;
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Adam Torres on 12/18/2017
 */
public class ClosingTheLoop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int times = scanner.nextInt();
        scanner.nextLine();
        int time = 1;
        while (time <= times) {
            int numSegments = scanner.nextInt();
            scanner.nextLine();
            String text = scanner.nextLine();
            String[] segments = text.split(" ");
            ArrayList<Integer> blueValues = cleanArray(segments, "B");
            ArrayList<Integer> redValues = cleanArray(segments, "R");
            int size = 0;
            if (blueValues.size() + redValues.size() == 1) {
                System.out.println("Case #" + time + ": " + size);
            } else {
                for (int i = 0; i < numSegments && blueValues.size() > 0 && redValues.size() > 0; i++) {
                    int blueMax = maxValue(blueValues);
                    int redMax = maxValue(redValues);
                    size += blueMax + redMax - 2;
                }
                if (redValues.size() == 1) {
                    size += redValues.get(0) - 1;
                }
                System.out.println("Case #" + time + ": " + size);
            }
            time++;
        }
    }

    private static ArrayList<Integer> cleanArray(String[] segments, String type) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < segments.length; i++) {
            try {
                if (segments[i].contains(type)) {
                    list.add(Integer.valueOf("" + segments[i].trim().substring(0, segments[i].trim().length() - 1)));
                }
            } catch (StringIndexOutOfBoundsException e) {

            }
        }
        return list;
    }

    private static int maxValue(ArrayList<Integer> values) {
        int max = Integer.MIN_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) > max) {
                max = values.get(i);
                maxIndex = i;
            }
        }
        values.remove(maxIndex);
        return max;
    }
}

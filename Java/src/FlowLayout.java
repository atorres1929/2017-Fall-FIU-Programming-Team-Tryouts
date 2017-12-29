import java.util.Scanner;

public class FlowLayout {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxWidthUsed = 0;
        int maxDepthUsed = 0;
        int currentWidth = 0;
        int currentDepth = 0;
        boolean done = true;

        int maxWidth = -1;

        while (scanner.hasNext()) {

            if (done) {
                maxWidth = scanner.nextInt();
                if (maxWidth == 0) {
                    scanner.close();
                    break;
                }
                scanner.nextLine();
                done = false;
            }

            int width = scanner.nextInt();
            int height = scanner.nextInt();
            scanner.nextLine();

            if (width == -1 && height == -1) {
                System.out.println(maxWidthUsed + " x " + maxDepthUsed);
                done = true;
                maxWidthUsed = 0;
                maxDepthUsed = 0;
                currentWidth = 0;
                currentDepth = 0;
            } else {
                if (width + currentWidth <= maxWidth) {
                    if (height > currentDepth) {
                        currentDepth += height - currentDepth;
                    }
                } else {
                    maxDepthUsed += currentDepth + height;
                    currentWidth = 0;
                    currentDepth = height;
                }
                currentWidth += width;
                if (currentWidth > maxWidthUsed) {
                    maxWidthUsed = currentWidth;
                }

            }
        }
    }

}

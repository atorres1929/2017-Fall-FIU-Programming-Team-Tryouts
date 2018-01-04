import java.util.Scanner;

public class EventPlanning {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int participants = scanner.nextInt();
        int budget = scanner.nextInt();
        int hotels = scanner.nextInt();
        int weeks = scanner.nextInt();
        int minimumPrice = Integer.MAX_VALUE;
        boolean hotelFound = false;
        for (int h = 0; h < hotels; h++) {
            int price = scanner.nextInt();
            for (int w = 0; w < weeks; w++){
                int beds = scanner.nextInt();
                if (participants <= beds) {
                    int totalPrice = price * participants;
                    if (totalPrice < budget && totalPrice < minimumPrice){
                        minimumPrice = totalPrice;
                        hotelFound = true;
                    }
                }
            }
        }
        if (hotelFound){
            System.out.println(minimumPrice);
        }
        else{
            System.out.println("stay home");
        }
    }
}

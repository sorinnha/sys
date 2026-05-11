import java.util.Scanner;

public class ChatBotsimplequeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("ChatBot Started (type exit to stop)");

        while (true) {
            System.out.print("You: ");
            input = sc.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Bot: Thank you! Visit again.");
                break;
            }
            else if (input.contains("hello") || input.contains("hi")) {
                System.out.println("Bot: Hello! How can I help you?");
            }
            else if (input.contains("product")) {
                System.out.println("Bot: We have laptops, mobiles, and accessories.");
            }
            else if (input.contains("price")) {
                System.out.println("Bot: Product prices start from Rs.500.");
            }
            else if (input.contains("service")) {
                System.out.println("Bot: We provide delivery and customer support.");
            }
            else if (input.contains("hours")) {
                System.out.println("Bot: Our working hours are 9 AM to 9 PM.");
            }
            else {
                System.out.println("Bot: Sorry, I did not understand.");
            }
        }
    }
}
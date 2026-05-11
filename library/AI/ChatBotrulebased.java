import java.util.Scanner;

public class ChatBotrulebased {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg;

        System.out.println("Customer Chatbot Started");
        System.out.println("Type 'exit' to stop");

        while (true) {
            System.out.print("You: ");
            msg = sc.nextLine().toLowerCase();

            if (msg.equals("exit")) {
                System.out.println("Bot: Thank you!");
                break;
            }
            else if (msg.contains("product")) {
                System.out.println("Bot: We sell laptops, mobiles, and accessories.");
            }
            else if (msg.contains("service")) {
                System.out.println("Bot: We provide delivery and customer support services.");
            }
            else if (msg.contains("price")) {
                System.out.println("Bot: Prices depend on the product.");
            }
            else if (msg.contains("hours")) {
                System.out.println("Bot: We are open from 9 AM to 9 PM.");
            }
            else {
                System.out.println("Bot: Sorry, I don't understand.");
            }
        }
    }
}
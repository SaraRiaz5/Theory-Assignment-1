import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        MessagingApp app = new MessagingApp();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMessaging App Menu:");
            System.out.println("1. Send a message");
            System.out.println("2. Delete a message");
            System.out.println("3. Search message by ID");
            System.out.println("4. Read unseen messages");
            System.out.println("5. Read all messages of a receiver");
            System.out.println("6. Read all messages from a sender");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter sender name: ");
                    String sender = scanner.nextLine();
                    System.out.print("Enter receiver name: ");
                    String receiver = scanner.nextLine();
                    System.out.print("Enter message content: ");
                    String content = scanner.nextLine();
                    app.sendMessage(sender, receiver, content);
                    break;

                case 2:
                    System.out.print("Enter message ID to delete: ");
                    int id = scanner.nextInt();
                    app.deleteMessage(id);
                    break;

                case 3:
                    System.out.print("Enter message ID to search: ");
                    id = scanner.nextInt();
                    app.searchMessageById(id);
                    break;

                case 4:
                    System.out.print("Enter receiver name to read unseen messages: ");
                    receiver = scanner.nextLine();
                    app.readUnseenMessages(receiver);
                    break;

                case 5:
                    System.out.print("Enter receiver name to read all messages: ");
                    receiver = scanner.nextLine();
                    app.readAllMessages(receiver);
                    break;

                case 6:
                    System.out.print("Enter sender name to read all messages: ");
                    sender = scanner.nextLine();
                    app.readMessagesFromSender(sender);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);
    }
}
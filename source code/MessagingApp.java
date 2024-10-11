public class MessagingApp {
    private Message[][][] messages; 
    private int[][] messageCount;  

    
    {
        int maxUsers = 10;
        int maxMessages = 10; 

        messages = new Message[maxUsers][maxUsers][maxMessages]; // [sender][receiver][messages]
        messageCount = new int[maxUsers][maxUsers];              // [sender][receiver] 

        
        addPreloadedMessages();
    }

    private void addPreloadedMessages() {
        sendMessage("Alice", "Bob", "Hello, Bob! How are you?");
        sendMessage("Bob", "Alice", "Hi Alice! I'm good. You?");
        sendMessage("Charlie", "Bob", "Hey Bob, long time no see!");
        sendMessage("Jack", "Sara", "Hello, Sara! How are you?");
        sendMessage("Sara", "Jack", "Hi Jack! I'm good. You?");
        sendMessage("Jack", "Sara", "Are you free this weekend?");
        sendMessage("Sara", "Jack", "Yes, I am! What do you have in mind?");
        sendMessage("Jack", "Sara", "How about a movie night?");
        sendMessage("Aleesha", "Adan", "Hey Adan, how's it going?");
        sendMessage("Adan", "Aleesha", "I'm doing well, Aleesha! How about you?");
        sendMessage("Aleesha", "Adan", "Let's grab lunch tomorrow.");
        sendMessage("Adan", "Aleesha", "Sounds great! Where should we go?");
        sendMessage("Aleesha", "Adan", "How about the new cafe downtown?");
    }

    public void sendMessage(String sender, String receiver, String content) {
        int senderIndex = getUserIndex(sender);
        int receiverIndex = getUserIndex(receiver);

        
        if (messageCount[senderIndex][receiverIndex] < 10) {
            int messageIndex = messageCount[senderIndex][receiverIndex];
          Message message = new Message(sender, receiver, content);
         message.markAsUnseen(); 
            messages[senderIndex][receiverIndex][messageIndex] = message;
            messageCount[senderIndex][receiverIndex]++;  
        } else {
            System.out.println("Cannot send more messages. Limit reached.");
     } 
    }

    public void deleteMessage(int id) {
        for (int i = 0; i < messages.length; i++) {
            for (int j = 0; j < messages[i].length; j++) {
                for (int k = 0; k < messageCount[i][j]; k++) {
                    if (messages[i][j][k] != null && messages[i][j][k].getMessageId() == id) { 
                      
              messages[i][j][k].markAsDeleted();  
                        System.out.println("Message with ID " + id + " deleted.");
                        return;
                   
                      }
                }
            }
        }
        System.out.println("Message with ID " + id + " not found.");
    }

    public void searchMessageById(int id) {
        for (int i = 0; i < messages.length; i++) {
            for (int j = 0; j < messages[i].length; j++) {
                          for (int k = 0; k < messageCount[i][j]; k++) {
                             if (messages[i][j][k] != null) {
                        if (messages[i][j][k].getMessageId() == id) {
                  
                          System.out.println(messages[i][j][k]); 
                            return;
            }
                    }
                       }
            }
        }
        System.out.println("Message with ID " + id + " not found.");
    }

    public void readUnseenMessages(String receiver) {
        int receiverIndex = getUserIndex(receiver);
        boolean hasUnseen = false;  

        for (int i = 0; i < messages.length; i++) {
            for (int j = 0; j < messageCount[i][receiverIndex]; j++) {
                if (messages[i][receiverIndex][j] != null && !messages[i][receiverIndex][j].isSeen() && !messages[i][receiverIndex][j].isDeleted()) {
                    System.out.println(messages[i][receiverIndex][j]);
             messages[i][receiverIndex][j].markAsSeen();
                    hasUnseen = true;  
                }
            }
        }

        if (!hasUnseen) {
            System.out.println("No unseen messages found.");
        }
    }

    public void readAllMessages(String receiver) {
        int receiverIndex = getUserIndex(receiver);
              boolean hasMessages = false; 

        for (int i = 0; i < messages.length; i++) {
            for (int j = 0; j < messageCount[i][receiverIndex]; j++) {
                if (messages[i][receiverIndex][j] != null && !messages[i][receiverIndex][j].isDeleted()) {
           System.out.println(messages[i][receiverIndex][j]);
                    hasMessages = true; 
                }
            }
        }

        if (!hasMessages) {
          System.out.println("No messages found for " + receiver + ".");
        }
    }

    public void readMessagesFromSender(String sender) {
        int senderIndex = getUserIndex(sender);
        boolean hasMessages = false;  

        for (int j = 0; j < messages[senderIndex].length; j++) {
            for (int k = 0; k < messageCount[senderIndex][j]; k++) {
                if (messages[senderIndex][j][k] != null && !messages[senderIndex][j][k].isDeleted()) {
                    System.out.println(messages[senderIndex][j][k]);
              hasMessages = true;  
                }
                }  
        }

        if (!hasMessages) {
            System.out.println("No messages found from " + sender + ".");
        }
    }

//i used this method to convert the user name into particlar indices.
    private int getUserIndex(String user) {
          return Math.abs(user.hashCode() % 10);
    }
}
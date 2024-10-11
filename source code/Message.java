import java.time.LocalDateTime;

class Message {
    private static int idCounter = 0;  
    private int messageId;              
    private String sender;             
    private String receiver;          
    private String content;             
    private LocalDateTime timestamp;    
    private boolean seen;                
    private boolean isDeleted;

    // Constructor
    public Message(String sender, String receiver, String content) {
        this.messageId = ++idCounter;   
        this.sender = sender;            
        this.receiver = receiver;        
        this.content = content;          
        this.timestamp = LocalDateTime.now(); 
        this.seen = false;              
         this.isDeleted = false;
    }

    
 public boolean isDeleted() {
        return isDeleted;
    }

    public void markAsDeleted() {
        this.isDeleted = true;
    }

    public int getMessageId() {
        return messageId;               
    }

    public String getSender() {
        return sender;                   
    }

    public String getReceiver() {
        return receiver;                 
    }

    public String getContent() {
        return content;                  
    }

    public LocalDateTime getTimestamp() {
        return timestamp;               
    }

    public boolean isSeen() {
        return seen;                    
    }

    public void markAsSeen() {
        this.seen = true;                
    }

    public void markAsUnseen() {
        this.seen = false;               
    }

   
    @Override
    public String toString() {
        if (isDeleted) {
            return "Message deleted"; 
        }
        return "From: " + sender + " To: " + receiver + " Message: " + content +
                " (ID: " + messageId + ") Sent at: " + timestamp
                ;
    }
}
public class Notification {
    private int notificationID;
    private User recipient;
    private String message;
    private int sentTime;

    //Initializes a notification object with the attributes: notificationID, recipient, message, sentTime
    public Notification(int notificationID, User recipient, String message, int sentTime) {
        this.notificationID = notificationID;
        this.recipient = recipient;
        this.message = message;
        this.sentTime = sentTime;
    }

    //Returns the recipient of the notification
    public User getRecipient() {
        return recipient;
    }

    //The receieveNotification method is called to send the notification to the user
    public void send() {
        recipient.receiveNotification(this);
        System.out.println("Sending notification to " + recipient.getUserName() + ": " + message);
    }

}

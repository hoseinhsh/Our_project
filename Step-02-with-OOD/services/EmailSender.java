package services;

public class EmailSender implements MessageSender {
    @Override
    public void deliver(String recipient, String content) {
        System.out.println("📧 Email delivered to " + recipient + ": " + content);
    }
}


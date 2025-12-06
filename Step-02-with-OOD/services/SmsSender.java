package services;

public class SmsSender implements MessageSender {
    @Override
    public void deliver(String recipient, String content) {
        System.out.println("📱 SMS delivered to " + recipient + ": " + content);
    }
}


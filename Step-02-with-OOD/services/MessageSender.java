package services;

public interface MessageSender {
    void deliver(String recipient, String content);
}


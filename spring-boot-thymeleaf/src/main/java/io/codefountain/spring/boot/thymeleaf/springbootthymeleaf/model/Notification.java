package io.codefountain.spring.boot.thymeleaf.springbootthymeleaf.model;

public class Notification {

    private String notificationId;
    private String notificationMessage;

    public Notification() {
    }

    public Notification(String notificationId, String notificationMessage) {
        this.notificationId = notificationId;
        this.notificationMessage = notificationMessage;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", notificationMessage='" + notificationMessage + '\'' +
                '}';
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }
}

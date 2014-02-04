package com.example.uploadjpegs.datamodels;

/**
 * The base model for a message.
 * <p/>
 * Example URL: https://api.imgur.com/3/message/{id}/
 * <p/>
 * https://api.imgur.com/models/message
 */
public class Message {

    private String id;
    private String from;
    private String account_id;
    private String recipient_account_id;
    private String subject;
    private String body;
    private String timestamp;
    private String parent_id;

    public Message() {
    }

    /**
     * @return The ID for the message
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Account Username of person sending the message
     */
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return The account ID of the person sending the message
     */
    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    /**
     * @return The account id of the person whom received the message
     */
    public String getRecipient_account_id() {
        return recipient_account_id;
    }

    public void setRecipient_account_id(String recipient_account_id) {
        this.recipient_account_id = recipient_account_id;
    }

    /**
     * @return The subject of the message.
     */
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return The text of body of the message
     */
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return The formatted time of the message from now.
     */
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return Parent ID is the message id first message in the thread
     */
    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", from='" + from + '\'' +
                ", account_id='" + account_id + '\'' +
                ", recipient_account_id='" + recipient_account_id + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", parent_id='" + parent_id + '\'' +
                '}';
    }
}

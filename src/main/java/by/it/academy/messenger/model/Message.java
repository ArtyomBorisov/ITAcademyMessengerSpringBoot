package by.it.academy.messenger.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(schema = "app", name = "message")
public class Message implements Serializable {
    private Long id;
    private User from;
    private User to;
    private String textMessage;
    private LocalDateTime timeSending;
    private LocalDateTime lastUpdate;

    public Message() {
    }

    public Message(User from, User to, String textMessage) {
        this.from = from;
        this.to = to;
        this.textMessage = textMessage;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "\"from\"", nullable = false)
    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    @ManyToOne
    @JoinColumn(name = "\"to\"", nullable = false)
    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    @Column(name = "text", nullable = false)
    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    @Column(name = "send_dt", nullable = false)
    public LocalDateTime getTimeSending() {
        return timeSending;
    }

    public void setTimeSending(LocalDateTime timeSending) {
        this.timeSending = timeSending;
    }

    @Column(name = "dt_update", nullable = false)
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

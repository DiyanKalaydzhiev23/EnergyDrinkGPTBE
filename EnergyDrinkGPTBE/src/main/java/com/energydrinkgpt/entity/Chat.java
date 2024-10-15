package com.energydrinkgpt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "chats")
@Getter
@Setter
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Many-to-One relationship with User

    @Column(name = "chat_history", columnDefinition = "jsonb")
    private String chatHistory;

    @Column(name = "created_at")
    private String createdAt;

    public Chat() {}

    public Chat(User user, String chatHistory, String createdAt) {
        this.user = user;
        this.chatHistory = chatHistory;
        this.createdAt = createdAt;
    }
}

package com.energydrinkgpt.entity;

import com.energydrinkgpt.validation.ValidPassword;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.util.List;
//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name = "users")
//@Getter
//@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @ValidPassword
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Chat> chats;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_gpt_unlocks",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "gpt_model_id") }
    )
    private List<GPTModel> unlockedGpts;
}

package com.energydrinkgpt.entity;

import jakarta.persistence.*;
import java.util.List;
//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name = "gpt_models")
//@Getter
//@Setter
public class GPTModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model_name", unique = true)
    private String modelName;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "unlockedGpts")
    private List<User> users;  // Many-to-many relationship with User
}

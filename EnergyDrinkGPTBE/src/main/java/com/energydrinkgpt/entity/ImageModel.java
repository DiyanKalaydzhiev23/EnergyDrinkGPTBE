package com.energydrinkgpt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "images")
@Getter
@Setter
public class ImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "url", nullable = false)
    private String url;  // URL or path to the image

    @Column(name = "alt_text")
    private String altText;

    @OneToOne(mappedBy = "image")
    private GPTModel gptModel;
}
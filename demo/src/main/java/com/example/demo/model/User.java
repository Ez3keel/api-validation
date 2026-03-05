package com.example.demo.model;

import jakarta.persistence.*;

@Entity //Diz que essa classe representa uma table no DB
@Table(name = "users") //Nome da table
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Chave PK

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer age;

    public User(){} // Construtor vazio obrigatório para o Spring

    //Constructor
    public User(String username, String email, String password, Integer age){
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    //Getters
    public Long getId(){ return id;}

}


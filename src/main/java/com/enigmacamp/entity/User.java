package com.enigmacamp.entity;


import java.util.List;

public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "user_id")
    private String id;
//    @Column(name = "username", nullable = false, unique = true)
    private String username;
//    @Column(name = "password", nullable = false)
    private String password;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "trx_user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//
//    )
    List<Role> roles;
}


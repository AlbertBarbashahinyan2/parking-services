package org.example.parkingservices.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @OneToMany(mappedBy = "community", cascade = CascadeType.PERSIST)
    private List<User> users;

    @OneToMany(mappedBy = "community", cascade = CascadeType.PERSIST)
    private List<Spot> spots;

}

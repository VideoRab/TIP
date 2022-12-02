package com.example.demo.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PLANE")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLANE_ID", updatable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany
    @JoinColumn(name = "PASSENGER_ID")
    private Set<Passenger> passengers;
}

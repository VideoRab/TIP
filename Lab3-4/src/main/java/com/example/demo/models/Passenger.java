package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PASSENGER")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PASSENGER_ID", updatable = false)
    private Long id;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "SURNAME")
    protected String surname;

    @Column(name = "PATRONYMIC")
    protected String patronymic;

    @Column(name = "PASSPORT_CARD_NO")
    private String passportCardNo;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "PLANE_ID")
    private Plane Plane;
}

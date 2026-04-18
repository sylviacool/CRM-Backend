package com.customer.CRM_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "interactions")
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private InteractionType type;

    @Column(name = "description")
    private String description;

    @Column(name = "date", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false) //foreign key
    private Customer customer;
}



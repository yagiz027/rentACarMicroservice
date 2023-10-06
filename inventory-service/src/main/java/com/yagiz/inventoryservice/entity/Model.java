package com.yagiz.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="models")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="modelName", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="brandId")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> brands;
}

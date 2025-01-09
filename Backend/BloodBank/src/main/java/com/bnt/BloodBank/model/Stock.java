package com.bnt.BloodBank.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bloodstock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

    @Column(name = "units", nullable = false)
    private int units;

    public Stock(String bloodGroup, int units) {
        this.bloodGroup = bloodGroup;
        this.units = units;
    }

}

